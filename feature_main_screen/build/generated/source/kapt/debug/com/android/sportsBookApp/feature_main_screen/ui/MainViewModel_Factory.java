package com.android.sportsBookApp.feature_main_screen.ui;

import com.android.sportsBookApp.core_domain.interactor.SportsInteractor;
import com.betson.interviewTest.core_resources.provider.ResourceProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<SportsInteractor> sportsInteractorProvider;

  private final Provider<ResourceProvider> resourceProvider;

  public MainViewModel_Factory(Provider<SportsInteractor> sportsInteractorProvider,
      Provider<ResourceProvider> resourceProvider) {
    this.sportsInteractorProvider = sportsInteractorProvider;
    this.resourceProvider = resourceProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(sportsInteractorProvider.get(), resourceProvider.get());
  }

  public static MainViewModel_Factory create(Provider<SportsInteractor> sportsInteractorProvider,
      Provider<ResourceProvider> resourceProvider) {
    return new MainViewModel_Factory(sportsInteractorProvider, resourceProvider);
  }

  public static MainViewModel newInstance(SportsInteractor sportsInteractor,
      ResourceProvider resourceProvider) {
    return new MainViewModel(sportsInteractor, resourceProvider);
  }
}
