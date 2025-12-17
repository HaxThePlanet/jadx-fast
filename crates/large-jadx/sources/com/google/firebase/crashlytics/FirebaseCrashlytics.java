package com.google.firebase.crashlytics;

import android.content.Context;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class FirebaseCrashlytics {

    static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    final CrashlyticsCore core;
    private FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        super();
        this.core = crashlyticsCore;
    }

    public static com.google.firebase.crashlytics.FirebaseCrashlytics getInstance() {
        Object obj = FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        Objects.requireNonNull((FirebaseCrashlytics)obj, "FirebaseCrashlytics component is not present.");
        return obj;
    }

    static com.google.firebase.crashlytics.FirebaseCrashlytics init(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi2, Deferred<CrashlyticsNativeComponent> deferred3, Deferred<AnalyticsConnector> deferred4) {
        Context applicationContext = firebaseApp.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Initializing Firebase Crashlytics ");
        stringBuilder.append(CrashlyticsCore.getVersion());
        stringBuilder.append(" for ");
        stringBuilder.append(packageName);
        Logger.getLogger().i(stringBuilder.toString());
        FirebaseApp firebaseApp2 = firebaseApp;
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        FirebaseInstallationsApi firebaseInstallationsApi = firebaseInstallationsApi2;
        IdManager idManager = new IdManager(applicationContext, packageName, firebaseInstallationsApi2, dataCollectionArbiter);
        CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = new CrashlyticsNativeComponentDeferredProxy(deferred3);
        AnalyticsDeferredProxy analyticsDeferredProxy = new AnalyticsDeferredProxy(deferred4);
        super(firebaseApp, idManager, crashlyticsNativeComponentDeferredProxy, dataCollectionArbiter, analyticsDeferredProxy.getDeferredBreadcrumbSource(), analyticsDeferredProxy.getAnalyticsEventLogger(), ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
        String applicationId = firebaseApp.getOptions().getApplicationId();
        String mappingFileId = CommonUtils.getMappingFileId(applicationContext);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Mapping file ID is: ");
        stringBuilder2.append(mappingFileId);
        Logger.getLogger().d(stringBuilder2.toString());
        ResourceUnityVersionProvider resourceUnityVersionProvider = new ResourceUnityVersionProvider(applicationContext);
        AppData create = AppData.create(applicationContext, idManager, applicationId, mappingFileId, resourceUnityVersionProvider);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Installer package name is: ");
        stringBuilder3.append(create.installerPackageName);
        Logger.getLogger().v(stringBuilder3.toString());
        java.util.concurrent.ExecutorService singleThreadExecutorService = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
        HttpRequestFactory httpRequestFactory = new HttpRequestFactory();
        SettingsController create2 = SettingsController.create(applicationContext, applicationId, idManager, httpRequestFactory, create.versionCode, create.versionName, dataCollectionArbiter);
        FirebaseCrashlytics.1 anon2 = new FirebaseCrashlytics.1();
        create2.loadSettingsData(singleThreadExecutorService).continueWith(singleThreadExecutorService, anon2);
        FirebaseCrashlytics.2 anon = new FirebaseCrashlytics.2(crashlyticsCore2.onPreExecute(create, create2), crashlyticsCore2, create2);
        m.c(singleThreadExecutorService, anon);
        FirebaseCrashlytics firebaseCrashlytics = new FirebaseCrashlytics(crashlyticsCore2);
        return firebaseCrashlytics;
    }

    public j<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void log(String string) {
        this.core.log(string);
    }

    public void recordException(Throwable throwable) {
        if (throwable == null) {
            Logger.getLogger().w("A null value was passed to recordException. Ignoring.");
        }
        this.core.logException(throwable);
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(Boolean boolean) {
        this.core.setCrashlyticsCollectionEnabled(boolean);
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCustomKey(String string, double d2) {
        this.core.setCustomKey(string, Double.toString(d2));
    }

    public void setCustomKey(String string, float f2) {
        this.core.setCustomKey(string, Float.toString(f2));
    }

    public void setCustomKey(String string, int i2) {
        this.core.setCustomKey(string, Integer.toString(i2));
    }

    public void setCustomKey(String string, long l2) {
        this.core.setCustomKey(string, Long.toString(l2));
    }

    public void setCustomKey(String string, String string2) {
        this.core.setCustomKey(string, string2);
    }

    public void setCustomKey(String string, boolean z2) {
        this.core.setCustomKey(string, Boolean.toString(z2));
    }

    public void setCustomKeys(com.google.firebase.crashlytics.CustomKeysAndValues customKeysAndValues) {
        this.core.setCustomKeys(customKeysAndValues.keysAndValues);
    }

    public void setUserId(String string) {
        this.core.setUserId(string);
    }
}
