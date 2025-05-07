package com.android.sportsBookApp.core_api.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
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
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<GsonConverterFactory> converterFactoryProvider;

  public NetworkModule_ProvideRetrofitFactory(NetworkModule module,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<GsonConverterFactory> converterFactoryProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
    this.converterFactoryProvider = converterFactoryProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, okHttpClientProvider.get(), converterFactoryProvider.get());
  }

  public static NetworkModule_ProvideRetrofitFactory create(NetworkModule module,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<GsonConverterFactory> converterFactoryProvider) {
    return new NetworkModule_ProvideRetrofitFactory(module, okHttpClientProvider, converterFactoryProvider);
  }

  public static Retrofit provideRetrofit(NetworkModule instance, OkHttpClient okHttpClient,
      GsonConverterFactory converterFactory) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit(okHttpClient, converterFactory));
  }
}
