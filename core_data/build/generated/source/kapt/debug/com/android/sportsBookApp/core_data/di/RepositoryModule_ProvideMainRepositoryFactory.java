package com.android.sportsBookApp.core_data.di;

import com.android.sportsBookApp.core_data.repository.SportsRepository;
import com.android.sportsBookApp.core_data.repository.SportsRepositoryImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RepositoryModule_ProvideMainRepositoryFactory implements Factory<SportsRepository> {
  private final RepositoryModule module;

  private final Provider<SportsRepositoryImpl> implProvider;

  public RepositoryModule_ProvideMainRepositoryFactory(RepositoryModule module,
      Provider<SportsRepositoryImpl> implProvider) {
    this.module = module;
    this.implProvider = implProvider;
  }

  @Override
  public SportsRepository get() {
    return provideMainRepository(module, implProvider.get());
  }

  public static RepositoryModule_ProvideMainRepositoryFactory create(RepositoryModule module,
      Provider<SportsRepositoryImpl> implProvider) {
    return new RepositoryModule_ProvideMainRepositoryFactory(module, implProvider);
  }

  public static SportsRepository provideMainRepository(RepositoryModule instance,
      SportsRepositoryImpl impl) {
    return Preconditions.checkNotNullFromProvides(instance.provideMainRepository(impl));
  }
}
