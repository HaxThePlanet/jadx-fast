package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public class SharedPreferencesUtils {

    static final String PREFERENCES_PACKAGE_NAME = "com.google.firebase.inappmessaging";
    private final FirebaseApp firebaseApp;
    public SharedPreferencesUtils(FirebaseApp firebaseApp) {
        super();
        this.firebaseApp = firebaseApp;
    }

    public void clearPreference(String string) {
        SharedPreferences.Editor edit = (Application)this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        edit.remove(string);
        edit.apply();
    }

    public boolean getAndSetBooleanPreference(String string, boolean z2) {
        SharedPreferences sharedPreferences = (Application)this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.inappmessaging", 0);
        if (sharedPreferences.contains(string)) {
            return sharedPreferences.getBoolean(string, z2);
        }
        setBooleanPreference(string, z2);
        return z2;
    }

    public boolean getBooleanManifestValue(String string, boolean z2) {
        Object applicationContext;
        PackageManager packageManager;
        int i;
        applicationContext = this.firebaseApp.getApplicationContext();
        packageManager = (Application)applicationContext.getPackageManager();
        applicationContext = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
        packageManager = applicationContext.metaData;
        if (packageManager != null && applicationContext != null && packageManager != null && packageManager.containsKey(string)) {
            applicationContext = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationContext != null) {
                packageManager = applicationContext.metaData;
                if (packageManager != null) {
                    if (packageManager.containsKey(string)) {
                        return applicationContext.metaData.getBoolean(string);
                    }
                }
            }
        }
        return z2;
    }

    public boolean getBooleanPreference(String string, boolean z2) {
        SharedPreferences sharedPreferences = (Application)this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.inappmessaging", 0);
        if (sharedPreferences.contains(string)) {
            return sharedPreferences.getBoolean(string, z2);
        }
        return z2;
    }

    public boolean isManifestSet(String string) {
        Object applicationContext;
        int i;
        int i2;
        String obj5;
        applicationContext = this.firebaseApp.getApplicationContext();
        i = 0;
        final PackageManager packageManager = (Application)applicationContext.getPackageManager();
        applicationContext = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
        applicationContext = applicationContext.metaData;
        if (packageManager != null && applicationContext != null && applicationContext != null && applicationContext.containsKey(string)) {
            applicationContext = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationContext != null) {
                applicationContext = applicationContext.metaData;
                if (applicationContext != null) {
                    if (applicationContext.containsKey(string)) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    public boolean isPreferenceSet(String string) {
        return (Application)this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.inappmessaging", 0).contains(string);
    }

    public void setBooleanPreference(String string, boolean z2) {
        SharedPreferences.Editor edit = (Application)this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        edit.putBoolean(string, z2);
        edit.apply();
    }
}
