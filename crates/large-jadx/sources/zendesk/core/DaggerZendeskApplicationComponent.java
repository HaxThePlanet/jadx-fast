package zendesk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.gson.Gson;
import g.b.a;
import g.b.d;
import g.b.e;
import j.a.a;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
final class DaggerZendeskApplicationComponent implements zendesk.core.ZendeskApplicationComponent {

    private a<zendesk.core.ActionHandlerRegistry> actionHandlerRegistryProvider;
    private a<zendesk.core.AcceptLanguageHeaderInterceptor> provideAcceptLanguageHeaderInterceptorProvider;
    private a<zendesk.core.ZendeskAccessInterceptor> provideAccessInterceptorProvider;
    private a<zendesk.core.AccessProvider> provideAccessProvider;
    private a<zendesk.core.AccessService> provideAccessServiceProvider;
    private a<zendesk.core.BaseStorage> provideAdditionalSdkBaseStorageProvider;
    private a<zendesk.core.ApplicationConfiguration> provideApplicationConfigurationProvider;
    private a<Context> provideApplicationContextProvider;
    private a<zendesk.core.ZendeskAuthHeaderInterceptor> provideAuthHeaderInterceptorProvider;
    private a<zendesk.core.AuthenticationProvider> provideAuthProvider;
    private a<zendesk.core.Serializer> provideBase64SerializerProvider;
    private a<OkHttpClient> provideBaseOkHttpClientProvider;
    private a<zendesk.core.BlipsService> provideBlipsServiceProvider;
    private a<Cache> provideCacheProvider;
    private a<zendesk.core.CachingInterceptor> provideCachingInterceptorProvider;
    private a<OkHttpClient> provideCoreOkHttpClientProvider;
    private a<Retrofit> provideCoreRetrofitProvider;
    private a<zendesk.core.CoreModule> provideCoreSdkModuleProvider;
    private a<zendesk.core.CoreSettingsStorage> provideCoreSettingsStorageProvider;
    private a<zendesk.core.DeviceInfo> provideDeviceInfoProvider;
    private a<ScheduledExecutorService> provideExecutorProvider;
    private a<ExecutorService> provideExecutorServiceProvider;
    private a<Gson> provideGsonProvider;
    private a<HttpLoggingInterceptor> provideHttpLoggingInterceptorProvider;
    private a<zendesk.core.BaseStorage> provideIdentityBaseStorageProvider;
    private a<zendesk.core.IdentityManager> provideIdentityManagerProvider;
    private a<zendesk.core.IdentityStorage> provideIdentityStorageProvider;
    private a<zendesk.core.SharedPreferencesStorage> provideLegacyIdentityBaseStorageProvider;
    private a<zendesk.core.LegacyIdentityMigrator> provideLegacyIdentityStorageProvider;
    private a<zendesk.core.SharedPreferencesStorage> provideLegacyPushBaseStorageProvider;
    private a<OkHttpClient> provideMediaOkHttpClientProvider;
    private a<zendesk.core.MemoryCache> provideMemoryCacheProvider;
    private a<OkHttpClient> provideOkHttpClientProvider;
    private a<zendesk.core.ProviderStore> provideProviderStoreProvider;
    private a<zendesk.core.PushDeviceIdStorage> providePushDeviceIdStorageProvider;
    private a<zendesk.core.ZendeskPushInterceptor> providePushInterceptorProvider;
    private a<Retrofit> providePushProviderRetrofitProvider;
    private a<zendesk.core.PushRegistrationProvider> providePushRegistrationProvider;
    private a<zendesk.core.PushRegistrationProviderInternal> providePushRegistrationProviderInternalProvider;
    private a<zendesk.core.PushRegistrationService> providePushRegistrationServiceProvider;
    private a<zendesk.core.RestServiceProvider> provideRestServiceProvider;
    private a<Retrofit> provideRetrofitProvider;
    private a<zendesk.core.BaseStorage> provideSdkBaseStorageProvider;
    private a<zendesk.core.SettingsProvider> provideSdkSettingsProvider;
    private a<zendesk.core.SdkSettingsProviderInternal> provideSdkSettingsProviderInternalProvider;
    private a<zendesk.core.SdkSettingsService> provideSdkSettingsServiceProvider;
    private a<zendesk.core.Storage> provideSdkStorageProvider;
    private a<zendesk.core.Serializer> provideSerializerProvider;
    private a<zendesk.core.SessionStorage> provideSessionStorageProvider;
    private a<zendesk.core.BaseStorage> provideSettingsBaseStorageProvider;
    private a<zendesk.core.ZendeskSettingsInterceptor> provideSettingsInterceptorProvider;
    private a<zendesk.core.SettingsStorage> provideSettingsStorageProvider;
    private a<zendesk.core.UserProvider> provideUserProvider;
    private a<zendesk.core.UserService> provideUserServiceProvider;
    private a<zendesk.core.ZendeskOauthIdHeaderInterceptor> provideZendeskBasicHeadersInterceptorProvider;
    private a<zendesk.core.ZendeskLocaleConverter> provideZendeskLocaleConverterProvider;
    private a<zendesk.core.ZendeskShadow> provideZendeskProvider;
    private a<zendesk.core.ZendeskSettingsProvider> provideZendeskSdkSettingsProvider;
    private a<zendesk.core.ZendeskUnauthorizedInterceptor> provideZendeskUnauthorizedInterceptorProvider;
    private a<zendesk.core.BlipsCoreProvider> providerBlipsCoreProvider;
    private a<zendesk.core.BlipsProvider> providerBlipsProvider;
    private a<ConnectivityManager> providerConnectivityManagerProvider;
    private a<zendesk.core.NetworkInfoProvider> providerNetworkInfoProvider;
    private a<zendesk.core.ZendeskBlipsProvider> providerZendeskBlipsProvider;
    private a<zendesk.core.AcceptHeaderInterceptor> providesAcceptHeaderInterceptorProvider;
    private a<File> providesBelvedereDirProvider;
    private a<File> providesCacheDirProvider;
    private a<File> providesDataDirProvider;
    private a<zendesk.core.BaseStorage> providesDiskLruStorageProvider;
    private a<zendesk.core.UserAgentAndClientHeadersInterceptor> providesUserAgentHeaderInterceptorProvider;

