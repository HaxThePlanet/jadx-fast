package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory implements b<zendesk.core.ZendeskAuthHeaderInterceptor> {

    private final a<zendesk.core.IdentityManager> identityManagerProvider;
    public ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory(a<zendesk.core.IdentityManager> a) {
        super();
        this.identityManagerProvider = a;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory create(a<zendesk.core.IdentityManager> a) {
        ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory zendeskNetworkModule_ProvideAuthHeaderInterceptorFactory = new ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory(a);
        return zendeskNetworkModule_ProvideAuthHeaderInterceptorFactory;
    }

    public static zendesk.core.ZendeskAuthHeaderInterceptor provideAuthHeaderInterceptor(Object object) {
        final zendesk.core.ZendeskAuthHeaderInterceptor obj1 = ZendeskNetworkModule.provideAuthHeaderInterceptor((IdentityManager)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskAuthHeaderInterceptor)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskAuthHeaderInterceptor get() {
        return ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory.provideAuthHeaderInterceptor(this.identityManagerProvider.get());
    }
}
