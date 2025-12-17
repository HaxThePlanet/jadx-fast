package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory implements b<zendesk.core.UserAgentAndClientHeadersInterceptor> {

    private final zendesk.core.ZendeskNetworkModule module;
    public ZendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory(zendesk.core.ZendeskNetworkModule zendeskNetworkModule) {
        super();
        this.module = zendeskNetworkModule;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory create(zendesk.core.ZendeskNetworkModule zendeskNetworkModule) {
        ZendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory zendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory = new ZendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory(zendeskNetworkModule);
        return zendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory;
    }

    public static zendesk.core.UserAgentAndClientHeadersInterceptor providesUserAgentHeaderInterceptor(zendesk.core.ZendeskNetworkModule zendeskNetworkModule) {
        final zendesk.core.UserAgentAndClientHeadersInterceptor obj1 = zendeskNetworkModule.providesUserAgentHeaderInterceptor();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (UserAgentAndClientHeadersInterceptor)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.UserAgentAndClientHeadersInterceptor get() {
        return ZendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory.providesUserAgentHeaderInterceptor(this.module);
    }
}
