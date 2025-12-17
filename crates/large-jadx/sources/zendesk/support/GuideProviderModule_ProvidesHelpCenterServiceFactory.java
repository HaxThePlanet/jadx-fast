package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.RestServiceProvider;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvidesHelpCenterServiceFactory implements b<zendesk.support.HelpCenterService> {

    private final a<zendesk.support.HelpCenterCachingNetworkConfig> helpCenterCachingNetworkConfigProvider;
    private final a<RestServiceProvider> restServiceProvider;
    public GuideProviderModule_ProvidesHelpCenterServiceFactory(a<RestServiceProvider> a, a<zendesk.support.HelpCenterCachingNetworkConfig> a2) {
        super();
        this.restServiceProvider = a;
        this.helpCenterCachingNetworkConfigProvider = a2;
    }

    public static zendesk.support.GuideProviderModule_ProvidesHelpCenterServiceFactory create(a<RestServiceProvider> a, a<zendesk.support.HelpCenterCachingNetworkConfig> a2) {
        GuideProviderModule_ProvidesHelpCenterServiceFactory guideProviderModule_ProvidesHelpCenterServiceFactory = new GuideProviderModule_ProvidesHelpCenterServiceFactory(a, a2);
        return guideProviderModule_ProvidesHelpCenterServiceFactory;
    }

    public static zendesk.support.HelpCenterService providesHelpCenterService(RestServiceProvider restServiceProvider, Object object2) {
        final zendesk.support.HelpCenterService obj0 = GuideProviderModule.providesHelpCenterService(restServiceProvider, (HelpCenterCachingNetworkConfig)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterService)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterService get() {
        return GuideProviderModule_ProvidesHelpCenterServiceFactory.providesHelpCenterService((RestServiceProvider)this.restServiceProvider.get(), this.helpCenterCachingNetworkConfigProvider.get());
    }
}
