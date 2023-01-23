package com.example.modernandroidapp.domain.models

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    //val origin: Origin = Origin(),
    val image: String
){/*
    data class Origin(
        val name: String = "",
        val url: String = ""
    )*/
}
