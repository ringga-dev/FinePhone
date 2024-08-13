package ngga.ring.finephone.di


import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ngga.ring.remote.AppExecutors
import ngga.ring.remote.di.DataModule
import ngga.ring.remote.di.RepositoryModule
import javax.inject.Singleton

@Module(includes = [DataModule::class, RepositoryModule::class, DataModule::class, ViewModelsModule::class])
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAppExecutor(): AppExecutors = AppExecutors()

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

}