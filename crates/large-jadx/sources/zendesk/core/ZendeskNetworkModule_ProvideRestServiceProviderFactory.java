package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideRestServiceProviderFactory implements b<zendesk.core.RestServiceProvider> {

    private final a<OkHttpClient> coreOkHttpClientProvider;
    private final a<OkHttpClient> mediaOkHttpClientProvider;
    private final zendesk.core.ZendeskNetworkModule module;
    private final a<Retrofit> retrofitProvider;
    private final a<OkHttpClient> standardOkHttpClientProvider;
    public ZendeskNetworkModule_ProvideRestServiceProviderFactory(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<Retrofit> a2, a<OkHttpClient> a3, a<OkHttpClient> a4, a<OkHttpClient> a5) {
        super();
        this.module = zendeskNetworkModule;
        this.retrofitProvider = a2;
        this.mediaOkHttpClientProvider = a3;
        this.standardOkHttpClientProvider = a4;
        this.coreOkHttpClientProvider = a5;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideRestServiceProviderFactory create(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<Retrofit> a2, a<OkHttpClient> a3, a<OkHttpClient> a4, a<OkHttpClient> a5) {
        super(zendeskNetworkModule, a2, a3, a4, a5);
        return zendeskNetworkModule_ProvideRestServiceProviderFactory;
    }

    public static zendesk.core.RestServiceProvider provideRestServiceProvider(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, Retrofit retrofit2, OkHttpClient okHttpClient3, OkHttpClient okHttpClient4, OkHttpClient okHttpClient5) {
        final zendesk.core.RestServiceProvider obj0 = zendeskNetworkModule.provideRestServiceProvider(retrofit2, okHttpClient3, okHttpClient4, okHttpClient5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RestServiceProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.RestServiceProvider get() {
        return ZendeskNetworkModule_ProvideRestServiceProviderFactory.provideRestServiceProvider(this.module, (Retrofit)this.retrofitProvider.get(), (OkHttpClient)this.mediaOkHttpClientProvider.get(), (OkHttpClient)this.standardOkHttpClientProvider.get(), (OkHttpClient)this.coreOkHttpClientProvider.get());
    }
}
