package com.android.sportsBookApp.feature_main_screen.router

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.sportsBookApp.feature_main_screen.ui.MainScreen


const val mainRoute = "main"

fun NavGraphBuilder.mainScreen() {
    composable(mainRoute) {
        MainScreen()
    }
}