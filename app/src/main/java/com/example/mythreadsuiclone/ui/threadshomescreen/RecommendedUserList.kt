package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
            modifier = modifier
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
            modifier = Modifier
                .padding(10.dp)
                .width(140.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularAvatar(
                    avatarUrl = userData.userAvatarUrl,
                    isOfficial = userData.isOfficial,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = userData.userName,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = userData.userID,
                    color = Color.Gray
                )
                Spacer(modifier =  Modifier.height(10.dp))
                RecommendFollowButton()
                Spacer(modifier = Modifier.height(10.dp))
            }

            Icon(
                imageVector = Icons.Default.Close,
                tint = Color.Gray,
                contentDescription = null,
                modifier = Modifier
                    .size(13.dp)
                    .align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
fun RecommendFollowButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(40.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "Follow",
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}