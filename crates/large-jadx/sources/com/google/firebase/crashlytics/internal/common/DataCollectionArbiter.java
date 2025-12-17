package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class DataCollectionArbiter {

    private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
    private Boolean crashlyticsDataCollectionEnabled;
    k<Void> dataCollectionEnabledTask;
    private final k<Void> dataCollectionExplicitlyApproved;
    private final FirebaseApp firebaseApp;
    private boolean setInManifest = false;
    private final SharedPreferences sharedPreferences;
    private final Object taskLock;
    boolean taskResolved;
    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Context applicationContext;
        Boolean obj3;
        super();
        Object object = new Object();
        this.taskLock = object;
        k kVar = new k();
        this.dataCollectionEnabledTask = kVar;
        this.taskResolved = false;
        k kVar2 = new k();
        this.dataCollectionExplicitlyApproved = kVar2;
        applicationContext = firebaseApp.getApplicationContext();
        this.firebaseApp = firebaseApp;
        this.sharedPreferences = CommonUtils.getSharedPrefs(applicationContext);
        if (getDataCollectionValueFromSharedPreferences() == null) {
            obj3 = getDataCollectionValueFromManifest(applicationContext);
        }
        this.crashlyticsDataCollectionEnabled = obj3;
        synchronized (object) {
            this.dataCollectionEnabledTask.e(0);
            this.taskResolved = true;
        }
    }

    private Boolean getDataCollectionValueFromManifest(Context context) {
        Boolean obj2 = DataCollectionArbiter.readCrashlyticsDataCollectionEnabledFromManifest(context);
        if (obj2 == null) {
            this.setInManifest = false;
            return null;
        }
        this.setInManifest = true;
        return Boolean.valueOf(Boolean.TRUE.equals(obj2));
    }

    private Boolean getDataCollectionValueFromSharedPreferences() {
        final String str = "firebase_crashlytics_collection_enabled";
        if (this.sharedPreferences.contains(str)) {
            this.setInManifest = false;
            return Boolean.valueOf(this.sharedPreferences.getBoolean(str, true));
        }
        return null;
    }

    private void logDataCollectionState(boolean z) {
        String str;
        String obj5;
        obj5 = z ? "ENABLED" : "DISABLED";
        str = this.crashlyticsDataCollectionEnabled == null ? "global Firebase setting" : setInManifest ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        Object[] arr = new Object[2];
        Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", obj5, str));
    }

    private static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context context) {
        String str;
        PackageManager packageManager;
        int i;
        Object obj3;
        str = "firebase_crashlytics_collection_enabled";
        packageManager = context.getPackageManager();
        obj3 = packageManager.getApplicationInfo(context.getPackageName(), 128);
        packageManager = obj3.metaData;
        if (packageManager != null && obj3 != null && packageManager != null && packageManager.containsKey(str)) {
            obj3 = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (obj3 != null) {
                try {
                    packageManager = obj3.metaData;
                    if (packageManager != null) {
                    }
                    if (packageManager.containsKey(str)) {
                    }
                    return Boolean.valueOf(obj3.metaData.getBoolean(str));
                    Logger.getLogger().e("Could not read data collection permission from manifest", context);
                    return null;
                }
            }
        }
    }

    private static void storeDataCollectionValueInSharedPreferences(SharedPreferences sharedPreferences, Boolean boolean2) {
        boolean obj2;
        final SharedPreferences.Editor obj1 = sharedPreferences.edit();
        final String str = "firebase_crashlytics_collection_enabled";
        if (boolean2) {
            obj1.putBoolean(str, boolean2.booleanValue());
        } else {
            obj1.remove(str);
        }
        obj1.commit();
    }

    public void grantDataCollectionPermission(boolean z) {
        if (!z) {
        } else {
            this.dataCollectionExplicitlyApproved.e(0);
        }
        IllegalStateException obj2 = new IllegalStateException("An invalid data collection token was used.");
        throw obj2;
    }

    public boolean isAutomaticDataCollectionEnabled() {
        boolean dataCollectionDefaultEnabled;
        Boolean crashlyticsDataCollectionEnabled = this.crashlyticsDataCollectionEnabled;
        synchronized (this) {
            try {
                dataCollectionDefaultEnabled = crashlyticsDataCollectionEnabled.booleanValue();
                dataCollectionDefaultEnabled = this.firebaseApp.isDataCollectionDefaultEnabled();
                logDataCollectionState(dataCollectionDefaultEnabled);
                return dataCollectionDefaultEnabled;
                throw th;
            }
        }
    }

    public void setCrashlyticsDataCollectionEnabled(Boolean boolean) {
        boolean taskResolved;
        Object dataCollectionValueFromManifest;
        boolean automaticDataCollectionEnabled;
        taskResolved = 0;
        synchronized (this) {
            this.setInManifest = taskResolved;
            if (boolean != null) {
                try {
                    dataCollectionValueFromManifest = boolean;
                    dataCollectionValueFromManifest = getDataCollectionValueFromManifest(this.firebaseApp.getApplicationContext());
                    this.crashlyticsDataCollectionEnabled = dataCollectionValueFromManifest;
                    DataCollectionArbiter.storeDataCollectionValueInSharedPreferences(this.sharedPreferences, boolean);
                    final Object obj3 = this.taskLock;
                    if (isAutomaticDataCollectionEnabled()) {
                    } else {
                    }
                    if (!this.taskResolved) {
                    }
                    this.dataCollectionEnabledTask.e(0);
                    this.taskResolved = true;
                    if (this.taskResolved) {
                    }
                    automaticDataCollectionEnabled = new k();
                    this.dataCollectionEnabledTask = automaticDataCollectionEnabled;
                    this.taskResolved = taskResolved;
                    throw th;
                    throw boolean;
                } catch (Throwable th) {
                }
            } else {
            }
        }
    }

    public j<Void> waitForAutomaticDataCollectionEnabled() {
        final Object taskLock = this.taskLock;
        return this.dataCollectionEnabledTask.a();
        synchronized (taskLock) {
            taskLock = this.taskLock;
            return this.dataCollectionEnabledTask.a();
        }
    }

    public j<Void> waitForDataCollectionPermission(Executor executor) {
        return Utils.race(executor, this.dataCollectionExplicitlyApproved.a(), waitForAutomaticDataCollectionEnabled());
    }
}
