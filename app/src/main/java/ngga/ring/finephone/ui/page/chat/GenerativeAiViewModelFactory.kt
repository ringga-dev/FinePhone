package ngga.ring.finephone.ui.page.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.generationConfig
import ngga.ring.finephone.BuildConfig
import ngga.ring.finephone.ui.view_models.SummarizeViewModel
import ngga.ring.finephone.ui.view_models.chat.ChatViewModel

val GenerativeViewModelFactory = object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        viewModelClass: Class<T>,
        extras: CreationExtras
    ): T {
        val config = generationConfig {
            temperature = 0.7f
        }

        return with(viewModelClass) {
            when {
                isAssignableFrom(SummarizeViewModel::class.java) -> {
                    // Initialize a GenerativeModel with the `gemini-pro` AI model
                    // for text generation
                    val generativeModel = GenerativeModel(
                        modelName = "gemini-1.0-pro",
                        apiKey = BuildConfig.apiKey,
                        generationConfig = config
                    )
//                    SummarizeViewModel(generativeModel)
                }
////
//                isAssignableFrom(PhotoReasoningViewModel::class.java) -> {
//                    // Initialize a GenerativeModel with the `gemini-pro-vision` AI model
//                    // for multimodal text generation
//                    val generativeModel = GenerativeModel(
//                        modelName = "gemini-1.0-pro-vision-latest",
//                        apiKey = BuildConfig.apiKey,
//                        generationConfig = config
//                    )
//                    PhotoReasoningViewModel(generativeModel)
//                }

//                isAssignableFrom(ChatViewModel::class.java) -> {
//                    // Initialize a GenerativeModel with the `gemini-pro` AI model for chat
//                    val generativeModel = GenerativeModel(
//                        modelName = "gemini-1.0-pro",
//                        apiKey = BuildConfig.apiKey,
//                        generationConfig = config
//                    )
//                    ChatViewModel(generativeModel)
//                }

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${viewModelClass.name}")
            }
        } as T
    }
}
