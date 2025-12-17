package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideMemoryCacheFactory implements b<zendesk.core.MemoryCache> {

    private static final zendesk.core.ZendeskStorageModule_ProvideMemoryCacheFactory INSTANCE;
    static {
        ZendeskStorageModule_ProvideMemoryCacheFactory zendeskStorageModule_ProvideMemoryCacheFactory = new ZendeskStorageModule_ProvideMemoryCacheFactory();
        ZendeskStorageModule_ProvideMemoryCacheFactory.INSTANCE = zendeskStorageModule_ProvideMemoryCacheFactory;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideMemoryCacheFactory create() {
        return ZendeskStorageModule_ProvideMemoryCacheFactory.INSTANCE;
    }

    public static zendesk.core.MemoryCache provideMemoryCache() {
        final zendesk.core.MemoryCache provideMemoryCache = ZendeskStorageModule.provideMemoryCache();
        d.c(provideMemoryCache, "Cannot return null from a non-@Nullable @Provides method");
        return (MemoryCache)provideMemoryCache;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.MemoryCache get() {
        return ZendeskStorageModule_ProvideMemoryCacheFactory.provideMemoryCache();
    }
}
