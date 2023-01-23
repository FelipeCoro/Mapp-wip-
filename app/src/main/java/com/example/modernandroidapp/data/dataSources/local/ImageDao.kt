package com.example.modernandroidapp.data.dataSources.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Query("SELECT * FROM images")
    suspend fun getAll(): List<ImageEntity>

    @Query("SELECT * FROM images WHERE id IN (:imageId)")
    fun loadById(imageId: Int): Flow<ImageEntity>

    @Query("SELECT * FROM images WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Flow<ImageEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveImages(imagesList:List<ImageEntity>)

    @Update
    suspend fun updateImage(image:ImageEntity)

    @Query("DELETE FROM images")
    suspend fun deleteImages()
}
