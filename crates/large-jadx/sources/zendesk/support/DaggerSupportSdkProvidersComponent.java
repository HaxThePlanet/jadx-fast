package zendesk.support;

import android.content.Context;
import g.b.a;
import g.b.d;
import j.a.a;
import java.util.Locale;
import zendesk.core.AuthenticationProvider;
import zendesk.core.BlipsProvider;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_ActionHandlerRegistryFactory;
import zendesk.core.CoreModule_GetApplicationContextFactory;
import zendesk.core.CoreModule_GetAuthenticationProviderFactory;
import zendesk.core.CoreModule_GetBlipsProviderFactory;
import zendesk.core.CoreModule_GetMemoryCacheFactory;
import zendesk.core.CoreModule_GetRestServiceProviderFactory;
import zendesk.core.CoreModule_GetSessionStorageFactory;
import zendesk.core.CoreModule_GetSettingsProviderFactory;
import zendesk.core.MemoryCache;
import zendesk.core.RestServiceProvider;
import zendesk.core.SessionStorage;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
final class DaggerSupportSdkProvidersComponent implements zendesk.support.SupportSdkProvidersComponent {

    private final CoreModule coreModule;
    private a<Context> getApplicationContextProvider;
    private a<AuthenticationProvider> getAuthenticationProvider;
    private a<BlipsProvider> getBlipsProvider;
    private a<MemoryCache> getMemoryCacheProvider;
    private a<RestServiceProvider> getRestServiceProvider;
    private a<SessionStorage> getSessionStorageProvider;
    private a<SettingsProvider> getSettingsProvider;
    private a<Locale> provideLocaleProvider;
    private a<zendesk.support.SupportSdkMetadata> provideMetadataProvider;
    private a<zendesk.support.ProviderStore> provideProviderStoreProvider;
    private a<zendesk.support.RequestMigrator> provideRequestMigratorProvider;
    private a<zendesk.support.RequestProvider> provideRequestProvider;
    private a<zendesk.support.RequestSessionCache> provideRequestSessionCacheProvider;
    private a<zendesk.support.RequestStorage> provideRequestStorageProvider;
    private a<zendesk.support.SupportSettingsProvider> provideSdkSettingsProvider;
    private a<zendesk.support.SupportBlipsProvider> provideSupportBlipsProvider;
    private a<zendesk.support.SupportModule> provideSupportModuleProvider;
    private a<zendesk.support.UploadProvider> provideUploadProvider;
    private a<ZendeskLocaleConverter> provideZendeskLocaleConverterProvider;
    private a<zendesk.support.ZendeskRequestService> provideZendeskRequestServiceProvider;
    private a<zendesk.support.ZendeskUploadService> provideZendeskUploadServiceProvider;
    private a<zendesk.support.ArticleVoteStorage> providesArticleVoteStorageProvider;
    private a<zendesk.support.HelpCenterProvider> providesHelpCenterProvider;
    private a<zendesk.support.RequestService> providesRequestServiceProvider;
    private a<zendesk.support.UploadService> providesUploadServiceProvider;
    private a<zendesk.support.ZendeskTracker> providesZendeskTrackerProvider;

    static final class Builder {

        private CoreModule coreModule;
        private zendesk.support.GuideModule guideModule;
        private zendesk.support.ProviderModule providerModule;
        private zendesk.support.StorageModule storageModule;
        private zendesk.support.SupportApplicationModule supportApplicationModule;
        Builder(zendesk.support.DaggerSupportSdkProvidersComponent.1 daggerSupportSdkProvidersComponent$1) {
            super();
        }

        public zendesk.support.SupportSdkProvidersComponent build() {
            zendesk.support.ProviderModule providerModule;
            zendesk.support.StorageModule storageModule;
            d.a(this.supportApplicationModule, SupportApplicationModule.class);
            d.a(this.coreModule, CoreModule.class);
            if (this.providerModule == null) {
                providerModule = new ProviderModule();
                this.providerModule = providerModule;
            }
            d.a(this.guideModule, GuideModule.class);
            if (this.storageModule == null) {
                storageModule = new StorageModule();
                this.storageModule = storageModule;
            }
            super(this.supportApplicationModule, this.coreModule, this.providerModule, this.guideModule, this.storageModule, 0);
            return daggerSupportSdkProvidersComponent;
        }

