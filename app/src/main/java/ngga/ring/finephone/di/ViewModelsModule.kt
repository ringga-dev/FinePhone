package ngga.ring.finephone.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ngga.ring.finephone.ui.view_models.DataStoreViewModels
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ViewModelsModule {

    @Provides
    @Singleton
    fun provideThemeViewModels(): DataStoreViewModels {
        return DataStoreViewModels()
    }

//    @Provides
//    @Singleton
//    fun provideAuthViewModel(authRepository: AuthRepository): AuthViewModel {
//        return AuthViewModel(authRepository)
//    }

}