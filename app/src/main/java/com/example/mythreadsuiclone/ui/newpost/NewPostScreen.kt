package com.example.mythreadsuiclone.ui.newpost

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NewPostScreen(
    onExit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            NewPostTopBar(
                onExit = onExit
            )
        },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(it)
                .fillMaxSize()
        ) {
            NewPostContentList(
                modifier = Modifier.weight(1f)
            )
            PostActionsRow(
                text = "Anyone can reply",
                isEnable = false
            )
        }
    }

}