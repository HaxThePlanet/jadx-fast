package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class GuideModule_ProvidesSettingsProviderFactory implements b<zendesk.support.HelpCenterSettingsProvider> {

    private final zendesk.support.GuideModule module;
    public GuideModule_ProvidesSettingsProviderFactory(zendesk.support.GuideModule guideModule) {
        super();
        this.module = guideModule;
    }

    public static zendesk.support.GuideModule_ProvidesSettingsProviderFactory create(zendesk.support.GuideModule guideModule) {
        GuideModule_ProvidesSettingsProviderFactory guideModule_ProvidesSettingsProviderFactory = new GuideModule_ProvidesSettingsProviderFactory(guideModule);
        return guideModule_ProvidesSettingsProviderFactory;
    }

    public static zendesk.support.HelpCenterSettingsProvider providesSettingsProvider(zendesk.support.GuideModule guideModule) {
        final zendesk.support.HelpCenterSettingsProvider obj1 = guideModule.providesSettingsProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterSettingsProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterSettingsProvider get() {
        return GuideModule_ProvidesSettingsProviderFactory.providesSettingsProvider(this.module);
    }
}
