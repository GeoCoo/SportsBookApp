package com.android.sportsBookApp.feature_main_screen.ui

import android.os.Build
import androidx.annotation.RequiresApi
import com.android.sportsBookApp.core_ui.base.MviViewModel
import com.android.sportsBookApp.core_ui.base.ViewEvent
import com.android.sportsBookApp.core_ui.base.ViewSideEffect
import com.android.sportsBookApp.core_ui.base.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


data class State(
    val isLoading: Boolean = false
) : ViewState

sealed class Event : ViewEvent {
}

sealed class Effect : ViewSideEffect {}

@HiltViewModel
class MainViewModel @Inject constructor(
) : MviViewModel<Event, State, Effect>() {
    override fun setInitialState(): State = State(
        isLoading = true,
    )

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun handleEvents(event: Event) {

    }
}

