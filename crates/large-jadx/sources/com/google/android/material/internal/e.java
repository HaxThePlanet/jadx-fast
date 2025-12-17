package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes2.dex */
public class e {
    public static boolean a() {
        int i;
        boolean z;
        if (!e.b()) {
            if (e.d()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static boolean b() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
    }

    public static boolean c() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
    }

    public static boolean d() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
    }
}
