package com.android.sportsBookApp.feature_single_event.ui


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.sportsBookApp.core_domain.model.EventDomain
import com.android.sportsBookApp.core_domain.model.SingleEventDomain
import com.android.sportsBookApp.core_ui.component.LifecycleEffect
import com.android.sportsBookApp.core_ui.component.MatchCard


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SingleEventScreen(event: SingleEventDomain,navController:NavController) {
    val viewModel = hiltViewModel<SingleEventVIewModel>()
    val state = viewModel.viewState
    val lifecycleOwner = LocalLifecycleOwner.current

    LifecycleEffect(
        lifecycleOwner = lifecycleOwner, lifecycleEvent = Lifecycle.Event.ON_CREATE
    ) {
        viewModel.setEvent(Event.HandleEvent(event))
    }

    LifecycleEffect(
        lifecycleOwner = lifecycleOwner, lifecycleEvent = Lifecycle.Event.ON_RESUME
    ) {
    }

    Scaffold(topBar = {
        TopAppBar(
            navigationIcon =
                {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                titleContentColor = MaterialTheme.colorScheme.onTertiary
            ), title = { state.value.sportName?.let { Text(text = it) } }
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.value.event?.let { MatchCard(it, toggleFavoriteEvent = {_,_->}, onEventClick = {}) }

        }
    }

}
