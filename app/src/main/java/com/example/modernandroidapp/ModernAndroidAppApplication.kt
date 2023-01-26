package com.example.modernandroidapp

import android.app.Application
import com.example.modernandroidapp.ui.offlineSync.Sync
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ModernAndroidAppApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        // Initialize Sync; the system responsible for keeping data in the app up to date.
        Sync.initialize(context = this)
    }
}
