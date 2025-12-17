package com.google.android.play.core.splitinstall.g;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes2.dex */
public final class j implements FileFilter {

    public static final com.google.android.play.core.splitinstall.g.j a;
    static {
        j jVar = new j();
        j.a = jVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        int i = a.p;
        return file.getName().endsWith(".apk");
    }
}
