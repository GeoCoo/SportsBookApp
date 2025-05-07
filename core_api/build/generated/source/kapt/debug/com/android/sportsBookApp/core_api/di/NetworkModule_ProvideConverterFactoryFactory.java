package com.android.sportsBookApp.core_api.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.converter.gson.GsonConverterFactory;

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
public final class NetworkModule_ProvideConverterFactoryFactory implements Factory<GsonConverterFactory> {
  private final NetworkModule module;

  public NetworkModule_ProvideConverterFactoryFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public GsonConverterFactory get() {
    return provideConverterFactory(module);
  }

  public static NetworkModule_ProvideConverterFactoryFactory create(NetworkModule module) {
    return new NetworkModule_ProvideConverterFactoryFactory(module);
  }

  public static GsonConverterFactory provideConverterFactory(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideConverterFactory());
  }
}
