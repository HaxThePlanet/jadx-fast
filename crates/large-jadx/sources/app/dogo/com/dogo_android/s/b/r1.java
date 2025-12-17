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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/local/VimeoCacheControlInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r1 implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Request request;
        CacheControl build;
        TimeUnit dAYS;
        int i;
        n.f(chain, "chain");
        if (chain.request().cacheControl().onlyIfCached()) {
            CacheControl.Builder builder3 = new CacheControl.Builder();
            dAYS = TimeUnit.DAYS;
            i = 365;
            request = chain.request().newBuilder().cacheControl(builder3.onlyIfCached().maxStale(i, dAYS).maxAge(i, dAYS).build()).build();
        } else {
            request = chain.request();
        }
        Response obj5 = chain.proceed(request);
        int i2 = 31536000;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("public,max-stale=");
        stringBuilder.append(i2);
        stringBuilder.append(",max-age=");
        stringBuilder.append(i2);
        return obj5.newBuilder().headers(obj5.headers()).header("Cache-Control", stringBuilder.toString()).build();
    }
}
