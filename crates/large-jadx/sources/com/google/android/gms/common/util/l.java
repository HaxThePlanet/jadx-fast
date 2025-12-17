package com.google.android.gms.common.util;

import android.os.Build.VERSION;

/* loaded from: classes2.dex */
public final class l {
    public static boolean a() {
        return 1;
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 16) {
            return 1;
        }
        return 0;
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT >= 18) {
            return 1;
        }
        return 0;
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT >= 19) {
            return 1;
        }
        return 0;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return 1;
        }
        return 0;
    }

    public static boolean f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return 1;
        }
        return 0;
    }

    public static boolean g() {
        if (Build.VERSION.SDK_INT >= 24) {
            return 1;
        }
        return 0;
    }

    public static boolean h() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 1;
        }
        return 0;
    }

    public static boolean i() {
        if (Build.VERSION.SDK_INT >= 28) {
            return 1;
        }
        return 0;
    }

    public static boolean j() {
        if (Build.VERSION.SDK_INT >= 29) {
            return 1;
        }
        return 0;
    }

    public static boolean k() {
        if (Build.VERSION.SDK_INT >= 30) {
            return 1;
        }
        return 0;
    }
}
