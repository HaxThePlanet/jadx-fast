package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.j;

/* loaded from: classes2.dex */
public final class u4 {
    public static String a(Context context) {
        String obj2;
        try {
            obj2 = context.getResources().getResourcePackageName(j.a);
            context = context.getPackageName();
            return obj2;
        }
    }

    public static final String b(String string, Resources resources2, String string3) {
        int obj3;
        final int obj1 = resources2.getIdentifier(string, "string", string3);
        obj3 = 0;
        if (obj1 == null) {
        } else {
            obj3 = resources2.getString(obj1);
        }
        return obj3;
    }
}
