package com.example.mythreadsuiclone.ui.data

data class PostData (
    val postID: String,
    val userData: UserData,
    val description: String,
    val postTime: Long,
    val postImageUrl: List<String>,
    val likeCount: Int,
    val commentCount: Int,
    val isLiked: Boolean,
    val comments: List<CommentData>,
)