package ngga.ring.remote.data.api

import ngga.ring.remote.models.cinnabar.CinnabarRespon
import retrofit2.Response
import retrofit2.http.GET

interface ApiCinnabar {

    @GET("daily/tawiki")
    suspend fun getTawiki(): Response<CinnabarRespon>
}