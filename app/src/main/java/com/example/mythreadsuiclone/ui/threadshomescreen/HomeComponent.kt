package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CardFunctionRow(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        LikedWidget()
        CommentWidget()
        RepostWidget()
        ShareWidget()
    }
}

@Composable
fun LikedWidget(
    modifier: Modifier = Modifier,
) {

}

@Composable
fun CommentWidget(
    modifier: Modifier = Modifier,
) {

}

@Composable
fun RepostWidget(
    modifier: Modifier = Modifier,
) {

}

@Composable
fun ShareWidget(
    modifier: Modifier = Modifier,
) {

}