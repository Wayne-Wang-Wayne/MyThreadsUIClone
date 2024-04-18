package com.example.mythreadsuiclone.ui.threadssearch

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mythreadsuiclone.ui.commonComponents.HalfCoverRow
import com.example.mythreadsuiclone.ui.threadshomescreen.CircularAvatar
import com.example.mythreadsuiclone.ui.threadshomescreen.UserName

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

@Preview
@Composable
fun ThreadsSearchCardPreview() {
    ThreadsSearchCard(
        imageUrl = "https://randomuser.me/api/portraits/men/50.jpg",
        title = "User Name",
        subtitle = "User ID",
        isFollowed = false,
        isOfficial = false,
        followersImages = listOf("https://randomuser.me/api/portraits/women/10.jpg", "https://randomuser.me/api/portraits/men/15.jpg")
    )
}

@Composable
fun ThreadsSearchCard(
    imageUrl: String,
    title: String,
    subtitle: String,
    isFollowed: Boolean,
    isOfficial: Boolean,
    followersImages: List<String>,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 4.dp)
    ) {
        val (userAvatar, titleRef, subtitleRef, followButton, followersImagesRow, blueCheckRef, bottomDividerRef) = createRefs()
        CircularAvatar(
            avatarUrl = imageUrl,
            isOfficial = false,
            modifier = Modifier
                .size(40.dp)
                .constrainAs(userAvatar) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                }
        )
        UserName(
            userName = title,
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(userAvatar.top)
                start.linkTo(userAvatar.end, margin = 8.dp)
            }
        )
        if (isOfficial) {
            BlueCheckCircle(
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(blueCheckRef) {
                        top.linkTo(titleRef.top)
                        bottom.linkTo(titleRef.bottom)
                        start.linkTo(titleRef.end, margin = 4.dp)
                    }
            )
        }
        Text(
            text = subtitle,
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(subtitleRef) {
                top.linkTo(titleRef.bottom, margin = 4.dp)
                start.linkTo(titleRef.start)
            }
        )
        FollowersRow(
            followersImages = followersImages,
            modifier = Modifier.constrainAs(followersImagesRow) {
                top.linkTo(subtitleRef.bottom, margin = 4.dp)
                start.linkTo(titleRef.start)
            }
        )
        FollowButton(
            isFollowed,
            modifier = Modifier
                .constrainAs(followButton) {
                    top.linkTo(parent.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                }
                .height(35.dp)
        )
        Divider(
            color = Color.Gray,
            thickness = 0.5.dp,
            modifier = Modifier
                .constrainAs(bottomDividerRef) {
                    top.linkTo(followersImagesRow.bottom, margin = 16.dp)
                    start.linkTo(titleRef.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Composable
fun FollowersRow(
    followersImages: List<String>,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        HalfCoverRow {
            followersImages.take(2).forEachIndexed { _, imageUrl ->
                CircularAvatar(
                    avatarUrl = imageUrl,
                    isOfficial = false,
                    modifier = Modifier
                        .size(23.dp)
                        .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                )
            }
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "${followersImages.size} 位粉絲",
            color = Color.White,
            fontSize = 14.sp,
        )
    }
}


@Composable
fun FollowButton(
    isFollowed: Boolean,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        modifier = modifier,
        onClick = { },
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
        )
    ){
        Text( text = if (isFollowed) "Follow back" else "Follow" )
    }
}

@Composable
fun BlueCheckCircle(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = Icons.Default.CheckCircle,
        tint = Color(0xFF1DA1F2),
        contentDescription = null,
        modifier = modifier
    )
}