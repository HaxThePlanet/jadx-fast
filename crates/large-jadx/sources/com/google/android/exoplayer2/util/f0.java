package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class f0 {
    public static int a(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        i3 = 1;
        while (i3 <= 2) {
            i6 %= 3;
            i3++;
        }
        return i;
    }

    public static boolean b(int i, int i2) {
        int i3;
        int i4;
        int obj3;
        i4 = 0;
        if (i != 0 && i != 1 && i != 2) {
            i4 = 0;
            if (i != 1) {
                if (i != 2) {
                    return i4;
                }
                if (i2 & 2 != 0) {
                } else {
                    i3 = i4;
                }
                return i3;
            }
            if (i2 & 1 != 0) {
            } else {
                i3 = i4;
            }
        }
        return i3;
    }
}
