package com.google.firebase.crashlytics.internal.common;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class d implements Comparator {

    public static final com.google.firebase.crashlytics.internal.common.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return SessionReportingCoordinator.b((CrashlyticsReport.CustomAttribute)object, (CrashlyticsReport.CustomAttribute)object2);
    }
}
