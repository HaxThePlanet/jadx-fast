package zendesk.core;

import android.content.Context;
import f.g.e.d;
import f.g.e.g;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/* loaded from: classes3.dex */
class AcceptLanguageHeaderInterceptor implements Interceptor {

    private Context context;
    public AcceptLanguageHeaderInterceptor(Context context) {
        super();
        this.context = context;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Request request = chain.request();
        java.util.Locale currentLocale = DeviceInfo.getCurrentLocale(this.context);
        final String str2 = "Accept-Language";
        if (g.e(request.header(str2)) && currentLocale != null) {
            if (currentLocale != null) {
                return chain.proceed(request.newBuilder().addHeader(str2, d.d(currentLocale)).build());
            }
        }
        return chain.proceed(request);
    }
}
