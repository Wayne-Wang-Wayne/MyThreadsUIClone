package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ThreadsHomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: ThreadsHomeViewModel = viewModel(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) {
    val pullToRefreshState = homeViewModel.pullToRefreshLayoutState

    PullToRefreshLayout(
        modifier = modifier.fillMaxSize(),
        pullRefreshLayoutState = pullToRefreshState,
        onRefresh = {
            coroutineScope.launch {
                homeViewModel.refresh()
            }
        },
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {}
    }
}
