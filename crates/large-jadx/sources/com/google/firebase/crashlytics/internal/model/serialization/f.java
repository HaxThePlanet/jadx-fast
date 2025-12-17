package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

/* loaded from: classes2.dex */
public final class f implements com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser {

    public static final com.google.firebase.crashlytics.internal.model.serialization.f a;
    static {
        f fVar = new f();
        f.a = fVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$ObjectParser
    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.f(jsonReader);
    }
}
