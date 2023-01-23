package com.example.modernandroidapp.domain.mappers

import android.provider.ContactsContract.CommonDataKinds.Im
import com.example.modernandroidapp.data.dataSources.local.ImageEntity
import com.example.modernandroidapp.domain.models.Character

fun ImageEntity.toCharacterModel(): Character =
        Character(
            id,
            name,
            status,
            species,
            type,
            gender,
           /* origin = Character.Origin(
                name = ImageEntity.Origin().name,
                url = ImageEntity.Origin().url
            ) ,*/
            image
        )
