package zendesk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProviderConnectivityManagerFactory implements b<ConnectivityManager> {

    private final a<Context> contextProvider;
    public ZendeskProvidersModule_ProviderConnectivityManagerFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProviderConnectivityManagerFactory create(a<Context> a) {
        ZendeskProvidersModule_ProviderConnectivityManagerFactory zendeskProvidersModule_ProviderConnectivityManagerFactory = new ZendeskProvidersModule_ProviderConnectivityManagerFactory(a);
        return zendeskProvidersModule_ProviderConnectivityManagerFactory;
    }

    public static ConnectivityManager providerConnectivityManager(Context context) {
        final ConnectivityManager obj1 = ZendeskProvidersModule.providerConnectivityManager(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ConnectivityManager)obj1;
    }

    @Override // g.b.b
    public ConnectivityManager get() {
        return ZendeskProvidersModule_ProviderConnectivityManagerFactory.providerConnectivityManager((Context)this.contextProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
