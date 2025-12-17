package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
public final class c implements FilenameFilter {

    public final String a;
    public c(String string) {
        super();
        this.a = string;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String string2) {
        return CrashlyticsReportPersistence.c(this.a, file, string2);
    }
}
