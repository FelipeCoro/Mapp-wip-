package com.example.modernandroidapp.data.dataSources.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageDtoList(
    val results: List<ImageDto>,
) {
    @JsonClass(generateAdapter = true)
    data class ImageDto(
        val id: Int,
        val name: String,
        val status: String,
        val species: String,
        val type: String,
        val gender: String,
     //   val origin: Origin = Origin(),
        val image: String,
        val url: String
    ) {

      /*  data class Origin(
            val name: String = "",
            val url: String = ""
        )*/
    }
}
