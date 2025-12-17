package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class IdManager implements com.google.firebase.crashlytics.internal.common.InstallIdProvider {

    public static final String DEFAULT_VERSION_NAME = "0.0";
    private static final String FORWARD_SLASH_REGEX = null;
    private static final Pattern ID_PATTERN = null;
    static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
    static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
    static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
    static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
    private static final String SYNTHETIC_FID_PREFIX = "SYN_";
    private final Context appContext;
    private final String appIdentifier;
    private String crashlyticsInstallId;
    private final com.google.firebase.crashlytics.internal.common.DataCollectionArbiter dataCollectionArbiter;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final com.google.firebase.crashlytics.internal.common.InstallerPackageNameProvider installerPackageNameProvider;
    static {
        IdManager.ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
        IdManager.FORWARD_SLASH_REGEX = Pattern.quote("/");
    }

    public IdManager(Context context, String string2, FirebaseInstallationsApi firebaseInstallationsApi3, com.google.firebase.crashlytics.internal.common.DataCollectionArbiter dataCollectionArbiter4) {
        super();
        if (context == null) {
        } else {
            if (string2 == null) {
            } else {
                this.appContext = context;
                this.appIdentifier = string2;
                this.firebaseInstallationsApi = firebaseInstallationsApi3;
                this.dataCollectionArbiter = dataCollectionArbiter4;
                InstallerPackageNameProvider obj1 = new InstallerPackageNameProvider();
                this.installerPackageNameProvider = obj1;
            }
            obj1 = new IllegalArgumentException("appIdentifier must not be null");
            throw obj1;
        }
        obj1 = new IllegalArgumentException("appContext must not be null");
        throw obj1;
    }

    private String createAndCacheCrashlyticsInstallId(String string, SharedPreferences sharedPreferences2) {
        String formatId = IdManager.formatId(UUID.randomUUID().toString());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Created new Crashlytics installation ID: ");
        stringBuilder.append(formatId);
        stringBuilder.append(" for FID: ");
        stringBuilder.append(string);
        Logger.getLogger().v(stringBuilder.toString());
        sharedPreferences2.edit().putString("crashlytics.installation.id", formatId).putString("firebase.installation.id", string).apply();
        return formatId;
        synchronized (this) {
            formatId = IdManager.formatId(UUID.randomUUID().toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Created new Crashlytics installation ID: ");
            stringBuilder.append(formatId);
            stringBuilder.append(" for FID: ");
            stringBuilder.append(string);
            Logger.getLogger().v(stringBuilder.toString());
            sharedPreferences2.edit().putString("crashlytics.installation.id", formatId).putString("firebase.installation.id", string).apply();
            return formatId;
        }
    }

    static String createSyntheticFid() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SYN_");
        stringBuilder.append(UUID.randomUUID().toString());
        return stringBuilder.toString();
    }

    private String fetchTrueFid() {
        Object awaitEvenIfOnMainThread;
        Logger logger;
        String str;
        awaitEvenIfOnMainThread = Utils.awaitEvenIfOnMainThread(this.firebaseInstallationsApi.getId());
        return awaitEvenIfOnMainThread;
    }

    private static String formatId(String string) {
        Locale locale;
        int obj1;
        if (string == null) {
            obj1 = 0;
        } else {
            obj1 = IdManager.ID_PATTERN.matcher(string).replaceAll("").toLowerCase(Locale.US);
        }
        return obj1;
    }

    static boolean isSyntheticFid(String string) {
        String str;
        boolean obj1;
        if (string != null && string.startsWith("SYN_")) {
            obj1 = string.startsWith("SYN_") ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private String readCachedCrashlyticsInstallId(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", 0);
    }

    private String removeForwardSlashesIn(String string) {
        return string.replaceAll(IdManager.FORWARD_SLASH_REGEX, "");
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public String getCrashlyticsInstallId() {
        Object andCacheCrashlyticsInstallId2;
        String andCacheCrashlyticsInstallId;
        String crashlyticsInstallId;
        String automaticDataCollectionEnabled;
        Object string2;
        String string;
        String str;
        String crashlyticsInstallId2 = this.crashlyticsInstallId;
        synchronized (this) {
            try {
                return crashlyticsInstallId2;
                Logger.getLogger().v("Determining Crashlytics installation ID...");
                andCacheCrashlyticsInstallId2 = CommonUtils.getSharedPrefs(this.appContext);
                String string3 = andCacheCrashlyticsInstallId2.getString("firebase.installation.id", 0);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Cached Firebase Installation ID: ");
                stringBuilder2.append(string3);
                Logger.getLogger().v(stringBuilder2.toString());
            }
            automaticDataCollectionEnabled = fetchTrueFid();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Fetched Firebase Installation ID: ");
            stringBuilder3.append(automaticDataCollectionEnabled);
            Logger.getLogger().v(stringBuilder3.toString());
            if (automaticDataCollectionEnabled == null) {
                if (string3 == null) {
                    automaticDataCollectionEnabled = IdManager.createSyntheticFid();
                } else {
                    automaticDataCollectionEnabled = string3;
                }
            }
            try {
                if (automaticDataCollectionEnabled.equals(string3)) {
                } else {
                }
                this.crashlyticsInstallId = readCachedCrashlyticsInstallId(andCacheCrashlyticsInstallId2);
                this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(automaticDataCollectionEnabled, andCacheCrashlyticsInstallId2);
                if (IdManager.isSyntheticFid(string3)) {
                } else {
                }
                this.crashlyticsInstallId = readCachedCrashlyticsInstallId(andCacheCrashlyticsInstallId2);
                this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(IdManager.createSyntheticFid(), andCacheCrashlyticsInstallId2);
                if (this.crashlyticsInstallId == null) {
                }
                Logger.getLogger().w("Unable to determine Crashlytics Install Id, creating a new one.");
                this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(IdManager.createSyntheticFid(), andCacheCrashlyticsInstallId2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Crashlytics installation ID: ");
                stringBuilder.append(this.crashlyticsInstallId);
                Logger.getLogger().v(stringBuilder.toString());
                return this.crashlyticsInstallId;
                throw th;
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public String getInstallerPackageName() {
        return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public String getModelName() {
        Object[] arr = new Object[2];
        return String.format(Locale.US, "%s/%s", removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL));
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(Build.VERSION.RELEASE);
    }
}
