package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes2.dex */
public final class d implements FileFilter {

    public final String a;
    public d(String string) {
        super();
        this.a = string;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return CrashlyticsReportPersistence.b(this.a, file);
    }
}
