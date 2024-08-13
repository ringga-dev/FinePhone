package ngga.ring.remote.di


import android.annotation.SuppressLint
import android.app.Application
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ngga.ring.remote.BuildConfig
import ngga.ring.remote.data.api.ApiBmkgImporte
import ngga.ring.remote.data.api.ApiCinnabar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

//    @Provides
//    fun provideBaseUrl(@ApplicationContext context: Context): String {
//        return "https://cinnabar.icaksh.my.id/public/"
////        return try {
////            val url = context.readTextFile("URL", "BaseUrl.txt").decrypt().toString()
////            url.ifEmpty { "http://192.168.100.213:2000/" }
////        } catch (e: Exception) {
////            "https://cinnabar.icaksh.my.id/public/"
////        }
//    }


//    @Singleton
//    @Provides
//    fun provideDb(app: Application): AppDatabase {
//        return Room
//            .databaseBuilder(app, AppDatabase::class.java, "school.db")
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .build()
//    }


//    @SuppressLint("HardwareIds")
//    @Singleton
//    @Provides
//    fun provideApiService(app: Application, baseUrl: String): Api {
//
//        val tokenClient = createHttpClient(app)
////        val tokenApiService = createApiService(tokenClient, baseUrl)
////        val tokenInterceptor = RefreshTokenInterceptor(app, tokenApiService)
//
//        val client = createHttpClient(app)
////        val client = createHttpClient(app, tokenInterceptor)
//
//        client.dispatcher.maxRequests = 20
//
//        return createApiService(client, baseUrl)
//    }


    private fun createHttpClient(app: Application) = OkHttpClient.Builder()
        .insertInterceptors(app)
        .retryOnConnectionFailure(true)
        .connectTimeout(40, TimeUnit.SECONDS)
        .writeTimeout(40, TimeUnit.SECONDS)
        .readTimeout(50, TimeUnit.SECONDS)
        .build()


    private fun OkHttpClient.Builder.insertInterceptors(
        app: Application,
    ) = apply {

        if (BuildConfig.FLAVOR == "staging") {
            val logInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val chuckerInterceptor = ChuckerInterceptor.Builder(app)
                .collector(ChuckerCollector(app))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build()

            addInterceptor(logInterceptor)
            addInterceptor(chuckerInterceptor)
        }
    }


    /**
     * Cinnabar API
     */
    private val URL_CINNABAR = "https://cinnabar.icaksh.my.id/public/"
    private fun createApiCinnabarService(client: OkHttpClient, baseUrl: String): ApiCinnabar {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiCinnabar::class.java)
    }

    @SuppressLint("HardwareIds")
    @Singleton
    @Provides
    fun provideApiCinnabarService(app: Application): ApiCinnabar {
        val client = createHttpClient(app)
        client.dispatcher.maxRequests = 20
        return createApiCinnabarService(client, URL_CINNABAR)
    }


    /**
     * Cinnabar API
     */

    private val URL_BMKG_IMPORTE = "https://ibnux.github.io/BMKG-importer/"

    private fun createApiBmkgImporteService(client: OkHttpClient, baseUrl: String): ApiBmkgImporte {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiBmkgImporte::class.java)
    }

    @SuppressLint("HardwareIds")
    @Singleton
    @Provides
    fun provideApiBmkgImporteService(app: Application): ApiBmkgImporte {
        val client = createHttpClient(app)
        client.dispatcher.maxRequests = 20
        return createApiBmkgImporteService(client, URL_BMKG_IMPORTE)
    }

}
