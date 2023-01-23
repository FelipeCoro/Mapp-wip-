package com.example.modernandroidapp.data.mappers

import com.example.modernandroidapp.data.dataSources.local.ImageEntity
import com.example.modernandroidapp.data.dataSources.remote.ImageDtoList

fun ImageDtoList.ImageDto.toImageEntity(): ImageEntity =
        ImageEntity(
            id,
            name,
            status,
            species,
            type,
            gender,
          /*  origin = ImageEntity.Origin(
                name = ImageDtoList.ImageDto.Origin().name,
                url = ImageDtoList.ImageDto.Origin().url
            ),*/
            image
        )