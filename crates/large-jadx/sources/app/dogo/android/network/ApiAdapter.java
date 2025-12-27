package app.dogo.android.network;

import com.squareup.moshi.r.a;
import com.squareup.moshi.w.a.b;
import i.b.s0.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/* compiled from: ApiAdapter.kt */
@Metadata(d1 = "\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/android/network/ApiAdapter;", "", "()V", "nullOnEmptyConverterFactory", "app/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1", "Lapp/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1;", "tokenInterceptor", "Lapp/dogo/android/network/TokenInterceptor;", "getTokenInterceptor", "()Lapp/dogo/android/network/TokenInterceptor;", "userAgentInterceptor", "Lapp/dogo/android/network/UserAgentInterceptor;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "baseUrl", "", "client", "Lokhttp3/OkHttpClient;", "okHttpClient", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class ApiAdapter {

    /* renamed from: a, reason: from kotlin metadata */
    public static final c nullOnEmptyConverterFactory = new c();
    private static final c.a b = new c$a();
    /* renamed from: c, reason: from kotlin metadata */
    private static final d userAgentInterceptor = new d(0, 0, 3, 0);
    private static final e d;

    @Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0002\u0000\u0005\u0008\n\u0018\u00002\u00020\u0001J\u000b\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"app/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1", "Lretrofit2/Converter$Factory;", "converterFactory", "()Lapp/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1;", "responseBodyConverter", "app/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1$responseBodyConverter$1", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lapp/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1$responseBodyConverter$1;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends Converter.Factory {
        a() {
            super();
        }

        @Override // retrofit2.Converter$Factory
        /* renamed from: b, reason: from kotlin metadata */
        public c.a.a responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            n.f(type, "type");
            n.f(annotations, "annotations");
            n.f(retrofit, "retrofit");
            return new ApiAdapter_nullOnEmptyConverterFactory_1_responseBodyConverter_1(retrofit, this, type, annotations);
        }

        @Override // retrofit2.Converter$Factory
        /* renamed from: a, reason: from kotlin metadata */
        public final c.a converterFactory() {
            return this;
        }
    }
    static {
        UserAgentInterceptor userAgentInterceptor = new UserAgentInterceptor(null, 0, null, 7, null);
        ApiAdapter.d = userAgentInterceptor;
    }

    private c() {
        super();
    }

    public static /* synthetic */ DogoApiClient b(c cVar, String str, OkHttpClient okHttpClient, int i, Object object) {
        OkHttpClient apiClient;
        if (i & 1 != 0) {
            str = "https://api-dot-dogo-8da73.uc.r.appspot.com";
        }
        i = i & 2;
        if (i & 2 != 0) {
            apiClient = cVar.apiClient(ApiAdapter.userAgentInterceptor, ApiAdapter.d);
        }
        return cVar.okHttpClient(str, apiClient);
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final OkHttpClient apiClient(d baseUrl, e client) {
        return new OkHttpClient_Builder().addInterceptor(baseUrl).addNetworkInterceptor(client).build();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final DogoApiClient okHttpClient(String tokenInterceptor, OkHttpClient userAgentInterceptor) {
        n.f(tokenInterceptor, "baseUrl");
        n.f(userAgentInterceptor, "client");
        r.a aVar2 = new r.a();
        aVar2.a(new b());
        Object retrofit = new Retrofit.Builder().baseUrl(tokenInterceptor).client(userAgentInterceptor).addConverterFactory(ApiAdapter.b).addConverterFactory(MoshiConverterFactory.create(aVar2.b())).addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(a.b())).build().create(DogoApiClient.class);
        n.e(retrofit, "Builder()\n        .baseUrl(baseUrl)\n        .client(client)\n        .addConverterFactory(nullOnEmptyConverterFactory) // order is important\n        .addConverterFactory(MoshiConverterFactory.create(\n            Moshi.Builder().add(KotlinJsonAdapterFactory()).build()\n        ))\n        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))\n        .build()\n        .create(DogoApiClient::class.java)");
        return retrofit;
    }

    public final d c() {
        return ApiAdapter.userAgentInterceptor;
    }
}
