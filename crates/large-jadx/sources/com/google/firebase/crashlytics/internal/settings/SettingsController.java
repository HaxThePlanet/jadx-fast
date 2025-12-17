package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SettingsController implements com.google.firebase.crashlytics.internal.settings.SettingsDataProvider {

    private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
    private static final String SETTINGS_URL_FORMAT = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";
    private final AtomicReference<k<AppSettingsData>> appSettingsData;
    private final com.google.firebase.crashlytics.internal.settings.CachedSettingsIo cachedSettingsIo;
    private final Context context;
    private final CurrentTimeProvider currentTimeProvider;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final AtomicReference<Settings> settings;
    private final com.google.firebase.crashlytics.internal.settings.SettingsJsonParser settingsJsonParser;
    private final SettingsRequest settingsRequest;
    private final SettingsSpiCall settingsSpiCall;
    SettingsController(Context context, SettingsRequest settingsRequest2, CurrentTimeProvider currentTimeProvider3, com.google.firebase.crashlytics.internal.settings.SettingsJsonParser settingsJsonParser4, com.google.firebase.crashlytics.internal.settings.CachedSettingsIo cachedSettingsIo5, SettingsSpiCall settingsSpiCall6, DataCollectionArbiter dataCollectionArbiter7) {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.settings = atomicReference;
        k kVar = new k();
        AtomicReference atomicReference2 = new AtomicReference(kVar);
        this.appSettingsData = atomicReference2;
        this.context = context;
        this.settingsRequest = settingsRequest2;
        this.currentTimeProvider = currentTimeProvider3;
        this.settingsJsonParser = settingsJsonParser4;
        this.cachedSettingsIo = cachedSettingsIo5;
        this.settingsSpiCall = settingsSpiCall6;
        this.dataCollectionArbiter = dataCollectionArbiter7;
        atomicReference.set(DefaultSettingsJsonTransform.defaultSettings(currentTimeProvider3));
    }

    static SettingsRequest access$000(com.google.firebase.crashlytics.internal.settings.SettingsController settingsController) {
        return settingsController.settingsRequest;
    }

    static SettingsSpiCall access$100(com.google.firebase.crashlytics.internal.settings.SettingsController settingsController) {
        return settingsController.settingsSpiCall;
    }

    static com.google.firebase.crashlytics.internal.settings.SettingsJsonParser access$200(com.google.firebase.crashlytics.internal.settings.SettingsController settingsController) {
        return settingsController.settingsJsonParser;
    }

    static com.google.firebase.crashlytics.internal.settings.CachedSettingsIo access$300(com.google.firebase.crashlytics.internal.settings.SettingsController settingsController) {
        return settingsController.cachedSettingsIo;
    }

    static void access$400(com.google.firebase.crashlytics.internal.settings.SettingsController settingsController, JSONObject jSONObject2, String string3) {
        settingsController.logSettings(jSONObject2, string3);
    }

    static boolean access$500(com.google.firebase.crashlytics.internal.settings.SettingsController settingsController, String string2) {
        return settingsController.setStoredBuildInstanceIdentifier(string2);
    }

    static AtomicReference access$600(com.google.firebase.crashlytics.internal.settings.SettingsController settingsController) {
        return settingsController.settings;
    }

    static AtomicReference access$700(com.google.firebase.crashlytics.internal.settings.SettingsController settingsController) {
        return settingsController.appSettingsData;
    }

    public static com.google.firebase.crashlytics.internal.settings.SettingsController create(Context context, String string2, IdManager idManager3, HttpRequestFactory httpRequestFactory4, String string5, String string6, DataCollectionArbiter dataCollectionArbiter7) {
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        SettingsJsonParser settingsJsonParser = new SettingsJsonParser(systemCurrentTimeProvider);
        CachedSettingsIo cachedSettingsIo = new CachedSettingsIo(context);
        int i2 = 1;
        Object[] arr = new Object[i2];
        int i5 = 0;
        arr[i5] = string2;
        DefaultSettingsSpiCall defaultSettingsSpiCall = new DefaultSettingsSpiCall(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", arr), httpRequestFactory4);
        String[] strArr = new String[4];
        strArr[i5] = CommonUtils.getMappingFileId(context);
        strArr[i2] = string2;
        strArr[2] = string6;
        strArr[3] = string5;
        super(string2, idManager3.getModelName(), idManager3.getOsBuildVersionString(), idManager3.getOsDisplayVersionString(), idManager3, CommonUtils.createInstanceIdFrom(strArr), string6, string5, DeliveryMechanism.determineFrom(idManager3.getInstallerPackageName()).getId());
        super(context, settingsRequest, systemCurrentTimeProvider, settingsJsonParser, cachedSettingsIo, defaultSettingsSpiCall, dataCollectionArbiter7);
        return settingsController;
    }

    private SettingsData getCachedSettingsData(com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior settingsCacheBehavior) {
        int i;
        boolean iGNORE_CACHE_EXPIRATION;
        Object settingsJson;
        long currentTimeMillis;
        Object obj6;
        if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
            try {
                JSONObject cachedSettings = this.cachedSettingsIo.readCachedSettings();
                if (cachedSettings != null) {
                } else {
                }
                settingsJson = this.settingsJsonParser.parseSettingsJson(cachedSettings);
                if (settingsJson != null) {
                } else {
                }
                logSettings(cachedSettings, "Loaded cached settings: ");
                if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                } else {
                }
                if (!settingsJson.isExpired(this.currentTimeProvider.getCurrentTimeMillis())) {
                } else {
                }
                Logger.getLogger().v("Cached settings have expired.");
                Logger.getLogger().v("Returning cached settings.");
                i = settingsJson;
                String str = settingsJson;
                Logger.getLogger().e("Failed to parse cached settings data.", 0);
                Logger.getLogger().d("No cached settings data found.");
                settingsJson = "Failed to get cached settings";
                Logger.getLogger().e(settingsJson, settingsCacheBehavior);
                return i;
            } catch (Exception e) {
            }
        }
    }

    private String getStoredBuildInstanceIdentifier() {
        return CommonUtils.getSharedPrefs(this.context).getString("existing_instance_identifier", "");
    }

    private void logSettings(JSONObject jSONObject, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(jSONObject.toString());
        Logger.getLogger().d(stringBuilder.toString());
    }

    private boolean setStoredBuildInstanceIdentifier(String string) {
        SharedPreferences.Editor edit = CommonUtils.getSharedPrefs(this.context).edit();
        edit.putString("existing_instance_identifier", string);
        edit.apply();
        return 1;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    boolean buildInstanceIdentifierChanged() {
        return equals ^= 1;
    }

    public j<AppSettingsData> getAppSettings() {
        return (k)this.appSettingsData.get().a();
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    public Settings getSettings() {
        return (Settings)this.settings.get();
    }

    public j<Void> loadSettingsData(com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior settingsCacheBehavior, Executor executor2) {
        boolean instanceIdentifierChanged;
        Object obj2;
        obj2 = getCachedSettingsData(settingsCacheBehavior);
        if (!buildInstanceIdentifierChanged() && obj2 != null) {
            obj2 = getCachedSettingsData(settingsCacheBehavior);
            if (obj2 != null) {
                this.settings.set(obj2);
                (k)this.appSettingsData.get().e(obj2.getAppSettingsData());
                return m.e(0);
            }
        }
        obj2 = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (obj2 != null) {
            this.settings.set(obj2);
            (k)this.appSettingsData.get().e(obj2.getAppSettingsData());
        }
        SettingsController.1 anon = new SettingsController.1(this);
        return this.dataCollectionArbiter.waitForDataCollectionPermission(executor2).onSuccessTask(executor2, anon);
    }

    public j<Void> loadSettingsData(Executor executor) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, executor);
    }
}
