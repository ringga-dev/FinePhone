package ngga.ring.remote.data.api

import ngga.ring.remote.models.cuaca.CuacaRespon
import ngga.ring.remote.models.cuaca.WilayahRespon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiBmkgImporte {

    @GET("cuaca/wilayah.json")
    suspend fun getWilayah(): Response<List<WilayahRespon>>

    @GET("cuaca/{wilayah}.json")
    suspend fun getCuaca(
        @Path("wilayah") wilayah: String
    ): Response<List<CuacaRespon>>

}