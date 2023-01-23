package com.example.modernandroidapp.ui.characterListScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.modernandroidapp.ui.MainUiState
import com.example.modernandroidapp.utils.network.NetworkMonitor

@SuppressLint("UnrememberedMutableState")

@Composable
fun CharacterList(
    uiState: MainUiState
) {
    if (uiState.error != null) {
        Text(
            text = uiState.error,
        )
    }
    if (uiState.isLoading) {

    } else if (uiState.error == null) {
        LazyColumn {
            items(uiState.characterList) { character ->
                CharacterItem(character.image)
            }
        }
    }
}
