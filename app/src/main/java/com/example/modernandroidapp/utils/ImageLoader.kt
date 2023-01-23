package com.example.modernandroidapp.ui


import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun ImageLoader(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null
    )
}