package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideAccessProviderFactory implements b<zendesk.core.AccessProvider> {

    private final a<zendesk.core.AccessService> accessServiceProvider;
    private final a<zendesk.core.IdentityManager> identityManagerProvider;
    public ZendeskProvidersModule_ProvideAccessProviderFactory(a<zendesk.core.IdentityManager> a, a<zendesk.core.AccessService> a2) {
        super();
        this.identityManagerProvider = a;
        this.accessServiceProvider = a2;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideAccessProviderFactory create(a<zendesk.core.IdentityManager> a, a<zendesk.core.AccessService> a2) {
        ZendeskProvidersModule_ProvideAccessProviderFactory zendeskProvidersModule_ProvideAccessProviderFactory = new ZendeskProvidersModule_ProvideAccessProviderFactory(a, a2);
        return zendeskProvidersModule_ProvideAccessProviderFactory;
    }

    public static zendesk.core.AccessProvider provideAccessProvider(Object object, Object object2) {
        final zendesk.core.AccessProvider obj0 = ZendeskProvidersModule.provideAccessProvider((IdentityManager)object, (AccessService)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AccessProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.AccessProvider get() {
        return ZendeskProvidersModule_ProvideAccessProviderFactory.provideAccessProvider(this.identityManagerProvider.get(), this.accessServiceProvider.get());
    }
}
