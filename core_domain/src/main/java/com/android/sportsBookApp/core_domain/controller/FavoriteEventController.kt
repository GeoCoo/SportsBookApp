package com.android.sportsBookApp.core_domain.controller

import com.android.sportsBookApp.core_domain.model.EventDomain
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.prefs.Preferences
import javax.inject.Inject
import kotlin.collections.count
import kotlin.collections.reversed
import kotlin.collections.takeLast
import kotlin.collections.toMutableList
import kotlin.text.isEmpty

interface FavoriteEventController {
    fun getFavorites(): Flow<FavoriteEventsControllerPartialState>
    fun addFavorite(eventId: String)
    fun removeFavorite(eventId: String)

}

class FavoriteEventControllerImpl @Inject constructor(
    private val preferencesController: PreferencesController,
    private val externalScope: CoroutineScope,
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


    override fun getFavorites(): Flow<FavoriteEventsControllerPartialState> = flow {
        val favorites = loadFavorites()
        when {
            favorites.isEmpty() -> emit(FavoriteEventsControllerPartialState.Fail(""))
            else ->  emit (FavoriteEventsControllerPartialState.Success(loadFavorites()))
        }
    }


    override fun addFavorite(eventId: String) {
        externalScope.launch {
            val favorites = loadFavorites()
            favorites.add(eventId)
            val jsonObject = gson.toJson(favorites)
            preferencesController.setString("FAVORITES", jsonObject)
        }
    }

    override fun removeFavorite(eventId: String) {
        externalScope.launch {
            val favorites = loadFavorites()
            favorites.remove(eventId)
            val jsonObject = gson.toJson(favorites)
            preferencesController.setString("FAVORITES", jsonObject)
        }
    }

}

sealed class FavoriteEventsControllerPartialState {
    data class Success(val favoriteEvents: List<String>) : FavoriteEventsControllerPartialState()
    data class Fail(val msg: String) : FavoriteEventsControllerPartialState()

}