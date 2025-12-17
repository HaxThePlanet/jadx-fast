package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
public final class f implements FilenameFilter {

    public static final com.google.firebase.crashlytics.internal.persistence.f a;
    static {
        f fVar = new f();
        f.a = fVar;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String string2) {
        return CrashlyticsReportPersistence.f(file, string2);
    }
}
