package com.android.sportsBookApp.feature_main_screen.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\b\u0010\u0007\u001a\u00020\u0001H\u0007\u001aB\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a\b\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006H\u0002\u00a8\u0006\u0013"}, d2 = {"MatchCard", "", "competitor1", "", "competitor2", "matchDurationSeconds", "", "MatchCardPreview", "SportHeader", "title", "isFavorite", "", "onFavoriteChanged", "Lkotlin/Function1;", "onExpandClick", "Lkotlin/Function0;", "SportHeaderPreview", "formatTime", "seconds", "feature_main_screen_debug"})
public final class MainComposablesKt {
    
    @androidx.compose.runtime.Composable()
    public static final void MatchCard(@org.jetbrains.annotations.NotNull()
    java.lang.String competitor1, @org.jetbrains.annotations.NotNull()
    java.lang.String competitor2, long matchDurationSeconds) {
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
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    public static final void SportHeaderPreview() {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, backgroundColor = 4281150765L)
    @androidx.compose.runtime.Composable()
    public static final void MatchCardPreview() {
    }
}