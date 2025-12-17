package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.i;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;

/* loaded from: classes2.dex */
public final class o {
    public static boolean a(Context context, int i2) {
        final String str = "com.google.android.gms";
        if (!o.b(context, i2, str)) {
            return 0;
        }
        return i.a(context).b(context.getPackageManager().getPackageInfo(str, 64));
    }

    public static boolean b(Context context, int i2, String string3) {
        return c.a(context).g(i2, string3);
    }
}
