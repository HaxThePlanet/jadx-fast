package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.RestServiceProvider;

/* loaded from: classes3.dex */
public final class ProviderModule_ProvideSupportModuleFactory implements b<zendesk.support.SupportModule> {

    private final a<zendesk.support.ArticleVoteStorage> articleVoteStorageProvider;
    private final a<zendesk.support.SupportBlipsProvider> blipsProvider;
    private final a<zendesk.support.HelpCenterProvider> helpCenterProvider;
    private final zendesk.support.ProviderModule module;
    private final a<zendesk.support.RequestProvider> requestProvider;
    private final a<RestServiceProvider> restServiceProvider;
    private final a<zendesk.support.SupportSettingsProvider> settingsProvider;
    private final a<zendesk.support.UploadProvider> uploadProvider;
    private final a<zendesk.support.ZendeskTracker> zendeskTrackerProvider;
    public ProviderModule_ProvideSupportModuleFactory(zendesk.support.ProviderModule providerModule, a<zendesk.support.RequestProvider> a2, a<zendesk.support.UploadProvider> a3, a<zendesk.support.HelpCenterProvider> a4, a<zendesk.support.SupportSettingsProvider> a5, a<RestServiceProvider> a6, a<zendesk.support.SupportBlipsProvider> a7, a<zendesk.support.ZendeskTracker> a8, a<zendesk.support.ArticleVoteStorage> a9) {
        super();
        this.module = providerModule;
        this.requestProvider = a2;
        this.uploadProvider = a3;
        this.helpCenterProvider = a4;
        this.settingsProvider = a5;
        this.restServiceProvider = a6;
        this.blipsProvider = a7;
        this.zendeskTrackerProvider = a8;
        this.articleVoteStorageProvider = a9;
    }

    public static zendesk.support.ProviderModule_ProvideSupportModuleFactory create(zendesk.support.ProviderModule providerModule, a<zendesk.support.RequestProvider> a2, a<zendesk.support.UploadProvider> a3, a<zendesk.support.HelpCenterProvider> a4, a<zendesk.support.SupportSettingsProvider> a5, a<RestServiceProvider> a6, a<zendesk.support.SupportBlipsProvider> a7, a<zendesk.support.ZendeskTracker> a8, a<zendesk.support.ArticleVoteStorage> a9) {
        super(providerModule, a2, a3, a4, a5, a6, a7, a8, a9);
        return providerModule_ProvideSupportModuleFactory;
    }

    public static zendesk.support.SupportModule provideSupportModule(zendesk.support.ProviderModule providerModule, zendesk.support.RequestProvider requestProvider2, zendesk.support.UploadProvider uploadProvider3, zendesk.support.HelpCenterProvider helpCenterProvider4, zendesk.support.SupportSettingsProvider supportSettingsProvider5, RestServiceProvider restServiceProvider6, zendesk.support.SupportBlipsProvider supportBlipsProvider7, Object object8, zendesk.support.ArticleVoteStorage articleVoteStorage9) {
        zendesk.support.SupportModule provideSupportModule = providerModule.provideSupportModule(requestProvider2, uploadProvider3, helpCenterProvider4, supportSettingsProvider5, restServiceProvider6, supportBlipsProvider7, (ZendeskTracker)object8, articleVoteStorage9);
        d.c(provideSupportModule, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportModule)provideSupportModule;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportModule get() {
        return ProviderModule_ProvideSupportModuleFactory.provideSupportModule(this.module, (RequestProvider)this.requestProvider.get(), (UploadProvider)this.uploadProvider.get(), (HelpCenterProvider)this.helpCenterProvider.get(), (SupportSettingsProvider)this.settingsProvider.get(), (RestServiceProvider)this.restServiceProvider.get(), (SupportBlipsProvider)this.blipsProvider.get(), this.zendeskTrackerProvider.get(), (ArticleVoteStorage)this.articleVoteStorageProvider.get());
    }
}
