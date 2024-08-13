package ngga.ring.remote.models.cinnabar

import com.google.gson.annotations.SerializedName

data class DataCinnabar (

    @SerializedName("info"       ) var info      : ArrayList<InfoCinnabar> = arrayListOf(),
    @SerializedName("image_link" ) var imageLink : String?         = null
)

data class InfoCinnabar (

    @SerializedName("id"           ) var id          : Int?    = null,
    @SerializedName("tahukah_anda" ) var tahukahAnda : String? = null

)