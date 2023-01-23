package com.example.modernandroidapp.utils.coroutines

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@InstallIn(SingletonComponent::class)
@Module
class CoroutinesModule {

    @IoDispatcher
    @Provides
    fun providesIoDispatcher():CoroutineDispatcher = Dispatchers.IO

}