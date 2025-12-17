package zendesk.support;

import f.g.e.g;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;
import okhttp3.Response.Builder;

/* loaded from: classes3.dex */
class HelpCenterCachingInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        boolean builder;
        String str;
        Response obj3;
        obj3 = chain.proceed(chain.request());
        str = "X-ZD-Cache-Control";
        if (g.c(obj3.headers().get(str))) {
            obj3 = obj3.newBuilder().header("Cache-Control", obj3.header(str)).build();
        }
        return obj3;
    }
}
