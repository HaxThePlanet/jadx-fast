package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class StorageModule_ProvideRequestSessionCacheFactory implements b<zendesk.support.RequestSessionCache> {

    private final zendesk.support.StorageModule module;
    public StorageModule_ProvideRequestSessionCacheFactory(zendesk.support.StorageModule storageModule) {
        super();
        this.module = storageModule;
    }

    public static zendesk.support.StorageModule_ProvideRequestSessionCacheFactory create(zendesk.support.StorageModule storageModule) {
        StorageModule_ProvideRequestSessionCacheFactory storageModule_ProvideRequestSessionCacheFactory = new StorageModule_ProvideRequestSessionCacheFactory(storageModule);
        return storageModule_ProvideRequestSessionCacheFactory;
    }

    public static zendesk.support.RequestSessionCache provideRequestSessionCache(zendesk.support.StorageModule storageModule) {
        final zendesk.support.RequestSessionCache obj1 = storageModule.provideRequestSessionCache();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestSessionCache)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.RequestSessionCache get() {
        return StorageModule_ProvideRequestSessionCacheFactory.provideRequestSessionCache(this.module);
    }
}
