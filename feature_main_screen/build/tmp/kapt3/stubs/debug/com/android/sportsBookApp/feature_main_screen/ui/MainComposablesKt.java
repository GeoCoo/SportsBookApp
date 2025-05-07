package com.android.sportsBookApp.feature_main_screen.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\b\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0007\u001a\b\u0010\f\u001a\u00020\u0001H\u0007\u001a@\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0007\u001a\b\u0010\u0016\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u00a8\u0006\u001a"}, d2 = {"MainScreenListItem", "", "sport", "Lcom/android/sportsBookApp/core_model/SportsEventsDomain;", "MainScreenListPreview", "MatchCard", "event", "Lcom/android/sportsBookApp/core_model/EventDomain;", "MatchCardPreview", "SportCompetitions", "competitions", "", "SportCompetitionsPreview", "SportHeader", "title", "", "isFavorite", "", "onFavoriteChanged", "Lkotlin/Function1;", "onExpandClick", "Lkotlin/Function0;", "SportHeaderPreview", "formatTime", "seconds", "", "feature_main_screen_debug"})
public final class MainComposablesKt {
    
    @androidx.compose.runtime.Composable()
    public static final void MatchCard(@org.jetbrains.annotations.NotNull()
    com.android.sportsBookApp.core_model.EventDomain event) {
    }
    
    private static final java.lang.String formatTime(long seconds) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SportHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String title, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onFavoriteChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onExpandClick) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.layout.ExperimentalLayoutApi.class})
    @androidx.compose.runtime.Composable()
    public static final void SportCompetitions(@org.jetbrains.annotations.NotNull()
    java.util.List<com.android.sportsBookApp.core_model.EventDomain> competitions) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MainScreenListItem(@org.jetbrains.annotations.NotNull()
    com.android.sportsBookApp.core_model.SportsEventsDomain sport) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview()
    @androidx.compose.runtime.Composable()
    public static final void MainScreenListPreview() {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    public static final void SportCompetitionsPreview() {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    public static final void SportHeaderPreview() {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, backgroundColor = 4281150765L)
    @androidx.compose.runtime.Composable()
    public static final void MatchCardPreview() {
    }
}