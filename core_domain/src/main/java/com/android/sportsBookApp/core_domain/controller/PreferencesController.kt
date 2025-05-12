package com.android.sportsBookApp.core_domain.controller


import android.content.Context
import androidx.core.content.edit
import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import javax.inject.Inject

const val SHARED_PREF = "shared_prefs"

interface PreferencesController {
    fun setString(key: String, value: String)
    fun getString(key: String, defaultValue: String): String
}

class PreferencesControllerImpl @Inject constructor(private val resourceProvider: ResourceProvider) :
    PreferencesController {

    private val sharedPrefs by lazy {
        resourceProvider.provideContext()
            .getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
    }


    override fun setString(key: String, value: String) {
        sharedPrefs.edit { putString(key, value) }
    }


    override fun getString(key: String, defaultValue: String): String {
        return sharedPrefs.getString(key, defaultValue) ?: defaultValue
    }


}