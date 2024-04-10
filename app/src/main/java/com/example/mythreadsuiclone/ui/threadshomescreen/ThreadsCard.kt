package com.example.mythreadsuiclone.ui.threadshomescreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mythreadsuiclone.ui.data.PostData

@Composable
fun ThreadsCard(
    postData: PostData,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (userAvatar, userName, editButton, postTime, postContent, postPics, cardFunRow) = createRefs()

        UserAvatar(
            avatarUrl = postData.userData.userAvatarUrl,
            modifier = Modifier.constrainAs(userAvatar) {
                top.linkTo(parent.top, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
            }
        )

        UserName(
            userName = postData.userData.userName,
            modifier = Modifier.constrainAs(userName) {
                top.linkTo(parent.top, margin = 9.dp)
                start.linkTo(userAvatar.end, margin = 5.dp)
            }
        )

        EditButton(
            modifier = Modifier.constrainAs(editButton) {
                centerVerticallyTo(userName)
                end.linkTo(parent.end, margin = 3.dp)
            }
        ) {}

        PostTime(
            postTime = postData.postTime,
            modifier = Modifier.constrainAs(postTime) {
                centerVerticallyTo(userName)
                end.linkTo(editButton.start, margin = 5.dp)
            }
        )

        PostContent(
            postContent = postData.description,
            modifier = Modifier.constrainAs(postContent) {
                top.linkTo(userName.bottom, margin = 5.dp)
                start.linkTo(userName.start)
                end.linkTo(parent.end, margin = 13.dp)
                width = Dimension.fillToConstraints
            }
        )
        val isPicExist = postData.postImageUrl.isNotEmpty()
        if (isPicExist) {
            PostPictures(
                postImageUrl = postData.postImageUrl,
                modifier = Modifier.constrainAs(postPics) {
                    top.linkTo(postContent.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                }
            )
        }
        CardFunctionRow(
            likeCount = postData.likeCount,
            isLiked = postData.isLiked,
            commentCount = postData.commentCount,
            repostCount = 0,
            modifier = Modifier.constrainAs(cardFunRow) {
                if (isPicExist) {
                    top.linkTo(postPics.bottom, margin = 10.dp)
                } else {
                    top.linkTo(postContent.bottom, margin = 10.dp)
                }
                start.linkTo(userName.start)
                end.linkTo(parent.end, margin = 50.dp)
                width = Dimension.fillToConstraints
            }
        )
    }
}
