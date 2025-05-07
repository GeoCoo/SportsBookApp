package com.android.sportsBookApp.core_data.di

import com.android.sportsBookApp.core_data.repository.SportsRepository
import com.android.sportsBookApp.core_data.repository.SportsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(impl: SportsRepositoryImpl): SportsRepository = impl
}

