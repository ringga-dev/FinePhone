package ngga.ring.remote.repository.cuaca

import ngga.ring.remote.data.api.ApiBmkgImporte
import ngga.ring.remote.models.cinnabar.CinnabarRespon
import ngga.ring.remote.models.cuaca.CuacaRespon
import ngga.ring.remote.models.cuaca.WilayahRespon
import ngga.ring.remote.respon_handler.Resource
import javax.inject.Inject

class CuacaRepository @Inject constructor(
    private val api : ApiBmkgImporte
) {

    suspend fun getWilayah(): Resource<List<WilayahRespon>> {
        return try {
            val response = api.getWilayah()
            if (response.isSuccessful) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }

    suspend fun getCuaca(wilayah: String): Resource<List<CuacaRespon>> {
        return try {
            val response = api.getCuaca(wilayah)
            if (response.isSuccessful) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}