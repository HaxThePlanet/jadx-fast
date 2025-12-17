package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideHelpCenterProviderFactory implements b<zendesk.support.HelpCenterProvider> {

    private final a<zendesk.support.HelpCenterBlipsProvider> blipsProvider;
    private final a<zendesk.support.ZendeskHelpCenterService> helpCenterServiceProvider;
    private final a<zendesk.support.HelpCenterSessionCache> helpCenterSessionCacheProvider;
    private final zendesk.support.GuideProviderModule module;
    private final a<zendesk.support.HelpCenterSettingsProvider> settingsProvider;
    public GuideProviderModule_ProvideHelpCenterProviderFactory(zendesk.support.GuideProviderModule guideProviderModule, a<zendesk.support.HelpCenterSettingsProvider> a2, a<zendesk.support.HelpCenterBlipsProvider> a3, a<zendesk.support.ZendeskHelpCenterService> a4, a<zendesk.support.HelpCenterSessionCache> a5) {
        super();
        this.module = guideProviderModule;
        this.settingsProvider = a2;
        this.blipsProvider = a3;
        this.helpCenterServiceProvider = a4;
        this.helpCenterSessionCacheProvider = a5;
    }

    public static zendesk.support.GuideProviderModule_ProvideHelpCenterProviderFactory create(zendesk.support.GuideProviderModule guideProviderModule, a<zendesk.support.HelpCenterSettingsProvider> a2, a<zendesk.support.HelpCenterBlipsProvider> a3, a<zendesk.support.ZendeskHelpCenterService> a4, a<zendesk.support.HelpCenterSessionCache> a5) {
        super(guideProviderModule, a2, a3, a4, a5);
        return guideProviderModule_ProvideHelpCenterProviderFactory;
    }

    public static zendesk.support.HelpCenterProvider provideHelpCenterProvider(zendesk.support.GuideProviderModule guideProviderModule, zendesk.support.HelpCenterSettingsProvider helpCenterSettingsProvider2, zendesk.support.HelpCenterBlipsProvider helpCenterBlipsProvider3, Object object4, Object object5) {
        final zendesk.support.HelpCenterProvider obj0 = guideProviderModule.provideHelpCenterProvider(helpCenterSettingsProvider2, helpCenterBlipsProvider3, (ZendeskHelpCenterService)object4, (HelpCenterSessionCache)object5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterProvider get() {
        return GuideProviderModule_ProvideHelpCenterProviderFactory.provideHelpCenterProvider(this.module, (HelpCenterSettingsProvider)this.settingsProvider.get(), (HelpCenterBlipsProvider)this.blipsProvider.get(), this.helpCenterServiceProvider.get(), this.helpCenterSessionCacheProvider.get());
    }
}
