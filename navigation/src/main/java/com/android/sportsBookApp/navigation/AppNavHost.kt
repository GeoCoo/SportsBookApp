package com.android.sportsBookApp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.sportsBookApp.core_common.helpers.deserialize
import com.android.sportsBookApp.core_common.helpers.serialize
import com.android.sportsBookApp.core_domain.model.EventDomain
import com.android.sportsBookApp.core_domain.model.SingleEventDomain
import com.android.sportsBookApp.feature_main_screen.ui.MainScreen
import com.android.sportsBookApp.feature_single_event.ui.SingleEventScreen
import com.google.gson.Gson


@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Sports.route
    ) {
        composable(route = Screen.Sports.route) {
            MainScreen(onEventClick = { event ->
                val eventArg = event.serialize(Gson())
                navController.navigate(Screen.SingleEvent.createRoute(eventArg))
            })
        }

        composable(
            route = Screen.SingleEvent.route,
            arguments = listOf(
                navArgument("singleEvent") { type = NavType.StringType })
        ) { backStackEntry ->
            val eventArg = backStackEntry.arguments?.getString("singleEvent") ?: return@composable
            val event = eventArg.deserialize<SingleEventDomain>(Gson())
            SingleEventScreen(event = event, navController = navController)
        }
    }
}