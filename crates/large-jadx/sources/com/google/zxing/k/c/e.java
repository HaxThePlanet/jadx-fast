package com.google.zxing.k.c;

import android.accounts.Account;
import com.google.zxing.WriterException;
import com.google.zxing.g.a;
import com.google.zxing.k.b.a;
import com.google.zxing.k.b.c;

/* loaded from: classes2.dex */
final class e {

    private static final int[][] a;
    private static final int[][] b;
    private static final int[][] c;
    private static final int[][] d;
    static {
        int i2 = 7;
        int[][] iArr8 = new int[i2];
        int[] iArr12 = new int[i2];
        iArr12 = new int[]{1, 1, 1, 1, 1, 1, 1};
        final int i5 = 0;
        iArr8[i5] = iArr12;
        int[] iArr13 = new int[i2];
        iArr13 = new int[]{1, 0, 0, 0, 0, 0, 1};
        final int i6 = 1;
        iArr8[i6] = iArr13;
        int[] iArr14 = new int[i2];
        iArr14 = new int[]{1, 0, 1, 1, 1, 0, 1};
        final int i7 = 2;
        iArr8[i7] = iArr14;
        int[] iArr15 = new int[i2];
        iArr15 = new int[]{1, 0, 1, 1, 1, 0, 1};
        final int i8 = 3;
        iArr8[i8] = iArr15;
        int[] iArr16 = new int[i2];
        iArr16 = new int[]{1, 0, 1, 1, 1, 0, 1};
        final int i9 = 4;
        iArr8[i9] = iArr16;
        int[] iArr17 = new int[i2];
        iArr17 = new int[]{1, 0, 0, 0, 0, 0, 1};
        final int i10 = 5;
        iArr8[i10] = iArr17;
        int[] iArr18 = new int[i2];
        iArr18 = new int[]{1, 1, 1, 1, 1, 1, 1};
        final int i11 = 6;
        iArr8[i11] = iArr18;
        e.a = iArr8;
        int[][] iArr9 = new int[i10];
        int[] iArr19 = new int[i10];
        iArr19 = new int[]{1, 1, 1, 1, 1};
        iArr9[i5] = iArr19;
        int[] iArr20 = new int[i10];
        iArr20 = new int[]{1, 0, 0, 0, 1};
        iArr9[i6] = iArr20;
        int[] iArr21 = new int[i10];
        iArr21 = new int[]{1, 0, 1, 0, 1};
        iArr9[i7] = iArr21;
        int[] iArr22 = new int[i10];
        iArr22 = new int[]{1, 0, 0, 0, 1};
        iArr9[i8] = iArr22;
        int[] iArr23 = new int[i10];
        iArr23 = new int[]{1, 1, 1, 1, 1};
        iArr9[i9] = iArr23;
        e.b = iArr9;
        int[][] iArr10 = new int[40];
        int[] iArr24 = new int[i2];
        iArr24 = new int[]{-1, -1, -1, -1, -1, -1, -1};
        iArr10[i5] = iArr24;
        int[] iArr25 = new int[i2];
        iArr25 = new int[]{6, 18, -1, -1, -1, -1, -1};
        iArr10[i6] = iArr25;
        int[] iArr26 = new int[i2];
        iArr26 = new int[]{6, 22, -1, -1, -1, -1, -1};
        iArr10[i7] = iArr26;
        int[] iArr27 = new int[i2];
        iArr27 = new int[]{6, 26, -1, -1, -1, -1, -1};
        iArr10[i8] = iArr27;
        int[] iArr28 = new int[i2];
        iArr28 = new int[]{6, 30, -1, -1, -1, -1, -1};
        iArr10[i9] = iArr28;
        int[] iArr29 = new int[i2];
        iArr29 = new int[]{6, 34, -1, -1, -1, -1, -1};
        iArr10[i10] = iArr29;
        int[] iArr30 = new int[i2];
        iArr30 = new int[]{6, 22, 38, -1, -1, -1, -1};
        iArr10[i11] = iArr30;
        int[] iArr31 = new int[i2];
        iArr31 = new int[]{6, 24, 42, -1, -1, -1, -1};
        iArr10[i2] = iArr31;
        int[] iArr32 = new int[i2];
        iArr32 = new int[]{6, 26, 46, -1, -1, -1, -1};
        final int i12 = 8;
        iArr10[i12] = iArr32;
        int[] iArr33 = new int[i2];
        iArr33 = new int[]{6, 28, 50, -1, -1, -1, -1};
        final int i13 = 9;
        iArr10[i13] = iArr33;
        int[] iArr34 = new int[i2];
        iArr34 = new int[]{6, 30, 54, -1, -1, -1, -1};
        final int i14 = 10;
        iArr10[i14] = iArr34;
        int[] iArr35 = new int[i2];
        iArr35 = new int[]{6, 32, 58, -1, -1, -1, -1};
        final int i15 = 11;
        iArr10[i15] = iArr35;
        int[] iArr36 = new int[i2];
        iArr36 = new int[]{6, 34, 62, -1, -1, -1, -1};
        final int i16 = 12;
        iArr10[i16] = iArr36;
        int[] iArr37 = new int[i2];
        iArr37 = new int[]{6, 26, 46, 66, -1, -1, -1};
        iArr10[13] = iArr37;
        int[] iArr38 = new int[i2];
        iArr38 = new int[]{6, 26, 48, 70, -1, -1, -1};
        final int i19 = 14;
        iArr10[i19] = iArr38;
        int[] iArr39 = new int[i2];
        iArr39 = new int[]{6, 26, 50, 74, -1, -1, -1};
        int i18 = 15;
        iArr10[i18] = iArr39;
        int[] iArr40 = new int[i2];
        iArr40 = new int[]{6, 30, 54, 78, -1, -1, -1};
        iArr10[16] = iArr40;
        int[] iArr41 = new int[i2];
        iArr41 = new int[]{6, 30, 56, 82, -1, -1, -1};
        iArr10[17] = iArr41;
        int[] iArr42 = new int[i2];
        iArr42 = new int[]{6, 30, 58, 86, -1, -1, -1};
        iArr10[18] = iArr42;
        int[] iArr43 = new int[i2];
        iArr43 = new int[]{6, 34, 62, 90, -1, -1, -1};
        iArr10[19] = iArr43;
        int[] iArr44 = new int[i2];
        iArr44 = new int[]{6, 28, 50, 72, 94, -1, -1};
        iArr10[20] = iArr44;
        int[] iArr45 = new int[i2];
        iArr45 = new int[]{6, 26, 50, 74, 98, -1, -1};
        iArr10[21] = iArr45;
        int[] iArr46 = new int[i2];
        iArr46 = new int[]{6, 30, 54, 78, 102, -1, -1};
        iArr10[22] = iArr46;
        int[] iArr47 = new int[i2];
        iArr47 = new int[]{6, 28, 54, 80, 106, -1, -1};
        iArr10[23] = iArr47;
        int[] iArr48 = new int[i2];
        iArr48 = new int[]{6, 32, 58, 84, 110, -1, -1};
        iArr10[24] = iArr48;
        int[] iArr49 = new int[i2];
        iArr49 = new int[]{6, 30, 58, 86, 114, -1, -1};
        iArr10[25] = iArr49;
        int[] iArr50 = new int[i2];
        iArr50 = new int[]{6, 34, 62, 90, 118, -1, -1};
        iArr10[26] = iArr50;
        int[] iArr51 = new int[i2];
        iArr51 = new int[]{6, 26, 50, 74, 98, 122, -1};
        iArr10[27] = iArr51;
        int[] iArr52 = new int[i2];
        iArr52 = new int[]{6, 30, 54, 78, 102, 126, -1};
        iArr10[28] = iArr52;
        int[] iArr53 = new int[i2];
        iArr53 = new int[]{6, 26, 52, 78, 104, 130, -1};
        iArr10[29] = iArr53;
        int[] iArr54 = new int[i2];
        iArr54 = new int[]{6, 30, 56, 82, 108, 134, -1};
        iArr10[30] = iArr54;
        int[] iArr55 = new int[i2];
        iArr55 = new int[]{6, 34, 60, 86, 112, 138, -1};
        iArr10[31] = iArr55;
        int[] iArr56 = new int[i2];
        iArr56 = new int[]{6, 30, 58, 86, 114, 142, -1};
        iArr10[32] = iArr56;
        int[] iArr57 = new int[i2];
        iArr57 = new int[]{6, 34, 62, 90, 118, 146, -1};
        iArr10[33] = iArr57;
        int[] iArr58 = new int[i2];
        iArr58 = new int[]{6, 30, 54, 78, 102, 126, 150};
        iArr10[34] = iArr58;
        int[] iArr59 = new int[i2];
        iArr59 = new int[]{6, 24, 50, 76, 102, 128, 154};
        iArr10[35] = iArr59;
        int[] iArr60 = new int[i2];
        iArr60 = new int[]{6, 28, 54, 80, 106, 132, 158};
        iArr10[36] = iArr60;
        int[] iArr61 = new int[i2];
        iArr61 = new int[]{6, 32, 58, 84, 110, 136, 162};
        iArr10[37] = iArr61;
        int[] iArr62 = new int[i2];
        iArr62 = new int[]{6, 26, 54, 82, 110, 138, 166};
        iArr10[38] = iArr62;
        int[] iArr63 = new int[i2];
        iArr63 = new int[]{6, 30, 58, 86, 114, 142, 170};
        iArr10[39] = iArr63;
        e.c = iArr10;
        int[][] iArr11 = new int[i18];
        int[] iArr64 = new int[i7];
        iArr64 = new int[]{8, 0};
        iArr11[i5] = iArr64;
        int[] iArr65 = new int[i7];
        iArr65 = new int[]{8, 1};
        iArr11[i6] = iArr65;
        int[] iArr66 = new int[i7];
        iArr66 = new int[]{8, 2};
        iArr11[i7] = iArr66;
        int[] iArr67 = new int[i7];
        iArr67 = new int[]{8, 3};
        iArr11[i8] = iArr67;
        int[] iArr68 = new int[i7];
        iArr68 = new int[]{8, 4};
        iArr11[i9] = iArr68;
        int[] iArr69 = new int[i7];
        iArr69 = new int[]{8, 5};
        iArr11[i10] = iArr69;
        int[] iArr70 = new int[i7];
        iArr70 = new int[]{8, 7};
        iArr11[i11] = iArr70;
        int[] iArr71 = new int[i7];
        iArr71 = new int[]{8, 8};
        iArr11[i2] = iArr71;
        int[] iArr = new int[i7];
        iArr = new int[]{7, 8};
        iArr11[i12] = iArr;
        int[] iArr2 = new int[i7];
        iArr2 = new int[]{5, 8};
        iArr11[i13] = iArr2;
        int[] iArr3 = new int[i7];
        iArr3 = new int[]{4, 8};
        iArr11[i14] = iArr3;
        int[] iArr4 = new int[i7];
        iArr4 = new int[]{3, 8};
        iArr11[i15] = iArr4;
        int[] iArr5 = new int[i7];
        iArr5 = new int[]{2, 8};
        iArr11[i16] = iArr5;
        int[] iArr6 = new int[i7];
        iArr6 = new int[]{1, 8};
        iArr11[13] = iArr6;
        int[] iArr7 = new int[i7];
        iArr7 = new int[]{0, 8};
        iArr11[i19] = iArr7;
        e.d = iArr11;
    }

