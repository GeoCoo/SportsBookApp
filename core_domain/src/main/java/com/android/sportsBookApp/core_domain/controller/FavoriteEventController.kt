package com.android.sportsBookApp.core_domain.controller

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface FavoriteEventController {
    suspend fun getFavorites(): Flow<FavoriteEventsControllerPartialState>
    suspend fun addFavorite(eventId: String): Flow<FavoriteEventsControllerPartialState>
    suspend fun removeFavorite(eventId: String): Flow<FavoriteEventsControllerPartialState>
}

class FavoriteEventControllerImpl @Inject constructor(
    private val preferencesController: PreferencesController,
    private val gson: Gson
) : FavoriteEventController {

    private fun loadFavorites(): MutableList<String> {
        val json = preferencesController.getString("FAVORITES", "")
        if (json.isEmpty()) {
            return mutableListOf()
        } else {
            val type = object : TypeToken<MutableList<String>?>() {}.type
            return (gson.fromJson<MutableList<String>?>(json, type).toMutableList())
        }
    }

    private fun saveFavorites(favorites: List<String>) {
        val jsonObject = gson.toJson(favorites)
        preferencesController.setString("FAVORITES", jsonObject)
    }

    override suspend fun getFavorites(): Flow<FavoriteEventsControllerPartialState> = flow {
        val favorites = loadFavorites()
        when {
            favorites.isEmpty() -> emit(FavoriteEventsControllerPartialState.Fail(""))
            else -> emit(FavoriteEventsControllerPartialState.Success(favorites))
        }
    }

    override suspend fun addFavorite(eventId: String) = flow {
        emit(updateFavorites { add(eventId) })
    }

    override suspend fun removeFavorite(eventId: String) = flow {
        emit(updateFavorites { remove(eventId) })
    }

    private fun updateFavorites(
        modify: MutableList<String>.() -> Boolean
    ): FavoriteEventsControllerPartialState {
        val favorites = loadFavorites()
        val changed = favorites.modify()
        if (changed) saveFavorites(favorites)
        return FavoriteEventsControllerPartialState.Success(favorites)
    }
}

sealed class FavoriteEventsControllerPartialState {
    data class Success(val favoriteEvents: List<String>) : FavoriteEventsControllerPartialState()
    data class Fail(val msg: String) : FavoriteEventsControllerPartialState()
}
