package com.android.sportsBookApp.core_data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/android/sportsBookApp/core_data/repository/SportsRepositoryImpl;", "Lcom/android/sportsBookApp/core_data/repository/SportsRepository;", "apiClient", "Lcom/android/sportsBookApp/core_api/api/ApiClient;", "(Lcom/android/sportsBookApp/core_api/api/ApiClient;)V", "getSports", "Lkotlinx/coroutines/flow/Flow;", "Lcom/android/sportsBookApp/core_data/repository/SportsResponse;", "core_data_debug"})
public final class SportsRepositoryImpl implements com.android.sportsBookApp.core_data.repository.SportsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.android.sportsBookApp.core_api.api.ApiClient apiClient = null;
    
    @javax.inject.Inject()
    public SportsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.android.sportsBookApp.core_api.api.ApiClient apiClient) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.android.sportsBookApp.core_data.repository.SportsResponse> getSports() {
        return null;
    }
}