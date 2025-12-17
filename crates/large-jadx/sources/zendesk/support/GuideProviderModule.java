package zendesk.support;

import java.util.Locale;
import zendesk.core.BlipsProvider;
import zendesk.core.RestServiceProvider;
import zendesk.core.SessionStorage;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
class GuideProviderModule {

    private zendesk.support.HelpCenterTracker tracker;
    GuideProviderModule(zendesk.support.HelpCenterTracker helpCenterTracker) {
        super();
        this.tracker = helpCenterTracker;
    }

    static zendesk.support.ArticleVoteStorage provideArticleVoteStorage(SessionStorage sessionStorage) {
        ZendeskArticleVoteStorage zendeskArticleVoteStorage = new ZendeskArticleVoteStorage(sessionStorage.getAdditionalSdkStorage());
        return zendeskArticleVoteStorage;
    }

    static zendesk.support.HelpCenterCachingNetworkConfig provideCustomNetworkConfig(zendesk.support.HelpCenterCachingInterceptor helpCenterCachingInterceptor) {
        HelpCenterCachingNetworkConfig helpCenterCachingNetworkConfig = new HelpCenterCachingNetworkConfig(helpCenterCachingInterceptor);
        return helpCenterCachingNetworkConfig;
    }

    static zendesk.support.HelpCenterCachingInterceptor provideHelpCenterCachingInterceptor() {
        HelpCenterCachingInterceptor helpCenterCachingInterceptor = new HelpCenterCachingInterceptor();
        return helpCenterCachingInterceptor;
    }

    static zendesk.support.HelpCenterSessionCache provideHelpCenterSessionCache() {
        ZendeskHelpCenterSessionCache zendeskHelpCenterSessionCache = new ZendeskHelpCenterSessionCache();
        return zendeskHelpCenterSessionCache;
    }

    static zendesk.support.ZendeskHelpCenterService provideZendeskHelpCenterService(zendesk.support.HelpCenterService helpCenterService, ZendeskLocaleConverter zendeskLocaleConverter2) {
        ZendeskHelpCenterService zendeskHelpCenterService = new ZendeskHelpCenterService(helpCenterService, zendeskLocaleConverter2);
        return zendeskHelpCenterService;
    }

    static ZendeskLocaleConverter provideZendeskLocaleConverter() {
        ZendeskLocaleConverter zendeskLocaleConverter = new ZendeskLocaleConverter();
        return zendeskLocaleConverter;
    }

    static zendesk.support.HelpCenterService providesHelpCenterService(RestServiceProvider restServiceProvider, zendesk.support.HelpCenterCachingNetworkConfig helpCenterCachingNetworkConfig2) {
        return (HelpCenterService)restServiceProvider.createRestService(HelpCenterService.class, "1.0.2", "Guide", helpCenterCachingNetworkConfig2);
    }

    Locale provideDeviceLocale() {
        return Locale.getDefault();
    }

    zendesk.support.GuideModule provideGuideModule(zendesk.support.HelpCenterProvider helpCenterProvider, zendesk.support.HelpCenterSettingsProvider helpCenterSettingsProvider2, zendesk.support.HelpCenterBlipsProvider helpCenterBlipsProvider3, zendesk.support.ArticleVoteStorage articleVoteStorage4, RestServiceProvider restServiceProvider5) {
        super(helpCenterProvider, helpCenterSettingsProvider2, helpCenterBlipsProvider3, this.tracker, articleVoteStorage4, restServiceProvider5.getMediaOkHttpClient());
        return guideModule2;
    }

    zendesk.support.HelpCenterProvider provideHelpCenterProvider(zendesk.support.HelpCenterSettingsProvider helpCenterSettingsProvider, zendesk.support.HelpCenterBlipsProvider helpCenterBlipsProvider2, zendesk.support.ZendeskHelpCenterService zendeskHelpCenterService3, zendesk.support.HelpCenterSessionCache helpCenterSessionCache4) {
        super(helpCenterSettingsProvider, helpCenterBlipsProvider2, zendeskHelpCenterService3, helpCenterSessionCache4, this.tracker);
        return zendeskHelpCenterProvider2;
    }

    zendesk.support.HelpCenterSettingsProvider provideSettingsProvider(SettingsProvider settingsProvider, ZendeskLocaleConverter zendeskLocaleConverter2, Locale locale3) {
        ZendeskHelpCenterSettingsProvider zendeskHelpCenterSettingsProvider = new ZendeskHelpCenterSettingsProvider(settingsProvider, zendeskLocaleConverter2, locale3);
        return zendeskHelpCenterSettingsProvider;
    }

    zendesk.support.HelpCenterBlipsProvider providesHelpCenterBlipsProvider(BlipsProvider blipsProvider, Locale locale2) {
        ZendeskHelpCenterBlipsProvider zendeskHelpCenterBlipsProvider = new ZendeskHelpCenterBlipsProvider(blipsProvider, locale2);
        return zendeskHelpCenterBlipsProvider;
    }
}
