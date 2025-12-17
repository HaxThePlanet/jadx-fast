package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideSdkStorageFactory implements b<zendesk.core.Storage> {

    private final a<zendesk.core.MemoryCache> memoryCacheProvider;
    private final a<zendesk.core.BaseStorage> sdkBaseStorageProvider;
    private final a<zendesk.core.SessionStorage> sessionStorageProvider;
    private final a<zendesk.core.SettingsStorage> settingsStorageProvider;
    public ZendeskStorageModule_ProvideSdkStorageFactory(a<zendesk.core.SettingsStorage> a, a<zendesk.core.SessionStorage> a2, a<zendesk.core.BaseStorage> a3, a<zendesk.core.MemoryCache> a4) {
        super();
        this.settingsStorageProvider = a;
        this.sessionStorageProvider = a2;
        this.sdkBaseStorageProvider = a3;
        this.memoryCacheProvider = a4;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideSdkStorageFactory create(a<zendesk.core.SettingsStorage> a, a<zendesk.core.SessionStorage> a2, a<zendesk.core.BaseStorage> a3, a<zendesk.core.MemoryCache> a4) {
        ZendeskStorageModule_ProvideSdkStorageFactory zendeskStorageModule_ProvideSdkStorageFactory = new ZendeskStorageModule_ProvideSdkStorageFactory(a, a2, a3, a4);
        return zendeskStorageModule_ProvideSdkStorageFactory;
    }

    public static zendesk.core.Storage provideSdkStorage(Object object, zendesk.core.SessionStorage sessionStorage2, zendesk.core.BaseStorage baseStorage3, zendesk.core.MemoryCache memoryCache4) {
        final zendesk.core.Storage obj0 = ZendeskStorageModule.provideSdkStorage((SettingsStorage)object, sessionStorage2, baseStorage3, memoryCache4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (Storage)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.Storage get() {
        return ZendeskStorageModule_ProvideSdkStorageFactory.provideSdkStorage(this.settingsStorageProvider.get(), (SessionStorage)this.sessionStorageProvider.get(), (BaseStorage)this.sdkBaseStorageProvider.get(), (MemoryCache)this.memoryCacheProvider.get());
    }
}
