package com.example.modernandroidapp.data.dataSources.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "images")
data class ImageEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    //val origin: Origin,
    val image: String,
    val albumId: Int = 0,
    val isFavorite: Boolean = false
){
    /*data class Origin(
        val name: String = "",
        val url: String = ""
    )*/
}
