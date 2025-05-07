package com.android.sportsBookApp.core_domain.di;

import com.android.sportsBookApp.core_domain.interactor.SportsInteractor;
import com.android.sportsBookApp.core_domain.interactor.SportsInteractorImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class InteractorModule_ProvideMainInteractorFactory implements Factory<SportsInteractor> {
  private final InteractorModule module;

  private final Provider<SportsInteractorImpl> implProvider;

  public InteractorModule_ProvideMainInteractorFactory(InteractorModule module,
      Provider<SportsInteractorImpl> implProvider) {
    this.module = module;
    this.implProvider = implProvider;
  }

  @Override
  public SportsInteractor get() {
    return provideMainInteractor(module, implProvider.get());
  }

  public static InteractorModule_ProvideMainInteractorFactory create(InteractorModule module,
      Provider<SportsInteractorImpl> implProvider) {
    return new InteractorModule_ProvideMainInteractorFactory(module, implProvider);
  }

  public static SportsInteractor provideMainInteractor(InteractorModule instance,
      SportsInteractorImpl impl) {
    return Preconditions.checkNotNullFromProvides(instance.provideMainInteractor(impl));
  }
}
