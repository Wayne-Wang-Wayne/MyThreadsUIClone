package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class ThreadsHomeViewModel : ViewModel() {
    val pullToRefreshLayoutState: PullToRefreshLayoutState = PullToRefreshLayoutState{it.toString()}


    suspend fun refresh() {
        delay(2000L)
        // Do some work
        pullToRefreshLayoutState.updateRefreshState(RefreshIndicatorState.Default)
    }
}