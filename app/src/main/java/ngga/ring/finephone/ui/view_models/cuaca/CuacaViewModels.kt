package ngga.ring.finephone.ui.view_models.cuaca

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
import ngga.ring.remote.models.cuaca.CuacaRespon
import ngga.ring.remote.models.cuaca.WilayahRespon
import ngga.ring.remote.repository.cuaca.CuacaRepository


@HiltViewModel
class CuacaViewModels @Inject constructor(
    private val cuacaRepository: CuacaRepository
) : ViewModel() {
    private val _wilayah = MutableStateFlow<Resource<List<WilayahRespon>>?>(Resource.Loading)
    val wilayah: StateFlow<Resource<List<WilayahRespon>>?> = _wilayah

    private val _cuaca = MutableStateFlow<Resource<List<CuacaRespon>>?>(Resource.Loading)
    val cuaca: StateFlow<Resource<List<CuacaRespon>>?> = _cuaca

    init {
        getWilayah()
    }

    private fun getWilayah() {
        viewModelScope.launch {
            try {
                _wilayah.value = cuacaRepository.getWilayah()
            } catch (e: Exception) {
                _wilayah.value = Resource.Error(e.message ?: "An error occurred")
            }
        }
    }

    fun getCuaca(wilayah: String) {
        viewModelScope.launch {
            try {
                _cuaca.value = cuacaRepository.getCuaca(wilayah)
            } catch (e: Exception) {
                _cuaca.value = Resource.Error(e.message ?: "An error occurred")
                }
        }
    }
}