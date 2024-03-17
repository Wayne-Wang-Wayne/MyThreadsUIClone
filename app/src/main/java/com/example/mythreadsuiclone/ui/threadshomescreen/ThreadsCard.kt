package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mythreadsuiclone.ui.data.PostData

@Composable
fun ThreadsCard(
    postData: PostData,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {

    }
}