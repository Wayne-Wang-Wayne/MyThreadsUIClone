package com.example.mythreadsuiclone.ui.threadssearch

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(
    searchString: String,
    modifier: Modifier = Modifier,
    onSearchStringChange: (String) -> Unit = {},
) {
    TextField(
        value = searchString,
        onValueChange = { onSearchStringChange(it) },
        placeholder = { Text("Search", color = Color.Gray) },
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            backgroundColor = Color(0xFF1e1e1e),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
    )
}