        public zendesk.support.DaggerSupportSdkProvidersComponent.Builder coreModule(CoreModule coreModule) {
            d.b(coreModule);
            this.coreModule = (CoreModule)coreModule;
            return this;
        }

        public zendesk.support.DaggerSupportSdkProvidersComponent.Builder guideModule(zendesk.support.GuideModule guideModule) {
            d.b(guideModule);
            this.guideModule = (GuideModule)guideModule;
            return this;
        }

        public zendesk.support.DaggerSupportSdkProvidersComponent.Builder providerModule(zendesk.support.ProviderModule providerModule) {
            d.b(providerModule);
            this.providerModule = (ProviderModule)providerModule;
            return this;
        }

        @Deprecated
        public zendesk.support.DaggerSupportSdkProvidersComponent.Builder serviceModule(zendesk.support.ServiceModule serviceModule) {
            d.b(serviceModule);
            return this;
        }

        public zendesk.support.DaggerSupportSdkProvidersComponent.Builder storageModule(zendesk.support.StorageModule storageModule) {
            d.b(storageModule);
            this.storageModule = (StorageModule)storageModule;
            return this;
        }

        public zendesk.support.DaggerSupportSdkProvidersComponent.Builder supportApplicationModule(zendesk.support.SupportApplicationModule supportApplicationModule) {
            d.b(supportApplicationModule);
            this.supportApplicationModule = (SupportApplicationModule)supportApplicationModule;
            return this;
        }
    }
    private DaggerSupportSdkProvidersComponent(zendesk.support.SupportApplicationModule supportApplicationModule, CoreModule coreModule2, zendesk.support.ProviderModule providerModule3, zendesk.support.GuideModule guideModule4, zendesk.support.StorageModule storageModule5) {
        super();
        this.coreModule = coreModule2;
        initialize(supportApplicationModule, coreModule2, providerModule3, guideModule4, storageModule5);
    }

    DaggerSupportSdkProvidersComponent(zendesk.support.SupportApplicationModule supportApplicationModule, CoreModule coreModule2, zendesk.support.ProviderModule providerModule3, zendesk.support.GuideModule guideModule4, zendesk.support.StorageModule storageModule5, zendesk.support.DaggerSupportSdkProvidersComponent.1 daggerSupportSdkProvidersComponent$16) {
        super(supportApplicationModule, coreModule2, providerModule3, guideModule4, storageModule5);
    }

    public static zendesk.support.DaggerSupportSdkProvidersComponent.Builder builder() {
        DaggerSupportSdkProvidersComponent.Builder builder = new DaggerSupportSdkProvidersComponent.Builder(0);
        return builder;
    }

