package zendesk.support;

import g.b.a;
import g.b.d;
import g.b.e;
import j.a.a;
import java.util.Locale;
import zendesk.core.BlipsProvider;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_GetBlipsProviderFactory;
import zendesk.core.CoreModule_GetRestServiceProviderFactory;
import zendesk.core.CoreModule_GetSessionStorageFactory;
import zendesk.core.CoreModule_GetSettingsProviderFactory;
import zendesk.core.RestServiceProvider;
import zendesk.core.SessionStorage;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
final class DaggerGuideSdkProvidersComponent implements zendesk.support.GuideSdkProvidersComponent {

    private a<BlipsProvider> getBlipsProvider;
    private a<RestServiceProvider> getRestServiceProvider;
    private a<SessionStorage> getSessionStorageProvider;
    private a<SettingsProvider> getSettingsProvider;
    private a<zendesk.support.ArticleVoteStorage> provideArticleVoteStorageProvider;
    private a<zendesk.support.HelpCenterCachingNetworkConfig> provideCustomNetworkConfigProvider;
    private a<Locale> provideDeviceLocaleProvider;
    private a<zendesk.support.GuideModule> provideGuideModuleProvider;
    private a<zendesk.support.HelpCenterCachingInterceptor> provideHelpCenterCachingInterceptorProvider;
    private a<zendesk.support.HelpCenterProvider> provideHelpCenterProvider;
    private a<zendesk.support.HelpCenterSessionCache> provideHelpCenterSessionCacheProvider;
    private a<zendesk.support.HelpCenterSettingsProvider> provideSettingsProvider;
    private a<zendesk.support.ZendeskHelpCenterService> provideZendeskHelpCenterServiceProvider;
    private a<ZendeskLocaleConverter> provideZendeskLocaleConverterProvider;
    private a<zendesk.support.HelpCenterBlipsProvider> providesHelpCenterBlipsProvider;
    private a<zendesk.support.HelpCenterService> providesHelpCenterServiceProvider;

    static final class Builder {

        private CoreModule coreModule;
        private zendesk.support.GuideProviderModule guideProviderModule;
        Builder(zendesk.support.DaggerGuideSdkProvidersComponent.1 daggerGuideSdkProvidersComponent$1) {
            super();
        }

        public zendesk.support.GuideSdkProvidersComponent build() {
            d.a(this.coreModule, CoreModule.class);
            d.a(this.guideProviderModule, GuideProviderModule.class);
            DaggerGuideSdkProvidersComponent daggerGuideSdkProvidersComponent = new DaggerGuideSdkProvidersComponent(this.coreModule, this.guideProviderModule, 0);
            return daggerGuideSdkProvidersComponent;
        }

        public zendesk.support.DaggerGuideSdkProvidersComponent.Builder coreModule(CoreModule coreModule) {
            d.b(coreModule);
            this.coreModule = (CoreModule)coreModule;
            return this;
        }

        public zendesk.support.DaggerGuideSdkProvidersComponent.Builder guideProviderModule(zendesk.support.GuideProviderModule guideProviderModule) {
            d.b(guideProviderModule);
            this.guideProviderModule = (GuideProviderModule)guideProviderModule;
            return this;
        }
    }
    private DaggerGuideSdkProvidersComponent(CoreModule coreModule, zendesk.support.GuideProviderModule guideProviderModule2) {
        super();
        initialize(coreModule, guideProviderModule2);
    }

    DaggerGuideSdkProvidersComponent(CoreModule coreModule, zendesk.support.GuideProviderModule guideProviderModule2, zendesk.support.DaggerGuideSdkProvidersComponent.1 daggerGuideSdkProvidersComponent$13) {
        super(coreModule, guideProviderModule2);
    }

    public static zendesk.support.DaggerGuideSdkProvidersComponent.Builder builder() {
        DaggerGuideSdkProvidersComponent.Builder builder = new DaggerGuideSdkProvidersComponent.Builder(0);
        return builder;
    }

    private void initialize(CoreModule coreModule, zendesk.support.GuideProviderModule guideProviderModule2) {
        this.getSettingsProvider = CoreModule_GetSettingsProviderFactory.create(coreModule);
        this.provideZendeskLocaleConverterProvider = a.a(GuideProviderModule_ProvideZendeskLocaleConverterFactory.create());
        a aVar2 = a.a(GuideProviderModule_ProvideDeviceLocaleFactory.create(guideProviderModule2));
        this.provideDeviceLocaleProvider = aVar2;
        this.provideSettingsProvider = a.a(GuideProviderModule_ProvideSettingsProviderFactory.create(guideProviderModule2, this.getSettingsProvider, this.provideZendeskLocaleConverterProvider, aVar2));
        CoreModule_GetBlipsProviderFactory create5 = CoreModule_GetBlipsProviderFactory.create(coreModule);
        this.getBlipsProvider = create5;
        this.providesHelpCenterBlipsProvider = a.a(GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory.create(guideProviderModule2, create5, this.provideDeviceLocaleProvider));
        this.getRestServiceProvider = CoreModule_GetRestServiceProviderFactory.create(coreModule);
        a aVar5 = e.a(GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory.create());
        this.provideHelpCenterCachingInterceptorProvider = aVar5;
        a aVar6 = e.a(GuideProviderModule_ProvideCustomNetworkConfigFactory.create(aVar5));
        this.provideCustomNetworkConfigProvider = aVar6;
        a aVar7 = a.a(GuideProviderModule_ProvidesHelpCenterServiceFactory.create(this.getRestServiceProvider, aVar6));
        this.providesHelpCenterServiceProvider = aVar7;
        this.provideZendeskHelpCenterServiceProvider = a.a(GuideProviderModule_ProvideZendeskHelpCenterServiceFactory.create(aVar7, this.provideZendeskLocaleConverterProvider));
        a aVar9 = a.a(GuideProviderModule_ProvideHelpCenterSessionCacheFactory.create());
        this.provideHelpCenterSessionCacheProvider = aVar9;
        this.provideHelpCenterProvider = a.a(GuideProviderModule_ProvideHelpCenterProviderFactory.create(guideProviderModule2, this.provideSettingsProvider, this.providesHelpCenterBlipsProvider, this.provideZendeskHelpCenterServiceProvider, aVar9));
        CoreModule_GetSessionStorageFactory obj7 = CoreModule_GetSessionStorageFactory.create(coreModule);
        this.getSessionStorageProvider = obj7;
        final a aVar11 = a.a(GuideProviderModule_ProvideArticleVoteStorageFactory.create(obj7));
        this.provideArticleVoteStorageProvider = aVar11;
        this.provideGuideModuleProvider = a.a(GuideProviderModule_ProvideGuideModuleFactory.create(guideProviderModule2, this.provideHelpCenterProvider, this.provideSettingsProvider, this.providesHelpCenterBlipsProvider, aVar11, this.getRestServiceProvider));
    }

    private zendesk.support.Guide injectGuide(zendesk.support.Guide guide) {
        Guide_MembersInjector.injectGuideModule(guide, (GuideModule)this.provideGuideModuleProvider.get());
        Guide_MembersInjector.injectBlipsProvider(guide, (HelpCenterBlipsProvider)this.providesHelpCenterBlipsProvider.get());
        return guide;
    }

    @Override // zendesk.support.GuideSdkProvidersComponent
    public zendesk.support.Guide inject(zendesk.support.Guide guide) {
        return injectGuide(guide);
    }
}
