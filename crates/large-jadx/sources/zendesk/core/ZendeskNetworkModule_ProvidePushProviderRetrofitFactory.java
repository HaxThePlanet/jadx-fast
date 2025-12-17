package zendesk.core;

import com.google.gson.Gson;
import g.b.b;
import g.b.d;
import j.a.a;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvidePushProviderRetrofitFactory implements b<Retrofit> {

    private final a<zendesk.core.ZendeskAuthHeaderInterceptor> authHeaderInterceptorProvider;
    private final a<zendesk.core.ApplicationConfiguration> configurationProvider;
    private final a<Gson> gsonProvider;
    private final a<OkHttpClient> okHttpClientProvider;
    public ZendeskNetworkModule_ProvidePushProviderRetrofitFactory(a<zendesk.core.ApplicationConfiguration> a, a<Gson> a2, a<OkHttpClient> a3, a<zendesk.core.ZendeskAuthHeaderInterceptor> a4) {
        super();
        this.configurationProvider = a;
        this.gsonProvider = a2;
        this.okHttpClientProvider = a3;
        this.authHeaderInterceptorProvider = a4;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvidePushProviderRetrofitFactory create(a<zendesk.core.ApplicationConfiguration> a, a<Gson> a2, a<OkHttpClient> a3, a<zendesk.core.ZendeskAuthHeaderInterceptor> a4) {
        ZendeskNetworkModule_ProvidePushProviderRetrofitFactory zendeskNetworkModule_ProvidePushProviderRetrofitFactory = new ZendeskNetworkModule_ProvidePushProviderRetrofitFactory(a, a2, a3, a4);
        return zendeskNetworkModule_ProvidePushProviderRetrofitFactory;
    }

    public static Retrofit providePushProviderRetrofit(zendesk.core.ApplicationConfiguration applicationConfiguration, Gson gson2, OkHttpClient okHttpClient3, Object object4) {
        final Retrofit obj0 = ZendeskNetworkModule.providePushProviderRetrofit(applicationConfiguration, gson2, okHttpClient3, (ZendeskAuthHeaderInterceptor)object4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (Retrofit)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Retrofit get() {
        return ZendeskNetworkModule_ProvidePushProviderRetrofitFactory.providePushProviderRetrofit((ApplicationConfiguration)this.configurationProvider.get(), (Gson)this.gsonProvider.get(), (OkHttpClient)this.okHttpClientProvider.get(), this.authHeaderInterceptorProvider.get());
    }
}
