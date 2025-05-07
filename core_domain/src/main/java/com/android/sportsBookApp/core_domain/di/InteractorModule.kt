package com.android.sportsBookApp.core_domain.di

import com.android.sportsBookApp.core_domain.interactor.SportsInteractor
import com.android.sportsBookApp.core_domain.interactor.SportsInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class InteractorModule {

    @Provides
    fun provideMainInteractor(impl: SportsInteractorImpl): SportsInteractor = impl


}