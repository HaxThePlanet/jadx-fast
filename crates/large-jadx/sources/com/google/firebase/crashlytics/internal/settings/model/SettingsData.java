package com.google.firebase.crashlytics.internal.settings.model;

/* loaded from: classes2.dex */
public class SettingsData implements com.google.firebase.crashlytics.internal.settings.model.Settings {

    public final com.google.firebase.crashlytics.internal.settings.model.AppSettingsData appData;
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData featuresData;
    public final com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData sessionData;
    public final int settingsVersion;
    public SettingsData(long l, com.google.firebase.crashlytics.internal.settings.model.AppSettingsData appSettingsData2, com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData sessionSettingsData3, com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData featuresSettingsData4, int i5, int i6) {
        super();
        this.expiresAtMillis = l;
        this.appData = sessionSettingsData3;
        this.sessionData = featuresSettingsData4;
        this.featuresData = i5;
        this.settingsVersion = i6;
        this.cacheDuration = obj7;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    public com.google.firebase.crashlytics.internal.settings.model.AppSettingsData getAppSettingsData() {
        return this.appData;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    public int getCacheDuration() {
        return this.cacheDuration;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    public long getExpiresAtMillis() {
        return this.expiresAtMillis;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    public com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData getFeaturesData() {
        return this.featuresData;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    public com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData getSessionData() {
        return this.sessionData;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    public int getSettingsVersion() {
        return this.settingsVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.model.Settings
    public boolean isExpired(long l) {
        int obj3;
        obj3 = Long.compare(expiresAtMillis, l) < 0 ? 1 : 0;
        return obj3;
    }
}
