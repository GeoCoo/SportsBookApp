package com.android.sportsBookApp.navigation

sealed class Screen(val route: String) {
    object Sports : Screen("sports")
    object SingleEvent : Screen("singleEvent/{singleEvent}") {
        fun createRoute(event: String?) = "singleEvent/$event"
    }
}