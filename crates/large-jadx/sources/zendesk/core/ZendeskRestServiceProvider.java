package zendesk.core;

import java.util.Iterator;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;

/* loaded from: classes3.dex */
class ZendeskRestServiceProvider implements zendesk.core.RestServiceProvider {

    private final OkHttpClient coreOkHttpClient;
    private final OkHttpClient mediaHttpClient;
    final Retrofit retrofit;
    final OkHttpClient standardOkHttpClient;
    ZendeskRestServiceProvider(Retrofit retrofit, OkHttpClient okHttpClient2, OkHttpClient okHttpClient3, OkHttpClient okHttpClient4) {
        super();
        this.retrofit = retrofit;
        this.mediaHttpClient = okHttpClient2;
        this.standardOkHttpClient = okHttpClient3;
        this.coreOkHttpClient = okHttpClient4;
    }

    private OkHttpClient.Builder createNonAuthenticatedOkHttpClient() {
        boolean z;
        OkHttpClient.Builder builder = this.standardOkHttpClient.newBuilder();
        Iterator iterator = builder.interceptors().iterator();
        while (iterator.hasNext()) {
            if (next2 instanceof ZendeskAuthHeaderInterceptor) {
            }
            iterator.remove();
        }
        return builder;
    }

    public <E> E createRestService(Class<E> class, String string2, String string3) {
        UserAgentAndClientHeadersInterceptor userAgentAndClientHeadersInterceptor = new UserAgentAndClientHeadersInterceptor(string2, string3);
        return this.retrofit.newBuilder().client(this.standardOkHttpClient.newBuilder().addInterceptor(userAgentAndClientHeadersInterceptor).build()).build().create(class);
    }

    public <E> E createRestService(Class<E> class, String string2, String string3, zendesk.core.CustomNetworkConfig customNetworkConfig4) {
        OkHttpClient.Builder builder = this.standardOkHttpClient.newBuilder();
        customNetworkConfig4.configureOkHttpClient(builder);
        UserAgentAndClientHeadersInterceptor userAgentAndClientHeadersInterceptor = new UserAgentAndClientHeadersInterceptor(string2, string3);
        builder.addInterceptor(userAgentAndClientHeadersInterceptor);
        Retrofit.Builder obj4 = this.retrofit.newBuilder();
        customNetworkConfig4.configureRetrofit(obj4);
        return obj4.client(builder.build()).build().create(class);
    }

    public <E> E createUnauthenticatedRestService(Class<E> class, String string2, String string3, zendesk.core.CustomNetworkConfig customNetworkConfig4) {
        final OkHttpClient.Builder nonAuthenticatedOkHttpClient = createNonAuthenticatedOkHttpClient();
        customNetworkConfig4.configureOkHttpClient(nonAuthenticatedOkHttpClient);
        UserAgentAndClientHeadersInterceptor userAgentAndClientHeadersInterceptor = new UserAgentAndClientHeadersInterceptor(string2, string3);
        nonAuthenticatedOkHttpClient.addInterceptor(userAgentAndClientHeadersInterceptor);
        Retrofit.Builder obj4 = this.retrofit.newBuilder();
        customNetworkConfig4.configureRetrofit(obj4);
        return obj4.client(nonAuthenticatedOkHttpClient.build()).build().create(class);
    }

    @Override // zendesk.core.RestServiceProvider
    public OkHttpClient getCoreOkHttpClient() {
        return this.coreOkHttpClient;
    }

    @Override // zendesk.core.RestServiceProvider
    public OkHttpClient getMediaOkHttpClient() {
        return this.mediaHttpClient;
    }
}
