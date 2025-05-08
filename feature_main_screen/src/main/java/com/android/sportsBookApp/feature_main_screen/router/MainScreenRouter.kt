package com.android.sportsBookApp.feature_main_screen.router

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.sportsBookApp.feature_main_screen.ui.MainScreen


const val mainRoute = "main"
const val infoRoute = "info"

fun NavGraphBuilder.mainScreen() {
    composable(mainRoute) {
        MainScreen()
    }
}

fun NavGraphBuilder.infoScreen() {
    composable(infoRoute) {
        MainScreen()
    }
}