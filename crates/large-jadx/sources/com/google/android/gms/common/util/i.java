package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.h;

/* loaded from: classes2.dex */
public final class i {

    private static Boolean a;
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;
    public static boolean a(Context context) {
        return i.b(context.getPackageManager());
    }

    public static boolean b(PackageManager packageManager) {
        boolean str;
        int i;
        boolean obj2;
        i = 0;
        if (i.d == null && l.h() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
            i = 0;
            if (l.h()) {
                if (packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                    i = 1;
                }
            }
            i.d = Boolean.valueOf(i);
        }
        return i.d.booleanValue();
    }

    public static boolean c() {
        int i = h.a;
        return "user".equals(Build.TYPE);
    }

    public static boolean d(Context context) {
        return i.e(context.getPackageManager());
    }

    public static boolean e(PackageManager packageManager) {
        boolean str;
        int i;
        boolean obj2;
        i = 0;
        if (i.a == null && l.e() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
            i = 0;
            if (l.e()) {
                if (packageManager.hasSystemFeature("android.hardware.type.watch")) {
                    i = 1;
                }
            }
            i.a = Boolean.valueOf(i);
        }
        return i.a.booleanValue();
    }

    public static boolean f(Context context) {
        boolean z;
        int i;
        Context obj3;
        if (i.d(context)) {
            if (l.g() && i.g(context) && l.h()) {
                if (i.g(context)) {
                    if (l.h()) {
                    }
                    return 1;
                }
                i = i2;
            }
        } else {
        }
        return i;
    }

    public static boolean g(Context context) {
        boolean str;
        int i;
        boolean obj2;
        i = 0;
        if (i.b == null && l.f() && context.getPackageManager().hasSystemFeature("cn.google")) {
            i = 0;
            if (l.f()) {
                if (context.getPackageManager().hasSystemFeature("cn.google")) {
                    i = 1;
                }
            }
            i.b = Boolean.valueOf(i);
        }
        return i.b.booleanValue();
    }

    public static boolean h(Context context) {
        boolean systemFeature;
        int i;
        boolean obj2;
        i = 1;
        if (i.c == null && !context.getPackageManager().hasSystemFeature("android.hardware.type.iot")) {
            i = 1;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot")) {
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                } else {
                    i = 0;
                }
            }
            i.c = Boolean.valueOf(i);
        }
        return i.c.booleanValue();
    }
}
