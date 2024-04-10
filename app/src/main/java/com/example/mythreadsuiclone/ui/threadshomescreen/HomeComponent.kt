package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardFunctionRow(
    likeCount: Int,
    isLiked: Boolean,
    commentCount: Int,
    repostCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LikedWidget(
            likeCount = likeCount,
            isLiked = isLiked
        )
        CommentWidget(
            commentCount = commentCount
        )
        RepostWidget(repostCount)
        ShareWidget()
    }
}

@Composable
fun LikedWidget(
    likeCount: Int,
    isLiked: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = "Like Icon",
            tint = if (isLiked) {
                Color.Red
            } else {
                Color.White
            }
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = likeCount.toString(),
            color = Color.White
        )
    }
}

@Composable
fun CommentWidget(
    commentCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = "Comment Icon",
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = commentCount.toString(),
            color = Color.White
        )
    }
}

@Composable
fun RepostWidget(
    repostCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Repost Icon",
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = repostCount.toString(), color = Color.White)
    }
}

@Composable
fun ShareWidget(
    modifier: Modifier = Modifier,
) {
    Icon(
        modifier = modifier,
        imageVector = Icons.Default.Send,
        contentDescription = "Share Icon",
        tint = Color.White
    )
}