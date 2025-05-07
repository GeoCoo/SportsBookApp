package com.android.sportsBookApp.core_api.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/android/sportsBookApp/core_api/di/ApiModule;", "", "()V", "provideApiClient", "Lcom/android/sportsBookApp/core_api/api/ApiClient;", "impl", "Lcom/android/sportsBookApp/core_api/api/ApiClientImpl;", "provideApiService", "Lcom/android/sportsBookApp/core_api/api/ApiService;", "retrofit", "Lretrofit2/Retrofit;", "core_api_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class ApiModule {
    
    public ApiModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.android.sportsBookApp.core_api.api.ApiService provideApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.android.sportsBookApp.core_api.api.ApiClient provideApiClient(@org.jetbrains.annotations.NotNull()
    com.android.sportsBookApp.core_api.api.ApiClientImpl impl) {
        return null;
    }
}