package com.google.firebase.crashlytics.internal.send;

import f.c.a.b.e;

/* loaded from: classes2.dex */
public final class a implements e {

    public static final com.google.firebase.crashlytics.internal.send.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // f.c.a.b.e
    public final Object apply(Object object) {
        return DataTransportCrashlyticsReportSender.b((CrashlyticsReport)object);
    }
}
