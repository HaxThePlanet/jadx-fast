package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class DefaultSettingsJsonTransform implements com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform {
    private static AppSettingsData buildAppDataFrom(JSONObject jSONObject) {
        super(jSONObject.getString("status"), jSONObject.getString("url"), jSONObject.getString("reports_url"), jSONObject.getString("ndk_reports_url"), jSONObject.optBoolean("update_required", false));
        return obj7;
    }

    private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        FeaturesSettingsData featuresSettingsData = new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_anrs", false));
        return featuresSettingsData;
    }

    private static SessionSettingsData buildSessionDataFrom(JSONObject jSONObject) {
        SessionSettingsData sessionSettingsData = new SessionSettingsData(jSONObject.optInt("max_custom_exception_events", 8), 4);
        return sessionSettingsData;
    }

    static Settings defaultSettings(CurrentTimeProvider currentTimeProvider) {
        JSONObject jSONObject = new JSONObject();
        super(DefaultSettingsJsonTransform.getExpiresAtFrom(currentTimeProvider, 3600, obj2), obj3, 0, DefaultSettingsJsonTransform.buildSessionDataFrom(jSONObject), DefaultSettingsJsonTransform.buildFeaturesSessionDataFrom(jSONObject), 0, 3600);
        return obj9;
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long l2, JSONObject jSONObject3) {
        String currentTimeMillis;
        int i;
        long obj4;
        int obj5;
        currentTimeMillis = "expires_at";
        if (obj7.has(currentTimeMillis)) {
            obj4 = obj7.optLong(currentTimeMillis);
        } else {
            obj4 = currentTimeMillis + obj5;
        }
        return obj4;
    }

    private JSONObject toAppJson(AppSettingsData appSettingsData) {
        JSONObject jSONObject = new JSONObject();
        return jSONObject.put("status", appSettingsData.status).put("url", appSettingsData.url).put("reports_url", appSettingsData.reportsUrl).put("ndk_reports_url", appSettingsData.ndkReportsUrl).put("update_required", appSettingsData.updateRequired);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) {
        JSONObject jSONObject = new JSONObject();
        return jSONObject.put("collect_reports", featuresSettingsData.collectReports);
    }

    private JSONObject toSessionJson(SessionSettingsData sessionSettingsData) {
        JSONObject jSONObject = new JSONObject();
        return jSONObject.put("max_custom_exception_events", sessionSettingsData.maxCustomExceptionEvents).put("max_complete_sessions_count", sessionSettingsData.maxCompleteSessionsCount);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public SettingsData buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject2) {
        int i2 = 3600;
        final int optInt2 = jSONObject2.optInt("cache_duration", i2);
        super(DefaultSettingsJsonTransform.getExpiresAtFrom(currentTimeProvider, (long)optInt2, i2), obj4, DefaultSettingsJsonTransform.buildAppDataFrom(jSONObject2.getJSONObject("app")), DefaultSettingsJsonTransform.buildSessionDataFrom(jSONObject2.getJSONObject("session")), DefaultSettingsJsonTransform.buildFeaturesSessionDataFrom(jSONObject2.getJSONObject("features")), jSONObject2.optInt("settings_version", 0), optInt2);
        return obj11;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public JSONObject toJson(SettingsData settingsData) {
        JSONObject jSONObject = new JSONObject();
        return jSONObject.put("expires_at", settingsData.expiresAtMillis).put("cache_duration", settingsData.cacheDuration).put("settings_version", settingsData.settingsVersion).put("features", toFeaturesJson(settingsData.featuresData)).put("app", toAppJson(settingsData.appData)).put("session", toSessionJson(settingsData.sessionData));
    }
}
