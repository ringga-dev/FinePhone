package ngga.ring.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

//    @Singleton
//    @Provides
//    fun providelocalDataSource(db: AppDatabase): LocalDataSource {
//        return db.localDataSource()
//    }
//
//    @Singleton
//    @Provides
//    fun provideUserDao(db: AppDatabase): UserDao {
//        return db.userDao()
//    }

}