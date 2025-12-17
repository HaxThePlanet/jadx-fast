package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes2.dex */
public abstract class CrashlyticsReportWithSessionId {
    public static com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId create(CrashlyticsReport crashlyticsReport, String string2) {
        AutoValue_CrashlyticsReportWithSessionId autoValue_CrashlyticsReportWithSessionId = new AutoValue_CrashlyticsReportWithSessionId(crashlyticsReport, string2);
        return autoValue_CrashlyticsReportWithSessionId;
    }

    public abstract CrashlyticsReport getReport();

    public abstract String getSessionId();
}
