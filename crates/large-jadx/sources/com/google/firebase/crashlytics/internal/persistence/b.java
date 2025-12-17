package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
public final class b implements FilenameFilter {

    public static final com.google.firebase.crashlytics.internal.persistence.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String string2) {
        return CrashlyticsReportPersistence.a(file, string2);
    }
}
