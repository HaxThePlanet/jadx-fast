package com.google.firebase.crashlytics.internal.persistence;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class e implements Comparator {

    public static final com.google.firebase.crashlytics.internal.persistence.e a;
    static {
        e eVar = new e();
        e.a = eVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return CrashlyticsReportPersistence.d((File)object, (File)object2);
    }
}
