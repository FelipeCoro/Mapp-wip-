package com.example.modernandroidapp.ui
import com.example.modernandroidapp.domain.models.Character
import com.example.modernandroidapp.utils.network.NetworkMonitor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class MainUiState(
    val characterList: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)