package com.android.sportsBookApp.core_domain.interactor


import com.android.sportsBookApp.core_data.repository.SportsRepository
import com.android.sportsBookApp.core_data.repository.SportsResponse
import com.android.sportsBookApp.core_domain.controller.FavoriteEventController
import com.android.sportsBookApp.core_domain.controller.FavoriteEventsControllerPartialState
import com.android.sportsBookApp.core_domain.model.SportsEventsDomain
import com.android.sportsBookApp.core_domain.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface SportsInteractor {
    fun getSports(): Flow<SportsPartialState>
    fun addFavorite(eventId: String)
    fun removeFavorite(eventId: String)
    fun getFavorites(): Flow<FavoritesPartialState>
}

class SportsInteractorImpl @Inject constructor(
    private val sportsRepository: SportsRepository,
    private val favoriteEventController: FavoriteEventController
) :
    SportsInteractor {
    override fun getSports(): Flow<SportsPartialState> = flow {
        sportsRepository.getSports().collect { response ->
            when (response) {
                is SportsResponse.Success -> emit(SportsPartialState.Success(response.sports?.map { it.toDomain() }))
                is SportsResponse.Failed -> emit(SportsPartialState.Failed(response.errorMsg))
            }
        }

    }

    override fun addFavorite(eventId: String) {
        favoriteEventController.addFavorite(eventId)
    }

    override fun removeFavorite(eventId: String) {
        favoriteEventController.removeFavorite(eventId)
    }

    override fun getFavorites(): Flow<FavoritesPartialState> = flow {
        favoriteEventController.getFavorites().collect {
            when (it) {
                is FavoriteEventsControllerPartialState.Success -> emit(
                    FavoritesPartialState.Success(
                        it.favoriteEvents
                    )
                )

                is FavoriteEventsControllerPartialState.Fail -> {
                    emit(FavoritesPartialState.Failed(it.msg))
                }
            }
        }
    }
}


sealed class SportsPartialState {
    data class Success(val sports: List<SportsEventsDomain>?) : SportsPartialState()
    data class Failed(val errorMessage: String) : SportsPartialState()
}

sealed class FavoritesPartialState {
    data class Success(val favorites: List<String>?) : FavoritesPartialState()
    data class Failed(val errorMessage: String) : FavoritesPartialState()
}