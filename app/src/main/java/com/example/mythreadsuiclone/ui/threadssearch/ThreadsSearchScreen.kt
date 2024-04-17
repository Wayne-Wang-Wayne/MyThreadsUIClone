package com.example.mythreadsuiclone.ui.threadssearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mythreadsuiclone.ui.data.FakeSearchData

@Composable
fun ThreadsSearchScreen(
    modifier: Modifier = Modifier
) {
    val fakeSearchData = FakeSearchData.rememberFakeSearchData()
    val searchString by fakeSearchData.searchString
    val searchDataList = fakeSearchData.searchDataList

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Search",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        SearchBar(
            searchString = searchString,
            onSearchStringChange = fakeSearchData::onSearchStringChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(searchDataList, key = {index, _ -> index}) { _, searchData ->
                ThreadsSearchCard(
                    imageUrl = searchData.userData.userAvatarUrl,
                    title = searchData.userData.userName,
                    subtitle = searchData.userData.userID,
                    isFollowed = searchData.isFollowed,
                    isOfficial = searchData.userData.isOfficial,
                    followersImages = searchData.userData.followers.map { it.userAvatarUrl }
                )
            }
        }
    }
}