    static final class Builder {

        private zendesk.core.ZendeskApplicationModule zendeskApplicationModule;
        private zendesk.core.ZendeskNetworkModule zendeskNetworkModule;
        Builder(zendesk.core.DaggerZendeskApplicationComponent.1 daggerZendeskApplicationComponent$1) {
            super();
        }

        public zendesk.core.ZendeskApplicationComponent build() {
            zendesk.core.ZendeskNetworkModule zendeskNetworkModule;
            d.a(this.zendeskApplicationModule, ZendeskApplicationModule.class);
            if (this.zendeskNetworkModule == null) {
                zendeskNetworkModule = new ZendeskNetworkModule();
                this.zendeskNetworkModule = zendeskNetworkModule;
            }
            DaggerZendeskApplicationComponent daggerZendeskApplicationComponent = new DaggerZendeskApplicationComponent(this.zendeskApplicationModule, this.zendeskNetworkModule, 0);
            return daggerZendeskApplicationComponent;
        }

        public zendesk.core.DaggerZendeskApplicationComponent.Builder zendeskApplicationModule(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
            d.b(zendeskApplicationModule);
            this.zendeskApplicationModule = (ZendeskApplicationModule)zendeskApplicationModule;
            return this;
        }

        public zendesk.core.DaggerZendeskApplicationComponent.Builder zendeskNetworkModule(zendesk.core.ZendeskNetworkModule zendeskNetworkModule) {
            d.b(zendeskNetworkModule);
            this.zendeskNetworkModule = (ZendeskNetworkModule)zendeskNetworkModule;
            return this;
        }

