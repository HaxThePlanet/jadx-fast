package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory implements b<zendesk.core.AcceptHeaderInterceptor> {

    private static final zendesk.core.ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory INSTANCE;
    static {
        ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory zendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory = new ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory();
        ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory.INSTANCE = zendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory create() {
        return ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory.INSTANCE;
    }

    public static zendesk.core.AcceptHeaderInterceptor providesAcceptHeaderInterceptor() {
        final zendesk.core.AcceptHeaderInterceptor providesAcceptHeaderInterceptor = ZendeskNetworkModule.providesAcceptHeaderInterceptor();
        d.c(providesAcceptHeaderInterceptor, "Cannot return null from a non-@Nullable @Provides method");
        return (AcceptHeaderInterceptor)providesAcceptHeaderInterceptor;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.AcceptHeaderInterceptor get() {
        return ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory.providesAcceptHeaderInterceptor();
    }
}
