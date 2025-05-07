package com.android.sportsBookApp.core_resources.di;

import com.betson.interviewTest.core_resources.provider.ResourceProvider;
import com.betson.interviewTest.core_resources.provider.ResourceProviderImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
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
public final class ResourceModule_ProvideResourceProviderFactory implements Factory<ResourceProvider> {
  private final ResourceModule module;

  private final Provider<ResourceProviderImpl> implProvider;

  public ResourceModule_ProvideResourceProviderFactory(ResourceModule module,
      Provider<ResourceProviderImpl> implProvider) {
    this.module = module;
    this.implProvider = implProvider;
  }

  @Override
  public ResourceProvider get() {
    return provideResourceProvider(module, implProvider.get());
  }

  public static ResourceModule_ProvideResourceProviderFactory create(ResourceModule module,
      Provider<ResourceProviderImpl> implProvider) {
    return new ResourceModule_ProvideResourceProviderFactory(module, implProvider);
  }

  public static ResourceProvider provideResourceProvider(ResourceModule instance,
      ResourceProviderImpl impl) {
    return Preconditions.checkNotNullFromProvides(instance.provideResourceProvider(impl));
  }
}
