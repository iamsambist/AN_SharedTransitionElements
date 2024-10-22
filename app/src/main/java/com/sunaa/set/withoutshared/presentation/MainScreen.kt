package com.sunaa.set.withoutshared.presentation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.sunaa.set.withoutshared.navigation.ScreenNav

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ScreenMainView(
    homeViewModel: HomeViewModel = viewModel()
) {
    val navHostController = rememberNavController()
    val coordinator: ScreenNav = remember { ScreenNav(navHostController) }
    var startDestination = "list"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())
    ) {
        SharedTransitionLayout {
            coordinator.NavigationHost(
                coordinator = coordinator, startDestination = startDestination,
                homeViewModel, this@SharedTransitionLayout
            )
        }

    }

}