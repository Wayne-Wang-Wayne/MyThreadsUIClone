package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun UserAvatar(
    avatarUrl: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Rounded.Add,
    iconSize: Int = 20,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        // 圓形頭像
        CircularAvatar(avatarUrl = avatarUrl)

        // 加號圖標
        Image(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(iconSize.dp)
                .align(Alignment.BottomEnd)
                .background(Color.White, shape = RoundedCornerShape(50))
                .padding(2.dp)
        )
    }
}

@Composable
fun CircularAvatar(
    avatarUrl: String,
    modifier: Modifier = Modifier,
) {
    // 加載頭像圖片
    Image(
        painter = rememberAsyncImagePainter(avatarUrl),
        contentDescription = null,
        modifier = modifier
            .size(50.dp) // 調整頭像大小
            .clip(CircleShape), // 將頭像裁剪為圓形
    )
}