package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
public final class c {
    public static void a(long l, d0 d02, com.google.android.exoplayer2.l2.s[] s3Arr3) {
        int str2;
        int i2;
        int str;
        int i4;
        int i;
        int i9;
        int i6;
        int i3;
        int i5;
        int i7;
        int i8;
        str = 1;
        while (s3Arr3.a() > str) {
            i4 = c.c(s3Arr3);
            i11 += i4;
            if (i4 != -1) {
            } else {
            }
            v.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
            i = s3Arr3.f();
            s3Arr3.I(i);
            str = 1;
            if (i4 > s3Arr3.a()) {
            } else {
            }
            if (c.c(s3Arr3) == 4 && i4 >= 8) {
            }
            if (i4 >= 8) {
            }
            i4 = s3Arr3.D();
            i9 = 49;
            i6 = 0;
            if (i4 == i9) {
            } else {
            }
            i3 = i6;
            i7 = 47;
            if (i4 == i7) {
            }
            if (s3Arr3.x() == 181) {
            } else {
            }
            str2 = i6;
            if (i4 == i9) {
            }
            if (str2 != null) {
            }
            c.b(l, d02, s3Arr3);
            if (i3 == 1195456820) {
            } else {
            }
            str = i6;
            str2 &= str;
            if (i4 != i9) {
            } else {
            }
            if (s3Arr3.x() == 3) {
            } else {
            }
            str2 = str;
            if (i4 == i7 && s3Arr3.x() == 3) {
            } else {
            }
            s3Arr3.J(str);
            i3 = s3Arr3.n();
        }
    }

    public static void b(long l, d0 d02, com.google.android.exoplayer2.l2.s[] s3Arr3) {
        int i2;
        int i6;
        Object obj;
        int cmp;
        int i5;
        int i3;
        int i4;
        int i;
        int i7 = s3Arr3.x();
        int i12 = 1;
        i2 = i7 & 64 != 0 ? i12 : i6;
        if (i2 == 0) {
        }
        s3Arr3.J(i12);
        i8 *= 3;
        while (i6 < obj14.length) {
            obj = obj14[i6];
            s3Arr3.I(s3Arr3.e());
            obj.c(s3Arr3, i9);
            if (Long.compare(l, l2) != 0) {
            }
            i6++;
            obj.d(l, obj6, 1, i9, 0);
        }
    }

    private static int c(d0 d0) {
        int i3;
        int i;
        int i2;
        i3 = 0;
        while (d0.a() == 0) {
            i = d0.x();
        }
        return -1;
    }
}
