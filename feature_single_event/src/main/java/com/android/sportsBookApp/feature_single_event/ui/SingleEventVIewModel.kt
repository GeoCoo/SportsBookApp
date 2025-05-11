package com.android.sportsBookApp.feature_single_event.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.android.sportsBookApp.core_domain.model.EventDomain
import com.android.sportsBookApp.core_domain.model.SingleEventDomain
import com.android.sportsBookApp.core_ui.base.MviViewModel
import com.android.sportsBookApp.core_ui.base.ViewEvent
import com.android.sportsBookApp.core_ui.base.ViewSideEffect
import com.android.sportsBookApp.core_ui.base.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


data class State(
    val isLoading: Boolean,
    val event: EventDomain? = null,
    val sportName: String? = ""
) : ViewState

sealed class Event : ViewEvent {
    data class HandleEvent(val event: SingleEventDomain?) : Event()
}

sealed class Effect : ViewSideEffect {}

@HiltViewModel
class SingleEventVIewModel @Inject constructor() : MviViewModel<Event, State, Effect>() {
    override fun setInitialState(): State = State(
        isLoading = true
    )

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun handleEvents(event: Event) {
        when (event) {
            is Event.HandleEvent -> {
                viewModelScope.launch {
                    setState {
                        copy(
                            sportName = event.event?.sportName,
                            event = event.event?.event,
                            isLoading = false
                        )
                    }
                }
            }
        }

    }

}