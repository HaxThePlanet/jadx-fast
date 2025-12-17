package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideUserProviderFactory implements b<zendesk.core.UserProvider> {

    private final a<zendesk.core.UserService> userServiceProvider;
    public ZendeskProvidersModule_ProvideUserProviderFactory(a<zendesk.core.UserService> a) {
        super();
        this.userServiceProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideUserProviderFactory create(a<zendesk.core.UserService> a) {
        ZendeskProvidersModule_ProvideUserProviderFactory zendeskProvidersModule_ProvideUserProviderFactory = new ZendeskProvidersModule_ProvideUserProviderFactory(a);
        return zendeskProvidersModule_ProvideUserProviderFactory;
    }

    public static zendesk.core.UserProvider provideUserProvider(Object object) {
        final zendesk.core.UserProvider obj1 = ZendeskProvidersModule.provideUserProvider((UserService)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (UserProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.UserProvider get() {
        return ZendeskProvidersModule_ProvideUserProviderFactory.provideUserProvider(this.userServiceProvider.get());
    }
}
