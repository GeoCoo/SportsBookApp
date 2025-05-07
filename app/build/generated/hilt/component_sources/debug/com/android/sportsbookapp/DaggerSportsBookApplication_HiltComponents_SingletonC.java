package com.android.sportsbookapp;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.android.sportsBookApp.core_api.api.ApiClient;
import com.android.sportsBookApp.core_api.api.ApiClientImpl;
import com.android.sportsBookApp.core_api.api.ApiService;
import com.android.sportsBookApp.core_api.di.ApiModule;
import com.android.sportsBookApp.core_api.di.ApiModule_ProvideApiClientFactory;
import com.android.sportsBookApp.core_api.di.ApiModule_ProvideApiServiceFactory;
import com.android.sportsBookApp.core_api.di.NetworkModule;
import com.android.sportsBookApp.core_api.di.NetworkModule_ProvideConverterFactoryFactory;
import com.android.sportsBookApp.core_api.di.NetworkModule_ProvideOkHttpClientFactory;
import com.android.sportsBookApp.core_api.di.NetworkModule_ProvideRetrofitFactory;
import com.android.sportsBookApp.core_api.di.NetworkModule_ProvidesHttpLoggingInterceptorFactory;
import com.android.sportsBookApp.core_data.di.RepositoryModule;
import com.android.sportsBookApp.core_data.di.RepositoryModule_ProvideMainRepositoryFactory;
import com.android.sportsBookApp.core_data.repository.SportsRepository;
import com.android.sportsBookApp.core_data.repository.SportsRepositoryImpl;
import com.android.sportsBookApp.core_domain.di.InteractorModule;
import com.android.sportsBookApp.core_domain.di.InteractorModule_ProvideMainInteractorFactory;
import com.android.sportsBookApp.core_domain.interactor.SportsInteractor;
import com.android.sportsBookApp.core_domain.interactor.SportsInteractorImpl;
import com.android.sportsBookApp.core_resources.di.ResourceModule;
import com.android.sportsBookApp.core_resources.di.ResourceModule_ProvideResourceProviderFactory;
import com.android.sportsBookApp.feature_main_screen.ui.MainViewModel;
import com.android.sportsBookApp.feature_main_screen.ui.MainViewModel_HiltModules_KeyModule_ProvideFactory;
import com.betson.interviewTest.core_resources.provider.ResourceProvider;
import com.betson.interviewTest.core_resources.provider.ResourceProviderImpl;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
public final class DaggerSportsBookApplication_HiltComponents_SingletonC {
  private DaggerSportsBookApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApiModule apiModule;

    private ApplicationContextModule applicationContextModule;

    private NetworkModule networkModule;

    private RepositoryModule repositoryModule;

    private ResourceModule resourceModule;

