package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideCoreOkHttpClientFactory implements b<OkHttpClient> {

    private final a<zendesk.core.AcceptHeaderInterceptor> acceptHeaderInterceptorProvider;
    private final a<zendesk.core.AcceptLanguageHeaderInterceptor> acceptLanguageHeaderInterceptorProvider;
    private final zendesk.core.ZendeskNetworkModule module;
    private final a<OkHttpClient> okHttpClientProvider;
    public ZendeskNetworkModule_ProvideCoreOkHttpClientFactory(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> a2, a<zendesk.core.AcceptLanguageHeaderInterceptor> a3, a<zendesk.core.AcceptHeaderInterceptor> a4) {
        super();
        this.module = zendeskNetworkModule;
        this.okHttpClientProvider = a2;
        this.acceptLanguageHeaderInterceptorProvider = a3;
        this.acceptHeaderInterceptorProvider = a4;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideCoreOkHttpClientFactory create(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> a2, a<zendesk.core.AcceptLanguageHeaderInterceptor> a3, a<zendesk.core.AcceptHeaderInterceptor> a4) {
        ZendeskNetworkModule_ProvideCoreOkHttpClientFactory zendeskNetworkModule_ProvideCoreOkHttpClientFactory = new ZendeskNetworkModule_ProvideCoreOkHttpClientFactory(zendeskNetworkModule, a2, a3, a4);
        return zendeskNetworkModule_ProvideCoreOkHttpClientFactory;
    }

    public static OkHttpClient provideCoreOkHttpClient(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, OkHttpClient okHttpClient2, Object object3, Object object4) {
        final OkHttpClient obj0 = zendeskNetworkModule.provideCoreOkHttpClient(okHttpClient2, (AcceptLanguageHeaderInterceptor)object3, (AcceptHeaderInterceptor)object4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (OkHttpClient)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public OkHttpClient get() {
        return ZendeskNetworkModule_ProvideCoreOkHttpClientFactory.provideCoreOkHttpClient(this.module, (OkHttpClient)this.okHttpClientProvider.get(), this.acceptLanguageHeaderInterceptorProvider.get(), this.acceptHeaderInterceptorProvider.get());
    }
}
