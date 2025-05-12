package com.android.sportsBookApp.core_domain.interactor


import com.android.sportsBookApp.core_data.repository.SportsRepository
import com.android.sportsBookApp.core_data.repository.SportsResponse
import com.android.sportsBookApp.core_domain.controller.FavoriteEventController
import com.android.sportsBookApp.core_domain.controller.FavoriteEventsControllerPartialState
import com.android.sportsBookApp.core_domain.interactor.FavoritesPartialState.Failed
import com.android.sportsBookApp.core_domain.interactor.FavoritesPartialState.Success
import com.android.sportsBookApp.core_domain.model.SportsEventsDomain
import com.android.sportsBookApp.core_domain.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface SportsInteractor {
    suspend fun getSports(): Flow<SportsPartialState>
    suspend fun addFavorite(eventId: String): Flow<FavoritesPartialState>
    suspend fun removeFavorite(eventId: String): Flow<FavoritesPartialState>
    suspend fun getFavorites(): Flow<List<String>?>
}

class SportsInteractorImpl @Inject constructor(
    private val sportsRepository: SportsRepository,
    private val favoriteEventController: FavoriteEventController
) :
    SportsInteractor {
    override suspend fun getSports(): Flow<SportsPartialState> = flow {
        sportsRepository.getSports().collect { response ->
            when (response) {
                is SportsResponse.Success -> {
                    emit(SportsPartialState.Success(response.sports?.map { it.toDomain() }))
                }

                is SportsResponse.Failed -> {
                    emit(SportsPartialState.Failed(response.errorMsg))
                }

                is SportsResponse.NoData -> {
                    emit(SportsPartialState.NoData(response.msg))
                }
            }
        }
    }

    override suspend fun addFavorite(eventId: String) = flow {
        favoriteEventController.addFavorite(eventId).collect {
            when (it) {
                is FavoriteEventsControllerPartialState.Success -> {
                    emit(Success(it.favoriteEvents))
                }

                is FavoriteEventsControllerPartialState.Fail -> {
                    emit(Failed(it.msg))
                }
            }
        }
    }

    override suspend fun removeFavorite(eventId: String) = flow {
        favoriteEventController.removeFavorite(eventId).collect {
            when (it) {
                is FavoriteEventsControllerPartialState.Fail -> {
                    emit(Failed(it.msg))
                }

                is FavoriteEventsControllerPartialState.Success -> {
                    emit(Success(it.favoriteEvents))
                }

            }
        }
    }

    override suspend fun getFavorites(): Flow<List<String>?> = flow {
        favoriteEventController.getFavorites().collect {
            emit(it)
        }
    }
}


sealed class SportsPartialState {
    data class Success(val sports: List<SportsEventsDomain>?) : SportsPartialState()
    data class Failed(val errorMessage: String) : SportsPartialState()
    data class NoData(val errorMessage: String) : SportsPartialState()

}

sealed class FavoritesPartialState {
    data class Success(val favorites: List<String>?) : FavoritesPartialState()
    data class Failed(val errorMessage: String) : FavoritesPartialState()
}
