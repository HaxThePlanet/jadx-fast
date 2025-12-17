package com.google.android.gms.internal.firebase-auth-api;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class dp {
    static {
        Logger.getLogger(dp.class.getName());
    }

    static com.google.android.gms.internal.firebase-auth-api.ak a(String string) {
        cm obj1 = new cm(Pattern.compile("[.-]"));
        return obj1;
    }

    static String b(String string) {
        String obj0;
        if (string == null) {
            obj0 = "";
        }
        return obj0;
    }

    static boolean c(String string) {
        boolean obj0;
        if (string != null && string.isEmpty()) {
            if (string.isEmpty()) {
            }
            return 0;
        }
        return 1;
    }
}
