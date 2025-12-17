package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class c implements c {

    public final com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator a;
    public c(com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator sessionReportingCoordinator) {
        super();
        this.a = sessionReportingCoordinator;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return Boolean.valueOf(SessionReportingCoordinator.a(this.a, j));
    }
}
