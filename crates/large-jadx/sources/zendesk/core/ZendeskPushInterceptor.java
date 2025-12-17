package zendesk.core;

import f.g.c.a;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

/* loaded from: classes3.dex */
class ZendeskPushInterceptor implements Interceptor {

    private static final String LOG_TAG = "ZendeskPushInterceptor";
    private final zendesk.core.IdentityStorage identityStorage;
    private final zendesk.core.PushDeviceIdStorage pushDeviceIdStorage;
    private final zendesk.core.PushRegistrationProviderInternal pushProvider;
    ZendeskPushInterceptor(zendesk.core.PushRegistrationProviderInternal pushRegistrationProviderInternal, zendesk.core.PushDeviceIdStorage pushDeviceIdStorage2, zendesk.core.IdentityStorage identityStorage3) {
        super();
        this.pushProvider = pushRegistrationProviderInternal;
        this.pushDeviceIdStorage = pushDeviceIdStorage2;
        this.identityStorage = identityStorage3;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Object storedAccessToken;
        String str;
        String str2;
        zendesk.core.PushRegistrationRequest pushRegistrationRequest = this.pushDeviceIdStorage.getPushRegistrationRequest();
        if (pushRegistrationRequest != null && this.identityStorage.getStoredAccessToken() != null) {
            if (this.identityStorage.getStoredAccessToken() != null) {
                a.b("ZendeskPushInterceptor", "Sending stored push registration request", new Object[0]);
                this.pushProvider.sendPushRegistrationRequest(pushRegistrationRequest);
            }
        }
        return chain.proceed(chain.request());
    }
}
