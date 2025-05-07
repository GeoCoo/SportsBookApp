package com.android.sportsBookApp.feature_main_screen.ui

import android.annotation.SuppressLint
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_ui.component.LifecycleEffect


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val viewModel = hiltViewModel<MainViewModel>()
    val state = viewModel.viewState
    LifecycleEffect(
        lifecycleOwner = LocalLifecycleOwner.current,
        lifecycleEvent = Lifecycle.Event.ON_RESUME
    ) {
        viewModel.setEvent(Event.GetSports)
    }

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.surfaceTint
            ), title = { Text(text = stringResource(R.string.app_name)) })
    }) { paddingValues ->
        if (state.value.isLoading)
            CircularProgressIndicator()
        else
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                state.value.sportsList?.let {
                    items(it.size) { index ->
                        MainScreenListItem(it[index])
                    }
                }
            }

    }
}

