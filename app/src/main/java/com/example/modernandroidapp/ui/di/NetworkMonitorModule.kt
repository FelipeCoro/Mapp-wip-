package com.example.modernandroidapp.ui.di

import com.example.modernandroidapp.utils.network.ConnectivityManagerNetworkMonitor
import com.example.modernandroidapp.utils.network.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface NetworkMonitorModule {

    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor
    ): NetworkMonitor
}