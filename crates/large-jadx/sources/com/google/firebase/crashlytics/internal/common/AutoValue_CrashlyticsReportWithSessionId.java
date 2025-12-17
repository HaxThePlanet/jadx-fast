package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReportWithSessionId extends com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId {

    private final CrashlyticsReport report;
    private final String sessionId;
    AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String string2) {
        super();
        Objects.requireNonNull(crashlyticsReport, "Null report");
        this.report = crashlyticsReport;
        Objects.requireNonNull(string2, "Null sessionId");
        this.sessionId = string2;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public boolean equals(Object object) {
        int i;
        boolean sessionId;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReportWithSessionId) {
            if (this.report.equals((CrashlyticsReportWithSessionId)object.getReport()) && this.sessionId.equals(object.getSessionId())) {
                if (this.sessionId.equals(object.getSessionId())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public CrashlyticsReport getReport() {
        return this.report;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CrashlyticsReportWithSessionId{report=");
        stringBuilder.append(this.report);
        stringBuilder.append(", sessionId=");
        stringBuilder.append(this.sessionId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
