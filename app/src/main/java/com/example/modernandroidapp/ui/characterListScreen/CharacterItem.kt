package com.example.modernandroidapp.ui.characterListScreen

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import com.example.modernandroidapp.ui.ImageLoader


@Composable
fun CharacterItem(
    characterImage: String

) {

    Card() {
        ImageLoader(characterImage)
    }
}
