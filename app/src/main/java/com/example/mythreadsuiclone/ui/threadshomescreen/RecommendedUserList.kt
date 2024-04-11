package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mythreadsuiclone.ui.data.UserData
import com.example.mythreadsuiclone.ui.theme.CardBackgroundColor

@Composable
fun RecommendedUserList(
    recommendedUserList: List<UserData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "為你推薦",
            color = Color.Gray,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.height(200.dp)
        ) {
            items(recommendedUserList, key = { userData -> userData.userID }) { userData ->
                RecommendedUserCard(
                    userData = userData
                )
            }
        }
    }

}

@Composable
fun RecommendedUserCard(
    userData: UserData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = CardBackgroundColor
        )
    ) {
        Box(
            modifier = Modifier.padding(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularAvatar(
                    avatarUrl = userData.userAvatarUrl,
                    modifier = Modifier.size(100.dp)
                )
            }

            Icon(
                imageVector = Icons.Default.Close,
                tint = Color.Gray,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.TopEnd)
            )
        }
    }
}