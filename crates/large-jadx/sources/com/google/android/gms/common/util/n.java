package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.RecentlyNullable;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class n {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static String a(String string) {
        java.lang.CharSequence obj1;
        if (TextUtils.isEmpty(string)) {
            obj1 = 0;
        }
        return obj1;
    }

    public static boolean b(String string) {
        boolean obj0;
        if (string != null && string.trim().isEmpty()) {
            if (string.trim().isEmpty()) {
            }
            return 0;
        }
        return 1;
    }
}
