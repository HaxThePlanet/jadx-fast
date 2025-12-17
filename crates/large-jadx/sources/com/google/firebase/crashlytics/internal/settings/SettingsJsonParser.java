package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SettingsJsonParser {

    private final CurrentTimeProvider currentTimeProvider;
    SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        super();
        this.currentTimeProvider = currentTimeProvider;
    }

    private static com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform getJsonTransformForVersion(int i) {
        if (i != 3) {
            DefaultSettingsJsonTransform obj1 = new DefaultSettingsJsonTransform();
            return obj1;
        }
        obj1 = new SettingsV3JsonTransform();
        return obj1;
    }

    public SettingsData parseSettingsJson(JSONObject jSONObject) {
        return SettingsJsonParser.getJsonTransformForVersion(jSONObject.getInt("settings_version")).buildFromJson(this.currentTimeProvider, jSONObject);
    }
}
