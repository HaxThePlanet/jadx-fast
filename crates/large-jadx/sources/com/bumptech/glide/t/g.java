package com.bumptech.glide.t;

import android.os.Build.VERSION;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class g {

    private static final double a = 1d;
    static {
        l /= d;
    }

    public static double a(long l) {
        return obj2 *= d;
    }

    public static long b() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }
}
