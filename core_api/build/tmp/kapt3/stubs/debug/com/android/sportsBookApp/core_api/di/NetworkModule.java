package com.android.sportsBookApp.core_api.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/android/sportsBookApp/core_api/di/NetworkModule;", "", "()V", "provideConverterFactory", "Lretrofit2/converter/gson/GsonConverterFactory;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "httpLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideRetrofit", "Lretrofit2/Retrofit;", "okHttpClient", "converterFactory", "providesHttpLoggingInterceptor", "core_api_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    
    public NetworkModule() {
        super();
    }
    
    /**
     * Constructs and provides a singleton [Retrofit] instance used to perform api calls.
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    retrofit2.converter.gson.GsonConverterFactory converterFactory) {
        return null;
    }
    
    /**
     * Constructs and provides a singleton [OkHttpClient] used for [Retrofit] instance
     * initialization.
     *
     * @return A [OkHttpClient] instance.
     */
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.logging.HttpLoggingInterceptor httpLoggingInterceptor) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.converter.gson.GsonConverterFactory provideConverterFactory() {
        return null;
    }
    
    /**
     * Constructs and provides a singleton [HttpLoggingInterceptor] instance.
     *
     * @return A [HttpLoggingInterceptor] instance.
     */
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.logging.HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        return null;
    }
}