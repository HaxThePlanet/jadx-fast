package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.content.a;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

/* loaded from: classes2.dex */
public class DataCollectionConfigStorage {

    public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";
    private static final String FIREBASE_APP_PREFS = "com.google.firebase.common.prefs:";
    private boolean dataCollectionDefaultEnabled;
    private final Context deviceProtectedContext;
    private final Publisher publisher;
    private final SharedPreferences sharedPreferences;
    public DataCollectionConfigStorage(Context context, String string2, Publisher publisher3) {
        super();
        Context obj3 = DataCollectionConfigStorage.directBootSafe(context);
        this.deviceProtectedContext = obj3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.google.firebase.common.prefs:");
        stringBuilder.append(string2);
        this.sharedPreferences = obj3.getSharedPreferences(stringBuilder.toString(), 0);
        this.publisher = publisher3;
        this.dataCollectionDefaultEnabled = readAutoDataCollectionEnabled();
    }

    private static Context directBootSafe(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        return a.b(context);
    }

    private boolean readAutoDataCollectionEnabled() {
        final String str = "firebase_data_collection_default_enabled";
        if (this.sharedPreferences.contains(str)) {
            return this.sharedPreferences.getBoolean(str, true);
        }
        return readManifestDataCollectionEnabled();
    }

    private boolean readManifestDataCollectionEnabled() {
        Object applicationInfo;
        String packageName;
        int i;
        String str = "firebase_data_collection_default_enabled";
        applicationInfo = this.deviceProtectedContext.getPackageManager();
        applicationInfo = applicationInfo.getApplicationInfo(this.deviceProtectedContext.getPackageName(), 128);
        packageName = applicationInfo.metaData;
        if (applicationInfo != null && applicationInfo != null && packageName != null && packageName.containsKey(str)) {
            applicationInfo = applicationInfo.getApplicationInfo(this.deviceProtectedContext.getPackageName(), 128);
            if (applicationInfo != null) {
                try {
                    packageName = applicationInfo.metaData;
                    if (packageName != null) {
                    }
                    if (packageName.containsKey(str)) {
                    }
                    return applicationInfo.metaData.getBoolean(str);
                    return 1;
                }
            }
        }
    }

    private void updateDataCollectionDefaultEnabled(boolean z) {
        boolean dataCollectionDefaultEnabled;
        Event event;
        Class<DataCollectionDefaultChange> obj;
        DataCollectionDefaultChange dataCollectionDefaultChange;
        synchronized (this) {
            try {
                this.dataCollectionDefaultEnabled = z;
                dataCollectionDefaultChange = new DataCollectionDefaultChange(z);
                event = new Event(DataCollectionDefaultChange.class, dataCollectionDefaultChange);
                this.publisher.publish(event);
                throw z;
            }
        }
    }

    public boolean isEnabled() {
        return this.dataCollectionDefaultEnabled;
        synchronized (this) {
            return this.dataCollectionDefaultEnabled;
        }
    }

    public void setEnabled(Boolean boolean) {
        Object boolean2;
        String str;
        boolean obj3;
        synchronized (this) {
            this.sharedPreferences.edit().remove("firebase_data_collection_default_enabled").apply();
            updateDataCollectionDefaultEnabled(readManifestDataCollectionEnabled());
            try {
                throw boolean;
            }
        }
    }
}
