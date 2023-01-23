package com.example.modernandroidapp.data.di

import com.example.modernandroidapp.data.dataSources.local.ImageDao
import com.example.modernandroidapp.data.dataSources.local.MaaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesAuthorDao(
        database: MaaDatabase,
    ): ImageDao = database.imageDao()
}