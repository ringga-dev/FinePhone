package ngga.ring.remote.models.cinnabar

import com.google.gson.annotations.SerializedName

data class CinnabarRespon  (
    @SerializedName("data" ) var data : DataCinnabar? = DataCinnabar()
)