        @Deprecated
        public zendesk.core.DaggerZendeskApplicationComponent.Builder zendeskProvidersModule(zendesk.core.ZendeskProvidersModule zendeskProvidersModule) {
            d.b(zendeskProvidersModule);
            return this;
        }

        @Deprecated
        public zendesk.core.DaggerZendeskApplicationComponent.Builder zendeskStorageModule(zendesk.core.ZendeskStorageModule zendeskStorageModule) {
            d.b(zendeskStorageModule);
            return this;
        }
    }
    private DaggerZendeskApplicationComponent(zendesk.core.ZendeskApplicationModule zendeskApplicationModule, zendesk.core.ZendeskNetworkModule zendeskNetworkModule2) {
        super();
        initialize(zendeskApplicationModule, zendeskNetworkModule2);
    }

    DaggerZendeskApplicationComponent(zendesk.core.ZendeskApplicationModule zendeskApplicationModule, zendesk.core.ZendeskNetworkModule zendeskNetworkModule2, zendesk.core.DaggerZendeskApplicationComponent.1 daggerZendeskApplicationComponent$13) {
        super(zendeskApplicationModule, zendeskNetworkModule2);
    }

    public static zendesk.core.DaggerZendeskApplicationComponent.Builder builder() {
        DaggerZendeskApplicationComponent.Builder builder = new DaggerZendeskApplicationComponent.Builder(0);
        return builder;
    }