    static void a(a a, a a2, c c3, int i4, com.google.zxing.k.c.b b5) {
        e.c(b5);
        e.d(c3, b5);
        e.l(a2, i4, b5);
        e.s(c3, b5);
        e.f(a, i4, b5);
    }

    static int b(int i, int i2) {
        int i3;
        int obj2;
        if (i2 == 0) {
        } else {
            final int i4 = e.n(i2);
            i <<= i3;
            while (e.n(obj2) >= i4) {
                obj2 ^= i3;
            }
            return obj2;
        }
        obj2 = new IllegalArgumentException("0 polynomial");
        throw obj2;
    }

    static void c(com.google.zxing.k.c.b b) {
        b.a(-1);
    }

    static void d(c c, com.google.zxing.k.c.b b2) {
        e.j(b2);
        e.e(b2);
        e.r(c, b2);
        e.k(b2);
    }

    private static void e(com.google.zxing.k.c.b b) {
        final int i5 = 8;
        if (b.b(i5, i -= i5) == 0) {
        } else {
            b.f(i5, i3 -= i5, 1);
        }
        WriterException obj3 = new WriterException();
        throw obj3;
    }

    static void f(a a, int i2, com.google.zxing.k.c.b b3) {
        int i3;
        int i;
        int i4;
        int i6;
        int i7;
        int i5;
        boolean z2;
        boolean z;
        i8--;
        i10--;
        final int i11 = -1;
        final int i12 = 0;
        i6 = i11;
        i4 = i12;
        while (i3 > 0) {
            if (i3 == 6) {
            }
            while (i >= 0) {
                if (i < b3.d()) {
                }
                i7 = i12;
                while (i7 < 2) {
                    i5 = i3 - i7;
                    if (e.o(b3.b(i5, i))) {
                    }
                    i7++;
                    if (i4 < a.g()) {
                    } else {
                    }
                    z2 = i12;
                    if (i2 != i11 && d.f(i2, i5, i)) {
                    }
                    b3.g(i5, i, z2);
                    if (d.f(i2, i5, i)) {
                    }
                    z2 ^= 1;
                    z2 = a.f(i4);
                    i4++;
                }
                i += i6;
                i5 = i3 - i7;
                if (e.o(b3.b(i5, i))) {
                }
                i7++;
                if (i4 < a.g()) {
                } else {
                }
                z2 = i12;
                if (i2 != i11 && d.f(i2, i5, i)) {
                }
                b3.g(i5, i, z2);
                if (d.f(i2, i5, i)) {
                }
                z2 ^= 1;
                z2 = a.f(i4);
                i4++;
            }
            i += i6;
            i3 += -2;
            if (i < b3.d()) {
            }
            i7 = i12;
            while (i7 < 2) {
                i5 = i3 - i7;
                if (e.o(b3.b(i5, i))) {
                }
                i7++;
                if (i4 < a.g()) {
                } else {
                }
                z2 = i12;
                if (i2 != i11 && d.f(i2, i5, i)) {
                }
                b3.g(i5, i, z2);
                if (d.f(i2, i5, i)) {
                }
                z2 ^= 1;
                z2 = a.f(i4);
                i4++;
            }
            i += i6;
            i5 = i3 - i7;
            if (e.o(b3.b(i5, i))) {
            }
            i7++;
            if (i4 < a.g()) {
            } else {
            }
            z2 = i12;
            if (i2 != i11 && d.f(i2, i5, i)) {
            }
            b3.g(i5, i, z2);
            if (d.f(i2, i5, i)) {
            }
            z2 ^= 1;
            z2 = a.f(i4);
            i4++;
            i3--;
        }
        if (i4 != a.g()) {
        } else {
        }
        StringBuilder obj12 = new StringBuilder("Not all bits consumed: ");
        obj12.append(i4);
        obj12.append('/');
        obj12.append(a.g());
        WriterException obj11 = new WriterException(obj12.toString());
        throw obj11;
    }

