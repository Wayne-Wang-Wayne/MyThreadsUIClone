package com.example.mythreadsuiclone.ui

import androidx.navigation.NavHostController
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_ACTIVITY_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_HOME_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_POST_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_PROFILE_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_SEARCH_ROUTE

object ThreadsNav {
    const val THREADS_ROUTE = "threads"
    const val THREADS_HOME_ROUTE = "$THREADS_ROUTE/home"
    const val THREADS_SEARCH_ROUTE = "$THREADS_ROUTE/search"
    const val THREADS_POST_ROUTE = "$THREADS_ROUTE/post"
    const val THREADS_ACTIVITY_ROUTE = "$THREADS_ROUTE/activity"
    const val THREADS_PROFILE_ROUTE = "$THREADS_ROUTE/profile"
}

class ThreadsNavigationActions(private val navController: NavHostController) {

    fun navigateToThreadsHome() {
        navController.navigate(THREADS_HOME_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToThreadsSearch() {
        navController.navigate(THREADS_SEARCH_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToThreadsPost() {
        navController.navigate(THREADS_POST_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToThreadsActivity() {
        navController.navigate(THREADS_ACTIVITY_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToThreadsProfile() {
        navController.navigate(THREADS_PROFILE_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun popBack() {
        navController.popBackStack()
    }

}