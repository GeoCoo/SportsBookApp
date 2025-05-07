package com.android.sportsBookApp.core_data.repository;

import com.android.sportsBookApp.core_api.api.ApiClient;
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
public final class SportsRepositoryImpl_Factory implements Factory<SportsRepositoryImpl> {
  private final Provider<ApiClient> apiClientProvider;

  public SportsRepositoryImpl_Factory(Provider<ApiClient> apiClientProvider) {
    this.apiClientProvider = apiClientProvider;
  }

  @Override
  public SportsRepositoryImpl get() {
    return newInstance(apiClientProvider.get());
  }

  public static SportsRepositoryImpl_Factory create(Provider<ApiClient> apiClientProvider) {
    return new SportsRepositoryImpl_Factory(apiClientProvider);
  }

  public static SportsRepositoryImpl newInstance(ApiClient apiClient) {
    return new SportsRepositoryImpl(apiClient);
  }
}
