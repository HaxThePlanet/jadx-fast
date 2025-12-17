package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory implements b<zendesk.support.HelpCenterCachingInterceptor> {

    private static final zendesk.support.GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory INSTANCE;
    static {
        GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory guideProviderModule_ProvideHelpCenterCachingInterceptorFactory = new GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory();
        GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory.INSTANCE = guideProviderModule_ProvideHelpCenterCachingInterceptorFactory;
    }

    public static zendesk.support.GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory create() {
        return GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory.INSTANCE;
    }

    public static zendesk.support.HelpCenterCachingInterceptor provideHelpCenterCachingInterceptor() {
        final zendesk.support.HelpCenterCachingInterceptor provideHelpCenterCachingInterceptor = GuideProviderModule.provideHelpCenterCachingInterceptor();
        d.c(provideHelpCenterCachingInterceptor, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterCachingInterceptor)provideHelpCenterCachingInterceptor;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterCachingInterceptor get() {
        return GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory.provideHelpCenterCachingInterceptor();
    }
}
