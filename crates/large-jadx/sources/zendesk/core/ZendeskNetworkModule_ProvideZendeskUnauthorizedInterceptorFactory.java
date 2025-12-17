package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory implements b<zendesk.core.ZendeskUnauthorizedInterceptor> {

    private final a<zendesk.core.SessionStorage> sessionStorageProvider;
    public ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory(a<zendesk.core.SessionStorage> a) {
        super();
        this.sessionStorageProvider = a;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory create(a<zendesk.core.SessionStorage> a) {
        ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory zendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory = new ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory(a);
        return zendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory;
    }

    public static zendesk.core.ZendeskUnauthorizedInterceptor provideZendeskUnauthorizedInterceptor(zendesk.core.SessionStorage sessionStorage) {
        final zendesk.core.ZendeskUnauthorizedInterceptor obj1 = ZendeskNetworkModule.provideZendeskUnauthorizedInterceptor(sessionStorage);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskUnauthorizedInterceptor)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskUnauthorizedInterceptor get() {
        return ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory.provideZendeskUnauthorizedInterceptor((SessionStorage)this.sessionStorageProvider.get());
    }
}
