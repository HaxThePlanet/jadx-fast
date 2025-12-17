package com.google.android.gms.internal.measurement;

import android.os.Build.VERSION;

/* loaded from: classes2.dex */
public final class x5 {
    static {
        x5.a();
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return 1;
        }
        return 0;
    }
}
