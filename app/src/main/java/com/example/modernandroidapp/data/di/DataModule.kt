package com.example.modernandroidapp.data.di

import com.example.modernandroidapp.data.repository.IImagesRepository
import com.example.modernandroidapp.data.repository.ImagesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsImagesRepositoryImpl(
        imagesRepositoryImpl: ImagesRepositoryImpl
    ): IImagesRepository
}