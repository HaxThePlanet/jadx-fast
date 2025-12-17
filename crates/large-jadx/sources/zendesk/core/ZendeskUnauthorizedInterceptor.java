package zendesk.core;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

/* loaded from: classes3.dex */
class ZendeskUnauthorizedInterceptor implements Interceptor {

    private final zendesk.core.SessionStorage sessionStorage;
    ZendeskUnauthorizedInterceptor(zendesk.core.SessionStorage sessionStorage) {
        super();
        this.sessionStorage = sessionStorage;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        boolean successful;
        int code;
        final Response obj3 = chain.proceed(chain.request());
        if (!obj3.isSuccessful() && 401 == obj3.code()) {
            if (401 == obj3.code()) {
                onHttpUnauthorized();
            }
        }
        return obj3;
    }

    @Override // okhttp3.Interceptor
    void onHttpUnauthorized() {
        this.sessionStorage.clear();
    }
}
