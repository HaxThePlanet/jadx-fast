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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/android/network/ApiAdapter;", "", "()V", "nullOnEmptyConverterFactory", "app/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1", "Lapp/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1;", "tokenInterceptor", "Lapp/dogo/android/network/TokenInterceptor;", "getTokenInterceptor", "()Lapp/dogo/android/network/TokenInterceptor;", "userAgentInterceptor", "Lapp/dogo/android/network/UserAgentInterceptor;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "baseUrl", "", "client", "Lokhttp3/OkHttpClient;", "okHttpClient", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c {

    public static final app.dogo.android.network.c a;
    private static final app.dogo.android.network.c.a b;
    private static final app.dogo.android.network.d c;
    private static final app.dogo.android.network.e d;

    @Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0002\u0000\u0005\u0008\n\u0018\u00002\u00020\u0001J\u000b\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"app/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1", "Lretrofit2/Converter$Factory;", "converterFactory", "()Lapp/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1;", "responseBodyConverter", "app/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1$responseBodyConverter$1", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lapp/dogo/android/network/ApiAdapter$nullOnEmptyConverterFactory$1$responseBodyConverter$1;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends Converter.Factory {
        @Override // retrofit2.Converter$Factory
        public final app.dogo.android.network.c.a a() {
            return this;
        }

        @Override // retrofit2.Converter$Factory
        public app.dogo.android.network.c.a.a b(Type type, Annotation[] annotation2Arr2, Retrofit retrofit3) {
            n.f(type, "type");
            n.f(annotation2Arr2, "annotations");
            n.f(retrofit3, "retrofit");
            c.a.a aVar = new c.a.a(retrofit3, this, type, annotation2Arr2);
            return aVar;
        }

        @Override // retrofit2.Converter$Factory
        public Converter responseBodyConverter(Type type, Annotation[] annotation2Arr2, Retrofit retrofit3) {
            return b(type, annotation2Arr2, retrofit3);
        }
    }
    static {
        c cVar = new c();
        c.a = cVar;
        c.a aVar = new c.a();
        c.b = aVar;
        final int i = 0;
        d dVar = new d(i, i, 3, i);
        c.c = dVar;
        super(0, 0, 0, 7, 0);
        c.d = eVar;
    }

    public static app.dogo.android.network.DogoApiClient b(app.dogo.android.network.c c, String string2, OkHttpClient okHttpClient3, int i4, Object object5) {
        String obj1;
        OkHttpClient obj2;
        int obj3;
        if (i4 & 1 != 0) {
            obj1 = "https://api-dot-dogo-8da73.uc.r.appspot.com";
        }
        if (i4 &= 2 != 0) {
            obj2 = c.d(c.c, c.d);
        }
        return c.a(obj1, obj2);
    }

    private final OkHttpClient d(app.dogo.android.network.d d, app.dogo.android.network.e e2) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.addInterceptor(d).addNetworkInterceptor(e2).build();
    }

    public final app.dogo.android.network.DogoApiClient a(String string, OkHttpClient okHttpClient2) {
        n.f(string, "baseUrl");
        n.f(okHttpClient2, "client");
        Retrofit.Builder builder = new Retrofit.Builder();
        r.a obj3 = new r.a();
        b bVar = new b();
        obj3.a(bVar);
        Object obj2 = builder.baseUrl(string).client(okHttpClient2).addConverterFactory(c.b).addConverterFactory(MoshiConverterFactory.create(obj3.b())).addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(a.b())).build().create(DogoApiClient.class);
        n.e(obj2, "Builder()\n        .baseUrl(baseUrl)\n        .client(client)\n        .addConverterFactory(nullOnEmptyConverterFactory) // order is important\n        .addConverterFactory(MoshiConverterFactory.create(\n            Moshi.Builder().add(KotlinJsonAdapterFactory()).build()\n        ))\n        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))\n        .build()\n        .create(DogoApiClient::class.java)");
        return (DogoApiClient)obj2;
    }

    public final app.dogo.android.network.d c() {
        return c.c;
    }
}
