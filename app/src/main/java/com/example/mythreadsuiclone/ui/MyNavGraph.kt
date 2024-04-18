package com.example.mythreadsuiclone.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mythreadsuiclone.ui.ThreadsNav.DETAIL_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.POST_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.SEARCH_ROUTE
import com.example.mythreadsuiclone.ui.ThreadsNav.THREADS_ROUTE
import com.example.mythreadsuiclone.ui.newpost.NewPostScreen

@Composable
fun MyNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    bottomBarNavController: NavHostController = rememberNavController(),
    startDestination: String = THREADS_ROUTE,
    navAction: ThreadsNavigationActions = remember(navController, bottomBarNavController) {
        ThreadsNavigationActions(navController, bottomBarNavController)
    }
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        threadsGraph(
            navAction = navAction,
            bottomBarNavController = bottomBarNavController,
        )
    }

}

fun NavGraphBuilder.threadsGraph(
    navAction: ThreadsNavigationActions,
    bottomBarNavController: NavHostController,
) {
    composable(THREADS_ROUTE) {
        ThreadsBottomBarNav(navAction, bottomBarNavController)
    }
    composable(POST_ROUTE) {
        NewPostScreen(
            onExit = { navAction.popBack() }
        )
    }
    composable(DETAIL_ROUTE) {

    }
    composable(SEARCH_ROUTE) {

    }
}
