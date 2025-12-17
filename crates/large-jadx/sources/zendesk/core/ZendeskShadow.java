package zendesk.core;

import f.g.c.a;
import f.g.e.g;

/* loaded from: classes3.dex */
final class ZendeskShadow {

    private static final String LOG_TAG = "ZendeskShadow";
    private final zendesk.core.BlipsCoreProvider blipsCoreProvider;
    private final zendesk.core.CoreModule coreModule;
    private final zendesk.core.IdentityManager identityManager;
    private final zendesk.core.LegacyIdentityMigrator legacyIdentityMigrator;
    private final zendesk.core.ProviderStore providerStore;
    private final zendesk.core.PushRegistrationProvider pushRegistrationProvider;
    private final zendesk.core.Storage storage;
    ZendeskShadow(zendesk.core.Storage storage, zendesk.core.LegacyIdentityMigrator legacyIdentityMigrator2, zendesk.core.IdentityManager identityManager3, zendesk.core.BlipsCoreProvider blipsCoreProvider4, zendesk.core.PushRegistrationProvider pushRegistrationProvider5, zendesk.core.CoreModule coreModule6, zendesk.core.ProviderStore providerStore7) {
        super();
        this.storage = storage;
        this.legacyIdentityMigrator = legacyIdentityMigrator2;
        this.identityManager = identityManager3;
        this.blipsCoreProvider = blipsCoreProvider4;
        this.pushRegistrationProvider = pushRegistrationProvider5;
        this.coreModule = coreModule6;
        this.providerStore = providerStore7;
    }

    private static boolean checkIdentityValid(zendesk.core.Identity identity) {
        boolean z;
        Object obj4;
        final String str = "ZendeskShadow";
        final int i = 0;
        final String str2 = "setIdentity(): The provided Identity object must be an Anonymous Identity or a JwtIdentity with a non-empty JWT identifier. Returning.";
        if (identity == null) {
            a.k(str, str2, new Object[i]);
            return i;
        }
        if (!identity instanceof AnonymousIdentity && !identity instanceof JwtIdentity) {
            if (!identity instanceof JwtIdentity) {
                a.k(str, str2, new Object[i]);
                return i;
            }
        }
        if (identity instanceof JwtIdentity && g.e((JwtIdentity)identity.getJwtUserIdentifier())) {
            if (g.e((JwtIdentity)identity.getJwtUserIdentifier())) {
                a.k(str, str2, new Object[i]);
                return i;
            }
        }
        return 1;
    }

    void cleanupIfNewConfig(zendesk.core.ApplicationConfiguration applicationConfiguration) {
        zendesk.core.Storage storage;
        boolean obj2;
        if (this.storage.hasSdkConfigChanged(applicationConfiguration) != null) {
            this.pushRegistrationProvider.unregisterDevice(0);
        }
    }

    public zendesk.core.CoreModule coreModule() {
        return this.coreModule;
    }

    public zendesk.core.Identity getIdentity() {
        return this.identityManager.getIdentity();
    }

    void init(zendesk.core.ApplicationConfiguration applicationConfiguration, boolean z2) {
        String sdkConfigChanged;
        zendesk.core.Storage obj5;
        final int i = 0;
        final String str = "ZendeskShadow";
        if (this.storage.hasSdkConfigChanged(applicationConfiguration) != null) {
            a.b(str, "SDK app config details have changed, cleaning up old config storage.", new Object[i]);
            this.storage.clear();
            this.storage.storeSdkHash(applicationConfiguration);
        } else {
            if (z2 != null) {
                a.g(str, "Zendesk is already initialized with these details, skipping.", new Object[i]);
            }
        }
        this.blipsCoreProvider.coreInitialized();
    }

    public zendesk.core.ProviderStore providers() {
        return this.providerStore;
    }

    void reset() {
        this.pushRegistrationProvider.unregisterDevice(0);
        this.storage.getSessionStorage().clear();
        this.storage.clear();
    }

    public void setIdentity(zendesk.core.Identity identity) {
        Object identityManager;
        int str;
        zendesk.core.Identity obj3;
        if (!ZendeskShadow.checkIdentityValid(identity)) {
        }
        this.legacyIdentityMigrator.checkAndMigrateIdentity();
        if (this.identityManager.identityIsDifferent(identity)) {
            this.pushRegistrationProvider.unregisterDevice(0);
            this.storage.getSessionStorage().clear();
            this.identityManager.updateAndPersistIdentity(identity);
        } else {
            a.g("ZendeskShadow", "Zendesk is already initialized with this identity, skipping.", new Object[0]);
        }
    }
}
