package com.bumptech.glide.t;

import android.os.Build.VERSION;
import android.os.SystemClock;

/* compiled from: LogTime.java */
/* loaded from: classes.dex */
public final class g {

    private static final double a = 0.0d;
    static {
        double d = 4607182418800017408L;
        d = 1d;
        int i = 17;
        if (Build.VERSION.SDK_INT >= 17) {
            double d2 = 6d;
            d = 1d / (Math.pow(10d, d2));
        }
        g.a = d;
    }

    public static double a(long j) {
        return (double)(g.b() - j) * g.a;
    }

    public static long b() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }
}