    private static void g(int i, int i2, com.google.zxing.k.c.b b3) {
        int i4;
        int i3;
        boolean z;
        final int i5 = 0;
        i4 = i5;
        while (i4 < 8) {
            i3 = i + i4;
            b3.f(i3, i2, i5);
            i4++;
        }
    }

    private static void h(int i, int i2, com.google.zxing.k.c.b b3) {
        int i5;
        int i3;
        int[] iArr;
        int i6;
        int i4;
        int i7;
        int i8;
        final int i9 = 0;
        i5 = i9;
        i3 = 5;
        while (i5 < i3) {
            i6 = i9;
            while (i6 < i3) {
                b3.f(i + i6, i2 + i5, e.b[i5][i6]);
                i6++;
            }
            i5++;
            i3 = 5;
            b3.f(i + i6, i2 + i5, iArr[i6]);
            i6++;
        }
    }

    private static void i(int i, int i2, com.google.zxing.k.c.b b3) {
        int i3;
        int i5;
        int[] iArr;
        int i6;
        int i4;
        int i7;
        int i8;
        final int i9 = 0;
        i3 = i9;
        i5 = 7;
        while (i3 < i5) {
            i6 = i9;
            while (i6 < i5) {
                b3.f(i + i6, i2 + i3, e.a[i3][i6]);
                i6++;
            }
            i3++;
            i5 = 7;
            b3.f(i + i6, i2 + i3, iArr[i6]);
            i6++;
        }
    }

