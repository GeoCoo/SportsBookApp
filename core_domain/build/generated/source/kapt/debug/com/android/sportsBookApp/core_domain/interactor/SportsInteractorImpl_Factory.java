package com.android.sportsBookApp.core_domain.interactor;

import com.android.sportsBookApp.core_data.repository.SportsRepository;
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
public final class SportsInteractorImpl_Factory implements Factory<SportsInteractorImpl> {
  private final Provider<SportsRepository> sportsRepositoryProvider;

  public SportsInteractorImpl_Factory(Provider<SportsRepository> sportsRepositoryProvider) {
    this.sportsRepositoryProvider = sportsRepositoryProvider;
  }

  @Override
  public SportsInteractorImpl get() {
    return newInstance(sportsRepositoryProvider.get());
  }

  public static SportsInteractorImpl_Factory create(
      Provider<SportsRepository> sportsRepositoryProvider) {
    return new SportsInteractorImpl_Factory(sportsRepositoryProvider);
  }

  public static SportsInteractorImpl newInstance(SportsRepository sportsRepository) {
    return new SportsInteractorImpl(sportsRepository);
  }
}
