package com.android.sportsBookApp.core_domain.controller

import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

const val FAVORITES = "FAVORITES"

interface FavoriteEventController {
    suspend fun getFavorites(): Flow<List<String>?>
    suspend fun addFavorite(eventId: String): Flow<FavoriteEventsControllerPartialState>
    suspend fun removeFavorite(eventId: String): Flow<FavoriteEventsControllerPartialState>
}

class FavoriteEventControllerImpl @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val preferencesController: PreferencesController,
    private val gson: Gson
) : FavoriteEventController {

    private fun loadFavorites(): MutableList<String> {
        val json = preferencesController.getString(FAVORITES, "")
        if (json.isEmpty()) {
            return mutableListOf()
        } else {
            val type = object : TypeToken<MutableList<String>?>() {}.type
            return (gson.fromJson<MutableList<String>?>(json, type).toMutableList())
        }
    }

    private fun saveFavorites(favorites: List<String>) {
        val jsonObject = gson.toJson(favorites)
        preferencesController.setString(FAVORITES, jsonObject)
    }

    override suspend fun getFavorites(): Flow<List<String>?> = flow {
        val favorites = loadFavorites()
        emit(favorites)
    }

    override suspend fun addFavorite(eventId: String) = flow {
        emit(updateFavorites(
            validate = { !it.contains(eventId) },
            modify = { add(eventId) }
        ))
    }

    override suspend fun removeFavorite(eventId: String) = flow {
        emit(updateFavorites(
            validate = { it.contains(eventId) },
            modify = { remove(eventId) }
        ))
    }


    private fun updateFavorites(
        validate: (List<String>) -> Boolean,
        modify: MutableList<String>.() -> Unit
    ): FavoriteEventsControllerPartialState {
        val favorites = loadFavorites()

        return if (validate(favorites)) {
            favorites.modify()
            saveFavorites(favorites)
            FavoriteEventsControllerPartialState.Success(favorites)
        } else {
            FavoriteEventsControllerPartialState.Fail(resourceProvider.getString(R.string.generic_error_msg))
        }
    }

}

sealed class FavoriteEventsControllerPartialState {
    data class Success(val favoriteEvents: List<String>) : FavoriteEventsControllerPartialState()
    data class Fail(val msg: String) : FavoriteEventsControllerPartialState()
}
