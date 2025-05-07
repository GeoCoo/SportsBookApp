package com.android.sportsBookApp.core_api.api;

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
public final class ApiClientImpl_Factory implements Factory<ApiClientImpl> {
  private final Provider<ApiService> apiServiceProvider;

  public ApiClientImpl_Factory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public ApiClientImpl get() {
    return newInstance(apiServiceProvider.get());
  }

  public static ApiClientImpl_Factory create(Provider<ApiService> apiServiceProvider) {
    return new ApiClientImpl_Factory(apiServiceProvider);
  }

  public static ApiClientImpl newInstance(ApiService apiService) {
    return new ApiClientImpl(apiService);
  }
}
