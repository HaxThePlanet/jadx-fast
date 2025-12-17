package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

/* loaded from: classes2.dex */
public final class b implements com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser {

    public static final com.google.firebase.crashlytics.internal.model.serialization.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$ObjectParser
    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.b(jsonReader);
    }
}
