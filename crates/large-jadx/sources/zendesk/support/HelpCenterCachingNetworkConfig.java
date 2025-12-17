package zendesk.support;

import okhttp3.OkHttpClient.Builder;
import zendesk.core.CustomNetworkConfig;

/* loaded from: classes3.dex */
class HelpCenterCachingNetworkConfig extends CustomNetworkConfig {

    private zendesk.support.HelpCenterCachingInterceptor interceptor;
    HelpCenterCachingNetworkConfig(zendesk.support.HelpCenterCachingInterceptor helpCenterCachingInterceptor) {
        super();
        this.interceptor = helpCenterCachingInterceptor;
    }

    @Override // zendesk.core.CustomNetworkConfig
    public void configureOkHttpClient(OkHttpClient.Builder okHttpClient$Builder) {
        builder.addNetworkInterceptor(this.interceptor);
    }
}
