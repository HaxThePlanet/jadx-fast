package app.dogo.com.dogo_android.s.b;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;

/* compiled from: VideoRepository.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/local/VimeoCacheControlInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r1, reason: from kotlin metadata */
public final class VimeoCacheControlInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Request request_Builder;
        n.f(chain, "chain");
        if (chain.request().cacheControl().onlyIfCached()) {
            dAYS2 = TimeUnit.DAYS;
            int i = 365;
            request_Builder = chain.request().newBuilder().cacheControl(new CacheControl_Builder().onlyIfCached().maxStale(i, dAYS2).maxAge(i, dAYS2).build()).build();
        } else {
            request_Builder = chain.request();
        }
        Response proceed = chain.proceed(request_Builder);
        int i2 = 31536000;
        StringBuilder stringBuilder = new StringBuilder();
        String str4 = "public,max-stale=";
        String str5 = ",max-age=";
        str2 = str4 + i2 + str5 + i2;
        return proceed.newBuilder().headers(proceed.headers()).header("Cache-Control", str2).build();
    }
}
