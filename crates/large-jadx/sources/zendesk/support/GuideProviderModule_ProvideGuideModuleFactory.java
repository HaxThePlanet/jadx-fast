package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.RestServiceProvider;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideGuideModuleFactory implements b<zendesk.support.GuideModule> {

    private final a<zendesk.support.ArticleVoteStorage> articleVoteStorageProvider;
    private final a<zendesk.support.HelpCenterBlipsProvider> blipsProvider;
    private final a<zendesk.support.HelpCenterProvider> helpCenterProvider;
    private final zendesk.support.GuideProviderModule module;
    private final a<RestServiceProvider> restServiceProvider;
    private final a<zendesk.support.HelpCenterSettingsProvider> settingsProvider;
    public GuideProviderModule_ProvideGuideModuleFactory(zendesk.support.GuideProviderModule guideProviderModule, a<zendesk.support.HelpCenterProvider> a2, a<zendesk.support.HelpCenterSettingsProvider> a3, a<zendesk.support.HelpCenterBlipsProvider> a4, a<zendesk.support.ArticleVoteStorage> a5, a<RestServiceProvider> a6) {
        super();
        this.module = guideProviderModule;
        this.helpCenterProvider = a2;
        this.settingsProvider = a3;
        this.blipsProvider = a4;
        this.articleVoteStorageProvider = a5;
        this.restServiceProvider = a6;
    }

    public static zendesk.support.GuideProviderModule_ProvideGuideModuleFactory create(zendesk.support.GuideProviderModule guideProviderModule, a<zendesk.support.HelpCenterProvider> a2, a<zendesk.support.HelpCenterSettingsProvider> a3, a<zendesk.support.HelpCenterBlipsProvider> a4, a<zendesk.support.ArticleVoteStorage> a5, a<RestServiceProvider> a6) {
        super(guideProviderModule, a2, a3, a4, a5, a6);
        return guideProviderModule_ProvideGuideModuleFactory;
    }

    public static zendesk.support.GuideModule provideGuideModule(zendesk.support.GuideProviderModule guideProviderModule, zendesk.support.HelpCenterProvider helpCenterProvider2, zendesk.support.HelpCenterSettingsProvider helpCenterSettingsProvider3, zendesk.support.HelpCenterBlipsProvider helpCenterBlipsProvider4, zendesk.support.ArticleVoteStorage articleVoteStorage5, RestServiceProvider restServiceProvider6) {
        final zendesk.support.GuideModule obj0 = guideProviderModule.provideGuideModule(helpCenterProvider2, helpCenterSettingsProvider3, helpCenterBlipsProvider4, articleVoteStorage5, restServiceProvider6);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (GuideModule)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.GuideModule get() {
        return GuideProviderModule_ProvideGuideModuleFactory.provideGuideModule(this.module, (HelpCenterProvider)this.helpCenterProvider.get(), (HelpCenterSettingsProvider)this.settingsProvider.get(), (HelpCenterBlipsProvider)this.blipsProvider.get(), (ArticleVoteStorage)this.articleVoteStorageProvider.get(), (RestServiceProvider)this.restServiceProvider.get());
    }
}
