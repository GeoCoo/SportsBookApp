package com.android.sportsBookApp.feature_main_screen.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_ui.component.LifecycleEffect


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val viewModel = hiltViewModel<MainViewModel>()
    val state = viewModel.viewState
    val lifecycleOwner = LocalLifecycleOwner.current

    LifecycleEffect(
        lifecycleOwner = lifecycleOwner, lifecycleEvent = Lifecycle.Event.ON_CREATE
    ) {
        viewModel.setEvent(Event.GetSavedFavorites)
    }

    LifecycleEffect(
        lifecycleOwner = lifecycleOwner, lifecycleEvent = Lifecycle.Event.ON_RESUME
    ) {
        viewModel.setEvent(Event.GetSportsData)
    }

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.surfaceTint
            ), title = { Text(text = stringResource(R.string.app_name)) })
    }) { paddingValues ->
        if (state.value.isLoading) Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        else LazyColumn(modifier = Modifier.padding(paddingValues)) {
            state.value.sportsList?.let {sports->
                items(sports.size) { index ->
                    MainScreenListItem(sports[index], expandSportCompetitions = {
                        viewModel.setEvent(Event.ExpandSportCompetitions(sports[index]))
                    },toggleFavoriteEvent = { eventId,isFavorite ->
                        val favEvent = Pair(eventId,isFavorite)
                        viewModel.setEvent(Event.ToggleFavoriteEvent(sports[index],favEvent))
                    })

                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.effect.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .collect { effect ->
                when (effect) {
                    Effect.GetSavedFavorites -> {viewModel.setEvent(Event.GetSavedFavorites)}
                }
            }
    }

}
