package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideCoreSettingsStorageFactory implements b<zendesk.core.CoreSettingsStorage> {

    private final a<zendesk.core.SettingsStorage> settingsStorageProvider;
    public ZendeskStorageModule_ProvideCoreSettingsStorageFactory(a<zendesk.core.SettingsStorage> a) {
        super();
        this.settingsStorageProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideCoreSettingsStorageFactory create(a<zendesk.core.SettingsStorage> a) {
        ZendeskStorageModule_ProvideCoreSettingsStorageFactory zendeskStorageModule_ProvideCoreSettingsStorageFactory = new ZendeskStorageModule_ProvideCoreSettingsStorageFactory(a);
        return zendeskStorageModule_ProvideCoreSettingsStorageFactory;
    }

    public static zendesk.core.CoreSettingsStorage provideCoreSettingsStorage(Object object) {
        final zendesk.core.CoreSettingsStorage obj1 = ZendeskStorageModule.provideCoreSettingsStorage((SettingsStorage)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (CoreSettingsStorage)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.CoreSettingsStorage get() {
        return ZendeskStorageModule_ProvideCoreSettingsStorageFactory.provideCoreSettingsStorage(this.settingsStorageProvider.get());
    }
}
