package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

/* loaded from: classes2.dex */
public final class e implements com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser {

    public static final com.google.firebase.crashlytics.internal.model.serialization.e a;
    static {
        e eVar = new e();
        e.a = eVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$ObjectParser
    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.e(jsonReader);
    }
}
