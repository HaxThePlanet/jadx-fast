package com.google.android.exoplayer2.video.b0;

import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
final class i {
    public static com.google.android.exoplayer2.video.b0.h a(byte[] bArr, int i2) {
        ArrayList list;
        d0 d0Var = new d0(bArr);
        int obj5 = 0;
        if (i.c(d0Var)) {
            list = i.f(d0Var);
        } else {
            list = i.e(d0Var);
        }
        if (list == null) {
            return obj5;
        }
        try {
            int size = list.size();
            final int i = 0;
            final int i3 = 1;
            if (size != i3 && size != 2) {
            }
            if (size != 2) {
            }
            return obj5;
            obj5 = new h((h.a)list.get(i), (h.a)list.get(i3), i2);
            return obj5;
            obj5 = new h((h.a)list.get(i), i2);
            return obj5;
        }
    }

    private static int b(int i) {
        return obj1 ^= i2;
    }

    private static boolean c(d0 d0) {
        int i;
        d0.J(4);
        d0.I(0);
        if (d0.n() == 1886547818) {
            i = 1;
        }
        return i;
    }

    private static com.google.android.exoplayer2.video.b0.h.a d(d0 d0) {
        int i10;
        int i4;
        int i9;
        float f2;
        long l;
        int i5;
        double d;
        int i3;
        int i2;
        int i6;
        int fArr;
        int[] iArr;
        int i8;
        int i;
        int i7;
        float f4;
        int i11;
        float f5;
        float f;
        float f3;
        int i12 = d0.n();
        final int i18 = 0;
        if (i12 > 10000) {
            return i18;
        }
        float[] fArr3 = new float[i12];
        i9 = 0;
        while (i9 < i12) {
            fArr3[i9] = d0.m();
            i9++;
        }
        int i21 = d0.n();
        if (i21 > 32000) {
            return i18;
        }
        l = 4611686018427387904L;
        final double d2 = Math.log(l);
        c0 c0Var = new c0(d0.d());
        c0Var.o(i26 *= i6);
        float[] fArr4 = new float[i21 * 5];
        iArr = new int[5];
        i8 = 0;
        i = 0;
        while (i8 < i21) {
            i4 = 0;
            while (i4 < fArr) {
                int i32 = i35 + i37;
                if (i32 < i12) {
                    break loop_10;
                }
                fArr4[i] = fArr3[i32];
                iArr[i4] = i32;
                i4++;
                i = i7;
                fArr = 5;
            }
            i8++;
            fArr = 5;
            i32 = i35 + i37;
            if (i32 < i12) {
                break;
            }
            fArr4[i] = fArr3[i32];
            iArr[i4] = i32;
            i4++;
            i = i7;
            fArr = 5;
        }
        c0Var.o(i14 &= -8);
        int i20 = c0Var.h(32);
        com.google.android.exoplayer2.video.b0.h.b[] arr = new h.b[i20];
        i2 = 0;
        while (i2 < i20) {
            int i33 = c0Var.h(i6);
            i8 = c0Var.h(i10);
            fArr = new float[i8 * 3];
            float[] fArr2 = new float[i8 * 2];
            i5 = 0;
            i3 = 0;
            while (i5 < i8) {
                i3 += i39;
                int i40 = i5 * 3;
                int i43 = i3 * 5;
                fArr[i40] = fArr4[i43];
                fArr[i40 + 1] = fArr4[i43 + 1];
                fArr[i40 += 2] = fArr4[i43 + 2];
                int i42 = i5 * 2;
                fArr2[i42] = fArr4[i43 + 3];
                fArr2[i42++] = fArr4[i43 += 4];
                i5++;
            }
            h.b bVar = new h.b(i33, fArr, fArr2, c0Var.h(i6));
            arr[i2] = bVar;
            i2++;
            i10 = 32;
            l = 4611686018427387904L;
            i6 = 8;
            i3 += i39;
            i40 = i5 * 3;
            i43 = i3 * 5;
            fArr[i40] = fArr4[i43];
            fArr[i40 + 1] = fArr4[i43 + 1];
            fArr[i40 += 2] = fArr4[i43 + 2];
            i42 = i5 * 2;
            fArr2[i42] = fArr4[i43 + 3];
            fArr2[i42++] = fArr4[i43 += 4];
            i5++;
        }
        h.a aVar = new h.a(arr);
        return aVar;
    }

    private static ArrayList<com.google.android.exoplayer2.video.b0.h.a> e(d0 d0) {
        int d0Var;
        int inflater;
        int i;
        d0 obj4;
        final int i4 = 0;
        if (d0.x() != 0) {
            return i4;
        }
        d0.J(7);
        d0Var = d0.n();
        if (d0Var == 1684433976) {
            d0Var = new d0();
            inflater = new Inflater(1);
            if (!p0.e0(d0, d0Var, inflater)) {
                inflater.end();
                return i4;
            }
            inflater.end();
            obj4 = d0Var;
        } else {
            if (d0Var != 1918990112) {
                return i4;
            }
        }
        return i.g(obj4);
    }

    private static ArrayList<com.google.android.exoplayer2.video.b0.h.a> f(d0 d0) {
        int i3;
        int i;
        int i2;
        d0.J(8);
        i3 = d0.e();
        final int i6 = d0.f();
        while (i3 < i6) {
            i8 += i3;
            int i5 = d0.n();
            d0.I(i2);
            i3 = i2;
        }
        return 0;
    }

    private static ArrayList<com.google.android.exoplayer2.video.b0.h.a> g(d0 d0) {
        int i4;
        int i;
        int i3;
        int i2;
        int i5;
        ArrayList arrayList = new ArrayList();
        i4 = d0.e();
        final int i6 = d0.f();
        while (i4 < i6) {
            i7 += i4;
            i2 = 0;
            d0.I(i3);
            i4 = i3;
            i = i.d(d0);
            arrayList.add(i);
        }
        return arrayList;
    }
}
