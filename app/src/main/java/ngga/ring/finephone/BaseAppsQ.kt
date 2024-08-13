package ngga.ring.finephone

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import io.paperdb.Paper
import timber.log.Timber

@HiltAndroidApp
class BaseAppsQ : Application() {
    override fun onCreate() {
        instance = this
        Paper.init(this)
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        var instance: BaseAppsQ = BaseAppsQ()
            private set

        val context: Context
            get() = instance
    }
}