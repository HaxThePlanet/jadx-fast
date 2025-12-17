package com.google.firebase.crashlytics.internal.send;

import com.google.android.gms.tasks.k;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import f.c.a.b.h;

/* loaded from: classes2.dex */
public final class b implements h {

    public final k a;
    public final CrashlyticsReportWithSessionId b;
    public b(k k, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId2) {
        super();
        this.a = k;
        this.b = crashlyticsReportWithSessionId2;
    }

    @Override // f.c.a.b.h
    public final void a(Exception exception) {
        DataTransportCrashlyticsReportSender.a(this.a, this.b, exception);
    }
}
