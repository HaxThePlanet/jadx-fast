package com.google.firebase.crashlytics.internal.settings.model;

/* loaded from: classes2.dex */
public interface Settings {
    public abstract int getCacheDuration();

    public abstract long getExpiresAtMillis();

    public abstract com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData getFeaturesData();

    public abstract com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData getSessionData();

    public abstract int getSettingsVersion();

    public abstract boolean isExpired(long l);
}
