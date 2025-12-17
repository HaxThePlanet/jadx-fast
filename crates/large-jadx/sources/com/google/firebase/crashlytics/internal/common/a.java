package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
public final class a implements FilenameFilter {

    public static final com.google.firebase.crashlytics.internal.common.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String string2) {
        return CrashlyticsController.a(file, string2);
    }
}
