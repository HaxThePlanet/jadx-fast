package zendesk.core;

import android.os.Build.VERSION;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/* loaded from: classes3.dex */
class UserAgentAndClientHeadersInterceptor implements Interceptor {

    private final String userAgent;
    private final String version;
    private final String zendeskClient;
    public UserAgentAndClientHeadersInterceptor(String string, String string2) {
        super();
        final Locale uS = Locale.US;
        Object[] arr = new Object[3];
        final int i2 = 0;
        arr[i2] = string;
        final int i4 = 1;
        arr[i4] = Integer.valueOf(Build.VERSION.SDK_INT);
        arr[2] = string2;
        this.userAgent = String.format(uS, "Zendesk-SDK/%s Android/%d Variant/%s", arr);
        Object[] arr2 = new Object[i4];
        arr2[i2] = string2.toLowerCase();
        this.zendeskClient = String.format(uS, "mobile/android/sdk/%s", arr2);
        this.version = string;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Request.Builder builder = chain.request().newBuilder();
        String str = "User-Agent";
        builder.removeHeader(str);
        builder.addHeader(str, this.userAgent);
        String str2 = "X-Zendesk-Client";
        builder.removeHeader(str2);
        builder.addHeader(str2, this.zendeskClient);
        String str3 = "X-Zendesk-Client-Version";
        builder.removeHeader(str3);
        builder.addHeader(str3, this.version);
        return chain.proceed(builder.build());
    }
}
