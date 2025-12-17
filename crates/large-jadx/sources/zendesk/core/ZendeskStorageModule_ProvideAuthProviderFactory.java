package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideAuthProviderFactory implements b<zendesk.core.AuthenticationProvider> {

    private final a<zendesk.core.IdentityManager> identityManagerProvider;
    public ZendeskStorageModule_ProvideAuthProviderFactory(a<zendesk.core.IdentityManager> a) {
        super();
        this.identityManagerProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideAuthProviderFactory create(a<zendesk.core.IdentityManager> a) {
        ZendeskStorageModule_ProvideAuthProviderFactory zendeskStorageModule_ProvideAuthProviderFactory = new ZendeskStorageModule_ProvideAuthProviderFactory(a);
        return zendeskStorageModule_ProvideAuthProviderFactory;
    }

    public static zendesk.core.AuthenticationProvider provideAuthProvider(Object object) {
        final zendesk.core.AuthenticationProvider obj1 = ZendeskStorageModule.provideAuthProvider((IdentityManager)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (AuthenticationProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.AuthenticationProvider get() {
        return ZendeskStorageModule_ProvideAuthProviderFactory.provideAuthProvider(this.identityManagerProvider.get());
    }
}
