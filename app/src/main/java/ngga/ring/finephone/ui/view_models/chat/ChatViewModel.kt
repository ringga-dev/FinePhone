package ngga.ring.finephone.ui.view_models.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.asTextOrNull
import com.google.ai.client.generativeai.type.generationConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ngga.ring.finephone.BuildConfig
import ngga.ring.finephone.ui.page.chat.ChatMessage
import ngga.ring.finephone.ui.page.chat.ChatUiState
import ngga.ring.finephone.ui.page.chat.Participant
import timber.log.Timber
import ngga.ring.finephone.SummarizeUiState

class ChatViewModel : ViewModel() {

    private val config = generationConfig {
        temperature = 0.7f
    }

    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.0-pro",
        apiKey = BuildConfig.apiKey,
        generationConfig = config
    )

    private val chat = generativeModel.startChat(
        history = listOf()
    )

    private val _uiState: MutableStateFlow<ChatUiState> =
        MutableStateFlow(ChatUiState(chat.history.map { content ->
            // Map the initial messages
            ChatMessage(
                text = content.parts.first().asTextOrNull() ?: "",
                participant = if (content.role == "user") Participant.User else Participant.Gemini,
                isPending = false
            )
        }))
    val uiState: StateFlow<ChatUiState> =
        _uiState.asStateFlow()


    fun sendMessage(userMessage: String) {
        // Add a pending message
        _uiState.value.addMessage(
            ChatMessage(
                text = userMessage,
                participant = Participant.User,
                isPending = true
            )
        )

        viewModelScope.launch {
            try {
                val response = chat.sendMessage(userMessage)

                _uiState.value.replaceLastPendingMessage()

                response.text?.let { modelResponse ->
                    _uiState.value.addMessage(
                        ChatMessage(
                            text = modelResponse,
                            participant = Participant.Gemini,
                            isPending = false
                        )
                    )
                }
            } catch (e: Exception) {
                _uiState.value.replaceLastPendingMessage()
                _uiState.value.addMessage(
                    ChatMessage(
                        text = e.localizedMessage,
                        participant = Participant.ERROR
                    )
                )
            }
        }
    }

    private val _uiStatePrompt: MutableStateFlow<SummarizeUiState> =
        MutableStateFlow(SummarizeUiState.Initial)

    val uiStatePrompt: StateFlow<SummarizeUiState> = _uiStatePrompt.asStateFlow()

    fun sendPrompt(prompt: String) {
        _uiStatePrompt.value = SummarizeUiState.Loading
        Timber.e("ringga respon: $prompt")
        viewModelScope.launch {
            try {
                val response =
                    generativeModel.generateContent(prompt)
                response.text?.let { outputContent ->
                    _uiStatePrompt.value = SummarizeUiState.Success(outputContent)
                }
            } catch (e: Exception) {
                _uiStatePrompt.value = SummarizeUiState.Error(e.localizedMessage ?: "")
            }
        }
    }
}
