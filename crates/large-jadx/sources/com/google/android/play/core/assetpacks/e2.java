package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
public final class e2 implements FilenameFilter {

    public final String a;
    public e2(String string) {
        super();
        this.a = string;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String string2) {
        boolean obj2;
        if (string2.startsWith(String.valueOf(this.a).concat("-")) && string2.endsWith(".apk")) {
            if (string2.endsWith(".apk")) {
                return 1;
            }
        }
        return 0;
    }
}
