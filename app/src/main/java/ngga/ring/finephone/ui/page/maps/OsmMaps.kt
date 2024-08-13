package ngga.ring.finephone.ui.page.maps


import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import ngga.ring.remote.models.cuaca.WilayahRespon
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class OsmMaps {

    @Composable
    fun View(
        modifier: Modifier = Modifier,
        dataLocation: WilayahRespon? = null,
    ) {
        val context = LocalContext.current
        val mapView = rememberMapViewWithLifecycle(context)

        AndroidView(
            modifier = modifier,
            factory = { mapView },
            update = { map ->

                map.controller.setZoom(if (dataLocation == null) 5.0 else 15.0)
                val startPoint = GeoPoint(
                    dataLocation?.lat ?: -1.035898527362231,
                    dataLocation?.lon ?: 110.29332619443623
                )
                map.controller.setCenter(startPoint)

                if (dataLocation != null) {
                    val marker = Marker(map).apply {
                        position = startPoint
                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                        title = dataLocation.propinsi
                        snippet = dataLocation.kota
                        subDescription = dataLocation.kecamatan
                    }
                    map.overlays.add(marker)
                }
            }
        )
    }


    @Composable
    private fun rememberMapViewWithLifecycle(context: Context): MapView {
        val mapView = remember { MapView(context) }

        DisposableEffect(mapView) {
            Configuration.getInstance().load(context, context.getSharedPreferences("osmdroid", 0))
            mapView.onResume()
            onDispose { mapView.onPause() }
        }

        return mapView
    }
}
