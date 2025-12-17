package zendesk.core;

import f.g.e.g;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/* loaded from: classes3.dex */
class ZendeskOauthIdHeaderInterceptor implements Interceptor {

    private final String oauthId;
    public ZendeskOauthIdHeaderInterceptor(String string) {
        super();
        this.oauthId = string;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        boolean oauthId;
        String str;
        Request.Builder builder = chain.request().newBuilder();
        if (g.c(this.oauthId)) {
            builder.addHeader("Client-Identifier", this.oauthId);
        }
        return chain.proceed(builder.build());
    }
}
