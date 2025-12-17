package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.v1;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.common.util.i;

/* loaded from: classes2.dex */
public class f {

    public static final int a;
    private static final com.google.android.gms.common.f b;
    static {
        f.a = h.a;
        f fVar = new f();
        f.b = fVar;
    }

    public static com.google.android.gms.common.f f() {
        return f.b;
    }

    public int a(Context context) {
        return h.b(context);
    }

    public Intent b(Context context, int i2, String string3) {
        int i;
        String str;
        Context obj4;
        int obj5;
        Object obj6;
        final String str3 = "com.google.android.gms";
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return v1.a(str3);
            }
        }
        if (context != null && !i.f(context)) {
            if (!i.f(context)) {
            }
            return v1.c();
        }
        obj5 = new StringBuilder();
        obj5.append("gcore_");
        obj5.append(f.a);
        str = "-";
        obj5.append(str);
        if (!TextUtils.isEmpty(string3)) {
            obj5.append(string3);
        }
        obj5.append(str);
        if (context != null) {
            obj5.append(context.getPackageName());
        }
        obj5.append(str);
        if (context != null) {
            obj5.append(obj4.versionCode);
        }
        return v1.b(str3, obj5.toString());
    }

    public PendingIntent c(Context context, int i2, int i3) {
        return d(context, i2, i3, 0);
    }

    public PendingIntent d(Context context, int i2, int i3, String string4) {
        final Intent obj2 = b(context, i2, string4);
        if (obj2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, obj2, 134217728);
    }

    public String e(int i) {
        return h.c(i);
    }

    public int g(Context context) {
        return h(context, f.a);
    }

    public int h(Context context, int i2) {
        final int obj2 = h.g(context, i2);
        if (h.h(context, obj2)) {
            return 18;
        }
        return obj2;
    }

    public boolean i(Context context, String string2) {
        return h.l(context, string2);
    }

    public boolean j(int i) {
        return h.j(i);
    }

    public void k(Context context, int i2) {
        h.a(context, i2);
    }
}
