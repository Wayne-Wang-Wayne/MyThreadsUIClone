package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mythreadsuiclone.ui.data.UserData

@Composable
fun RecommendedUserList(
    recommendedUserList: List<UserData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "為你推薦",
            color = Color.Gray
        )

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
    Column(
        modifier = modifier
    ) {

    }
}