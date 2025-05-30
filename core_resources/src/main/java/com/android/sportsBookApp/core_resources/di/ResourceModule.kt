package com.android.sportsBookApp.core_resources.di

import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import com.android.sportsBookApp.core_resources.provider.ResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ResourceModule {

    @Provides
    @Singleton
    fun provideResourceProvider(impl: ResourceProviderImpl): ResourceProvider = impl

}