package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideLegacyIdentityStorageFactory implements b<zendesk.core.LegacyIdentityMigrator> {

    private final a<zendesk.core.IdentityManager> identityManagerProvider;
    private final a<zendesk.core.IdentityStorage> identityStorageProvider;
    private final a<zendesk.core.SharedPreferencesStorage> legacyIdentityBaseStorageProvider;
    private final a<zendesk.core.SharedPreferencesStorage> legacyPushBaseStorageProvider;
    private final a<zendesk.core.PushDeviceIdStorage> pushDeviceIdStorageProvider;
    public ZendeskStorageModule_ProvideLegacyIdentityStorageFactory(a<zendesk.core.SharedPreferencesStorage> a, a<zendesk.core.SharedPreferencesStorage> a2, a<zendesk.core.IdentityStorage> a3, a<zendesk.core.IdentityManager> a4, a<zendesk.core.PushDeviceIdStorage> a5) {
        super();
        this.legacyIdentityBaseStorageProvider = a;
        this.legacyPushBaseStorageProvider = a2;
        this.identityStorageProvider = a3;
        this.identityManagerProvider = a4;
        this.pushDeviceIdStorageProvider = a5;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideLegacyIdentityStorageFactory create(a<zendesk.core.SharedPreferencesStorage> a, a<zendesk.core.SharedPreferencesStorage> a2, a<zendesk.core.IdentityStorage> a3, a<zendesk.core.IdentityManager> a4, a<zendesk.core.PushDeviceIdStorage> a5) {
        super(a, a2, a3, a4, a5);
        return zendeskStorageModule_ProvideLegacyIdentityStorageFactory;
    }

    public static zendesk.core.LegacyIdentityMigrator provideLegacyIdentityStorage(Object object, Object object2, Object object3, Object object4, Object object5) {
        final zendesk.core.LegacyIdentityMigrator obj0 = ZendeskStorageModule.provideLegacyIdentityStorage((SharedPreferencesStorage)object, (SharedPreferencesStorage)object2, (IdentityStorage)object3, (IdentityManager)object4, (PushDeviceIdStorage)object5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (LegacyIdentityMigrator)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.LegacyIdentityMigrator get() {
        return ZendeskStorageModule_ProvideLegacyIdentityStorageFactory.provideLegacyIdentityStorage(this.legacyIdentityBaseStorageProvider.get(), this.legacyPushBaseStorageProvider.get(), this.identityStorageProvider.get(), this.identityManagerProvider.get(), this.pushDeviceIdStorageProvider.get());
    }
}
