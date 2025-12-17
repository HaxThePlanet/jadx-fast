package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

/* loaded from: classes2.dex */
public final class a implements com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser {

    public static final com.google.firebase.crashlytics.internal.model.serialization.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$ObjectParser
    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.a(jsonReader);
    }
}
