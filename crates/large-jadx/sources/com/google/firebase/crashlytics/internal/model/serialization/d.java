package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

/* loaded from: classes2.dex */
public final class d implements com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser {

    public static final com.google.firebase.crashlytics.internal.model.serialization.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$ObjectParser
    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.d(jsonReader);
    }
}
