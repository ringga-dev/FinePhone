package ngga.ring.finephone.ui.page.launcher

import android.content.Intent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ngga.ring.finephone.R
import ngga.ring.finephone.ui.activity.home.HomeActivity

class SplashScreenView {

    @Composable
    fun View(page: Int = 1) {
        var progress by remember { mutableStateOf(0.0f) }
        val progressAnimatable = remember { Animatable(0.0f) }
        val context = LocalContext.current

        DisposableEffect(progress) {
            onDispose {
                // Reset progress to 0.0f when the composable is disposed
                context.startActivity(Intent(context, HomeActivity::class.java))
            }
        }

        LaunchedEffect(key1 = progress) {
            // Start progress animation automatically and repeat when it completes
            progressAnimatable.animateTo(
                targetValue = 1.0f,
                animationSpec = tween(durationMillis = 5000,delayMillis= 1, easing = LinearEasing),
                block = {
                    // Reset progress to 0.0f when the animation completes
                    context.startActivity(Intent(context, HomeActivity::class.java))

                }
            )
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.align(alignment = Alignment.Center)) {
                Image(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .width(200.dp)
                        .height(200.dp),
                    painter = painterResource(id = R.drawable.ic_launcher),

                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )

                Spacer(modifier = Modifier.height(16.dp))

                LinearProgressIndicator(
                    progress = { progressAnimatable.value },
                    modifier = Modifier
                        .width(200.dp)
                        .height(10.dp)
                        .clip(MaterialTheme.shapes.small)
                        .background(MaterialTheme.colorScheme.primary),
                )
            }
        }
    }


    /** Iterate the progress value */

}

@Composable
@Preview(device = Devices.TABLET, showBackground = true)
@Preview(device = Devices.DESKTOP, showBackground = true)
@Preview(device = Devices.PIXEL, showBackground = true)
@Preview(showBackground = true)
fun ShowSplashScreenView() {
    SplashScreenView().View()
}