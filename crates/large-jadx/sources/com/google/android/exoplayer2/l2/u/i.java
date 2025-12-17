package com.google.android.exoplayer2.l2.u;

import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.util.d0;
import com.google.firebase.database.R.integer;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.storage.FirebaseStorage.1;
import com.google.protobuf.w0;

/* loaded from: classes2.dex */
final class i {

    private static final int[] a;
    static {
        int[] iArr = new int[29];
        iArr = new int[]{
            1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857,
            1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552,
            1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686
        };
        i.a = iArr;
    }

    private static boolean a(int i, boolean z2) {
        int i3;
        int i2;
        final int i6 = 1;
        if (i >>> 8 == 3368816) {
            return i6;
        }
        if (i == 1751476579 && z2) {
            if (z2) {
                return i6;
            }
        }
        final int[] obj6 = i.a;
        int i8 = 0;
        i3 = i8;
        while (i3 < obj6.length) {
            i3++;
        }
        return i8;
    }

    public static boolean b(j j) {
        return i.c(j, true, false);
    }

    private static boolean c(j j, boolean z2, boolean z3) {
        int i7;
        long length2;
        int i4;
        int i15;
        int i10;
        int i8;
        int i14;
        byte[] cmp3;
        int i17;
        boolean z;
        int i5;
        int i12;
        int cmp4;
        int i2;
        int i16;
        int i11;
        int i3;
        int i;
        int i6;
        int cmp2;
        int i9;
        long l;
        int i13;
        int cmp;
        int length;
        long l2;
        Object obj = j;
        length2 = j.getLength();
        final int cmp5 = Long.compare(length2, i14);
        if (cmp5 != 0) {
            if (Long.compare(length2, i5) > 0) {
            } else {
                i5 = length2;
            }
        }
        i12 = (int)i5;
        d0 d0Var = new d0(64);
        i3 = i11;
        i = 1;
        while (i11 < i12) {
            i9 = 8;
            d0Var.E(i9);
            l = d0Var.z();
            i13 = d0Var.n();
            if (Long.compare(l, i26) == 0) {
            } else {
            }
            length = j.getLength();
            if (Long.compare(l, length) == 0 && Long.compare(length, i14) != 0) {
            }
            i6 = i9;
            cmp3 = (long)i6;
            i11 += i6;
            i4 = (int)l;
            i11 = cmp + i4;
            i2 = z3;
            i15 = 0;
            if (i4 != 0) {
            }
            i2 = i15;
            length2 = l2;
            i14 = -1;
            i = 1;
            obj.g(i4);
            d0Var.E(i4);
            obj.m(d0Var.d(), 0, i4);
            i10 = 0;
            while (i10 < i4 /= 4) {
                cmp3 = 1;
                i10++;
                d0Var.J(4);
                i2 = z3;
            }
            i2 = z3;
            i15 = 0;
            cmp3 = 1;
            if (i10 == cmp3) {
            } else {
            }
            if (i.a(d0Var.n(), z3)) {
            } else {
            }
            i10++;
            i3 = cmp3;
            d0Var.J(4);
            i2 = z3;
            if (cmp5 != 0 && Long.compare(l4, length2) > 0) {
            }
            if (Long.compare(l4, length2) > 0) {
            }
            i12 = (int)length2;
            length = j.getLength();
            if (Long.compare(length, i14) != 0) {
            }
            l6 += length;
            obj.m(d0Var.d(), i9, i9);
            d0Var.H(16);
            l = d0Var.r();
        }
        i8 = i2;
        i17 = i;
        i7 = i8;
        if (i3 != 0 && z2 == i7) {
            i16 = z2 == i7 ? i17 : i8;
        } else {
        }
        return i16;
    }
}
