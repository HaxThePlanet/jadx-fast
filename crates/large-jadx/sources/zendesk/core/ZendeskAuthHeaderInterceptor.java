package zendesk.core;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/* loaded from: classes3.dex */
class ZendeskAuthHeaderInterceptor implements Interceptor {

    private zendesk.core.IdentityManager identityManager;
    ZendeskAuthHeaderInterceptor(zendesk.core.IdentityManager identityManager) {
        super();
        this.identityManager = identityManager;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        String str;
        Request.Builder builder = chain.request().newBuilder();
        String storedAccessTokenAsBearerToken = this.identityManager.getStoredAccessTokenAsBearerToken();
        if (storedAccessTokenAsBearerToken != null) {
            builder.addHeader("Authorization", storedAccessTokenAsBearerToken);
        }
        return chain.proceed(builder.build());
    }
}
