package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProviderBlipsProviderFactory implements b<zendesk.core.BlipsProvider> {

    private final a<zendesk.core.ZendeskBlipsProvider> zendeskBlipsProvider;
    public ZendeskProvidersModule_ProviderBlipsProviderFactory(a<zendesk.core.ZendeskBlipsProvider> a) {
        super();
        this.zendeskBlipsProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProviderBlipsProviderFactory create(a<zendesk.core.ZendeskBlipsProvider> a) {
        ZendeskProvidersModule_ProviderBlipsProviderFactory zendeskProvidersModule_ProviderBlipsProviderFactory = new ZendeskProvidersModule_ProviderBlipsProviderFactory(a);
        return zendeskProvidersModule_ProviderBlipsProviderFactory;
    }

    public static zendesk.core.BlipsProvider providerBlipsProvider(Object object) {
        final zendesk.core.BlipsProvider obj1 = ZendeskProvidersModule.providerBlipsProvider((ZendeskBlipsProvider)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (BlipsProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.BlipsProvider get() {
        return ZendeskProvidersModule_ProviderBlipsProviderFactory.providerBlipsProvider(this.zendeskBlipsProvider.get());
    }
}
