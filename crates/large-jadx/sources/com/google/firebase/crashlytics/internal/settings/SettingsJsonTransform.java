package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

/* loaded from: classes2.dex */
interface SettingsJsonTransform {
    public abstract SettingsData buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject2);

    public abstract JSONObject toJson(SettingsData settingsData);
}
