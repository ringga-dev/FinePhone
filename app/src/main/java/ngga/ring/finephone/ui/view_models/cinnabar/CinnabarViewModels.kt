package ngga.ring.finephone.ui.view_models.cinnabar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ngga.ring.remote.models.cinnabar.CinnabarRespon
import ngga.ring.remote.repository.cinnabar.CinnabarRepository
import ngga.ring.remote.respon_handler.Resource
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow


@HiltViewModel
class CinnabarViewModels @Inject constructor(
    private val cinnabarRepository: CinnabarRepository
) : ViewModel() {
    private val _tawiki = MutableStateFlow<Resource<CinnabarRespon>?>(Resource.Loading)
    val tawiki: StateFlow<Resource<CinnabarRespon>?> = _tawiki

    init {
        getTawiki()
    }

    private fun getTawiki() {
        viewModelScope.launch {
            try {
                _tawiki.value = cinnabarRepository.getTawiki()
            } catch (e: Exception) {
                _tawiki.value = Resource.Error(e.message ?: "An error occurred")
            }
        }
    }
}