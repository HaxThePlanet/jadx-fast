package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class GuideModule_ProvidesHelpCenterProviderFactory implements b<zendesk.support.HelpCenterProvider> {

    private final zendesk.support.GuideModule module;
    public GuideModule_ProvidesHelpCenterProviderFactory(zendesk.support.GuideModule guideModule) {
        super();
        this.module = guideModule;
    }

    public static zendesk.support.GuideModule_ProvidesHelpCenterProviderFactory create(zendesk.support.GuideModule guideModule) {
        GuideModule_ProvidesHelpCenterProviderFactory guideModule_ProvidesHelpCenterProviderFactory = new GuideModule_ProvidesHelpCenterProviderFactory(guideModule);
        return guideModule_ProvidesHelpCenterProviderFactory;
    }

    public static zendesk.support.HelpCenterProvider providesHelpCenterProvider(zendesk.support.GuideModule guideModule) {
        final zendesk.support.HelpCenterProvider obj1 = guideModule.providesHelpCenterProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterProvider get() {
        return GuideModule_ProvidesHelpCenterProviderFactory.providesHelpCenterProvider(this.module);
    }
}
