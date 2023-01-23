package com.example.modernandroidapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.modernandroidapp.data.dataSources.local.MaaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesMaaDatabase(
        @ApplicationContext context: Context,
    ): MaaDatabase = Room.databaseBuilder(
        context,
        MaaDatabase::class.java,
        "maa-database"
    ).build()
}