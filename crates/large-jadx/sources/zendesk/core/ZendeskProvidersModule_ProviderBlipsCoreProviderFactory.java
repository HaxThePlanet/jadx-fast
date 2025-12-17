package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProviderBlipsCoreProviderFactory implements b<zendesk.core.BlipsCoreProvider> {

    private final a<zendesk.core.ZendeskBlipsProvider> zendeskBlipsProvider;
    public ZendeskProvidersModule_ProviderBlipsCoreProviderFactory(a<zendesk.core.ZendeskBlipsProvider> a) {
        super();
        this.zendeskBlipsProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProviderBlipsCoreProviderFactory create(a<zendesk.core.ZendeskBlipsProvider> a) {
        ZendeskProvidersModule_ProviderBlipsCoreProviderFactory zendeskProvidersModule_ProviderBlipsCoreProviderFactory = new ZendeskProvidersModule_ProviderBlipsCoreProviderFactory(a);
        return zendeskProvidersModule_ProviderBlipsCoreProviderFactory;
    }

    public static zendesk.core.BlipsCoreProvider providerBlipsCoreProvider(Object object) {
        final zendesk.core.BlipsCoreProvider obj1 = ZendeskProvidersModule.providerBlipsCoreProvider((ZendeskBlipsProvider)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (BlipsCoreProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.BlipsCoreProvider get() {
        return ZendeskProvidersModule_ProviderBlipsCoreProviderFactory.providerBlipsCoreProvider(this.zendeskBlipsProvider.get());
    }
}
