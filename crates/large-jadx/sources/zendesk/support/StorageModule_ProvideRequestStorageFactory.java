package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.MemoryCache;
import zendesk.core.SessionStorage;

/* loaded from: classes3.dex */
public final class StorageModule_ProvideRequestStorageFactory implements b<zendesk.support.RequestStorage> {

    private final a<SessionStorage> baseStorageProvider;
    private final a<MemoryCache> memoryCacheProvider;
    private final zendesk.support.StorageModule module;
    private final a<zendesk.support.RequestMigrator> requestMigratorProvider;
    public StorageModule_ProvideRequestStorageFactory(zendesk.support.StorageModule storageModule, a<SessionStorage> a2, a<zendesk.support.RequestMigrator> a3, a<MemoryCache> a4) {
        super();
        this.module = storageModule;
        this.baseStorageProvider = a2;
        this.requestMigratorProvider = a3;
        this.memoryCacheProvider = a4;
    }

    public static zendesk.support.StorageModule_ProvideRequestStorageFactory create(zendesk.support.StorageModule storageModule, a<SessionStorage> a2, a<zendesk.support.RequestMigrator> a3, a<MemoryCache> a4) {
        StorageModule_ProvideRequestStorageFactory storageModule_ProvideRequestStorageFactory = new StorageModule_ProvideRequestStorageFactory(storageModule, a2, a3, a4);
        return storageModule_ProvideRequestStorageFactory;
    }

    public static zendesk.support.RequestStorage provideRequestStorage(zendesk.support.StorageModule storageModule, SessionStorage sessionStorage2, Object object3, MemoryCache memoryCache4) {
        final zendesk.support.RequestStorage obj0 = storageModule.provideRequestStorage(sessionStorage2, (RequestMigrator)object3, memoryCache4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestStorage)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.RequestStorage get() {
        return StorageModule_ProvideRequestStorageFactory.provideRequestStorage(this.module, (SessionStorage)this.baseStorageProvider.get(), this.requestMigratorProvider.get(), (MemoryCache)this.memoryCacheProvider.get());
    }
}
