package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.Locale;
import zendesk.core.BlipsProvider;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory implements b<zendesk.support.HelpCenterBlipsProvider> {

    private final a<BlipsProvider> blipsProvider;
    private final a<Locale> localeProvider;
    private final zendesk.support.GuideProviderModule module;
    public GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory(zendesk.support.GuideProviderModule guideProviderModule, a<BlipsProvider> a2, a<Locale> a3) {
        super();
        this.module = guideProviderModule;
        this.blipsProvider = a2;
        this.localeProvider = a3;
    }

    public static zendesk.support.GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory create(zendesk.support.GuideProviderModule guideProviderModule, a<BlipsProvider> a2, a<Locale> a3) {
        GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory guideProviderModule_ProvidesHelpCenterBlipsProviderFactory = new GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory(guideProviderModule, a2, a3);
        return guideProviderModule_ProvidesHelpCenterBlipsProviderFactory;
    }

    public static zendesk.support.HelpCenterBlipsProvider providesHelpCenterBlipsProvider(zendesk.support.GuideProviderModule guideProviderModule, BlipsProvider blipsProvider2, Locale locale3) {
        final zendesk.support.HelpCenterBlipsProvider obj0 = guideProviderModule.providesHelpCenterBlipsProvider(blipsProvider2, locale3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterBlipsProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterBlipsProvider get() {
        return GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory.providesHelpCenterBlipsProvider(this.module, (BlipsProvider)this.blipsProvider.get(), (Locale)this.localeProvider.get());
    }
}
