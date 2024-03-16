package com.example.mythreadsuiclone.ui.threadshomescreen

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mythreadsuiclone.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.math.roundToInt

private const val maxHeight = 100

@Composable
fun PullToRefreshIndicator(
    modifier: Modifier = Modifier,
    indicatorState: RefreshIndicatorState,
    pullToRefreshProgress: Float,
    timeElapsed: String,
) {
    val heightModifier = when (indicatorState) {
        RefreshIndicatorState.PullingDown -> {
            Modifier.height(
                (pullToRefreshProgress * 100)
                    .roundToInt()
                    .coerceAtMost(maxHeight).dp,
            )
        }
        RefreshIndicatorState.ReachedThreshold -> Modifier.height(maxHeight.dp)
        RefreshIndicatorState.Refreshing -> Modifier.wrapContentHeight()
        RefreshIndicatorState.Default -> Modifier.height(0.dp)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
            .then(heightModifier)
            .padding(15.dp),
        contentAlignment = Alignment.BottomStart,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = stringResource(indicatorState.messageRes),
                color = Color.White,
            )
            if (indicatorState == RefreshIndicatorState.Refreshing) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    color = Color.Black,
                    trackColor = Color.Gray,
                    strokeWidth = 2.dp,
                )
            } else {
                Text(
                    text = stringResource(R.string.last_updated, timeElapsed),
                    color = Color.White,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PullToRefreshLayout(
    modifier: Modifier = Modifier,
    pullRefreshLayoutState: PullToRefreshLayoutState,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit,
) {
    val refreshIndicatorState by pullRefreshLayoutState.refreshIndicatorState
    val timeElapsedSinceLastRefresh by pullRefreshLayoutState.lastRefreshText

    val pullToRefreshState = rememberPullRefreshState(
        refreshing = refreshIndicatorState == RefreshIndicatorState.Refreshing,
        refreshThreshold = 120.dp,
        onRefresh = {
            onRefresh()
            pullRefreshLayoutState.refresh()
        },
    )

    LaunchedEffect(key1 = pullToRefreshState.progress) {
        Log.d("PullToRefreshLayout", "Progress: ${pullToRefreshState.progress}")
        when {
            pullToRefreshState.progress >= 1 -> {
                pullRefreshLayoutState.updateRefreshState(RefreshIndicatorState.ReachedThreshold)
            }

            pullToRefreshState.progress > 0 -> {
                pullRefreshLayoutState.updateRefreshState(RefreshIndicatorState.PullingDown)
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .pullRefresh(pullToRefreshState),
    ) {
        PullToRefreshIndicator(
            indicatorState = refreshIndicatorState,
            pullToRefreshProgress = pullToRefreshState.progress,
            timeElapsed = timeElapsedSinceLastRefresh,
        )
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
    }
}

class PullToRefreshLayoutState(
    val onTimeUpdated: (Long) -> String,
) {

    private val _lastRefreshTime: MutableStateFlow<Long> = MutableStateFlow(System.currentTimeMillis())

    var refreshIndicatorState = mutableStateOf(RefreshIndicatorState.Default)
        private set

    var lastRefreshText = mutableStateOf("")
        private set

    fun updateRefreshState(refreshState: RefreshIndicatorState) {
        val now = System.currentTimeMillis()
        val timeElapsed = now - _lastRefreshTime.value
        lastRefreshText.value = onTimeUpdated(timeElapsed)
        refreshIndicatorState.value = refreshState
    }

    fun refresh() {
        _lastRefreshTime.value = System.currentTimeMillis()
        updateRefreshState(RefreshIndicatorState.Refreshing)
    }
}

@Composable
fun rememberPullToRefreshState(
    onTimeUpdated: (Long) -> String,
): PullToRefreshLayoutState =
    remember {
        PullToRefreshLayoutState(onTimeUpdated)
    }

enum class RefreshIndicatorState(@StringRes val messageRes: Int) {
    Default(R.string.pull_to_refresh_complete_label),
    PullingDown(R.string.pull_to_refresh_pull_label),
    ReachedThreshold(R.string.pull_to_refresh_release_label),
    Refreshing(R.string.pull_to_refresh_refreshing_label)
}