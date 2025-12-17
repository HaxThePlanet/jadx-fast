package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideIdentityStorageFactory implements b<zendesk.core.IdentityStorage> {

    private final a<zendesk.core.BaseStorage> baseStorageProvider;
    public ZendeskStorageModule_ProvideIdentityStorageFactory(a<zendesk.core.BaseStorage> a) {
        super();
        this.baseStorageProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideIdentityStorageFactory create(a<zendesk.core.BaseStorage> a) {
        ZendeskStorageModule_ProvideIdentityStorageFactory zendeskStorageModule_ProvideIdentityStorageFactory = new ZendeskStorageModule_ProvideIdentityStorageFactory(a);
        return zendeskStorageModule_ProvideIdentityStorageFactory;
    }

    public static zendesk.core.IdentityStorage provideIdentityStorage(zendesk.core.BaseStorage baseStorage) {
        final zendesk.core.IdentityStorage obj1 = ZendeskStorageModule.provideIdentityStorage(baseStorage);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (IdentityStorage)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.IdentityStorage get() {
        return ZendeskStorageModule_ProvideIdentityStorageFactory.provideIdentityStorage((BaseStorage)this.baseStorageProvider.get());
    }
}
