package zendesk.core;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/* loaded from: classes3.dex */
class AcceptHeaderInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        return chain.proceed(chain.request().newBuilder().addHeader("Accept", "application/json").build());
    }
}
