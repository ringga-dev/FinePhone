package ngga.ring.finephone.ui.view_models.chat

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.asTextOrNull
import com.google.ai.client.generativeai.type.content
import com.google.ai.client.generativeai.type.generationConfig
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
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

class GeminiViewModel : ViewModel() {


    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = BuildConfig.apiKey
    )

    private val _uiState: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.Initial)
    val uiState: StateFlow<UiState> =
        _uiState.asStateFlow()

    private fun postImage(bitmap: Bitmap): Deferred<String> {
        return viewModelScope.async(Dispatchers.IO) {
            try {
                val response = generativeModel.generateContent(
                    content {
                        image(bitmap)
                        text(
                            "Describe the image with a general description. If the image features the face of a well-known person, don’t mention their name; just describe their appearance as seen through the eyes of others. If the image contains anything controversial, either ignore it or use neutral words to avoid controversy. Then, act as if you are the harshest person in the world, hated by many because what you say is brutally honest."
                        )
                    }
                )
                Timber.e("ringga respon: ${response.text}")
                response.text ?: ""
            } catch (e: Exception) {
                Timber.e("ringga respon: ${e.localizedMessage}")
                ""
            }
        }
    }

    fun sendRoastingPrompt(bitmap: Bitmap) {
        _uiState.value = UiState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val prompt = postImage(bitmap).await()
                if (prompt.isNotEmpty()) {
                    val response = generativeModel.generateContent(
                        content {
                            text(
                                "$prompt\n" +
                                        "Give a price for the image, ranging from Rp. 100.00 to a maximum of Rp. 100,000.00, and provide a reason for the given price.\n\n" +
                                        "Create a roast for the description of this image. You may use light, non-offensive, and mildly cheeky Indonesian words, employing detailed and critical roast techniques. Use current trends or relevant news to spice up your roast and include emojis for extra flair. Ensure that your roast is in straightforward and tense Indonesian, like how most Indonesians speak, and provide the best roast available.\n\n" +
                                        "Make sure all responses are in Indonesian."
                            )
                        }
                    )
                    Timber.e("ringga respon: ${response.text}")
                    _uiState.value = UiState.Success(response.text ?: "")
                } else {
                    _uiState.value = UiState.Error("Sorry, I am too harsh to respond to this image, so it's censored!!")
                }
            } catch (e: Exception) {
                Timber.e("ringga respon: ${e.localizedMessage}")
                _uiState.value =
                    UiState.Error("Sorry, I am too harsh to respond to this image, so it's censored!! \n\n" + e.localizedMessage)
            }
        }
    }

}

sealed interface UiState {

    /**
     * Empty state when the screen is first shown
     */
    object Initial : UiState

    /**
     * Still loading
     */
    object Loading : UiState

    /**
     * Text has been generated
     */
    data class Success(val outputText: String) : UiState

    /**
     * There was an error generating text
     */
    data class Error(val errorMessage: String) : UiState
}