package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public interface a2 {
    public static int B(int i) {
        return i &= 7;
    }

    public static int d(int i) {
        return i &= 32;
    }

    public static int n(int i, int i2, int i3) {
        return obj0 |= i3;
    }

    public static int q(int i) {
        return i &= 24;
    }

    public static int r(int i) {
        final int i2 = 0;
        return a2.n(i, i2, i2);
    }

    public abstract int b(com.google.android.exoplayer2.i1 i1);

    public abstract String getName();

    public abstract int i();

    public abstract int t();
}
