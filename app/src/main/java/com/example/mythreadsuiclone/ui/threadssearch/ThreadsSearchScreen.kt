package com.example.mythreadsuiclone.ui.threadssearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
        modifier = modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Search",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = searchString,
            onValueChange = { fakeSearchData.onSearchStringChange(it) },
            placeholder = { Text("Search", color = Color.Gray) },
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray)
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                backgroundColor = Color(0xFF1e1e1e),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.White
            ),
            singleLine = true,
        )
    }
}