package com.example.modernandroidapp.data.repository

import com.example.modernandroidapp.domain.models.Character
import com.example.modernandroidapp.utils.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface IImagesRepository {
    fun getImages(): Flow<Resource<List<Character>>>
}