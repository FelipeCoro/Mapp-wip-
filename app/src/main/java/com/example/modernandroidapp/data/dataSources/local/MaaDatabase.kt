package com.example.modernandroidapp.data.dataSources.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ImageEntity::class], version = 1)
abstract class MaaDatabase: RoomDatabase() {
    abstract fun imageDao() : ImageDao
}