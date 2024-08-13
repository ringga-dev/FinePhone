package ngga.ring.remote.repository.cinnabar

import ngga.ring.remote.data.api.ApiCinnabar
import ngga.ring.remote.models.cinnabar.CinnabarRespon
import ngga.ring.remote.respon_handler.Resource
import javax.inject.Inject

class CinnabarRepository @Inject constructor(
    private val api : ApiCinnabar
) {

    suspend fun getTawiki(): Resource<CinnabarRespon> {
        return try {
            val response = api.getTawiki()
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