package zendesk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProviderNetworkInfoProviderFactory implements b<zendesk.core.NetworkInfoProvider> {

    private final a<ConnectivityManager> connectivityManagerProvider;
    private final a<Context> contextProvider;
    public ZendeskProvidersModule_ProviderNetworkInfoProviderFactory(a<Context> a, a<ConnectivityManager> a2) {
        super();
        this.contextProvider = a;
        this.connectivityManagerProvider = a2;
    }

    public static zendesk.core.ZendeskProvidersModule_ProviderNetworkInfoProviderFactory create(a<Context> a, a<ConnectivityManager> a2) {
        ZendeskProvidersModule_ProviderNetworkInfoProviderFactory zendeskProvidersModule_ProviderNetworkInfoProviderFactory = new ZendeskProvidersModule_ProviderNetworkInfoProviderFactory(a, a2);
        return zendeskProvidersModule_ProviderNetworkInfoProviderFactory;
    }

    public static zendesk.core.NetworkInfoProvider providerNetworkInfoProvider(Context context, ConnectivityManager connectivityManager2) {
        final zendesk.core.NetworkInfoProvider obj0 = ZendeskProvidersModule.providerNetworkInfoProvider(context, connectivityManager2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (NetworkInfoProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.NetworkInfoProvider get() {
        return ZendeskProvidersModule_ProviderNetworkInfoProviderFactory.providerNetworkInfoProvider((Context)this.contextProvider.get(), (ConnectivityManager)this.connectivityManagerProvider.get());
    }
}
