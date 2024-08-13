package ngga.ring.finephone.ui.page.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import ngga.ring.finephone.R
import ngga.ring.finephone.ui.view_models.chat.ChatViewModel
import timber.log.Timber

class ChatScreenView {

    @Composable
    fun View(
        chatViewModel: ChatViewModel = viewModel()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            val chatUiState by chatViewModel.uiState.collectAsState()
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()

            Scaffold(
                bottomBar = {
                    MessageInput(
                        onSendMessage = { inputText ->
                            chatViewModel.sendMessage(inputText)
                        },
                        resetScroll = {
                            coroutineScope.launch {
                                listState.scrollToItem(0)
                            }
                        }
                    )
                }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {
                    Card() {

                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Beritau gemini harus mengunakan bahasa apa di awal!",
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 20.sp
                            )
                        )
                    }
                    // Messages List
                    ChatList(chatUiState.messages, listState)
                }
            }
        }
    }

    @Composable
    fun ChatList(
        chatMessages: List<ChatMessage>,
        listState: LazyListState
    ) {
        LazyColumn(
            reverseLayout = true,
            state = listState
        ) {
            items(chatMessages.reversed()) { message ->
                ChatBubbleItem(message)
            }
        }
    }

    @Composable
    fun ChatBubbleItem(
        chatMessage: ChatMessage
    ) {
        val isModelMessage = chatMessage.participant == Participant.Gemini ||
                chatMessage.participant == Participant.ERROR

        val backgroundColor = when (chatMessage.participant) {
            Participant.Gemini -> MaterialTheme.colorScheme.primaryContainer
            Participant.User -> MaterialTheme.colorScheme.tertiaryContainer
            Participant.ERROR -> MaterialTheme.colorScheme.errorContainer
        }

        val bubbleShape = if (isModelMessage) {
            RoundedCornerShape(4.dp, 20.dp, 20.dp, 20.dp)
        } else {
            RoundedCornerShape(20.dp, 4.dp, 20.dp, 20.dp)
        }

        val horizontalAlignment = if (isModelMessage) {
            Alignment.Start
        } else {
            Alignment.End
        }

        Column(
            horizontalAlignment = horizontalAlignment,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = chatMessage.participant.name,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Row {
                if (chatMessage.isPending) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(all = 8.dp)
                    )
                }
                BoxWithConstraints {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = backgroundColor),
                        shape = bubbleShape,
                        modifier = Modifier.widthIn(0.dp, maxWidth * 0.9f)
                    ) {
                        Text(
                            text = chatMessage.text,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun MessageInput(
        onSendMessage: (String) -> Unit,
        resetScroll: () -> Unit = {}
    ) {
        var userMessage by rememberSaveable { mutableStateOf("") }

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = userMessage,
                label = { Text(stringResource(R.string.chat_label)) },
                onValueChange = { userMessage = it },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .weight(0.85f),
                shape = RoundedCornerShape(20)
            )

            Card(onClick = {
                if (userMessage.isNotBlank()) {
                    onSendMessage(userMessage)
                    Timber.e(userMessage)
                    userMessage = ""
                    resetScroll()
                }
            }, shape = RoundedCornerShape(62.dp),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_send),
                    contentDescription = stringResource(R.string.action_send),
                    modifier = Modifier
                        .padding(0.dp)
                        .size(43.dp)
                )
            }
        }

    }

}