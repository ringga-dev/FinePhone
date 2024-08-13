package ngga.ring.remote.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

//    @Provides
//    @Singleton
//    fun provideRepository(api: Api, localDataSource: LocalDataSource): Repository {
//        return Repository(api, localDataSource)
//    }
//
//    @Provides
//    @Singleton
//    fun provideAuthRepository(
//        userDao: UserDao,
//        appExecutors: AppExecutors,
//        api: Api
//    ): AuthRepository {
//        return AuthRepository(userDao, appExecutors, api)
//    }

}