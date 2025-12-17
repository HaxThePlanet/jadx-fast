package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class g {
    static {
    }

    public static boolean a(Context context, Throwable throwable2) {
        String str;
        Object obj1;
        Object obj2;
        try {
            r.j(context);
            r.j(throwable2);
            throwable2 = "CrashUtils";
            Log.e(throwable2, "Error adding exception to DropBox!", context);
            return 0;
        }
    }
}
