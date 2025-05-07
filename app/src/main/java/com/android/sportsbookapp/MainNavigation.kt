package com.android.sportsbookapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.android.sportsBookApp.feature_main_screen.router.mainRoute
import com.android.sportsBookApp.feature_main_screen.router.mainScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = mainRoute) {
        mainScreen()
    }
}