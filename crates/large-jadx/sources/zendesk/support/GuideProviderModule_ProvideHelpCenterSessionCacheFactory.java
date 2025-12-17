package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideHelpCenterSessionCacheFactory implements b<zendesk.support.HelpCenterSessionCache> {

    private static final zendesk.support.GuideProviderModule_ProvideHelpCenterSessionCacheFactory INSTANCE;
    static {
        GuideProviderModule_ProvideHelpCenterSessionCacheFactory guideProviderModule_ProvideHelpCenterSessionCacheFactory = new GuideProviderModule_ProvideHelpCenterSessionCacheFactory();
        GuideProviderModule_ProvideHelpCenterSessionCacheFactory.INSTANCE = guideProviderModule_ProvideHelpCenterSessionCacheFactory;
    }

    public static zendesk.support.GuideProviderModule_ProvideHelpCenterSessionCacheFactory create() {
        return GuideProviderModule_ProvideHelpCenterSessionCacheFactory.INSTANCE;
    }

    public static zendesk.support.HelpCenterSessionCache provideHelpCenterSessionCache() {
        final zendesk.support.HelpCenterSessionCache provideHelpCenterSessionCache = GuideProviderModule.provideHelpCenterSessionCache();
        d.c(provideHelpCenterSessionCache, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterSessionCache)provideHelpCenterSessionCache;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterSessionCache get() {
        return GuideProviderModule_ProvideHelpCenterSessionCacheFactory.provideHelpCenterSessionCache();
    }
}
