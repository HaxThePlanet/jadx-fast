package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideIdentityManagerFactory implements b<zendesk.core.IdentityManager> {

    private final a<zendesk.core.IdentityStorage> identityStorageProvider;
    public ZendeskStorageModule_ProvideIdentityManagerFactory(a<zendesk.core.IdentityStorage> a) {
        super();
        this.identityStorageProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideIdentityManagerFactory create(a<zendesk.core.IdentityStorage> a) {
        ZendeskStorageModule_ProvideIdentityManagerFactory zendeskStorageModule_ProvideIdentityManagerFactory = new ZendeskStorageModule_ProvideIdentityManagerFactory(a);
        return zendeskStorageModule_ProvideIdentityManagerFactory;
    }

    public static zendesk.core.IdentityManager provideIdentityManager(Object object) {
        final zendesk.core.IdentityManager obj1 = ZendeskStorageModule.provideIdentityManager((IdentityStorage)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (IdentityManager)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.IdentityManager get() {
        return ZendeskStorageModule_ProvideIdentityManagerFactory.provideIdentityManager(this.identityStorageProvider.get());
    }
}
