package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideOkHttpClientFactory implements b<OkHttpClient> {

    private final a<zendesk.core.AcceptHeaderInterceptor> acceptHeaderInterceptorProvider;
    private final a<zendesk.core.ZendeskAccessInterceptor> accessInterceptorProvider;
    private final a<zendesk.core.ZendeskAuthHeaderInterceptor> authHeaderInterceptorProvider;
    private final a<Cache> cacheProvider;
    private final zendesk.core.ZendeskNetworkModule module;
    private final a<OkHttpClient> okHttpClientProvider;
    private final a<zendesk.core.ZendeskPushInterceptor> pushInterceptorProvider;
    private final a<zendesk.core.ZendeskSettingsInterceptor> settingsInterceptorProvider;
    private final a<zendesk.core.ZendeskUnauthorizedInterceptor> unauthorizedInterceptorProvider;
    public ZendeskNetworkModule_ProvideOkHttpClientFactory(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> a2, a<zendesk.core.ZendeskAccessInterceptor> a3, a<zendesk.core.ZendeskUnauthorizedInterceptor> a4, a<zendesk.core.ZendeskAuthHeaderInterceptor> a5, a<zendesk.core.ZendeskSettingsInterceptor> a6, a<zendesk.core.AcceptHeaderInterceptor> a7, a<zendesk.core.ZendeskPushInterceptor> a8, a<Cache> a9) {
        super();
        this.module = zendeskNetworkModule;
        this.okHttpClientProvider = a2;
        this.accessInterceptorProvider = a3;
        this.unauthorizedInterceptorProvider = a4;
        this.authHeaderInterceptorProvider = a5;
        this.settingsInterceptorProvider = a6;
        this.acceptHeaderInterceptorProvider = a7;
        this.pushInterceptorProvider = a8;
        this.cacheProvider = a9;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideOkHttpClientFactory create(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> a2, a<zendesk.core.ZendeskAccessInterceptor> a3, a<zendesk.core.ZendeskUnauthorizedInterceptor> a4, a<zendesk.core.ZendeskAuthHeaderInterceptor> a5, a<zendesk.core.ZendeskSettingsInterceptor> a6, a<zendesk.core.AcceptHeaderInterceptor> a7, a<zendesk.core.ZendeskPushInterceptor> a8, a<Cache> a9) {
        super(zendeskNetworkModule, a2, a3, a4, a5, a6, a7, a8, a9);
        return zendeskNetworkModule_ProvideOkHttpClientFactory;
    }

    public static OkHttpClient provideOkHttpClient(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, OkHttpClient okHttpClient2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Cache cache9) {
        OkHttpClient provideOkHttpClient = zendeskNetworkModule.provideOkHttpClient(okHttpClient2, (ZendeskAccessInterceptor)object3, (ZendeskUnauthorizedInterceptor)object4, (ZendeskAuthHeaderInterceptor)object5, (ZendeskSettingsInterceptor)object6, (AcceptHeaderInterceptor)object7, (ZendeskPushInterceptor)object8, cache9);
        d.c(provideOkHttpClient, "Cannot return null from a non-@Nullable @Provides method");
        return (OkHttpClient)provideOkHttpClient;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public OkHttpClient get() {
        return ZendeskNetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient(this.module, (OkHttpClient)this.okHttpClientProvider.get(), this.accessInterceptorProvider.get(), this.unauthorizedInterceptorProvider.get(), this.authHeaderInterceptorProvider.get(), this.settingsInterceptorProvider.get(), this.acceptHeaderInterceptorProvider.get(), this.pushInterceptorProvider.get(), (Cache)this.cacheProvider.get());
    }
}
