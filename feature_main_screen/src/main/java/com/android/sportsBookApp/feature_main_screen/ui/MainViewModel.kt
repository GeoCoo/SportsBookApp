package com.android.sportsBookApp.feature_main_screen.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.android.sportsBookApp.core_domain.interactor.FavoritesPartialState
import com.android.sportsBookApp.core_domain.interactor.SportsInteractor
import com.android.sportsBookApp.core_domain.interactor.SportsPartialState
import com.android.sportsBookApp.core_domain.model.SportsEventsDomain
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import com.android.sportsBookApp.core_ui.base.MviViewModel
import com.android.sportsBookApp.core_ui.base.ViewEvent
import com.android.sportsBookApp.core_ui.base.ViewSideEffect
import com.android.sportsBookApp.core_ui.base.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


data class State(
    val isLoading: Boolean,
    val sportEvents: List<SportsEventsDomain>? = listOf(),
    val savedFavorites: List<String>? = listOf(),
) : ViewState

sealed class Event : ViewEvent {
    data class GetSportsData(val savedFavorites: List<String>?) : Event()
    data class ExpandSportCompetitions(val sport: SportsEventsDomain) : Event()
    data class ToggleFavoriteEvent(
        val sport: SportsEventsDomain,
        val favEvent: Pair<String, Boolean>
    ) : Event()

    data object GetSavedFavorites : Event()
    data object ToggleFavoriteEventNotEnabled : Event()
    data class HideShowFavorites(
        val sportId: String?,
        val toggleFavorites: Boolean,
        val sportEvents: List<SportsEventsDomain>?
    ) : Event()

}

sealed class Effect : ViewSideEffect {
    data class ShowMessage(val msg: String) : Effect()
}


@HiltViewModel
class MainViewModel @Inject constructor(
    private val sportsInteractor: SportsInteractor,
    private val resourceProvider: ResourceProvider,
) : MviViewModel<Event, State, Effect>() {
    override fun setInitialState(): State = State(
        isLoading = true,
        sportEvents = listOf(),
        savedFavorites = listOf(),
    )

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun handleEvents(event: Event) {
        when (event) {
            is Event.GetSportsData -> {
                viewModelScope.launch {
                    sportsInteractor.getSports().collect {
                        when (it) {
                            is SportsPartialState.Failed -> {
                                setState {
                                    copy(
                                        isLoading = false
                                    )
                                }

                                setEffect {
                                    Effect.ShowMessage(it.errorMessage)
                                }
                            }

                            is SportsPartialState.NoData -> {
                                setState {
                                    copy(
                                        isLoading = false
                                    )
                                }
                                setEffect {
                                    Effect.ShowMessage(it.errorMessage)
                                }
                            }

                            is SportsPartialState.Success -> {
                                setState {
                                    copy(
                                        sportEvents = mapEvents(
                                            event.savedFavorites,
                                            it.sports
                                        ),
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
                    val sports = viewState.value.sportEvents?.map {
                        it.copy(isExpanded = if (it.sportId == event.sport.sportId) !it.isExpanded else it.isExpanded)
                    }
                    setState {
                        copy(sportEvents = sports?.toMutableList())
                    }
                }
            }

            is Event.ToggleFavoriteEvent -> {
                viewModelScope.launch {
                    val (eventId, isFavorite) = event.favEvent
                    when (isFavorite) {
                        true -> {
                            sportsInteractor.removeFavorite(eventId).collect {
                                when (it) {
                                    is FavoritesPartialState.Failed -> {
                                        setEffect {
                                            Effect.ShowMessage(it.errorMessage)
                                        }
                                    }

                                    is FavoritesPartialState.Success -> {
                                        setState {
                                            copy(
                                                savedFavorites = it.favorites,
                                                sportEvents = mapEvents(
                                                    it.favorites,
                                                    viewState.value.sportEvents
                                                )
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        false -> {
                            sportsInteractor.addFavorite(eventId).collect {
                                when (it) {
                                    is FavoritesPartialState.Failed -> {
                                        setEffect {
                                            Effect.ShowMessage(it.errorMessage)
                                        }
                                    }

                                    is FavoritesPartialState.Success -> {
                                        setState {
                                            copy(
                                                savedFavorites = it.favorites,
                                                sportEvents = mapEvents(
                                                    it.favorites,
                                                    viewState.value.sportEvents
                                                )
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            is Event.GetSavedFavorites -> {
                viewModelScope.launch {
                    sportsInteractor.getFavorites().collect {
                        setState {
                            copy(
                                savedFavorites = it,
                                sportEvents = mapEvents(
                                    it,
                                    viewState.value.sportEvents
                                )
                            )
                        }
                    }
                }
            }

            is Event.HideShowFavorites -> {
                viewModelScope.launch {
                    val sports = event.sportEvents.orEmpty()
                    val updatedList = sports.map { sport ->
                        if (sport.sportId != event.sportId) return@map sport

                        updateSportWithFavoritesToggle(
                            sport = sport,
                            toggleFavorites = event.toggleFavorites,
                            getNoFavoritesMessage = { resourceProvider.getString(R.string.no_sport_favs_msg) },
                            emitEffect = { setEffect { it } }
                        ) ?: sport
                    }

                    setState { copy(sportEvents = updatedList) }
                }

            }

            is Event.ToggleFavoriteEventNotEnabled -> {
                setEffect { Effect.ShowMessage(resourceProvider.getString(R.string.no_sport_favs_msg)) }
            }
        }
    }
}

private fun mapEvents(
    favorites: List<String>?,
    sports: List<SportsEventsDomain>?
): List<SportsEventsDomain>? = sports?.map { sport ->
    val updatedActiveEvents = sport.activeEvents?.map { event ->
        event.copy(isFavorite = event.eventId in (favorites.orEmpty()))
    }

    val updatedOriginalEvents = sport.originalEvents?.map { event ->
        event.copy(isFavorite = event.eventId in (favorites.orEmpty()))
    }

    sport.copy(
        activeEvents = updatedActiveEvents,
        originalEvents = updatedOriginalEvents,
        hasFavorites = updatedActiveEvents?.any { it.isFavorite == true } == true
    )
}

private fun updateSportWithFavoritesToggle(
    sport: SportsEventsDomain,
    toggleFavorites: Boolean,
    getNoFavoritesMessage: () -> String,
    emitEffect: (Effect) -> Unit
): SportsEventsDomain? {
    val allEvents = sport.originalEvents ?: sport.activeEvents.orEmpty()

    return if (toggleFavorites) {
        val favorites = allEvents.filter { it.isFavorite }

        if (favorites.isEmpty()) {
            emitEffect(Effect.ShowMessage(getNoFavoritesMessage()))
            return null
        }

        sport.copy(
            originalEvents = allEvents,
            activeEvents = favorites,
            hasFavorites = true
        )
    } else {
        sport.copy(
            activeEvents = sport.originalEvents ?: sport.activeEvents,
            originalEvents = null,
            hasFavorites = false
        )
    }

}
