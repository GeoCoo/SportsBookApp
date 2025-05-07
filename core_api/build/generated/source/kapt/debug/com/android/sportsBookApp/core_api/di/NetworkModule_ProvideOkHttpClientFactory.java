package com.android.sportsBookApp.core_api.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
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
public final class NetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final NetworkModule module;

  private final Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;

  public NetworkModule_ProvideOkHttpClientFactory(NetworkModule module,
      Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
    this.module = module;
    this.httpLoggingInterceptorProvider = httpLoggingInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(module, httpLoggingInterceptorProvider.get());
  }

  public static NetworkModule_ProvideOkHttpClientFactory create(NetworkModule module,
      Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
    return new NetworkModule_ProvideOkHttpClientFactory(module, httpLoggingInterceptorProvider);
  }

  public static OkHttpClient provideOkHttpClient(NetworkModule instance,
      HttpLoggingInterceptor httpLoggingInterceptor) {
    return Preconditions.checkNotNullFromProvides(instance.provideOkHttpClient(httpLoggingInterceptor));
  }
}