    private Builder() {
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public Builder repositoryModule(RepositoryModule repositoryModule) {
      this.repositoryModule = Preconditions.checkNotNull(repositoryModule);
      return this;
    }

    public Builder resourceModule(ResourceModule resourceModule) {
      this.resourceModule = Preconditions.checkNotNull(resourceModule);
      return this;
    }

    public SportsBookApplication_HiltComponents.SingletonC build() {
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
      }
      if (repositoryModule == null) {
        this.repositoryModule = new RepositoryModule();
      }
      if (resourceModule == null) {
        this.resourceModule = new ResourceModule();
      }
      return new SingletonCImpl(apiModule, applicationContextModule, networkModule, repositoryModule, resourceModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements SportsBookApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public SportsBookApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements SportsBookApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public SportsBookApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements SportsBookApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public SportsBookApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements SportsBookApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public SportsBookApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements SportsBookApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public SportsBookApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements SportsBookApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public SportsBookApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, new InteractorModule(), savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements SportsBookApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public SportsBookApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends SportsBookApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends SportsBookApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends SportsBookApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends SportsBookApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return Collections.<String>singleton(MainViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends SportsBookApplication_HiltComponents.ViewModelC {
    private final InteractorModule interactorModule;

    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<MainViewModel> mainViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, InteractorModule interactorModuleParam,
        SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.interactorModule = interactorModuleParam;
      initialize(interactorModuleParam, savedStateHandleParam, viewModelLifecycleParam);

    }

    private SportsInteractorImpl sportsInteractorImpl() {
      return new SportsInteractorImpl(singletonCImpl.provideMainRepositoryProvider.get());
    }

    private SportsInteractor sportsInteractor() {
      return InteractorModule_ProvideMainInteractorFactory.provideMainInteractor(interactorModule, sportsInteractorImpl());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final InteractorModule interactorModuleParam,
        final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.mainViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
    }

    @Override
    public Map<String, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return Collections.<String, javax.inject.Provider<ViewModel>>singletonMap("com.android.sportsBookApp.feature_main_screen.ui.MainViewModel", ((Provider) mainViewModelProvider));
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return Collections.<String, Object>emptyMap();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.android.sportsBookApp.feature_main_screen.ui.MainViewModel 
          return (T) new MainViewModel(viewModelCImpl.sportsInteractor(), singletonCImpl.provideResourceProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends SportsBookApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends SportsBookApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends SportsBookApplication_HiltComponents.SingletonC {
    private final RepositoryModule repositoryModule;

    private final ApiModule apiModule;

    private final NetworkModule networkModule;

    private final ResourceModule resourceModule;

    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<HttpLoggingInterceptor> providesHttpLoggingInterceptorProvider;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<GsonConverterFactory> provideConverterFactoryProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<ApiService> provideApiServiceProvider;

    private Provider<ApiClient> provideApiClientProvider;

    private Provider<SportsRepository> provideMainRepositoryProvider;

    private Provider<ResourceProvider> provideResourceProvider;

    private SingletonCImpl(ApiModule apiModuleParam,
        ApplicationContextModule applicationContextModuleParam, NetworkModule networkModuleParam,
        RepositoryModule repositoryModuleParam, ResourceModule resourceModuleParam) {
      this.repositoryModule = repositoryModuleParam;
      this.apiModule = apiModuleParam;
      this.networkModule = networkModuleParam;
      this.resourceModule = resourceModuleParam;
      this.applicationContextModule = applicationContextModuleParam;
      initialize(apiModuleParam, applicationContextModuleParam, networkModuleParam, repositoryModuleParam, resourceModuleParam);

    }

    private ApiClientImpl apiClientImpl() {
      return new ApiClientImpl(provideApiServiceProvider.get());
    }

    private SportsRepositoryImpl sportsRepositoryImpl() {
      return new SportsRepositoryImpl(provideApiClientProvider.get());
    }

    private ResourceProviderImpl resourceProviderImpl() {
      return new ResourceProviderImpl(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApiModule apiModuleParam,
        final ApplicationContextModule applicationContextModuleParam,
        final NetworkModule networkModuleParam, final RepositoryModule repositoryModuleParam,
        final ResourceModule resourceModuleParam) {
      this.providesHttpLoggingInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<HttpLoggingInterceptor>(singletonCImpl, 5));
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 4));
      this.provideConverterFactoryProvider = DoubleCheck.provider(new SwitchingProvider<GsonConverterFactory>(singletonCImpl, 6));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 3));
      this.provideApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<ApiService>(singletonCImpl, 2));
      this.provideApiClientProvider = DoubleCheck.provider(new SwitchingProvider<ApiClient>(singletonCImpl, 1));
      this.provideMainRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<SportsRepository>(singletonCImpl, 0));
      this.provideResourceProvider = DoubleCheck.provider(new SwitchingProvider<ResourceProvider>(singletonCImpl, 7));
    }

    @Override
    public void injectSportsBookApplication(SportsBookApplication sportsBookApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.android.sportsBookApp.core_data.repository.SportsRepository 
          return (T) RepositoryModule_ProvideMainRepositoryFactory.provideMainRepository(singletonCImpl.repositoryModule, singletonCImpl.sportsRepositoryImpl());

          case 1: // com.android.sportsBookApp.core_api.api.ApiClient 
          return (T) ApiModule_ProvideApiClientFactory.provideApiClient(singletonCImpl.apiModule, singletonCImpl.apiClientImpl());

          case 2: // com.android.sportsBookApp.core_api.api.ApiService 
          return (T) ApiModule_ProvideApiServiceFactory.provideApiService(singletonCImpl.apiModule, singletonCImpl.provideRetrofitProvider.get());

          case 3: // retrofit2.Retrofit 
          return (T) NetworkModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.networkModule, singletonCImpl.provideOkHttpClientProvider.get(), singletonCImpl.provideConverterFactoryProvider.get());

          case 4: // okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient(singletonCImpl.networkModule, singletonCImpl.providesHttpLoggingInterceptorProvider.get());

          case 5: // okhttp3.logging.HttpLoggingInterceptor 
          return (T) NetworkModule_ProvidesHttpLoggingInterceptorFactory.providesHttpLoggingInterceptor(singletonCImpl.networkModule);

          case 6: // retrofit2.converter.gson.GsonConverterFactory 
          return (T) NetworkModule_ProvideConverterFactoryFactory.provideConverterFactory(singletonCImpl.networkModule);

          case 7: // com.betson.interviewTest.core_resources.provider.ResourceProvider 
          return (T) ResourceModule_ProvideResourceProviderFactory.provideResourceProvider(singletonCImpl.resourceModule, singletonCImpl.resourceProviderImpl());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
