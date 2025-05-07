package com.android.sportsBookApp.core_api.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.logging.HttpLoggingInterceptor;

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
public final class NetworkModule_ProvidesHttpLoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
  private final NetworkModule module;

  public NetworkModule_ProvidesHttpLoggingInterceptorFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public HttpLoggingInterceptor get() {
    return providesHttpLoggingInterceptor(module);
  }

  public static NetworkModule_ProvidesHttpLoggingInterceptorFactory create(NetworkModule module) {
    return new NetworkModule_ProvidesHttpLoggingInterceptorFactory(module);
  }

  public static HttpLoggingInterceptor providesHttpLoggingInterceptor(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesHttpLoggingInterceptor());
  }
}
