package com.android.sportsBookApp.core_domain.di


import com.android.sportsBookApp.core_domain.controller.FavoriteEventController
import com.android.sportsBookApp.core_domain.controller.FavoriteEventControllerImpl
import com.android.sportsBookApp.core_domain.controller.PreferencesController
import com.android.sportsBookApp.core_domain.controller.PreferencesControllerImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ControllerModule {

    @Provides
    @Singleton
    fun providePreferencesController(impl: PreferencesControllerImpl): PreferencesController = impl

    @Provides
    @Singleton
    fun provideFavoriteEventController(impl: FavoriteEventControllerImpl): FavoriteEventController = impl

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}
