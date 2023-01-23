package com.example.modernandroidapp.data.di

import com.example.modernandroidapp.data.dataSources.remote.ImagesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val ImagesBaseUrl = "https://rickandmortyapi.com/api/"

    @Provides
    @Singleton
    fun retrofitImageNetwork(): ImagesService {
        return Retrofit.Builder()
            .baseUrl(ImagesBaseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ImagesService::class.java)
    }



}

