package zendesk.support;

import android.content.Context;
import zendesk.core.MemoryCache;
import zendesk.core.SessionStorage;

/* loaded from: classes3.dex */
class StorageModule {

    private static final String LEGACY_REQUEST_STORAGE_PREFS_NAME = "zendesk-authorization";
    zendesk.support.RequestMigrator provideRequestMigrator(Context context) {
        LegacyRequestMigrator legacyRequestMigrator = new LegacyRequestMigrator(context.getSharedPreferences("zendesk-authorization", 0));
        return legacyRequestMigrator;
    }

    zendesk.support.RequestSessionCache provideRequestSessionCache() {
        ZendeskRequestSessionCache zendeskRequestSessionCache = new ZendeskRequestSessionCache();
        return zendeskRequestSessionCache;
    }

    zendesk.support.RequestStorage provideRequestStorage(SessionStorage sessionStorage, zendesk.support.RequestMigrator requestMigrator2, MemoryCache memoryCache3) {
        ZendeskRequestStorage zendeskRequestStorage = new ZendeskRequestStorage(sessionStorage.getAdditionalSdkStorage(), requestMigrator2, memoryCache3);
        return zendeskRequestStorage;
    }
}