    private void initialize(zendesk.support.SupportApplicationModule supportApplicationModule, CoreModule coreModule2, zendesk.support.ProviderModule providerModule3, zendesk.support.GuideModule guideModule4, zendesk.support.StorageModule storageModule5) {
        this.providesHelpCenterProvider = GuideModule_ProvidesHelpCenterProviderFactory.create(guideModule4);
        this.getSettingsProvider = CoreModule_GetSettingsProviderFactory.create(coreModule2);
        this.provideLocaleProvider = a.a(SupportApplicationModule_ProvideLocaleFactory.create(supportApplicationModule));
        a aVar2 = a.a(ProviderModule_ProvideZendeskLocaleConverterFactory.create(providerModule3));
        this.provideZendeskLocaleConverterProvider = aVar2;
        this.provideSdkSettingsProvider = a.a(ProviderModule_ProvideSdkSettingsProviderFactory.create(providerModule3, this.getSettingsProvider, this.provideLocaleProvider, aVar2));
        this.getAuthenticationProvider = CoreModule_GetAuthenticationProviderFactory.create(coreModule2);
        CoreModule_GetRestServiceProviderFactory create7 = CoreModule_GetRestServiceProviderFactory.create(coreModule2);
        this.getRestServiceProvider = create7;
        a aVar4 = a.a(ServiceModule_ProvidesRequestServiceFactory.create(create7));
        this.providesRequestServiceProvider = aVar4;
        this.provideZendeskRequestServiceProvider = a.a(ServiceModule_ProvideZendeskRequestServiceFactory.create(aVar4));
        this.getSessionStorageProvider = CoreModule_GetSessionStorageFactory.create(coreModule2);
        CoreModule_GetApplicationContextFactory create11 = CoreModule_GetApplicationContextFactory.create(coreModule2);
        this.getApplicationContextProvider = create11;
        this.provideRequestMigratorProvider = a.a(StorageModule_ProvideRequestMigratorFactory.create(storageModule5, create11));
        CoreModule_GetMemoryCacheFactory create13 = CoreModule_GetMemoryCacheFactory.create(coreModule2);
        this.getMemoryCacheProvider = create13;
        this.provideRequestStorageProvider = a.a(StorageModule_ProvideRequestStorageFactory.create(storageModule5, this.getSessionStorageProvider, this.provideRequestMigratorProvider, create13));
        this.provideRequestSessionCacheProvider = a.a(StorageModule_ProvideRequestSessionCacheFactory.create(storageModule5));
        this.providesZendeskTrackerProvider = a.a(SupportApplicationModule_ProvidesZendeskTrackerFactory.create(supportApplicationModule));
        this.provideMetadataProvider = a.a(SupportApplicationModule_ProvideMetadataFactory.create(supportApplicationModule, this.getApplicationContextProvider));
        CoreModule_GetBlipsProviderFactory obj10 = CoreModule_GetBlipsProviderFactory.create(coreModule2);
        this.getBlipsProvider = obj10;
        a aVar8 = a.a(ProviderModule_ProvideSupportBlipsProviderFactory.create(providerModule3, obj10));
        this.provideSupportBlipsProvider = aVar8;
        zendesk.support.ProviderModule providerModule = providerModule3;
        this.provideRequestProvider = a.a(ProviderModule_ProvideRequestProviderFactory.create(providerModule, this.provideSdkSettingsProvider, this.getAuthenticationProvider, this.provideZendeskRequestServiceProvider, this.provideRequestStorageProvider, this.provideRequestSessionCacheProvider, this.providesZendeskTrackerProvider, this.provideMetadataProvider, aVar8));
        obj10 = a.a(ServiceModule_ProvidesUploadServiceFactory.create(this.getRestServiceProvider));
        this.providesUploadServiceProvider = obj10;
        obj10 = a.a(ServiceModule_ProvideZendeskUploadServiceFactory.create(obj10));
        this.provideZendeskUploadServiceProvider = obj10;
        obj10 = a.a(ProviderModule_ProvideUploadProviderFactory.create(providerModule3, obj10));
        this.provideUploadProvider = obj10;
        this.provideProviderStoreProvider = a.a(ProviderModule_ProvideProviderStoreFactory.create(providerModule3, this.providesHelpCenterProvider, this.provideRequestProvider, obj10));
        zendesk.support.GuideModule_ProvidesArticleVoteStorageFactory create15 = GuideModule_ProvidesArticleVoteStorageFactory.create(guideModule4);
        this.providesArticleVoteStorageProvider = create15;
        this.provideSupportModuleProvider = a.a(ProviderModule_ProvideSupportModuleFactory.create(providerModule, this.provideRequestProvider, this.provideUploadProvider, this.providesHelpCenterProvider, this.provideSdkSettingsProvider, this.getRestServiceProvider, this.provideSupportBlipsProvider, this.providesZendeskTrackerProvider, create15));
    }

    private zendesk.support.Support injectSupport(zendesk.support.Support support) {
        Support_MembersInjector.injectProviderStore(support, (ProviderStore)this.provideProviderStoreProvider.get());
        Support_MembersInjector.injectSupportModule(support, (SupportModule)this.provideSupportModuleProvider.get());
        Support_MembersInjector.injectRequestMigrator(support, this.provideRequestMigratorProvider.get());
        Support_MembersInjector.injectBlipsProvider(support, (SupportBlipsProvider)this.provideSupportBlipsProvider.get());
        Support_MembersInjector.injectActionHandlerRegistry(support, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
        Support_MembersInjector.injectRequestProvider(support, (RequestProvider)this.provideRequestProvider.get());
        Support_MembersInjector.injectAuthenticationProvider(support, CoreModule_GetAuthenticationProviderFactory.getAuthenticationProvider(this.coreModule));
        return support;
    }

    @Override // zendesk.support.SupportSdkProvidersComponent
    public zendesk.support.Support inject(zendesk.support.Support support) {
        return injectSupport(support);
    }
}
