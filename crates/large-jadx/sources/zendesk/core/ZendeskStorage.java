package zendesk.core;

import f.g.e.b;
import java.util.Locale;

/* loaded from: classes3.dex */
class ZendeskStorage implements zendesk.core.Storage {

    private static final String SDK_HASH_FORMAT = "%s_%s_%s";
    private static final String SDK_HASH_KEY = "sdk_hash";
    private final zendesk.core.MemoryCache memoryCache;
    private final zendesk.core.BaseStorage sdkDetailsStorage;
    private final zendesk.core.SessionStorage sessionStorage;
    private final zendesk.core.SettingsStorage settingsStorage;
    ZendeskStorage(zendesk.core.SessionStorage sessionStorage, zendesk.core.SettingsStorage settingsStorage2, zendesk.core.BaseStorage baseStorage3, zendesk.core.MemoryCache memoryCache4) {
        super();
        this.sessionStorage = sessionStorage;
        this.settingsStorage = settingsStorage2;
        this.sdkDetailsStorage = baseStorage3;
        this.memoryCache = memoryCache4;
    }

    private String generateSdkHash(zendesk.core.ApplicationConfiguration applicationConfiguration) {
        final Locale uS = Locale.US;
        Object[] arr = new Object[3];
        return b.c(String.format(uS, "%s_%s_%s", applicationConfiguration.getZendeskUrl().toLowerCase(uS), applicationConfiguration.getApplicationId().toLowerCase(uS), applicationConfiguration.getOauthClientId().toLowerCase(uS)));
    }

    @Override // zendesk.core.Storage
    public void clear() {
        this.sessionStorage.clear();
        this.settingsStorage.clear();
        this.memoryCache.clear();
    }

    @Override // zendesk.core.Storage
    public zendesk.core.SessionStorage getSessionStorage() {
        return this.sessionStorage;
    }

    @Override // zendesk.core.Storage
    public boolean hasSdkConfigChanged(zendesk.core.ApplicationConfiguration applicationConfiguration) {
        return obj3 ^= 1;
    }

    @Override // zendesk.core.Storage
    public void storeSdkHash(zendesk.core.ApplicationConfiguration applicationConfiguration) {
        this.sdkDetailsStorage.put("sdk_hash", generateSdkHash(applicationConfiguration));
    }
}
