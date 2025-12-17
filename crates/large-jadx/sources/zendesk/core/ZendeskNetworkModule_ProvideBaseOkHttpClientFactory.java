package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideBaseOkHttpClientFactory implements b<OkHttpClient> {

    private final a<ExecutorService> executorServiceProvider;
    private final a<HttpLoggingInterceptor> loggingInterceptorProvider;
    private final zendesk.core.ZendeskNetworkModule module;
    private final a<zendesk.core.ZendeskOauthIdHeaderInterceptor> oauthIdHeaderInterceptorProvider;
    private final a<zendesk.core.UserAgentAndClientHeadersInterceptor> userAgentAndClientHeadersInterceptorProvider;
    public ZendeskNetworkModule_ProvideBaseOkHttpClientFactory(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<HttpLoggingInterceptor> a2, a<zendesk.core.ZendeskOauthIdHeaderInterceptor> a3, a<zendesk.core.UserAgentAndClientHeadersInterceptor> a4, a<ExecutorService> a5) {
        super();
        this.module = zendeskNetworkModule;
        this.loggingInterceptorProvider = a2;
        this.oauthIdHeaderInterceptorProvider = a3;
        this.userAgentAndClientHeadersInterceptorProvider = a4;
        this.executorServiceProvider = a5;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideBaseOkHttpClientFactory create(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<HttpLoggingInterceptor> a2, a<zendesk.core.ZendeskOauthIdHeaderInterceptor> a3, a<zendesk.core.UserAgentAndClientHeadersInterceptor> a4, a<ExecutorService> a5) {
        super(zendeskNetworkModule, a2, a3, a4, a5);
        return zendeskNetworkModule_ProvideBaseOkHttpClientFactory;
    }

    public static OkHttpClient provideBaseOkHttpClient(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, HttpLoggingInterceptor httpLoggingInterceptor2, Object object3, Object object4, ExecutorService executorService5) {
        final OkHttpClient obj0 = zendeskNetworkModule.provideBaseOkHttpClient(httpLoggingInterceptor2, (ZendeskOauthIdHeaderInterceptor)object3, (UserAgentAndClientHeadersInterceptor)object4, executorService5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (OkHttpClient)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public OkHttpClient get() {
        return ZendeskNetworkModule_ProvideBaseOkHttpClientFactory.provideBaseOkHttpClient(this.module, (HttpLoggingInterceptor)this.loggingInterceptorProvider.get(), this.oauthIdHeaderInterceptorProvider.get(), this.userAgentAndClientHeadersInterceptorProvider.get(), (ExecutorService)this.executorServiceProvider.get());
    }
}
