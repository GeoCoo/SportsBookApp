package com.android.sportsBookApp.feature_main_screen.ui;

import com.android.sportsBookApp.core_domain.interactor.SportsInteractor;
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

  public MainViewModel_Factory(Provider<SportsInteractor> sportsInteractorProvider) {
    this.sportsInteractorProvider = sportsInteractorProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(sportsInteractorProvider.get());
  }

  public static MainViewModel_Factory create(Provider<SportsInteractor> sportsInteractorProvider) {
    return new MainViewModel_Factory(sportsInteractorProvider);
  }

  public static MainViewModel newInstance(SportsInteractor sportsInteractor) {
    return new MainViewModel(sportsInteractor);
  }
}
