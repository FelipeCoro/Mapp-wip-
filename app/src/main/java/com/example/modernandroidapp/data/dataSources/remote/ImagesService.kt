package com.example.modernandroidapp.data.dataSources.remote


import retrofit2.Response
import retrofit2.http.GET


interface ImagesService {
    @GET("character")
    suspend fun getCharacters(): Response<ImageDtoList>
}







