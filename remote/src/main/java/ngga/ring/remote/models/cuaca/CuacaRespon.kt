package ngga.ring.remote.models.cuaca

import com.google.gson.annotations.SerializedName

data class WilayahRespon(

    @SerializedName("id") var id: String? = null,
    @SerializedName("propinsi") var propinsi: String? = null,
    @SerializedName("kota") var kota: String? = null,
    @SerializedName("kecamatan") var kecamatan: String? = null,
    @SerializedName("lat") var lat: Double? = null,
    @SerializedName("lon") var lon: Double? = null

)

data class CuacaRespon(

    @SerializedName("jamCuaca"  ) var jamCuaca  : String? = null,
    @SerializedName("kodeCuaca" ) var kodeCuaca : String? = null,
    @SerializedName("cuaca"     ) var cuaca     : String? = null,
    @SerializedName("humidity"  ) var humidity  : String? = null,
    @SerializedName("tempC"     ) var tempC     : String? = null,
    @SerializedName("tempF"     ) var tempF     : String? = null

)

