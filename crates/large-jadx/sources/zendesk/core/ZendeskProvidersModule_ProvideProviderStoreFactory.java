package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideProviderStoreFactory implements b<zendesk.core.ProviderStore> {

    private final a<zendesk.core.PushRegistrationProvider> pushRegistrationProvider;
    private final a<zendesk.core.UserProvider> userProvider;
    public ZendeskProvidersModule_ProvideProviderStoreFactory(a<zendesk.core.UserProvider> a, a<zendesk.core.PushRegistrationProvider> a2) {
        super();
        this.userProvider = a;
        this.pushRegistrationProvider = a2;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideProviderStoreFactory create(a<zendesk.core.UserProvider> a, a<zendesk.core.PushRegistrationProvider> a2) {
        ZendeskProvidersModule_ProvideProviderStoreFactory zendeskProvidersModule_ProvideProviderStoreFactory = new ZendeskProvidersModule_ProvideProviderStoreFactory(a, a2);
        return zendeskProvidersModule_ProvideProviderStoreFactory;
    }

    public static zendesk.core.ProviderStore provideProviderStore(zendesk.core.UserProvider userProvider, zendesk.core.PushRegistrationProvider pushRegistrationProvider2) {
        final zendesk.core.ProviderStore obj0 = ZendeskProvidersModule.provideProviderStore(userProvider, pushRegistrationProvider2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ProviderStore)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ProviderStore get() {
        return ZendeskProvidersModule_ProvideProviderStoreFactory.provideProviderStore((UserProvider)this.userProvider.get(), (PushRegistrationProvider)this.pushRegistrationProvider.get());
    }
}
