package ngga.ring.finephone.ui.base

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import ngga.ring.core.utils.handleOrientation
import ngga.ring.core.utils.imageBlurDrawable
import ngga.ring.finephone.ui.theme.FinePhoneTheme
import ngga.ring.finephone.ui.view_models.DataStoreViewModels
import ngga.ring.remote.AppExecutors
import javax.inject.Inject
import coil.compose.rememberAsyncImagePainter

@AndroidEntryPoint
abstract class BaseActivity : ComponentActivity() {
    @Inject
    lateinit var themeViewModels: DataStoreViewModels

    @Inject
    lateinit var appExecutors: AppExecutors

    @Composable
    abstract fun setupViews()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            FinePhoneTheme(
                appTheme = themeViewModels.stateApp.theme,
                appThemeColor = themeViewModels.stateApp.themeColor
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
                        Image(
                            painter = painterResource(id = handleOrientation(application.resources.configuration.orientation)),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .blur(
                                    radiusX = 10.dp,
                                    radiusY = 10.dp,
                                    edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
                                ),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Image(
                            painter = rememberAsyncImagePainter(
                                imageBlurDrawable(
                                    drawable = resources.getDrawable(handleOrientation(application.resources.configuration.orientation)),
                                    blurRadius = 16F
                                )
                            ),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    setupViews()
                }
            }
        }

    }


}
