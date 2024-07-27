package com.soha.infotech.daggerhiltcourse

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class UserModule {

    /*@Singleton
    @Provides
    fun provideUserRepository(): UserRepository {
        return FirebaseRepository()
    }*/


    /*@Singleton
    @Provides
    fun provideUserRepository(sqlRepository: SQLRepository): UserRepository {
        return sqlRepository
    }*/

    @Singleton
    @Provides
    // @Named("sql")
    @SQLQualifier
    fun provideSQLRepository(sqlRepository: SQLRepository): UserRepository {
        return sqlRepository
    }

    @Singleton
    @Provides
    // @Named("firebase")
    @FirebaseQualifier
    fun provideFirebaseRepository(): UserRepository {
        return FirebaseRepository()
    }

}

// For binds
/*@InstallIn(SingletonComponent::class)
@Module
abstract class UserModule {

    @Binds
    abstract fun bindUserRepository(sqlRepository: SQLRepository): UserRepository
}*/
