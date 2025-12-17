package zendesk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import java.io.File;
import java.util.Locale;
import okhttp3.Cache;

/* loaded from: classes3.dex */
class ZendeskStorageModule {

    private static final String BASE_STORAGE_ADDITIONAL_SDK = "base_storage_additional_sdk";
    static final String BASE_STORAGE_DISK_LRU = "base_storage_disk_lru";
    private static final String BASE_STORAGE_IDENTITY = "base_storage_identity";
    private static final String BASE_STORAGE_LEGACY_IDENTITY = "base_storage_legacy_identity";
    private static final String BASE_STORAGE_LEGACY_PUSH = "base_storage_legacy_push";
    private static final String BASE_STORAGE_SDK = "base_storage_sdk";
    private static final String BASE_STORAGE_SETTINGS = "base_storage_settings";
    private static final String BELVEDERE_DIR = "belvedere_dir";
    private static final String CACHE_DIR = "cache_dir";
    private static final String DATA_DIR = "data_dir";
    static final String GSON_SERIALIZER = "gson_serializer";
    private static final String LEGACY_IDENTITY_STORAGE_FILE_NAME = "zendesk-token";
    private static final String LEGACY_PUSH_ID_STORAGE_FILE_NAME = "zendesk-push-token";
    private static final int MAX_CACHE_SIZE = 20971520;
    private static final String STORAGE_BELVEDERE_CACHE = null;
    private static final String STORAGE_NAME_ADDITIONAL_SDK = "additional_sdk";
    private static final String STORAGE_NAME_CORE_SDK = "sdk";
    private static final String STORAGE_NAME_IDENTITY = "identity";
    private static final String STORAGE_NAME_MEDIA_CACHE = "media_cache";
    private static final String STORAGE_NAME_RESPONSE_CACHE = "response_cache";
    private static final String STORAGE_NAME_SETTINGS = "settings";
    private static final String ZENDESK_DIR_NAME = "zendesk";
    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("belvedere-data-v2");
        String separator = File.separator;
        stringBuilder.append(separator);
        stringBuilder.append("user");
        stringBuilder.append(separator);
        stringBuilder.append("zendesk");
        ZendeskStorageModule.STORAGE_BELVEDERE_CACHE = stringBuilder.toString();
    }

    private static SharedPreferences getSharedPrefs(Context context, String string2) {
        return context.getSharedPreferences(string2, 0);
    }

    static zendesk.core.BaseStorage provideAdditionalSdkBaseStorage(Context context, zendesk.core.Serializer serializer2) {
        SharedPreferencesStorage sharedPreferencesStorage = new SharedPreferencesStorage(ZendeskStorageModule.getSharedPrefs(context, ZendeskStorageModule.storageName("additional_sdk")), serializer2);
        return sharedPreferencesStorage;
    }

    static zendesk.core.AuthenticationProvider provideAuthProvider(zendesk.core.IdentityManager identityManager) {
        ZendeskAuthenticationProvider zendeskAuthenticationProvider = new ZendeskAuthenticationProvider(identityManager);
        return zendeskAuthenticationProvider;
    }

    static Cache provideCache(File file) {
        File file2 = new File(file, ZendeskStorageModule.storageName("response_cache"));
        Cache cache = new Cache(file2, 20971520, obj3);
        return cache;
    }

    static zendesk.core.CoreSettingsStorage provideCoreSettingsStorage(zendesk.core.SettingsStorage settingsStorage) {
        ZendeskCoreSettingsStorage zendeskCoreSettingsStorage = new ZendeskCoreSettingsStorage(settingsStorage);
        return zendeskCoreSettingsStorage;
    }

    static zendesk.core.BaseStorage provideIdentityBaseStorage(Context context, zendesk.core.Serializer serializer2) {
        SharedPreferencesStorage sharedPreferencesStorage = new SharedPreferencesStorage(ZendeskStorageModule.getSharedPrefs(context, ZendeskStorageModule.storageName("identity")), serializer2);
        return sharedPreferencesStorage;
    }

    static zendesk.core.IdentityManager provideIdentityManager(zendesk.core.IdentityStorage identityStorage) {
        ZendeskIdentityManager zendeskIdentityManager = new ZendeskIdentityManager(identityStorage);
        return zendeskIdentityManager;
    }

    static zendesk.core.IdentityStorage provideIdentityStorage(zendesk.core.BaseStorage baseStorage) {
        ZendeskIdentityStorage zendeskIdentityStorage = new ZendeskIdentityStorage(baseStorage);
        return zendeskIdentityStorage;
    }

    static zendesk.core.SharedPreferencesStorage provideLegacyIdentityBaseStorage(Context context, zendesk.core.Serializer serializer2) {
        SharedPreferencesStorage sharedPreferencesStorage = new SharedPreferencesStorage(ZendeskStorageModule.getSharedPrefs(context, "zendesk-token"), serializer2);
        return sharedPreferencesStorage;
    }

    static zendesk.core.LegacyIdentityMigrator provideLegacyIdentityStorage(zendesk.core.SharedPreferencesStorage sharedPreferencesStorage, zendesk.core.SharedPreferencesStorage sharedPreferencesStorage2, zendesk.core.IdentityStorage identityStorage3, zendesk.core.IdentityManager identityManager4, zendesk.core.PushDeviceIdStorage pushDeviceIdStorage5) {
        super(sharedPreferencesStorage, sharedPreferencesStorage2, identityStorage3, identityManager4, pushDeviceIdStorage5);
        return legacyIdentityMigrator2;
    }

    static zendesk.core.SharedPreferencesStorage provideLegacyPushBaseStorage(Context context, zendesk.core.Serializer serializer2) {
        SharedPreferencesStorage sharedPreferencesStorage = new SharedPreferencesStorage(ZendeskStorageModule.getSharedPrefs(context, "zendesk-push-token"), serializer2);
        return sharedPreferencesStorage;
    }

    static zendesk.core.MemoryCache provideMemoryCache() {
        ZendeskLruMemoryCache zendeskLruMemoryCache = new ZendeskLruMemoryCache();
        return zendeskLruMemoryCache;
    }

    static zendesk.core.PushDeviceIdStorage providePushDeviceIdStorage(zendesk.core.BaseStorage baseStorage) {
        ZendeskPushDeviceIdStorage zendeskPushDeviceIdStorage = new ZendeskPushDeviceIdStorage(baseStorage);
        return zendeskPushDeviceIdStorage;
    }

    static zendesk.core.BaseStorage provideSdkBaseStorage(Context context, zendesk.core.Serializer serializer2) {
        SharedPreferencesStorage sharedPreferencesStorage = new SharedPreferencesStorage(ZendeskStorageModule.getSharedPrefs(context, ZendeskStorageModule.storageName("sdk")), serializer2);
        return sharedPreferencesStorage;
    }

    static zendesk.core.Storage provideSdkStorage(zendesk.core.SettingsStorage settingsStorage, zendesk.core.SessionStorage sessionStorage2, zendesk.core.BaseStorage baseStorage3, zendesk.core.MemoryCache memoryCache4) {
        ZendeskStorage zendeskStorage = new ZendeskStorage(sessionStorage2, settingsStorage, baseStorage3, memoryCache4);
        return zendeskStorage;
    }

    static zendesk.core.Serializer provideSerializer(Gson gson) {
        GsonSerializer gsonSerializer = new GsonSerializer(gson);
        return gsonSerializer;
    }

    static zendesk.core.SessionStorage provideSessionStorage(zendesk.core.IdentityStorage identityStorage, zendesk.core.BaseStorage baseStorage2, zendesk.core.BaseStorage baseStorage3, Cache cache4, File file5, File file6, File file7) {
        super(identityStorage, baseStorage2, cache4, baseStorage3, file5, file6, file7);
        return zendeskSessionStorage2;
    }

    static zendesk.core.BaseStorage provideSettingsBaseStorage(Context context, zendesk.core.Serializer serializer2) {
        SharedPreferencesStorage sharedPreferencesStorage = new SharedPreferencesStorage(ZendeskStorageModule.getSharedPrefs(context, ZendeskStorageModule.storageName("settings")), serializer2);
        return sharedPreferencesStorage;
    }

    static zendesk.core.SettingsStorage provideSettingsStorage(zendesk.core.BaseStorage baseStorage) {
        ZendeskSettingsStorage zendeskSettingsStorage = new ZendeskSettingsStorage(baseStorage);
        return zendeskSettingsStorage;
    }

    static File providesBelvedereDir(Context context) {
        File file = new File(context.getCacheDir(), ZendeskStorageModule.STORAGE_BELVEDERE_CACHE);
        return file;
    }

    static File providesCacheDir(Context context) {
        File file = new File(context.getCacheDir(), "zendesk");
        return file;
    }

    static File providesDataDir(Context context) {
        File file = new File(context.getFilesDir(), "zendesk");
        return file;
    }

    static zendesk.core.BaseStorage providesDiskLruStorage(File file, zendesk.core.Serializer serializer2) {
        File file2 = new File(file, ZendeskStorageModule.storageName("media_cache"));
        ZendeskDiskLruCache zendeskDiskLruCache = new ZendeskDiskLruCache(file2, serializer2, 20971520);
        return zendeskDiskLruCache;
    }

    private static String storageName(String string) {
        Object[] arr = new Object[1];
        return String.format(Locale.US, "zendesk_%s", string);
    }
}
