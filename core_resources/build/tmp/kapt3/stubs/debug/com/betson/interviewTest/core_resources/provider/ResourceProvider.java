package com.betson.interviewTest.core_resources.provider;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/betson/interviewTest/core_resources/provider/ResourceProvider;", "", "getString", "", "resId", "", "provideContext", "Landroid/content/Context;", "core_resources_debug"})
public abstract interface ResourceProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.content.Context provideContext();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getString(@androidx.annotation.StringRes()
    int resId);
}