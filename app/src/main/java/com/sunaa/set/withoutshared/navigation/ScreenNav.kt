package com.sunaa.set.withoutshared.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sunaa.set.withoutshared.presentation.DetailsScreenView
import com.sunaa.set.withoutshared.presentation.HomeScreenView
import com.sunaa.set.withoutshared.presentation.HomeViewModel

class ScreenNav(
    val navController: NavHostController,
) {

    fun navigateTo(route: String, itemIndex: Int) {
        navController.navigate("$route/$itemIndex") {
            // To avoid stack build-up
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    @OptIn(ExperimentalSharedTransitionApi::class)
    @Composable
    fun NavigationHost(
        coordinator: ScreenNav,
        startDestination: String,
        homeViewModel: HomeViewModel,
        sharedTransionScope : SharedTransitionScope
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {

            composable(route = "list") {
                HomeScreenView(homeViewModel.listItemsState.value, coordinator,
                    animatedVisibilityScope = this,
                    sharedTransitionScope = sharedTransionScope)
            }
            composable(
                route = "details/{itemIndex}",
                arguments = listOf(navArgument(name = "itemIndex") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->
                val myInteger = backStackEntry.arguments?.getInt("itemIndex") ?: 0
                DetailsScreenView(myInteger, homeViewModel,
                    animatedVisibilityScope = this,
                    sharedTransitionScope = sharedTransionScope)
            }
        }
    }
}