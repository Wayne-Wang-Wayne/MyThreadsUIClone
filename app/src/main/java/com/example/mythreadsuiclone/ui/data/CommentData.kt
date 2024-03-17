package com.example.mythreadsuiclone.ui.data

data class CommentData (
    val commentID: String,
    val userData: UserData,
    val comment: String,
    val commentTime: Long,
    )