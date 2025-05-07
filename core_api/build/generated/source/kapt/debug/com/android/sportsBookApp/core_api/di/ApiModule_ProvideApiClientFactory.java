package com.android.sportsBookApp.core_api.di;

import com.android.sportsBookApp.core_api.api.ApiClient;
import com.android.sportsBookApp.core_api.api.ApiClientImpl;
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
public final class ApiModule_ProvideApiClientFactory implements Factory<ApiClient> {
  private final ApiModule module;

  private final Provider<ApiClientImpl> implProvider;

  public ApiModule_ProvideApiClientFactory(ApiModule module, Provider<ApiClientImpl> implProvider) {
    this.module = module;
    this.implProvider = implProvider;
  }

  @Override
  public ApiClient get() {
    return provideApiClient(module, implProvider.get());
  }

  public static ApiModule_ProvideApiClientFactory create(ApiModule module,
      Provider<ApiClientImpl> implProvider) {
    return new ApiModule_ProvideApiClientFactory(module, implProvider);
  }

  public static ApiClient provideApiClient(ApiModule instance, ApiClientImpl impl) {
    return Preconditions.checkNotNullFromProvides(instance.provideApiClient(impl));
  }
}