    private static void j(com.google.zxing.k.c.b b) {
        int i2 = 0;
        int length = iArr.length;
        e.i(i2, i2, b);
        e.i(i5 -= length, i2, b);
        e.i(i2, i7 -= length, b);
        int i = 7;
        e.g(i2, i, b);
        e.g(i9 += -8, i, b);
        e.g(i2, i11 += -8, b);
        e.m(i, i2, b);
        e.m(i14--, i2, b);
        e.m(i, i3 -= i, b);
    }

    private static void k(com.google.zxing.k.c.b b) {
        int i3;
        int i;
        int i2;
        int i4;
        boolean z;
        final int i5 = 8;
        i3 = i5;
        while (i3 < i6 -= i5) {
            i = i3 + 1;
            i2 = i % 2;
            i4 = 6;
            if (e.o(b.b(i3, i4))) {
            }
            if (e.o(b.b(i4, i3))) {
            }
            i3 = i;
            b.f(i4, i3, i2);
            b.f(i3, i4, i2);
        }
    }

    static void l(a a, int i2, com.google.zxing.k.c.b b3) {
        boolean z;
        int i3;
        int i4;
        int i;
        int obj6;
        a aVar = new a();
        e.p(a, i2, aVar);
        final int obj5 = 0;
        obj6 = obj5;
        while (obj6 < aVar.g()) {
            i3 = 1;
            z = aVar.f(i7 -= obj6);
            int[] iArr = e.d[obj6];
            b3.g(iArr[obj5], iArr[i3], z);
            i4 = 8;
            if (obj6 < i4) {
            } else {
            }
            b3.g(i4, i10 += i, z);
            obj6++;
            b3.g(i14 -= i3, i4, z);
        }
    }

