package com.example.modernandroidapp.ui.viewmodels

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernandroidapp.data.repository.IImagesRepository
import com.example.modernandroidapp.ui.MainUiState
import com.example.modernandroidapp.utils.network.NetworkMonitor
import com.example.modernandroidapp.utils.wrapper.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val imagesRepository: IImagesRepository,
    private val networkMonitor: NetworkMonitor
) : ViewModel() {
    var mainState by mutableStateOf(MainUiState())
        private set

    private val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )


    init {

            loadCharactersList(isOffline.value)
        }


    fun loadCharactersList(networkStatus:Boolean) {
        viewModelScope.launch {
            mainState = mainState.copy(
                isLoading = true,
                error = null
            )
            imagesRepository.getImages(networkStatus).collect() { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { characters ->
                            mainState = mainState.copy(
                                characterList = characters,
                            )
                        }
                    }

                    is Resource.Error -> {
                        mainState = mainState.copy(
                            error = result.message
                        )
                    }

                    is Resource.Loading -> {
                        mainState = mainState.copy(
                            isLoading = result.isLoading,
                        )
                    }
                }
            }
        }
    }
}
