package com.example.mythreadsuiclone.ui.data

import com.example.mythreadsuiclone.ui.data.FakeUserData.Companion.fakeUserData

class FakePostData {
    companion object {
        val homeListData = listOf(
            PostData(
                postID = "1",
                userData = fakeUserData["1"]!!,
                description = "剛剛完成了在山上的徒步旅行，風景太美妙了！",
                postTime = 1620053948000, // 前一天
                postImageUrl = generateRandomSceneryImages(),
                likeCount = 100,
                commentCount = 20,
                comments = listOf(
                    CommentData(
                        commentID = "1",
                        userData = fakeUserData["2"]!!,
                        comment = "好美的風景！",
                        commentTime = 1620053948000
                    ),
                    CommentData(
                        commentID = "2",
                        userData = fakeUserData["3"]!!,
                        comment = "好想和你一起去！",
                        commentTime = 1620053948000
                    ),
                )
            ),
            PostData(
                postID = "2",
                userData = fakeUserData["2"]!!,
                description = "和朋友一起度過了一天，一起烤了餅乾，氛圍真的很溫馨！",
                postTime = 1620133948000, // 兩天前
                postImageUrl = generateRandomSceneryImages(),
                likeCount = 100,
                commentCount = 20,
                comments = listOf()
            ),
            fakeUserData.values.toList()
            ,
            PostData(
                postID = "3",
                userData = fakeUserData["3"]!!,
                description = "正在湖邊野餐，天氣真是太好了！",
                postTime = 1620213948000, // 三天前
                postImageUrl = generateRandomSceneryImages(),
                likeCount = 100,
                commentCount = 20,
                comments = listOf(
                    CommentData(
                        commentID = "3",
                        userData = fakeUserData["4"]!!,
                        comment = "好像很讚！",
                        commentTime = 1620213948000
                    ),
                    CommentData(
                        commentID = "4",
                        userData = fakeUserData["5"]!!,
                        comment = "一起去吃麻辣鍋！",
                        commentTime = 1620213948000
                    ),
                )
            ),
            PostData(
                postID = "4",
                userData = fakeUserData["4"]!!,
                description = "正在探索城市的隱藏寶藏，找到了一家超可愛的咖啡廳！",
                postTime = 1620293948000, // 四天前
                postImageUrl = generateRandomSceneryImages(),
                likeCount = 100,
                commentCount = 20,
                comments = listOf()
            ),
            PostData(
                postID = "5",
                userData = fakeUserData["5"]!!,
                description = "正在後院和朋友們一起燒烤，氣氛真的超棒！",
                postTime = 1620373948000, // 五天前
                postImageUrl = generateRandomSceneryImages(),
                likeCount = 100,
                commentCount = 20,
                comments = listOf()
            ),
        )

        private fun generateRandomSceneryImages(): List<String> {
            val imageCount = (1..3).random() // 隨機生成1~3張照片
            val images = mutableListOf<String>()
            repeat(imageCount) {
                val imageIndex = (1..100).random() // 隨機選擇一張風景圖片
                images.add("https://picsum.photos/600/400?random=$imageIndex")
            }
            return images
        }
    }
}