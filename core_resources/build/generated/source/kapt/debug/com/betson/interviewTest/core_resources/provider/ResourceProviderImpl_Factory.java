package com.betson.interviewTest.core_resources.provider;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ResourceProviderImpl_Factory implements Factory<ResourceProviderImpl> {
  private final Provider<Context> contextProvider;

  public ResourceProviderImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ResourceProviderImpl get() {
    return newInstance(contextProvider.get());
  }

  public static ResourceProviderImpl_Factory create(Provider<Context> contextProvider) {
    return new ResourceProviderImpl_Factory(contextProvider);
  }

  public static ResourceProviderImpl newInstance(Context context) {
    return new ResourceProviderImpl(context);
  }
}
