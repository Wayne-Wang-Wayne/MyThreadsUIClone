package com.example.mythreadsuiclone.ui.newpost

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mythreadsuiclone.ui.threadshomescreen.CardFunctionRow
import com.example.mythreadsuiclone.ui.threadshomescreen.CircularAvatar
import com.example.mythreadsuiclone.ui.threadshomescreen.EditButton
import com.example.mythreadsuiclone.ui.threadshomescreen.PostContent
import com.example.mythreadsuiclone.ui.threadshomescreen.PostPictures
import com.example.mythreadsuiclone.ui.threadshomescreen.PostTime
import com.example.mythreadsuiclone.ui.threadshomescreen.UserAvatar
import com.example.mythreadsuiclone.ui.threadshomescreen.UserName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPostTopBar(
    onExit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = { NewPostTitle() },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
        ),
        navigationIcon = {
            ExitButton(onClick = onExit)
        }
    )
}

@Composable
fun NewPostContentList(
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {

    }
}

@Composable
fun NewPostCard(
    imageUrl: String,
    userName: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (userAvatar, userNameRef, editButton, postTime, postContent, postPics, cardFunRow) = createRefs()

        // TODO: Complete the implementation of the NewPostCard composable

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

        UserName(userName = userName, modifier = Modifier.constrainAs(userNameRef) {
            top.linkTo(parent.top, margin = 9.dp)
            start.linkTo(userAvatar.end, margin = 5.dp)
        })
    }
}

@Composable
fun NewPostTitle(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "New Post",
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun ExitButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            tint = Color.White
        )
    }
}

@Composable
fun PostActionsRow(
    text: String,
    isEnable: Boolean,
    modifier: Modifier = Modifier,
    onPostClick: () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(text = text, color = Color.Gray, fontSize = 13.sp, modifier = Modifier.weight(1f))
        Button(
            onClick = if (isEnable) onPostClick else { {} },
            modifier = modifier
                .height(35.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isEnable) Color.White else Color.Gray.copy(alpha = 0.5f),
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Post",
                fontWeight = FontWeight.Bold,
            )
        }

    }
}
