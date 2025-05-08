package com.android.sportsBookApp.feature_main_screen.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/android/sportsBookApp/feature_main_screen/ui/Event;", "Lcom/android/sportsBookApp/core_ui/base/ViewEvent;", "()V", "ExpandSportCompetitions", "GetSports", "ToggleFavorites", "setFavorite", "Lcom/android/sportsBookApp/feature_main_screen/ui/Event$ExpandSportCompetitions;", "Lcom/android/sportsBookApp/feature_main_screen/ui/Event$GetSports;", "Lcom/android/sportsBookApp/feature_main_screen/ui/Event$ToggleFavorites;", "Lcom/android/sportsBookApp/feature_main_screen/ui/Event$setFavorite;", "feature_main_screen_debug"})
public abstract class Event implements com.android.sportsBookApp.core_ui.base.ViewEvent {
    
    private Event() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/android/sportsBookApp/feature_main_screen/ui/Event$ExpandSportCompetitions;", "Lcom/android/sportsBookApp/feature_main_screen/ui/Event;", "sport", "Lcom/android/sportsBookApp/core_model/SportsEventsDomain;", "(Lcom/android/sportsBookApp/core_model/SportsEventsDomain;)V", "getSport", "()Lcom/android/sportsBookApp/core_model/SportsEventsDomain;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "feature_main_screen_debug"})
    public static final class ExpandSportCompetitions extends com.android.sportsBookApp.feature_main_screen.ui.Event {
        @org.jetbrains.annotations.NotNull()
        private final com.android.sportsBookApp.core_model.SportsEventsDomain sport = null;
        
        public ExpandSportCompetitions(@org.jetbrains.annotations.NotNull()
        com.android.sportsBookApp.core_model.SportsEventsDomain sport) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.android.sportsBookApp.core_model.SportsEventsDomain getSport() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.android.sportsBookApp.core_model.SportsEventsDomain component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.android.sportsBookApp.feature_main_screen.ui.Event.ExpandSportCompetitions copy(@org.jetbrains.annotations.NotNull()
        com.android.sportsBookApp.core_model.SportsEventsDomain sport) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/sportsBookApp/feature_main_screen/ui/Event$GetSports;", "Lcom/android/sportsBookApp/feature_main_screen/ui/Event;", "()V", "feature_main_screen_debug"})
    public static final class GetSports extends com.android.sportsBookApp.feature_main_screen.ui.Event {
        @org.jetbrains.annotations.NotNull()
        public static final com.android.sportsBookApp.feature_main_screen.ui.Event.GetSports INSTANCE = null;
        
        private GetSports() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/sportsBookApp/feature_main_screen/ui/Event$ToggleFavorites;", "Lcom/android/sportsBookApp/feature_main_screen/ui/Event;", "()V", "feature_main_screen_debug"})
    public static final class ToggleFavorites extends com.android.sportsBookApp.feature_main_screen.ui.Event {
        @org.jetbrains.annotations.NotNull()
        public static final com.android.sportsBookApp.feature_main_screen.ui.Event.ToggleFavorites INSTANCE = null;
        
        private ToggleFavorites() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/sportsBookApp/feature_main_screen/ui/Event$setFavorite;", "Lcom/android/sportsBookApp/feature_main_screen/ui/Event;", "()V", "feature_main_screen_debug"})
    public static final class setFavorite extends com.android.sportsBookApp.feature_main_screen.ui.Event {
        @org.jetbrains.annotations.NotNull()
        public static final com.android.sportsBookApp.feature_main_screen.ui.Event.setFavorite INSTANCE = null;
        
        private setFavorite() {
        }
    }
}