package com.android.sportsBookApp.core_model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\bH\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r\u00a8\u0006%"}, d2 = {"Lcom/android/sportsBookApp/core_model/EventDto;", "", "eventName", "", "eventId", "competitors", "sportId", "eventStartTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCompetitors", "()Ljava/lang/String;", "setCompetitors", "(Ljava/lang/String;)V", "getEventId", "setEventId", "getEventName", "setEventName", "getEventStartTime", "()Ljava/lang/Integer;", "setEventStartTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSportId", "setSportId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/android/sportsBookApp/core_model/EventDto;", "equals", "", "other", "hashCode", "toString", "core_model_debug"})
public final class EventDto {
    @com.google.gson.annotations.SerializedName(value = "d")
    @org.jetbrains.annotations.Nullable()
    private java.lang.String eventName;
    @com.google.gson.annotations.SerializedName(value = "i")
    @org.jetbrains.annotations.Nullable()
    private java.lang.String eventId;
    @com.google.gson.annotations.SerializedName(value = "sh")
    @org.jetbrains.annotations.Nullable()
    private java.lang.String competitors;
    @com.google.gson.annotations.SerializedName(value = "si")
    @org.jetbrains.annotations.Nullable()
    private java.lang.String sportId;
    @com.google.gson.annotations.SerializedName(value = "tt")
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer eventStartTime;
    
    public EventDto(@org.jetbrains.annotations.Nullable()
    java.lang.String eventName, @org.jetbrains.annotations.Nullable()
    java.lang.String eventId, @org.jetbrains.annotations.Nullable()
    java.lang.String competitors, @org.jetbrains.annotations.Nullable()
    java.lang.String sportId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer eventStartTime) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEventName() {
        return null;
    }
    
    public final void setEventName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEventId() {
        return null;
    }
    
    public final void setEventId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCompetitors() {
        return null;
    }
    
    public final void setCompetitors(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSportId() {
        return null;
    }
    
    public final void setSportId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getEventStartTime() {
        return null;
    }
    
    public final void setEventStartTime(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public EventDto() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.android.sportsBookApp.core_model.EventDto copy(@org.jetbrains.annotations.Nullable()
    java.lang.String eventName, @org.jetbrains.annotations.Nullable()
    java.lang.String eventId, @org.jetbrains.annotations.Nullable()
    java.lang.String competitors, @org.jetbrains.annotations.Nullable()
    java.lang.String sportId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer eventStartTime) {
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