package com.example.mythreadsuiclone.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun ThreadsBottomBarNav(
    navAction: ThreadsNavigationActions,
    bottomBarNavController: NavHostController
) {
    val navBackStackEntry by bottomBarNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route ?: ThreadsNav.THREADS_HOME_ROUTE
    val items = getBottomBarItems(currentDestination, navAction)
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.Black
            ) {
                items.forEach { bottomBarItem ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                if (bottomBarItem.isSelected) bottomBarItem.selectedIcon else bottomBarItem.unselectedIcon,
                                tint = if (bottomBarItem.isSelected) Color.White else Color.Gray,
                                contentDescription = null
                            )
                        },
                        selected = bottomBarItem.isSelected,
                        onClick = bottomBarItem.onClick
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(bottomBarNavController, startDestination = ThreadsNav.THREADS_HOME_ROUTE, Modifier.padding(innerPadding)) {
            threadsBottomBarGraph()
        }
    }
}

private fun NavGraphBuilder.threadsBottomBarGraph() {
    composable(ThreadsNav.THREADS_HOME_ROUTE) {

    }
    composable(ThreadsNav.THREADS_SEARCH_ROUTE) {

    }
    composable(ThreadsNav.THREADS_ACTIVITY_ROUTE) {

    }
    composable(ThreadsNav.THREADS_PROFILE_ROUTE) {

    }
}

data class BottomBarItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val isSelected: Boolean,
    val onClick: () -> Unit
)

fun getBottomBarItems(route: String, navAction: ThreadsNavigationActions) = listOf(
    BottomBarItem(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        isSelected = route == ThreadsNav.THREADS_HOME_ROUTE,
        onClick = {
            navAction.navigateToThreadsHome()
        }
    ),
    BottomBarItem(
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        isSelected = route == ThreadsNav.THREADS_SEARCH_ROUTE,
        onClick = {
            navAction.navigateToThreadsSearch()
        }
    ),
    BottomBarItem(
        selectedIcon = Icons.Filled.Edit,
        unselectedIcon = Icons.Outlined.Edit,
        isSelected = route == ThreadsNav.POST_ROUTE,
        onClick = {
            navAction.navigateToThreadsPost()
        }
    ),
    BottomBarItem(
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.Favorite,
        isSelected = route == ThreadsNav.THREADS_ACTIVITY_ROUTE,
        onClick = {
            navAction.navigateToThreadsActivity()
        }
    ),
    BottomBarItem(
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        isSelected = route == ThreadsNav.THREADS_PROFILE_ROUTE,
        onClick = {
            navAction.navigateToThreadsProfile()
        }
    )
)