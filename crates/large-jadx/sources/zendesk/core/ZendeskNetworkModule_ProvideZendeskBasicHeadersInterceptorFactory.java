package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory implements b<zendesk.core.ZendeskOauthIdHeaderInterceptor> {

    private final a<zendesk.core.ApplicationConfiguration> configurationProvider;
    private final zendesk.core.ZendeskNetworkModule module;
    public ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<zendesk.core.ApplicationConfiguration> a2) {
        super();
        this.module = zendeskNetworkModule;
        this.configurationProvider = a2;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory create(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, a<zendesk.core.ApplicationConfiguration> a2) {
        ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory zendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory = new ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory(zendeskNetworkModule, a2);
        return zendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory;
    }

    public static zendesk.core.ZendeskOauthIdHeaderInterceptor provideZendeskBasicHeadersInterceptor(zendesk.core.ZendeskNetworkModule zendeskNetworkModule, zendesk.core.ApplicationConfiguration applicationConfiguration2) {
        final zendesk.core.ZendeskOauthIdHeaderInterceptor obj0 = zendeskNetworkModule.provideZendeskBasicHeadersInterceptor(applicationConfiguration2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskOauthIdHeaderInterceptor)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskOauthIdHeaderInterceptor get() {
        return ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory.provideZendeskBasicHeadersInterceptor(this.module, (ApplicationConfiguration)this.configurationProvider.get());
    }
}
