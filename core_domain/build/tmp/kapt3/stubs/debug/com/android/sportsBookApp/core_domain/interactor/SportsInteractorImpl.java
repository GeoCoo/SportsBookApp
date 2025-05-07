package com.android.sportsBookApp.core_domain.interactor;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/android/sportsBookApp/core_domain/interactor/SportsInteractorImpl;", "Lcom/android/sportsBookApp/core_domain/interactor/SportsInteractor;", "sportsRepository", "Lcom/android/sportsBookApp/core_data/repository/SportsRepository;", "(Lcom/android/sportsBookApp/core_data/repository/SportsRepository;)V", "getSports", "Lkotlinx/coroutines/flow/Flow;", "Lcom/android/sportsBookApp/core_domain/interactor/SportsPartialState;", "core_domain_debug"})
public final class SportsInteractorImpl implements com.android.sportsBookApp.core_domain.interactor.SportsInteractor {
    @org.jetbrains.annotations.NotNull()
    private final com.android.sportsBookApp.core_data.repository.SportsRepository sportsRepository = null;
    
    @javax.inject.Inject()
    public SportsInteractorImpl(@org.jetbrains.annotations.NotNull()
    com.android.sportsBookApp.core_data.repository.SportsRepository sportsRepository) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.android.sportsBookApp.core_domain.interactor.SportsPartialState> getSports() {
        return null;
    }
}