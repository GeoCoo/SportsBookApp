package com.android.sportsBookApp.core_model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003JI\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\tH\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/android/sportsBookApp/core_model/EventDomain;", "", "eventName", "", "eventId", "competitors", "Lkotlin/Pair;", "sportId", "eventStartTime", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/Pair;Ljava/lang/String;I)V", "getCompetitors", "()Lkotlin/Pair;", "setCompetitors", "(Lkotlin/Pair;)V", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "getEventName", "setEventName", "getEventStartTime", "()I", "setEventStartTime", "(I)V", "getSportId", "setSportId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "core_model_debug"})
public final class EventDomain {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String eventName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String eventId;
    @org.jetbrains.annotations.Nullable()
    private kotlin.Pair<java.lang.String, java.lang.String> competitors;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sportId;
    private int eventStartTime;
    
    public EventDomain(@org.jetbrains.annotations.NotNull()
    java.lang.String eventName, @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.String, java.lang.String> competitors, @org.jetbrains.annotations.NotNull()
    java.lang.String sportId, int eventStartTime) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEventName() {
        return null;
    }
    
    public final void setEventName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEventId() {
        return null;
    }
    
    public final void setEventId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.Pair<java.lang.String, java.lang.String> getCompetitors() {
        return null;
    }
    
    public final void setCompetitors(@org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.String, java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSportId() {
        return null;
    }
    
    public final void setSportId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getEventStartTime() {
        return 0;
    }
    
    public final void setEventStartTime(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.Pair<java.lang.String, java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.android.sportsBookApp.core_model.EventDomain copy(@org.jetbrains.annotations.NotNull()
    java.lang.String eventName, @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.String, java.lang.String> competitors, @org.jetbrains.annotations.NotNull()
    java.lang.String sportId, int eventStartTime) {
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