package com.margaritalashina.mytrainingprojectmobiledev.di.module

import com.margaritalashina.mytrainingprojectmobiledev.data.json.AuthTokensAdapter
import com.margaritalashina.mytrainingprojectmobiledev.entity.AuthTokens
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SerializationModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(AuthTokens::class.java, AuthTokensAdapter().nullSafe())
            .build()
}