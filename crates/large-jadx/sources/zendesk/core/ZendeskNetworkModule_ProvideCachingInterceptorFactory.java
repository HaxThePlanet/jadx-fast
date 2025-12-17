package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideCachingInterceptorFactory implements b<zendesk.core.CachingInterceptor> {

    private final a<zendesk.core.BaseStorage> mediaCacheProvider;
    public ZendeskNetworkModule_ProvideCachingInterceptorFactory(a<zendesk.core.BaseStorage> a) {
        super();
        this.mediaCacheProvider = a;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideCachingInterceptorFactory create(a<zendesk.core.BaseStorage> a) {
        ZendeskNetworkModule_ProvideCachingInterceptorFactory zendeskNetworkModule_ProvideCachingInterceptorFactory = new ZendeskNetworkModule_ProvideCachingInterceptorFactory(a);
        return zendeskNetworkModule_ProvideCachingInterceptorFactory;
    }

    public static zendesk.core.CachingInterceptor provideCachingInterceptor(zendesk.core.BaseStorage baseStorage) {
        final zendesk.core.CachingInterceptor obj1 = ZendeskNetworkModule.provideCachingInterceptor(baseStorage);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (CachingInterceptor)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.CachingInterceptor get() {
        return ZendeskNetworkModule_ProvideCachingInterceptorFactory.provideCachingInterceptor((BaseStorage)this.mediaCacheProvider.get());
    }
}
