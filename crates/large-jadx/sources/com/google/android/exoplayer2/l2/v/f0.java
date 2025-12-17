package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.util.d0;

/* loaded from: classes2.dex */
public final class f0 {
    public static int a(byte[] bArr, int i2, int i3) {
        byte b;
        int i;
        while (i2 < i3) {
            if (bArr[i2] != 71) {
            }
            i2++;
        }
        return i2;
    }

    public static boolean b(byte[] bArr, int i2, int i3, int i4) {
        int i7;
        int i5;
        int i6;
        int i;
        final int i8 = 0;
        i7 = -4;
        i5 = i8;
        while (i7 <= 4) {
            i10 += i4;
            i5 = i8;
            i7++;
            i6 = 1;
        }
        return i8;
    }

    public static long c(d0 d0, int i2, int i3) {
        int i;
        int obj5;
        int obj6;
        d0.I(i2);
        final long l = -9223372036854775807L;
        if (d0.a() < 5) {
            return l;
        }
        obj5 = d0.n();
        if (i5 &= obj5 != 0) {
            return l;
        }
        if (i8 >>= 8 != i3) {
            return l;
        }
        int i10 = 0;
        obj5 = obj5 &= 32 != 0 ? obj6 : i10;
        if (obj5 == null) {
            return l;
        }
        i = 7;
        if (d0.x() >= i && d0.a() >= i) {
            if (d0.a() >= i) {
                i = 16;
                if (obj5 &= i == i) {
                } else {
                    obj6 = i10;
                }
                if (obj6 != null) {
                    obj5 = 6;
                    obj6 = new byte[obj5];
                    d0.j(obj6, i10, obj5);
                    return f0.d(obj6);
                }
            }
        }
        return l;
    }

    private static long d(byte[] bArr) {
        int i8 = 255;
        int i12 = 1;
        return i6 |= i10;
    }
}