    private void initialize(zendesk.core.ZendeskApplicationModule zendeskApplicationModule, zendesk.core.ZendeskNetworkModule zendeskNetworkModule2) {
        this.provideApplicationContextProvider = a.a(ZendeskApplicationModule_ProvideApplicationContextFactory.create(zendeskApplicationModule));
        a aVar2 = e.a(ZendeskApplicationModule_ProvideGsonFactory.create());
        this.provideGsonProvider = aVar2;
        a aVar3 = a.a(ZendeskStorageModule_ProvideSerializerFactory.create(aVar2));
        this.provideSerializerProvider = aVar3;
        a aVar4 = a.a(ZendeskStorageModule_ProvideSettingsBaseStorageFactory.create(this.provideApplicationContextProvider, aVar3));
        this.provideSettingsBaseStorageProvider = aVar4;
        this.provideSettingsStorageProvider = a.a(ZendeskStorageModule_ProvideSettingsStorageFactory.create(aVar4));
        a aVar6 = a.a(ZendeskStorageModule_ProvideIdentityBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
        this.provideIdentityBaseStorageProvider = aVar6;
        this.provideIdentityStorageProvider = a.a(ZendeskStorageModule_ProvideIdentityStorageFactory.create(aVar6));
        this.provideAdditionalSdkBaseStorageProvider = a.a(ZendeskStorageModule_ProvideAdditionalSdkBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
        a aVar9 = a.a(ZendeskStorageModule_ProvidesCacheDirFactory.create(this.provideApplicationContextProvider));
        this.providesCacheDirProvider = aVar9;
        this.providesDiskLruStorageProvider = a.a(ZendeskStorageModule_ProvidesDiskLruStorageFactory.create(aVar9, this.provideSerializerProvider));
        this.provideCacheProvider = a.a(ZendeskStorageModule_ProvideCacheFactory.create(this.providesCacheDirProvider));
        this.providesDataDirProvider = a.a(ZendeskStorageModule_ProvidesDataDirFactory.create(this.provideApplicationContextProvider));
        a aVar48 = a.a(ZendeskStorageModule_ProvidesBelvedereDirFactory.create(this.provideApplicationContextProvider));
        this.providesBelvedereDirProvider = aVar48;
        this.provideSessionStorageProvider = a.a(ZendeskStorageModule_ProvideSessionStorageFactory.create(this.provideIdentityStorageProvider, this.provideAdditionalSdkBaseStorageProvider, this.providesDiskLruStorageProvider, this.provideCacheProvider, this.providesCacheDirProvider, this.providesDataDirProvider, aVar48));
        this.provideSdkBaseStorageProvider = a.a(ZendeskStorageModule_ProvideSdkBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
        a aVar15 = a.a(ZendeskStorageModule_ProvideMemoryCacheFactory.create());
        this.provideMemoryCacheProvider = aVar15;
        this.provideSdkStorageProvider = a.a(ZendeskStorageModule_ProvideSdkStorageFactory.create(this.provideSettingsStorageProvider, this.provideSessionStorageProvider, this.provideSdkBaseStorageProvider, aVar15));
        this.provideLegacyIdentityBaseStorageProvider = a.a(ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
        this.provideLegacyPushBaseStorageProvider = a.a(ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
        this.provideIdentityManagerProvider = a.a(ZendeskStorageModule_ProvideIdentityManagerFactory.create(this.provideIdentityStorageProvider));
        a aVar20 = a.a(ZendeskStorageModule_ProvidePushDeviceIdStorageFactory.create(this.provideAdditionalSdkBaseStorageProvider));
        this.providePushDeviceIdStorageProvider = aVar20;
        this.provideLegacyIdentityStorageProvider = a.a(ZendeskStorageModule_ProvideLegacyIdentityStorageFactory.create(this.provideLegacyIdentityBaseStorageProvider, this.provideLegacyPushBaseStorageProvider, this.provideIdentityStorageProvider, this.provideIdentityManagerProvider, aVar20));
        this.provideApplicationConfigurationProvider = a.a(ZendeskApplicationModule_ProvideApplicationConfigurationFactory.create(zendeskApplicationModule));
        this.provideHttpLoggingInterceptorProvider = e.a(ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory.create());
        this.provideZendeskBasicHeadersInterceptorProvider = e.a(ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory.create(zendeskNetworkModule2, this.provideApplicationConfigurationProvider));
        this.providesUserAgentHeaderInterceptorProvider = e.a(ZendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory.create(zendeskNetworkModule2));
        a aVar26 = a.a(ZendeskApplicationModule_ProvideExecutorFactory.create());
        this.provideExecutorProvider = aVar26;
        a aVar27 = a.a(ZendeskApplicationModule_ProvideExecutorServiceFactory.create(aVar26));
        this.provideExecutorServiceProvider = aVar27;
        this.provideBaseOkHttpClientProvider = a.a(ZendeskNetworkModule_ProvideBaseOkHttpClientFactory.create(zendeskNetworkModule2, this.provideHttpLoggingInterceptorProvider, this.provideZendeskBasicHeadersInterceptorProvider, this.providesUserAgentHeaderInterceptorProvider, aVar27));
        this.provideAcceptLanguageHeaderInterceptorProvider = e.a(ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory.create(this.provideApplicationContextProvider));
        a aVar30 = e.a(ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory.create());
        this.providesAcceptHeaderInterceptorProvider = aVar30;
        a aVar31 = a.a(ZendeskNetworkModule_ProvideCoreOkHttpClientFactory.create(zendeskNetworkModule2, this.provideBaseOkHttpClientProvider, this.provideAcceptLanguageHeaderInterceptorProvider, aVar30));
        this.provideCoreOkHttpClientProvider = aVar31;
        a aVar32 = a.a(ZendeskNetworkModule_ProvideCoreRetrofitFactory.create(this.provideApplicationConfigurationProvider, this.provideGsonProvider, aVar31));
        this.provideCoreRetrofitProvider = aVar32;
        this.provideBlipsServiceProvider = a.a(ZendeskProvidersModule_ProvideBlipsServiceFactory.create(aVar32));
        this.provideDeviceInfoProvider = a.a(ZendeskApplicationModule_ProvideDeviceInfoFactory.create(this.provideApplicationContextProvider));
        this.provideBase64SerializerProvider = e.a(ZendeskApplicationModule_ProvideBase64SerializerFactory.create(zendeskApplicationModule, this.provideSerializerProvider));
        a aVar46 = a.a(ZendeskStorageModule_ProvideCoreSettingsStorageFactory.create(this.provideSettingsStorageProvider));
        this.provideCoreSettingsStorageProvider = aVar46;
        a aVar36 = a.a(ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory.create(this.provideBlipsServiceProvider, this.provideDeviceInfoProvider, this.provideBase64SerializerProvider, this.provideIdentityManagerProvider, this.provideApplicationConfigurationProvider, aVar46, this.provideExecutorServiceProvider));
        this.providerZendeskBlipsProvider = aVar36;
        this.providerBlipsCoreProvider = a.a(ZendeskProvidersModule_ProviderBlipsCoreProviderFactory.create(aVar36));
        a aVar38 = e.a(ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory.create(this.provideIdentityManagerProvider));
        this.provideAuthHeaderInterceptorProvider = aVar38;
        a aVar39 = a.a(ZendeskNetworkModule_ProvidePushProviderRetrofitFactory.create(this.provideApplicationConfigurationProvider, this.provideGsonProvider, this.provideCoreOkHttpClientProvider, aVar38));
        this.providePushProviderRetrofitProvider = aVar39;
        this.providePushRegistrationServiceProvider = e.a(ZendeskProvidersModule_ProvidePushRegistrationServiceFactory.create(aVar39));
        this.provideSdkSettingsServiceProvider = e.a(ZendeskProvidersModule_ProvideSdkSettingsServiceFactory.create(this.provideCoreRetrofitProvider));
        this.actionHandlerRegistryProvider = a.a(ZendeskProvidersModule_ActionHandlerRegistryFactory.create());
        a aVar44 = a.a(ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory.create(zendeskApplicationModule));
        this.provideZendeskLocaleConverterProvider = aVar44;
        a obj13 = a.a(ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory.create(this.provideSdkSettingsServiceProvider, this.provideSettingsStorageProvider, this.provideCoreSettingsStorageProvider, this.actionHandlerRegistryProvider, this.provideSerializerProvider, aVar44, this.provideApplicationConfigurationProvider, this.provideApplicationContextProvider));
        this.provideZendeskSdkSettingsProvider = obj13;
        a aVar43 = a.a(ZendeskProvidersModule_ProvideSdkSettingsProviderFactory.create(obj13));
        this.provideSdkSettingsProvider = aVar43;
        this.providePushRegistrationProvider = a.a(ZendeskProvidersModule_ProvidePushRegistrationProviderFactory.create(this.providePushRegistrationServiceProvider, this.provideIdentityManagerProvider, aVar43, this.providerBlipsCoreProvider, this.providePushDeviceIdStorageProvider, this.provideApplicationContextProvider));
        obj13 = e.a(ZendeskProvidersModule_ProvideAccessServiceFactory.create(this.provideCoreRetrofitProvider));
        this.provideAccessServiceProvider = obj13;
        obj13 = a.a(ZendeskProvidersModule_ProvideAccessProviderFactory.create(this.provideIdentityManagerProvider, obj13));
        this.provideAccessProvider = obj13;
        this.provideAccessInterceptorProvider = e.a(ZendeskNetworkModule_ProvideAccessInterceptorFactory.create(this.provideIdentityManagerProvider, obj13, this.provideSdkStorageProvider, this.provideCoreSettingsStorageProvider));
        this.provideZendeskUnauthorizedInterceptorProvider = e.a(ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory.create(this.provideSessionStorageProvider));
        obj13 = a.a(ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory.create(this.provideZendeskSdkSettingsProvider));
        this.provideSdkSettingsProviderInternalProvider = obj13;
        this.provideSettingsInterceptorProvider = e.a(ZendeskNetworkModule_ProvideSettingsInterceptorFactory.create(obj13, this.provideSettingsStorageProvider));
        obj13 = a.a(ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory.create(this.providePushRegistrationProvider));
        this.providePushRegistrationProviderInternalProvider = obj13;
        a aVar49 = e.a(ZendeskNetworkModule_ProvidePushInterceptorFactory.create(obj13, this.providePushDeviceIdStorageProvider, this.provideIdentityStorageProvider));
        this.providePushInterceptorProvider = aVar49;
        obj13 = a.a(ZendeskNetworkModule_ProvideOkHttpClientFactory.create(zendeskNetworkModule2, this.provideBaseOkHttpClientProvider, this.provideAccessInterceptorProvider, this.provideZendeskUnauthorizedInterceptorProvider, this.provideAuthHeaderInterceptorProvider, this.provideSettingsInterceptorProvider, this.providesAcceptHeaderInterceptorProvider, aVar49, this.provideCacheProvider));
        this.provideOkHttpClientProvider = obj13;
        this.provideRetrofitProvider = a.a(ZendeskNetworkModule_ProvideRetrofitFactory.create(this.provideApplicationConfigurationProvider, this.provideGsonProvider, obj13));
        a aVar45 = e.a(ZendeskNetworkModule_ProvideCachingInterceptorFactory.create(this.providesDiskLruStorageProvider));
        this.provideCachingInterceptorProvider = aVar45;
        obj13 = a.a(ZendeskNetworkModule_ProvideMediaOkHttpClientFactory.create(zendeskNetworkModule2, this.provideBaseOkHttpClientProvider, this.provideAccessInterceptorProvider, this.provideAuthHeaderInterceptorProvider, this.provideSettingsInterceptorProvider, aVar45, this.provideZendeskUnauthorizedInterceptorProvider));
        this.provideMediaOkHttpClientProvider = obj13;
        this.provideRestServiceProvider = a.a(ZendeskNetworkModule_ProvideRestServiceProviderFactory.create(zendeskNetworkModule2, this.provideRetrofitProvider, obj13, this.provideOkHttpClientProvider, this.provideCoreOkHttpClientProvider));
        this.providerBlipsProvider = a.a(ZendeskProvidersModule_ProviderBlipsProviderFactory.create(this.providerZendeskBlipsProvider));
        obj13 = a.a(ZendeskProvidersModule_ProviderConnectivityManagerFactory.create(this.provideApplicationContextProvider));
        this.providerConnectivityManagerProvider = obj13;
        this.providerNetworkInfoProvider = a.a(ZendeskProvidersModule_ProviderNetworkInfoProviderFactory.create(this.provideApplicationContextProvider, obj13));
        final a aVar50 = a.a(ZendeskStorageModule_ProvideAuthProviderFactory.create(this.provideIdentityManagerProvider));
        this.provideAuthProvider = aVar50;
        this.provideCoreSdkModuleProvider = e.a(ZendeskProvidersModule_ProvideCoreSdkModuleFactory.create(this.provideSdkSettingsProvider, this.provideRestServiceProvider, this.providerBlipsProvider, this.provideSessionStorageProvider, this.providerNetworkInfoProvider, this.provideMemoryCacheProvider, this.actionHandlerRegistryProvider, this.provideExecutorProvider, this.provideApplicationContextProvider, aVar50, this.provideApplicationConfigurationProvider, this.providePushRegistrationProvider));
        obj13 = e.a(ZendeskProvidersModule_ProvideUserServiceFactory.create(this.provideRetrofitProvider));
        this.provideUserServiceProvider = obj13;
        obj13 = a.a(ZendeskProvidersModule_ProvideUserProviderFactory.create(obj13));
        this.provideUserProvider = obj13;
        a aVar47 = a.a(ZendeskProvidersModule_ProvideProviderStoreFactory.create(obj13, this.providePushRegistrationProvider));
        this.provideProviderStoreProvider = aVar47;
        this.provideZendeskProvider = a.a(ZendeskApplicationModule_ProvideZendeskFactory.create(this.provideSdkStorageProvider, this.provideLegacyIdentityStorageProvider, this.provideIdentityManagerProvider, this.providerBlipsCoreProvider, this.providePushRegistrationProvider, this.provideCoreSdkModuleProvider, aVar47));
    }

    @Override // zendesk.core.ZendeskApplicationComponent
    public zendesk.core.ZendeskShadow zendeskShadow() {
        return (ZendeskShadow)this.provideZendeskProvider.get();
    }
}
