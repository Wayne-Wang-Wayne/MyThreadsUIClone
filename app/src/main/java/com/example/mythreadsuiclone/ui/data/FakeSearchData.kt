package com.example.mythreadsuiclone.ui.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class FakeSearchData {

    val searchString: MutableState<String> = mutableStateOf("")

    val searchDataList: List<SearchData> = listOf(
        SearchData(
            userData = FakeUserData.fakeUserData["1"]!!,
            isFollowed = false
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["2"]!!,
            isFollowed = true
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["3"]!!,
            isFollowed = false
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["4"]!!,
            isFollowed = true
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["5"]!!,
            isFollowed = false
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["6"]!!,
            isFollowed = true
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["7"]!!,
            isFollowed = false
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["8"]!!,
            isFollowed = true
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["9"]!!,
            isFollowed = false
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["10"]!!,
            isFollowed = true
        ),
        SearchData(
            userData = FakeUserData.fakeUserData["11"]!!,
            isFollowed = false
        ),
    )

    fun onSearchStringChange(newSearchString: String) {
        searchString.value = newSearchString
    }

    companion object {
        @Composable
        fun rememberFakeSearchData(): FakeSearchData {
            return remember {
                FakeSearchData()
            }
        }
    }
}