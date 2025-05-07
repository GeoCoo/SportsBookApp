package com.android.sportsBookApp.feature_main_screen.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.android.sportsBookApp.core_domain.interactor.SportsInteractor
import com.android.sportsBookApp.core_domain.interactor.SportsPartialState
import com.android.sportsBookApp.core_model.SportsEventsDomain
import com.android.sportsBookApp.core_model.SportsEventsDto
import com.android.sportsBookApp.core_ui.base.MviViewModel
import com.android.sportsBookApp.core_ui.base.ViewEvent
import com.android.sportsBookApp.core_ui.base.ViewSideEffect
import com.android.sportsBookApp.core_ui.base.ViewState
import com.betson.interviewTest.core_resources.provider.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


data class State(
    val isLoading: Boolean = false,
    val sportsList: List<SportsEventsDomain>? = listOf()
) : ViewState

sealed class Event : ViewEvent {
    object GetSports : Event()
}

sealed class Effect : ViewSideEffect {}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sportsInteractor: SportsInteractor,resourceProvider:ResourceProvider
) : MviViewModel<Event, State, Effect>() {
    override fun setInitialState(): State = State(
        isLoading = true,
    )

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun handleEvents(event: Event) {
        when (event) {
            is Event.GetSports -> {
                viewModelScope.launch {
                    sportsInteractor.getSports().collect {
                        when (it) {
                            is SportsPartialState.Failed -> {}
                            is SportsPartialState.Success -> {
                                setState {
                                    copy(
                                        sportsList = it.sports,
                                        isLoading = false,
                                        )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

