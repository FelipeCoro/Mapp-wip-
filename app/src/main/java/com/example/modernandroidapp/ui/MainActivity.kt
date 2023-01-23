package com.example.modernandroidapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.modernandroidapp.ui.characterListScreen.CharacterList
import com.example.modernandroidapp.ui.theme.ModernAndroidAppTheme
import com.example.modernandroidapp.ui.viewmodels.CharacterListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CharacterListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
                ModernAndroidAppTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        CharacterList(
                            viewModel.mainState)
                    }
                }
        }
    }
}
