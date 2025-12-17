package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetMemoryCacheFactory implements b<zendesk.core.MemoryCache> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetMemoryCacheFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetMemoryCacheFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetMemoryCacheFactory coreModule_GetMemoryCacheFactory = new CoreModule_GetMemoryCacheFactory(coreModule);
        return coreModule_GetMemoryCacheFactory;
    }

    public static zendesk.core.MemoryCache getMemoryCache(zendesk.core.CoreModule coreModule) {
        final zendesk.core.MemoryCache obj1 = coreModule.getMemoryCache();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (MemoryCache)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.MemoryCache get() {
        return CoreModule_GetMemoryCacheFactory.getMemoryCache(this.module);
    }
}
