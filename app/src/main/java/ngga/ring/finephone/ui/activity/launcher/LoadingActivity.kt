package ngga.ring.finephone.ui.activity.launcher

import android.content.Intent
import androidx.compose.runtime.Composable
import ngga.ring.finephone.ui.activity.home.HomeActivity
import ngga.ring.finephone.ui.base.BaseActivity
import ngga.ring.finephone.ui.page.launcher.LoadingScreenView

class LoadingActivity : BaseActivity() {


    @Composable
    override fun setupViews() {
        val view = LoadingScreenView()
        view.View{
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

}

