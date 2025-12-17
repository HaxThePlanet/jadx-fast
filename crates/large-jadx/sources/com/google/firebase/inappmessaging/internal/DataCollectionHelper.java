package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class DataCollectionHelper {

    static final String AUTO_INIT_PREFERENCES = "auto_init";
    static final String MANIFEST_METADATA_AUTO_INIT_ENABLED = "firebase_inapp_messaging_auto_data_collection_enabled";
    private AtomicBoolean isGlobalAutomaticDataCollectionEnabled;
    private com.google.firebase.inappmessaging.internal.SharedPreferencesUtils sharedPreferencesUtils;
    public DataCollectionHelper(FirebaseApp firebaseApp, com.google.firebase.inappmessaging.internal.SharedPreferencesUtils sharedPreferencesUtils2, Subscriber subscriber3) {
        super();
        this.sharedPreferencesUtils = sharedPreferencesUtils2;
        AtomicBoolean obj2 = new AtomicBoolean(firebaseApp.isDataCollectionDefaultEnabled());
        this.isGlobalAutomaticDataCollectionEnabled = obj2;
        obj2 = new i(this);
        subscriber3.subscribe(DataCollectionDefaultChange.class, obj2);
    }

    private void a(Event event) {
        this.isGlobalAutomaticDataCollectionEnabled.set(obj2.enabled);
    }

    private boolean isProductManifestSet() {
        return this.sharedPreferencesUtils.isManifestSet("firebase_inapp_messaging_auto_data_collection_enabled");
    }

    private boolean isProductManuallySet() {
        return this.sharedPreferencesUtils.isPreferenceSet("auto_init");
    }

    private boolean readAutomaticDataCollectionEnabledFromPreferences() {
        return this.sharedPreferencesUtils.getBooleanPreference("auto_init", true);
    }

    public void b(Event event) {
        a(event);
    }

    public boolean isAutomaticDataCollectionEnabled() {
        final int i = 1;
        if (isProductManuallySet()) {
            return this.sharedPreferencesUtils.getBooleanPreference("auto_init", i);
        }
        if (isProductManifestSet()) {
            return this.sharedPreferencesUtils.getBooleanManifestValue("firebase_inapp_messaging_auto_data_collection_enabled", i);
        }
        return this.isGlobalAutomaticDataCollectionEnabled.get();
    }

    public void setAutomaticDataCollectionEnabled(Boolean boolean) {
        com.google.firebase.inappmessaging.internal.SharedPreferencesUtils sharedPreferencesUtils;
        Boolean tRUE;
        com.google.firebase.inappmessaging.internal.SharedPreferencesUtils obj4;
        final String str = "auto_init";
        if (boolean == null) {
            this.sharedPreferencesUtils.clearPreference(str);
        } else {
            this.sharedPreferencesUtils.setBooleanPreference(str, Boolean.TRUE.equals(boolean));
        }
    }

    public void setAutomaticDataCollectionEnabled(boolean z) {
        this.sharedPreferencesUtils.setBooleanPreference("auto_init", z);
    }
}
