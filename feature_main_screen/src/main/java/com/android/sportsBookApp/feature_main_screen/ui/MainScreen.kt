package com.android.sportsBookApp.feature_main_screen.ui

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.android.sportsBookApp.core_domain.model.SingleEventDomain
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_ui.component.LifecycleEffect


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(onEventClick: (SingleEventDomain) -> Unit) {
    val viewModel = hiltViewModel<MainViewModel>()
    val state = viewModel.viewState
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LifecycleEffect(
        lifecycleOwner = lifecycleOwner, lifecycleEvent = Lifecycle.Event.ON_CREATE
    ) {
        viewModel.setEvent(Event.GetSavedFavorites)
    }

    LifecycleEffect(
        lifecycleOwner = lifecycleOwner, lifecycleEvent = Lifecycle.Event.ON_RESUME
    ) {
        viewModel.setEvent(Event.GetSportsData(state.value.savedFavorites))
    }

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                titleContentColor = MaterialTheme.colorScheme.onTertiary
            ), title = { Text(text = stringResource(R.string.app_name)) })
    }) { paddingValues ->
        if (state.value.isLoading) Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        else LazyColumn(modifier = Modifier.padding(paddingValues)) {
            state.value.sportEvents?.let { sports ->
                items(sports.size) { index ->
                    MainScreenListItem(
                        sport = sports[index],
                        isEnabled = sports[index].hasFavorites,
                        expandSportCompetitions = {
                            viewModel.setEvent(Event.ExpandSportCompetitions(sports[index]))
                        },
                        toggleFavoriteEvent = { eventId, isFavorite ->
                            val favEvent = Pair(eventId, isFavorite)
                            viewModel.setEvent(Event.ToggleFavoriteEvent(sports[index], favEvent))
                        },
                        onFavoriteChanged = {
                            viewModel.setEvent(Event.HideShowFavorites(sports[index].sportId, it,state.value.sportEvents))
                        },
                        notifyNotEnabled = {
                            viewModel.setEvent(Event.ToggleFavoriteEventNotEnabled)
                        },
                        onItemClick = { event ->
                            onEventClick(
                                SingleEventDomain(
                                    sportName = sports[index].sportName,
                                    event = event
                                )
                            )
                        }
                    )

                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.effect.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .collect { effect ->
                when (effect) {
                    is Effect.ShowMessage -> Toast.makeText(
                        context,
                        effect.msg,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}
