package zendesk.support.guide;

import g.a;
import j.a.a;
import o.a.b;
import okhttp3.OkHttpClient;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.ArticleVoteStorage;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSettingsProvider;

/* loaded from: classes3.dex */
public final class ViewArticleActivity_MembersInjector implements a<zendesk.support.guide.ViewArticleActivity> {

    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<ApplicationConfiguration> applicationConfigurationProvider;
    private final a<ArticleVoteStorage> articleVoteStorageProvider;
    private final a<b> configurationHelperProvider;
    private final a<HelpCenterProvider> helpCenterProvider;
    private final a<NetworkInfoProvider> networkInfoProvider;
    private final a<OkHttpClient> okHttpClientProvider;
    private final a<HelpCenterSettingsProvider> settingsProvider;
    public ViewArticleActivity_MembersInjector(a<OkHttpClient> a, a<ApplicationConfiguration> a2, a<HelpCenterProvider> a3, a<ArticleVoteStorage> a4, a<NetworkInfoProvider> a5, a<HelpCenterSettingsProvider> a6, a<ActionHandlerRegistry> a7, a<b> a8) {
        super();
        this.okHttpClientProvider = a;
        this.applicationConfigurationProvider = a2;
        this.helpCenterProvider = a3;
        this.articleVoteStorageProvider = a4;
        this.networkInfoProvider = a5;
        this.settingsProvider = a6;
        this.actionHandlerRegistryProvider = a7;
        this.configurationHelperProvider = a8;
    }

    public static a<zendesk.support.guide.ViewArticleActivity> create(a<OkHttpClient> a, a<ApplicationConfiguration> a2, a<HelpCenterProvider> a3, a<ArticleVoteStorage> a4, a<NetworkInfoProvider> a5, a<HelpCenterSettingsProvider> a6, a<ActionHandlerRegistry> a7, a<b> a8) {
        super(a, a2, a3, a4, a5, a6, a7, a8);
        return viewArticleActivity_MembersInjector;
    }

    public static void injectActionHandlerRegistry(zendesk.support.guide.ViewArticleActivity viewArticleActivity, ActionHandlerRegistry actionHandlerRegistry2) {
        viewArticleActivity.actionHandlerRegistry = actionHandlerRegistry2;
    }

    public static void injectApplicationConfiguration(zendesk.support.guide.ViewArticleActivity viewArticleActivity, ApplicationConfiguration applicationConfiguration2) {
        viewArticleActivity.applicationConfiguration = applicationConfiguration2;
    }

    public static void injectArticleVoteStorage(zendesk.support.guide.ViewArticleActivity viewArticleActivity, ArticleVoteStorage articleVoteStorage2) {
        viewArticleActivity.articleVoteStorage = articleVoteStorage2;
    }

    public static void injectConfigurationHelper(zendesk.support.guide.ViewArticleActivity viewArticleActivity, b b2) {
        viewArticleActivity.configurationHelper = b2;
    }

    public static void injectHelpCenterProvider(zendesk.support.guide.ViewArticleActivity viewArticleActivity, HelpCenterProvider helpCenterProvider2) {
        viewArticleActivity.helpCenterProvider = helpCenterProvider2;
    }

    public static void injectNetworkInfoProvider(zendesk.support.guide.ViewArticleActivity viewArticleActivity, NetworkInfoProvider networkInfoProvider2) {
        viewArticleActivity.networkInfoProvider = networkInfoProvider2;
    }

    public static void injectOkHttpClient(zendesk.support.guide.ViewArticleActivity viewArticleActivity, OkHttpClient okHttpClient2) {
        viewArticleActivity.okHttpClient = okHttpClient2;
    }

    public static void injectSettingsProvider(zendesk.support.guide.ViewArticleActivity viewArticleActivity, HelpCenterSettingsProvider helpCenterSettingsProvider2) {
        viewArticleActivity.settingsProvider = helpCenterSettingsProvider2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((ViewArticleActivity)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        ViewArticleActivity_MembersInjector.injectOkHttpClient(viewArticleActivity, (OkHttpClient)this.okHttpClientProvider.get());
        ViewArticleActivity_MembersInjector.injectApplicationConfiguration(viewArticleActivity, (ApplicationConfiguration)this.applicationConfigurationProvider.get());
        ViewArticleActivity_MembersInjector.injectHelpCenterProvider(viewArticleActivity, (HelpCenterProvider)this.helpCenterProvider.get());
        ViewArticleActivity_MembersInjector.injectArticleVoteStorage(viewArticleActivity, (ArticleVoteStorage)this.articleVoteStorageProvider.get());
        ViewArticleActivity_MembersInjector.injectNetworkInfoProvider(viewArticleActivity, (NetworkInfoProvider)this.networkInfoProvider.get());
        ViewArticleActivity_MembersInjector.injectSettingsProvider(viewArticleActivity, (HelpCenterSettingsProvider)this.settingsProvider.get());
        ViewArticleActivity_MembersInjector.injectActionHandlerRegistry(viewArticleActivity, (ActionHandlerRegistry)this.actionHandlerRegistryProvider.get());
        ViewArticleActivity_MembersInjector.injectConfigurationHelper(viewArticleActivity, (b)this.configurationHelperProvider.get());
    }
}
