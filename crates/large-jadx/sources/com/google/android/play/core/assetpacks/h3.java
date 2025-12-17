package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
public final class h3 implements FilenameFilter {

    public static final com.google.android.play.core.assetpacks.h3 a;
    static {
        h3 h3Var = new h3();
        h3.a = h3Var;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String string2) {
        return i3.b(file, string2);
    }
}
