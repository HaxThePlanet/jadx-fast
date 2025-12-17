package com.google.android.play.core.internal;

import java.io.File;

/* loaded from: classes2.dex */
public final class j1 {
    public static String a(File file) {
        boolean equals;
        if (file.getName().endsWith(".apk") == null) {
        } else {
            String str10 = "";
            String obj3 = file.getName().replaceFirst("(_\\d+)?\\.apk", str10);
            if (!obj3.equals("base-master")) {
                if (obj3.equals("base-main")) {
                } else {
                    String str4 = "base-";
                    if (obj3.startsWith(str4)) {
                        return obj3.replace(str4, "config.");
                    }
                }
                return obj3.replace("-", ".config.").replace(".config.master", str10).replace(".config.main", str10);
            }
            return str10;
        }
        obj3 = new IllegalArgumentException("Non-apk found in splits directory.");
        throw obj3;
    }
}
