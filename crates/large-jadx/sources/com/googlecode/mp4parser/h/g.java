package com.googlecode.mp4parser.h;

/* loaded from: classes2.dex */
public class g {
    public static long a(long l, long l2) {
        final int obj4 = obj6;
        int obj6 = i2;
        while (Long.compare(obj4, i) <= 0) {
            obj6 %= obj4;
            obj4 = obj6;
            obj6 = i2;
        }
        return obj6;
    }

    public static long b(long l, long l2) {
        return l *= obj4;
    }
}
