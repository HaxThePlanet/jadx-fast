package com.google.zxing.i;

import com.google.zxing.FormatException;

/* loaded from: classes2.dex */
public abstract class p extends com.google.zxing.i.m {

    static final int[] a;
    static final int[] b;
    static final int[] c;
    static final int[][] d;
    static final int[][] e;
    static {
        int[][] iArr;
        int iArr2;
        int i;
        int[][] iArr3;
        int length;
        int i2 = 3;
        int[] iArr10 = new int[i2];
        iArr10 = new int[]{1, 1, 1};
        p.a = iArr10;
        int i4 = 5;
        int[] iArr12 = new int[i4];
        iArr12 = new int[]{1, 1, 1, 1, 1};
        p.b = iArr12;
        iArr2 = 6;
        int[] iArr13 = new int[iArr2];
        iArr13 = new int[]{1, 1, 1, 1, 1, 1};
        p.c = iArr13;
        i = 10;
        iArr3 = new int[i];
        length = 4;
        int[] iArr14 = new int[length];
        iArr14 = new int[]{3, 2, 1, 1};
        final int i11 = 0;
        iArr3[i11] = iArr14;
        int[] iArr15 = new int[length];
        iArr15 = new int[]{2, 2, 2, 1};
        final int i12 = 1;
        iArr3[i12] = iArr15;
        int[] iArr16 = new int[length];
        iArr16 = new int[]{2, 1, 2, 2};
        iArr3[2] = iArr16;
        int[] iArr17 = new int[length];
        iArr17 = new int[]{1, 4, 1, 1};
        iArr3[i2] = iArr17;
        int[] iArr4 = new int[length];
        iArr4 = new int[]{1, 1, 3, 2};
        iArr3[length] = iArr4;
        int[] iArr5 = new int[length];
        iArr5 = new int[]{1, 2, 3, 1};
        iArr3[i4] = iArr5;
        int[] iArr6 = new int[length];
        iArr6 = new int[]{1, 1, 1, 4};
        iArr3[iArr2] = iArr6;
        int[] iArr7 = new int[length];
        iArr7 = new int[]{1, 3, 1, 2};
        iArr3[7] = iArr7;
        int[] iArr8 = new int[length];
        iArr8 = new int[]{1, 2, 1, 3};
        iArr3[8] = iArr8;
        int[] iArr9 = new int[length];
        iArr9 = new int[]{3, 1, 1, 2};
        iArr3[9] = iArr9;
        p.d = iArr3;
        int i3 = 20;
        iArr = new int[i3];
        p.e = iArr;
        System.arraycopy(iArr3, i11, iArr, i11, i);
        while (i < i3) {
            int[] iArr11 = p.d[i + -10];
            iArr2 = new int[iArr11.length];
            iArr3 = i11;
            while (iArr3 < iArr11.length) {
                iArr2[iArr3] = iArr11[i9 -= i12];
                iArr3++;
            }
            p.e[i] = iArr2;
            i++;
            iArr2[iArr3] = iArr11[i9 -= i12];
            iArr3++;
        }
    }

    static boolean a(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        final int i2 = 0;
        if (length == 0) {
            return i2;
        }
        final int i3 = 1;
        length -= i3;
        if (p.b(charSequence.subSequence(i2, i)) == Character.digit(charSequence.charAt(i), 10)) {
            return i3;
        }
        return i2;
    }

    static int b(java.lang.CharSequence charSequence) {
        int i2;
        int i3;
        int i4;
        int i;
        int i5;
        int i6;
        int length = charSequence.length();
        i3 = length + -1;
        i4 = 0;
        i5 = 9;
        while (i3 >= 0) {
            charAt2 += -48;
            i4 += i6;
            i3 += -2;
            i5 = 9;
        }
        i4 *= 3;
        length += -2;
        while (i2 >= 0) {
            charAt += -48;
            i += i3;
            i2 += -2;
        }
        return obj5 %= 10;
    }
}
