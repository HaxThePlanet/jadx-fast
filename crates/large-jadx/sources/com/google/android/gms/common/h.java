package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.a1;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.common.util.i;
import com.google.android.gms.common.util.l;
import com.google.android.gms.common.util.o;
import com.google.android.gms.common.util.r;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class h {

    @Deprecated
    public static final int a = 12451000;
    static final AtomicBoolean b = null;
    private static boolean c = false;
    static boolean d = false;
    private static final AtomicBoolean e;
    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        h.b = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        h.e = atomicBoolean2;
    }

    @Deprecated
    public static void a(Context context, int i2) {
        final int obj3 = f.f().h(context, i2);
        android.content.Intent obj2 = f.f().b(context, obj3, "e");
        StringBuilder stringBuilder = new StringBuilder(57);
        stringBuilder.append("GooglePlayServices not available due to error ");
        stringBuilder.append(obj3);
        Log.e("GooglePlayServicesUtil", stringBuilder.toString());
        if (obj3 != null && obj2 == null) {
            obj2 = f.f().b(context, obj3, "e");
            stringBuilder = new StringBuilder(57);
            stringBuilder.append("GooglePlayServices not available due to error ");
            stringBuilder.append(obj3);
            Log.e("GooglePlayServicesUtil", stringBuilder.toString());
            if (obj2 == null) {
                obj2 = new GooglePlayServicesNotAvailableException(obj3);
                throw obj2;
            }
            GooglePlayServicesRepairableException googlePlayServicesRepairableException = new GooglePlayServicesRepairableException(obj3, "Google Play Services not available", obj2);
            throw googlePlayServicesRepairableException;
        }
    }

    @Deprecated
    public static int b(Context context) {
        return obj2.versionCode;
    }

    @Deprecated
    public static String c(int i) {
        return b.o2(i);
    }

    public static Context d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
            context = 0;
            return context;
        }
    }

    public static Resources e(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            context = 0;
            return context;
        }
    }

    public static boolean f(Context context) {
        boolean z;
        String str;
        int i;
        Context obj5;
        final int i2 = 0;
        final int i3 = 1;
        if (!h.d) {
            z = c.a(context).e("com.google.android.gms", 64);
            i.a(context);
            if (z != null && !i.e(z, i2) && i.e(z, i3)) {
                if (!i.e(z, i2)) {
                    if (i.e(z, i3)) {
                        h.c = i3;
                    } else {
                        h.c = i2;
                    }
                } else {
                }
            } else {
            }
            try {
                h.d = i3;
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", context);
                h.d = obj2;
                h.d = obj2;
                throw context;
                if (!h.c && !i.c()) {
                }
                if (!i.c()) {
                }
                return i2;
                return i3;
            } catch (Throwable th) {
            }
        }
    }

    @Deprecated
    public static int g(Context context, int i2) {
        Resources resources;
        boolean equals;
        int str;
        boolean z;
        Object stringBuilder;
        int i4;
        int i;
        int i3;
        android.content.pm.PackageInfo packageInfo;
        int i5;
        boolean obj10;
        int obj11;
        final String str2 = "GooglePlayServicesUtil";
        context.getResources().getString(j.a);
        try {
            stringBuilder = "com.google.android.gms";
            if (!stringBuilder.equals(context.getPackageName())) {
            }
            equals = a1.a(context);
            obj10 = new GooglePlayServicesIncorrectManifestValueException(equals);
            throw obj10;
            obj10 = new GooglePlayServicesMissingManifestValueException();
            throw obj10;
            int i8 = 1;
            final int i9 = 0;
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
        }
        str = !i.h(context) ? i8 : i9;
        i3 = i2 >= 0 ? i8 : i9;
        r.a(i3);
        String packageName2 = context.getPackageName();
        final PackageManager packageManager = context.getPackageManager();
        if (str != null) {
            packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
        } else {
            packageInfo = 0;
        }
        android.content.pm.PackageInfo packageInfo2 = packageManager.getPackageInfo(stringBuilder, 64);
        i.a(context);
        if (!i.e(packageInfo2, i8)) {
            i = i10;
            return i;
        } else {
        }
        return i9;
    }

    @Deprecated
    public static boolean h(Context context, int i2) {
        final int i = 1;
        if (i2 == 18) {
            return i;
        }
        if (i2 == i) {
            return h.l(context, "com.google.android.gms");
        }
        return 0;
    }

    public static boolean i(Context context) {
        boolean systemService;
        Bundle obj1;
        systemService = context.getSystemService("user");
        r.j(systemService);
        obj1 = (UserManager)systemService.getApplicationRestrictions(context.getPackageName());
        if (l.c() && obj1 != null && "true".equals(obj1.getString("restricted_profile")) != null) {
            systemService = context.getSystemService("user");
            r.j(systemService);
            obj1 = (UserManager)systemService.getApplicationRestrictions(context.getPackageName());
            if (obj1 != null) {
                if ("true".equals(obj1.getString("restricted_profile")) != null) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Deprecated
    public static boolean j(int i) {
        int i2;
        final int i3 = 1;
        if (i != i3 && i != 2 && i != 3 && i != 9) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 9) {
                        return 0;
                    }
                }
            }
        }
        return i3;
    }

    @Deprecated
    public static boolean k(Context context, int i2, String string3) {
        return o.b(context, i2, string3);
    }

    static boolean l(Context context, String string2) {
        boolean iterator;
        boolean equals;
        Context obj5;
        final int i = 1;
        if (l.f()) {
            iterator = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            for (PackageInstaller.SessionInfo next : iterator) {
            }
        }
        android.content.pm.ApplicationInfo obj6 = context.getPackageManager().getApplicationInfo(string2, 8192);
        if (string2.equals("com.google.android.gms")) {
            return obj6.enabled;
        }
        if (obj6.enabled && !h.i(context)) {
            if (!h.i(context)) {
                return i;
            }
        }
        return 0;
    }
}
