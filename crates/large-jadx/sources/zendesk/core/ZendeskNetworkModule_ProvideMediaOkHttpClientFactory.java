package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideMediaOkHttpClientFactory implements b<OkHttpClient> {

    private final a<zendesk.core.ZendeskAccessInterceptor> accessInterceptorProvider;
    private final a<zendesk.core.ZendeskAuthHeaderInterceptor> authHeaderInterceptorProvider;
    private final a<zendesk.core.CachingInterceptor> cachingInterceptorProvider;
    private final zendesk.core.ZendeskNetworkModule module;
    private final a<OkHttpClient> okHttpClientProvider;
    private final a<zendesk.core.ZendeskSettingsInterceptor> settingsInterceptorProvider;
    private final a<zendesk.core.ZendeskUnauthorizedInterceptor> unauthorizedInterceptorProvider;
    public ZendeskNetworkModule_ProvideMediaOkHttpClientFactory(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> a2, a<zendesk.core.ZendeskAccessInterceptor> a3, a<zendesk.core.ZendeskAuthHeaderInterceptor> a4, a<zendesk.core.ZendeskSettingsInterceptor> a5, a<zendesk.core.CachingInterceptor> a6, a<zendesk.core.ZendeskUnauthorizedInterceptor> a7) {
        super();
        this.module = zendeskNetworkModule;
        this.okHttpClientProvider = a2;
        this.accessInterceptorProvider = a3;
        this.authHeaderInterceptorProvider = a4;
        this.settingsInterceptorProvider = a5;
        this.cachingInterceptorProvider = a6;
        this.unauthorizedInterceptorProvider = a7;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideMediaOkHttpClientFactory create(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> a2, a<zendesk.core.ZendeskAccessInterceptor> a3, a<zendesk.core.ZendeskAuthHeaderInterceptor> a4, a<zendesk.core.ZendeskSettingsInterceptor> a5, a<zendesk.core.CachingInterceptor> a6, a<zendesk.core.ZendeskUnauthorizedInterceptor> a7) {
        super(zendeskNetworkModule, a2, a3, a4, a5, a6, a7);
        return zendeskNetworkModule_ProvideMediaOkHttpClientFactory;
    }

    public static OkHttpClient provideMediaOkHttpClient(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, OkHttpClient okHttpClient2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        final OkHttpClient obj7 = zendeskNetworkModule.provideMediaOkHttpClient(okHttpClient2, (ZendeskAccessInterceptor)object3, (ZendeskAuthHeaderInterceptor)object4, (ZendeskSettingsInterceptor)object5, (CachingInterceptor)object6, (ZendeskUnauthorizedInterceptor)object7);
        d.c(obj7, "Cannot return null from a non-@Nullable @Provides method");
        return (OkHttpClient)obj7;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public OkHttpClient get() {
        return ZendeskNetworkModule_ProvideMediaOkHttpClientFactory.provideMediaOkHttpClient(this.module, (OkHttpClient)this.okHttpClientProvider.get(), this.accessInterceptorProvider.get(), this.authHeaderInterceptorProvider.get(), this.settingsInterceptorProvider.get(), this.cachingInterceptorProvider.get(), this.unauthorizedInterceptorProvider.get());
    }
}