    private static void m(int i, int i2, com.google.zxing.k.c.b b3) {
        int i3;
        int i4;
        boolean z;
        final int i5 = 0;
        i3 = i5;
        while (i3 < 7) {
            i4 = i2 + i3;
            b3.f(i, i4, i5);
            i3++;
        }
    }

    static int n(int i) {
        return obj0 - 32;
    }

    private static boolean o(int i) {
        if (i == -1) {
            return 1;
        }
        return 0;
    }

    static void p(a a, int i2, a a3) {
        if (!f.b(i2)) {
        } else {
            obj1 |= i2;
            a3.c(obj1, 5);
            a3.c(e.b(obj1, 1335), 10);
            a obj1 = new a();
            int i = 15;
            obj1.c(21522, i);
            a3.l(obj1);
            if (a3.g() != i) {
            } else {
            }
            StringBuilder obj2 = new StringBuilder("should not happen but we got: ");
            obj2.append(a3.g());
            obj1 = new WriterException(obj2.toString());
            throw obj1;
        }
        obj1 = new WriterException("Invalid mask pattern");
        throw obj1;
    }

    static void q(c c, a a2) {
        a2.c(c.f(), 6);
        a2.c(e.b(c.f(), 7973), 12);
        if (a2.g() != 18) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder("should not happen but we got: ");
        stringBuilder.append(a2.g());
        WriterException obj2 = new WriterException(stringBuilder.toString());
        throw obj2;
    }

    private static void r(c c, com.google.zxing.k.c.b b2) {
        int i;
        int i4;
        int length;
        int i2;
        int i3;
        boolean z;
        if (c.f() < 2) {
        }
        int[] obj8 = e.c[obj8--];
        int i7 = 0;
        i = i7;
        while (i < obj8.length) {
            i4 = obj8[i];
            if (i4 >= 0) {
            }
            i++;
            i2 = i7;
            while (i2 < obj8.length) {
                i3 = obj8[i2];
                if (i3 >= 0 && e.o(b2.b(i3, i4))) {
                }
                i2++;
                if (e.o(b2.b(i3, i4))) {
                }
                e.h(i3 += -2, i4 + -2, b2);
            }
            i3 = obj8[i2];
            if (i3 >= 0 && e.o(b2.b(i3, i4))) {
            }
            i2++;
            if (e.o(b2.b(i3, i4))) {
            }
            e.h(i3 += -2, i4 + -2, b2);
        }
    }

    static void s(c c, com.google.zxing.k.c.b b2) {
        int i2;
        int i3;
        int i4;
        int i;
        int obj6;
        if (c.f() < 7) {
        }
        a aVar = new a();
        e.q(c, aVar);
        obj6 = 17;
        int i7 = 0;
        i2 = i7;
        while (i2 < 6) {
            i3 = i7;
            while (i3 < 3) {
                i4 = aVar.f(obj6);
                obj6--;
                b2.g(i2, i10 += i3, i4);
                b2.g(i13 += i3, i2, i4);
                i3++;
            }
            i2++;
            i4 = aVar.f(obj6);
            obj6--;
            b2.g(i2, i10 += i3, i4);
            b2.g(i13 += i3, i2, i4);
            i3++;
        }
    }
}
