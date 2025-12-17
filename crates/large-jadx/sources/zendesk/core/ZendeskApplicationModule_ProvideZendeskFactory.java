package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideZendeskFactory implements b<zendesk.core.ZendeskShadow> {

    private final a<zendesk.core.BlipsCoreProvider> blipsCoreProvider;
    private final a<zendesk.core.CoreModule> coreModuleProvider;
    private final a<zendesk.core.IdentityManager> identityManagerProvider;
    private final a<zendesk.core.LegacyIdentityMigrator> legacyIdentityMigratorProvider;
    private final a<zendesk.core.ProviderStore> providerStoreProvider;
    private final a<zendesk.core.PushRegistrationProvider> pushRegistrationProvider;
    private final a<zendesk.core.Storage> storageProvider;
    public ZendeskApplicationModule_ProvideZendeskFactory(a<zendesk.core.Storage> a, a<zendesk.core.LegacyIdentityMigrator> a2, a<zendesk.core.IdentityManager> a3, a<zendesk.core.BlipsCoreProvider> a4, a<zendesk.core.PushRegistrationProvider> a5, a<zendesk.core.CoreModule> a6, a<zendesk.core.ProviderStore> a7) {
        super();
        this.storageProvider = a;
        this.legacyIdentityMigratorProvider = a2;
        this.identityManagerProvider = a3;
        this.blipsCoreProvider = a4;
        this.pushRegistrationProvider = a5;
        this.coreModuleProvider = a6;
        this.providerStoreProvider = a7;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideZendeskFactory create(a<zendesk.core.Storage> a, a<zendesk.core.LegacyIdentityMigrator> a2, a<zendesk.core.IdentityManager> a3, a<zendesk.core.BlipsCoreProvider> a4, a<zendesk.core.PushRegistrationProvider> a5, a<zendesk.core.CoreModule> a6, a<zendesk.core.ProviderStore> a7) {
        super(a, a2, a3, a4, a5, a6, a7);
        return zendeskApplicationModule_ProvideZendeskFactory;
    }

    public static zendesk.core.ZendeskShadow provideZendesk(Object object, Object object2, Object object3, Object object4, zendesk.core.PushRegistrationProvider pushRegistrationProvider5, zendesk.core.CoreModule coreModule6, zendesk.core.ProviderStore providerStore7) {
        final zendesk.core.ZendeskShadow obj7 = ZendeskApplicationModule.provideZendesk((Storage)object, (LegacyIdentityMigrator)object2, (IdentityManager)object3, (BlipsCoreProvider)object4, pushRegistrationProvider5, coreModule6, providerStore7);
        d.c(obj7, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskShadow)obj7;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskShadow get() {
        return ZendeskApplicationModule_ProvideZendeskFactory.provideZendesk(this.storageProvider.get(), this.legacyIdentityMigratorProvider.get(), this.identityManagerProvider.get(), this.blipsCoreProvider.get(), (PushRegistrationProvider)this.pushRegistrationProvider.get(), (CoreModule)this.coreModuleProvider.get(), (ProviderStore)this.providerStoreProvider.get());
    }
}
