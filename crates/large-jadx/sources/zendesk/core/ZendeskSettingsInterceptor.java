package zendesk.core;

import f.g.c.a;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;

/* loaded from: classes3.dex */
class ZendeskSettingsInterceptor implements Interceptor {

    private static final String LOG_TAG = "SettingsInterceptor";
    private final zendesk.core.SdkSettingsProviderInternal provider;
    private zendesk.core.SettingsStorage settingsStorage;
    ZendeskSettingsInterceptor(zendesk.core.SdkSettingsProviderInternal sdkSettingsProviderInternal, zendesk.core.SettingsStorage settingsStorage2) {
        super();
        this.provider = sdkSettingsProviderInternal;
        this.settingsStorage = settingsStorage2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        boolean settingsUpToDate;
        Object str;
        int i2 = 0;
        String str4 = "SettingsInterceptor";
        a.b(str4, "Requesting SDK settings.", new Object[i2]);
        if (this.settingsStorage.areSettingsUpToDate(1, obj3) == null && this.provider.getCoreSettings() == null) {
            a.b(str4, "Requesting SDK settings.", new Object[i2]);
            if (this.provider.getCoreSettings() == null) {
                a.b(str4, "Retrieved settings are null. Returning 404.", new Object[i2]);
                Response.Builder builder = new Response.Builder();
                return builder.protocol(Protocol.HTTP_2).request(chain.request()).message(chain.request().method()).code(404).build();
            }
        }
        a.b(str4, "Proceeding with chain.", new Object[i2]);
        return chain.proceed(chain.request());
    }
}
