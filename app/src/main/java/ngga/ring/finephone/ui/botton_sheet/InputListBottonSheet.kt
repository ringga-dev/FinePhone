@file:OptIn(ExperimentalMaterial3Api::class)

package ngga.ring.finephone.ui.botton_sheet


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ngga.ring.finephone.R


class InputListBottonSheet {

    @Composable
    fun View(items: List<InputListBottonSheetItem>, onSelect: (InputListBottonSheetItem) -> Unit) {
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberBottomSheetScaffoldState()

        var itemSelected by remember { mutableStateOf<InputListBottonSheetItem?>(null) }

        BottomSheetScaffold(
            scaffoldState = scaffoldState,

            sheetContent = {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    item {
                        Text(
                            text = if (itemSelected != null) itemSelected?.name.toString() else "Select Option",
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }

                    items(items) { item ->
                        Card(onClick = {
                            itemSelected = item
                            onSelect(item)
                            scope.launch { scaffoldState.bottomSheetState.hide() } }) {
                            Row {
                                item.icon?.let {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = item.description
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        .weight(1f)
                                ) {
                                    Text(
                                        text = item.name.toString(), style = TextStyle(
                                            color = MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.Bold

                                        ), fontSize = 16.sp
                                    )
                                    Text(
                                        text = item.description.toString(), style = TextStyle(
                                            color = MaterialTheme.colorScheme.onPrimary,
                                            fontWeight = FontWeight.Normal
                                        ), fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }

                }
            }
        ) {
            Card(onClick = {  scope.launch { scaffoldState.bottomSheetState.expand() } }) {

                Row {
                    Text(text = "Select Option")
                }

            }
        }

    }
}


data class InputListBottonSheetItem(
    val id: String? = null,
    val name: String? = null,
    val icon: String? = null,
    val description: String? = null,
    val isSelected: Boolean? = null,
    val isDisabled: Boolean? = null
)