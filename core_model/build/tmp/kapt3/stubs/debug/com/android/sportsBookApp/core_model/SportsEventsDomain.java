package com.android.sportsBookApp.core_model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/android/sportsBookApp/core_model/SportsEventsDomain;", "", "sportName", "", "isExpanded", "", "hasFavoritess", "activeEvents", "", "Lcom/android/sportsBookApp/core_model/EventDomain;", "sportId", "(Ljava/lang/String;ZZLjava/util/List;Ljava/lang/String;)V", "getActiveEvents", "()Ljava/util/List;", "setActiveEvents", "(Ljava/util/List;)V", "getHasFavoritess", "()Z", "setExpanded", "(Z)V", "getSportId", "()Ljava/lang/String;", "setSportId", "(Ljava/lang/String;)V", "getSportName", "setSportName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "core_model_debug"})
public final class SportsEventsDomain {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String sportName;
    private boolean isExpanded;
    private final boolean hasFavoritess = false;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.android.sportsBookApp.core_model.EventDomain> activeEvents;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String sportId;
    
    public SportsEventsDomain(@org.jetbrains.annotations.Nullable()
    java.lang.String sportName, boolean isExpanded, boolean hasFavoritess, @org.jetbrains.annotations.NotNull()
    java.util.List<com.android.sportsBookApp.core_model.EventDomain> activeEvents, @org.jetbrains.annotations.Nullable()
    java.lang.String sportId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSportName() {
        return null;
    }
    
    public final void setSportName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean isExpanded() {
        return false;
    }
    
    public final void setExpanded(boolean p0) {
    }
    
    public final boolean getHasFavoritess() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.android.sportsBookApp.core_model.EventDomain> getActiveEvents() {
        return null;
    }
    
    public final void setActiveEvents(@org.jetbrains.annotations.NotNull()
    java.util.List<com.android.sportsBookApp.core_model.EventDomain> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSportId() {
        return null;
    }
    
    public final void setSportId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public SportsEventsDomain() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.android.sportsBookApp.core_model.EventDomain> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.android.sportsBookApp.core_model.SportsEventsDomain copy(@org.jetbrains.annotations.Nullable()
    java.lang.String sportName, boolean isExpanded, boolean hasFavoritess, @org.jetbrains.annotations.NotNull()
    java.util.List<com.android.sportsBookApp.core_model.EventDomain> activeEvents, @org.jetbrains.annotations.Nullable()
    java.lang.String sportId) {
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