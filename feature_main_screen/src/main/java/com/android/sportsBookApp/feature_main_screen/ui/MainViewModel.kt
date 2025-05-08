package com.android.sportsBookApp.feature_main_screen.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.android.sportsBookApp.core_domain.interactor.FavoritesPartialState
import com.android.sportsBookApp.core_domain.interactor.SportsInteractor
import com.android.sportsBookApp.core_domain.interactor.SportsPartialState
import com.android.sportsBookApp.core_domain.model.SportsEventsDomain
import com.android.sportsBookApp.core_ui.base.MviViewModel
import com.android.sportsBookApp.core_ui.base.ViewEvent
import com.android.sportsBookApp.core_ui.base.ViewSideEffect
import com.android.sportsBookApp.core_ui.base.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


data class State(
    val isLoading: Boolean = false,
    val sportsList: List<SportsEventsDomain>? = listOf(),
    val savedFavorites: List<String>? = listOf(),
    val errorMessage: String? = null
) : ViewState

sealed class Event : ViewEvent {
    object GetSportsData : Event()
    data class ExpandSportCompetitions(val sport: SportsEventsDomain) : Event()
    data class ToggleFavoriteEvent(
        val sport: SportsEventsDomain,
        val favEvent: Pair<String, Boolean>
    ) :
        Event()

    object GetSavedFavorites : Event()

}

sealed class Effect : ViewSideEffect {
    object GetSavedFavorites : Effect()

}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sportsInteractor: SportsInteractor
) : MviViewModel<Event, State, Effect>() {
    override fun setInitialState(): State = State(
        isLoading = true,
    )

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun handleEvents(event: Event) {
        when (event) {
            is Event.GetSportsData -> {
                viewModelScope.launch {
                    sportsInteractor.getSports().collect {
                        when (it) {
                            is SportsPartialState.Failed -> {
                                setState{
                                    copy(errorMessage = it.errorMessage)
                                }
                            }
                            is SportsPartialState.Success -> {
                                setState {
                                    copy(
                                        sportsList = mapEvents(viewState.value.savedFavorites, it.sports),
                                        isLoading = false,
                                    )
                                }
                            }
                        }
                    }
                }
            }

            is Event.ExpandSportCompetitions -> {
                viewModelScope.launch {
                    val sports = viewState.value.sportsList?.map {
                        it.copy(isExpanded = if (it.sportId == event.sport.sportId) !it.isExpanded else it.isExpanded)
                    }
                    setState {
                        copy(sportsList = sports?.toMutableList())
                    }
                }
            }

            is Event.ToggleFavoriteEvent -> {
                viewModelScope.launch {
                    val isFavorite = event.favEvent.second
                    val eventId = event.favEvent.first
                    when (isFavorite) {
                        true -> sportsInteractor.removeFavorite(eventId)
                        false -> sportsInteractor.addFavorite(eventId)
                    }
                    setEffect {
                        Effect.GetSavedFavorites
                    }
                }
            }

            is Event.GetSavedFavorites -> {
                viewModelScope.launch {
                    sportsInteractor.getFavorites().collect {
                        when (it) {
                            is FavoritesPartialState.Failed -> {
                                setState { copy(errorMessage = it.errorMessage) }
                            }

                            is FavoritesPartialState.Success -> {
                                setState {
                                    copy(
                                        savedFavorites = it.favorites,
                                        sportsList = mapEvents(it.favorites, viewState.value.sportsList)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun mapEvents(
        favorites: List<String>?,
        sports: List<SportsEventsDomain>?
    ): List<SportsEventsDomain>? {
        return sports?.map { sport ->
            val updatedEvents = sport.activeEvents.map { event ->
                event.copy(isFavorite = event.eventId in (favorites ?: emptyList()))
            }
            sport.copy(activeEvents = updatedEvents)
        }
    }
}

