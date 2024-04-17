package com.example.mythreadsuiclone.ui.data

import kotlin.random.Random

class FakeUserData {
    companion object {
        val fakeUserData by lazy {
            mutableMapOf<String, UserData>().apply {
                repeat(100) { index ->
                    val userId = (index + 1).toString()
                    val userName = generateRandomName()
                    val userAvatarUrl = generateRandomAvatarUrl()
                    val isOfficial = index % 3 == 0

                    this[userId] = UserData(
                        userID = userId,
                        userName = userName,
                        userAvatarUrl = userAvatarUrl,
                        isOfficial = isOfficial,
                    )
                }
                // randomly assign followers
                this.values.forEach { userData ->
                    userData.followers.addAll(this.values.filter { it != userData }
                        .shuffled()
                        .take(Random.nextInt(1, 99)))
                }
            }
        }

        private fun generateRandomName(): String {
            val names = listOf(
                "John Smith", "Jane Doe", "Michael Johnson", "Olivia Brown", "James Taylor",
                "Emma Lee", "Daniel Wilson", "Sophia Garcia", "William Martinez", "Isabella Robinson",
                "Joseph Clark", "Charlotte Rodriguez", "David Lewis", "Amelia Hall", "Benjamin Young",
                "Mia Allen", "Samuel Hernandez", "Evelyn King", "Ethan Wright", "Avery Scott",
                "Alexander Torres", "Scarlett Nguyen", "Matthew Hill", "Madison Green", "Henry Adams",
                "Lily Baker", "Luke Perez", "Grace Baker", "Gabriel Reed", "Aria Cook",
                "Jack Cooper", "Zoe Rivera", "Owen Ward", "Nora Coleman", "Connor Richardson",
                "Penelope Cox", "Levi Howard", "Hannah Ward", "Isaac Mitchell", "Ariana Flores",
            )
            return names.random()
        }


        private fun generateRandomAvatarUrl(): String {
            val genders = listOf("men", "women")
            val randomGender = genders.random()
            val randomUserId = Random.nextInt(1, 100)
            return "https://randomuser.me/api/portraits/$randomGender/$randomUserId.jpg"
        }
    }



}