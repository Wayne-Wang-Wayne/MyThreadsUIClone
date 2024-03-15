package com.example.mythreadsuiclone.ui

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.example.mythreadsuiclone.ui.ThreadsNav.DETAIL_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.POST_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.SEARCH_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_ACTIVITY_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_HOME_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_PROFILE_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_SEARCH_ROUTE

object ThreadsNav {
    const val THREADS_ROUTE = "threads"
    const val THREADS_HOME_ROUTE = "$THREADS_ROUTE/home"
    const val THREADS_SEARCH_ROUTE = "$THREADS_ROUTE/search"
    const val POST_ROUTE = "post"
    const val THREADS_ACTIVITY_ROUTE = "$THREADS_ROUTE/activity"
    const val THREADS_PROFILE_ROUTE = "$THREADS_ROUTE/profile"
    const val DETAIL_ROUTE = "detail"
    const val SEARCH_ROUTE = "search"
}

class ThreadsNavigationActions(private val navController: NavHostController, private val bottomBarNavController: NavHostController) {

    fun navigateToThreadsHome() {
        bottomBarNavController.navigate(THREADS_HOME_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToThreadsSearch() {
        bottomBarNavController.navigate(THREADS_SEARCH_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToThreadsPost() {
        navController.navigate(POST_ROUTE)
    }

    fun navigateToThreadsActivity() {
        bottomBarNavController.navigate(THREADS_ACTIVITY_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToThreadsProfile() {
        bottomBarNavController.navigate(THREADS_PROFILE_ROUTE) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }

    fun navigateToDetail() {
        navController.navigate(DETAIL_ROUTE)
    }

    fun navigateToSearch() {
        navController.navigate(SEARCH_ROUTE)
    }

    fun popBack() {
        navController.popBackStack()
    }

}