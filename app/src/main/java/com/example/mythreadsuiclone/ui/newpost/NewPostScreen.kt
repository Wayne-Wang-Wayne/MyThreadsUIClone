package com.example.mythreadsuiclone.ui.newpost

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

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
        ConstraintLayout(
            modifier = Modifier.padding(it)
                .fillMaxSize()
        ) {
            ExitButton()
            NewPostTitle()
            NewPostContentList()
        }
    }

}
