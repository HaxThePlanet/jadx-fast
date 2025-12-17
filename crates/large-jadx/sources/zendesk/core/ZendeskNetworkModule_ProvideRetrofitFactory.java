package zendesk.core;

import com.google.gson.Gson;
import g.b.b;
import g.b.d;
import j.a.a;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideRetrofitFactory implements b<Retrofit> {

    private final a<zendesk.core.ApplicationConfiguration> configurationProvider;
    private final a<Gson> gsonProvider;
    private final a<OkHttpClient> okHttpClientProvider;
    public ZendeskNetworkModule_ProvideRetrofitFactory(a<zendesk.core.ApplicationConfiguration> a, a<Gson> a2, a<OkHttpClient> a3) {
        super();
        this.configurationProvider = a;
        this.gsonProvider = a2;
        this.okHttpClientProvider = a3;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideRetrofitFactory create(a<zendesk.core.ApplicationConfiguration> a, a<Gson> a2, a<OkHttpClient> a3) {
        ZendeskNetworkModule_ProvideRetrofitFactory zendeskNetworkModule_ProvideRetrofitFactory = new ZendeskNetworkModule_ProvideRetrofitFactory(a, a2, a3);
        return zendeskNetworkModule_ProvideRetrofitFactory;
    }

    public static Retrofit provideRetrofit(zendesk.core.ApplicationConfiguration applicationConfiguration, Gson gson2, OkHttpClient okHttpClient3) {
        final Retrofit obj0 = ZendeskNetworkModule.provideRetrofit(applicationConfiguration, gson2, okHttpClient3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (Retrofit)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Retrofit get() {
        return ZendeskNetworkModule_ProvideRetrofitFactory.provideRetrofit((ApplicationConfiguration)this.configurationProvider.get(), (Gson)this.gsonProvider.get(), (OkHttpClient)this.okHttpClientProvider.get());
    }
}
