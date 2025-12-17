package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideCustomNetworkConfigFactory implements b<zendesk.support.HelpCenterCachingNetworkConfig> {

    private final a<zendesk.support.HelpCenterCachingInterceptor> helpCenterCachingInterceptorProvider;
    public GuideProviderModule_ProvideCustomNetworkConfigFactory(a<zendesk.support.HelpCenterCachingInterceptor> a) {
        super();
        this.helpCenterCachingInterceptorProvider = a;
    }

    public static zendesk.support.GuideProviderModule_ProvideCustomNetworkConfigFactory create(a<zendesk.support.HelpCenterCachingInterceptor> a) {
        GuideProviderModule_ProvideCustomNetworkConfigFactory guideProviderModule_ProvideCustomNetworkConfigFactory = new GuideProviderModule_ProvideCustomNetworkConfigFactory(a);
        return guideProviderModule_ProvideCustomNetworkConfigFactory;
    }

    public static zendesk.support.HelpCenterCachingNetworkConfig provideCustomNetworkConfig(Object object) {
        final zendesk.support.HelpCenterCachingNetworkConfig obj1 = GuideProviderModule.provideCustomNetworkConfig((HelpCenterCachingInterceptor)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterCachingNetworkConfig)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterCachingNetworkConfig get() {
        return GuideProviderModule_ProvideCustomNetworkConfigFactory.provideCustomNetworkConfig(this.helpCenterCachingInterceptorProvider.get());
    }
}
