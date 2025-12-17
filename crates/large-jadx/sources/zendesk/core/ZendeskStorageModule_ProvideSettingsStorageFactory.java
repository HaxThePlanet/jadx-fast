package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideSettingsStorageFactory implements b<zendesk.core.SettingsStorage> {

    private final a<zendesk.core.BaseStorage> baseStorageProvider;
    public ZendeskStorageModule_ProvideSettingsStorageFactory(a<zendesk.core.BaseStorage> a) {
        super();
        this.baseStorageProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideSettingsStorageFactory create(a<zendesk.core.BaseStorage> a) {
        ZendeskStorageModule_ProvideSettingsStorageFactory zendeskStorageModule_ProvideSettingsStorageFactory = new ZendeskStorageModule_ProvideSettingsStorageFactory(a);
        return zendeskStorageModule_ProvideSettingsStorageFactory;
    }

    public static zendesk.core.SettingsStorage provideSettingsStorage(zendesk.core.BaseStorage baseStorage) {
        final zendesk.core.SettingsStorage obj1 = ZendeskStorageModule.provideSettingsStorage(baseStorage);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (SettingsStorage)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SettingsStorage get() {
        return ZendeskStorageModule_ProvideSettingsStorageFactory.provideSettingsStorage((BaseStorage)this.baseStorageProvider.get());
    }
}
