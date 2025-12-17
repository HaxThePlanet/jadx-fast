package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class SettingsV3JsonTransform implements com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform {

    private static final String CRASHLYTICS_APP_URL = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
    private static final String CRASHLYTICS_APP_URL_FORMAT = "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s";
    private static final String NDK_REPORTS_URL_FORMAT = "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps";
    private static final String REPORTS_URL_FORMAT = "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports";
    private static AppSettingsData buildAppDataFrom(JSONObject jSONObject, JSONObject jSONObject2) {
        String format;
        Object[] arr;
        String str;
        final String string = jSONObject2.getString("status");
        final String string2 = jSONObject.getString("bundle_id");
        int obj11 = 1;
        int i = 0;
        if ("new".equals(string)) {
            format = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
        } else {
            arr = new Object[obj11];
            arr[i] = string2;
            format = String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", arr);
        }
        Locale uS = Locale.US;
        Object[] arr2 = new Object[obj11];
        arr2[i] = string2;
        obj11 = new Object[obj11];
        obj11[i] = string2;
        super(string, format, String.format(uS, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", arr2), String.format(uS, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", obj11), string2, jSONObject.getString("org_id"), jSONObject2.optBoolean("update_required", i), jSONObject2.optInt("report_upload_variant", i), jSONObject2.optInt("native_report_upload_variant", i));
        return obj11;
    }

    private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        FeaturesSettingsData featuresSettingsData = new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_anrs", false));
        return featuresSettingsData;
    }

    private static SessionSettingsData defaultSessionData() {
        SessionSettingsData sessionSettingsData = new SessionSettingsData(8, 4);
        return sessionSettingsData;
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
        return jSONObject.put("status", appSettingsData.status).put("update_required", appSettingsData.updateRequired).put("report_upload_variant", appSettingsData.reportUploadVariant).put("native_report_upload_variant", appSettingsData.nativeReportUploadVariant);
    }

    private JSONObject toFabricJson(AppSettingsData appSettingsData) {
        JSONObject jSONObject = new JSONObject();
        return jSONObject.put("bundle_id", appSettingsData.bundleId).put("org_id", appSettingsData.organizationId);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) {
        JSONObject jSONObject = new JSONObject();
        return jSONObject.put("collect_reports", featuresSettingsData.collectReports);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public SettingsData buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject2) {
        final int optInt2 = jSONObject2.optInt("cache_duration", 3600);
        JSONObject jSONObject4 = jSONObject2.getJSONObject("app");
        super(SettingsV3JsonTransform.getExpiresAtFrom(currentTimeProvider, (long)optInt2, jSONObject4), obj4, SettingsV3JsonTransform.buildAppDataFrom(jSONObject2.getJSONObject("fabric"), jSONObject4), SettingsV3JsonTransform.defaultSessionData(), SettingsV3JsonTransform.buildFeaturesSessionDataFrom(jSONObject2.getJSONObject("features")), jSONObject2.optInt("settings_version", 0), optInt2);
        return obj11;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public JSONObject toJson(SettingsData settingsData) {
        JSONObject jSONObject = new JSONObject();
        return jSONObject.put("expires_at", settingsData.expiresAtMillis).put("cache_duration", settingsData.cacheDuration).put("settings_version", settingsData.settingsVersion).put("features", toFeaturesJson(settingsData.featuresData)).put("app", toAppJson(settingsData.appData)).put("fabric", toFabricJson(settingsData.appData));
    }
}
