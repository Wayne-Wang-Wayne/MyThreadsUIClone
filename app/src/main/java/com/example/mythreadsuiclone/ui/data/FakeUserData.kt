package com.example.mythreadsuiclone.ui.data

class FakeUserData {
    companion object {
        val fakeUserData = mapOf(
            "1" to UserData(
                userID = "1",
                userName = "John Smith",
                userAvatarUrl = "https://randomuser.me/api/portraits/men/1.jpg",),
            "2" to UserData(
                userID = "2",
                userName = "Jane Doe",
                userAvatarUrl = "https://randomuser.me/api/portraits/women/2.jpg",),
            "3" to UserData(
                userID = "3",
                userName = "Michael Johnson",
                userAvatarUrl = "https://randomuser.me/api/portraits/men/3.jpg",),
            "4" to UserData(
                userID = "4",
                userName = "Olivia Brown",
                userAvatarUrl = "https://randomuser.me/api/portraits/women/4.jpg",),
            "5" to UserData(
                userID = "5",
                userName = "James Taylor",
                userAvatarUrl = "https://randomuser.me/api/portraits/men/5.jpg",),
        )
    }

}