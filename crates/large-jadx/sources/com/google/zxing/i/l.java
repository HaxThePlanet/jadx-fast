package com.google.zxing.i;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.g.b;
import java.util.Map;

/* loaded from: classes2.dex */
public final class l extends com.google.zxing.i.n {

    private static final int[] a;
    private static final int[] b;
    private static final int[][] c;
    static {
        int i = 4;
        int[] iArr6 = new int[i];
        iArr6 = new int[]{1, 1, 1, 1};
        l.a = iArr6;
        int i2 = 3;
        int[] iArr8 = new int[i2];
        iArr8 = new int[]{3, 1, 1};
        l.b = iArr8;
        int[][] iArr9 = new int[10];
        final int i8 = 5;
        int[] iArr10 = new int[i8];
        iArr10 = new int[]{1, 1, 3, 3, 1};
        int[] iArr11 = new int[i8];
        iArr11 = new int[]{3, 1, 1, 1, 3};
        int[] iArr12 = new int[i8];
        iArr12 = new int[]{1, 3, 1, 1, 3};
        int[] iArr13 = new int[i8];
        iArr13 = new int[]{3, 3, 1, 1, 1};
        iArr9[i2] = iArr13;
        int[] iArr7 = new int[i8];
        iArr7 = new int[]{1, 1, 3, 1, 3};
        iArr9[i] = iArr7;
        int[] iArr = new int[i8];
        iArr = new int[]{3, 1, 3, 1, 1};
        iArr9[i8] = iArr;
        int[] iArr2 = new int[i8];
        iArr2 = new int[]{1, 3, 3, 1, 1};
        iArr9[6] = iArr2;
        int[] iArr3 = new int[i8];
        iArr3 = new int[]{1, 1, 1, 3, 3};
        iArr9[7] = iArr3;
        int[] iArr4 = new int[i8];
        iArr4 = new int[]{3, 1, 1, 3, 1};
        iArr9[8] = iArr4;
        int[] iArr5 = new int[i8];
        iArr5 = new int[]{1, 3, 1, 3, 1};
        iArr9[9] = iArr5;
        l.c = iArr9;
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        if (a2 != a.ITF) {
        } else {
            return super.a(string, a2, i3, i4, map5);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(a2)));
        throw obj2;
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String string) {
        int i3;
        int i7;
        int i;
        int[] iArr;
        int digit;
        int i5;
        int i6;
        int i2;
        int i4;
        int length = string.length();
        if (length % 2 != 0) {
        } else {
            if (length > 80) {
            } else {
                boolean[] zArr = new boolean[i10 += 9];
                final int i12 = 0;
                final int i13 = 1;
                i3 = n.b(zArr, i12, l.a, i13);
                i7 = i12;
                while (i7 < length) {
                    int i14 = 10;
                    iArr = new int[i14];
                    i5 = i12;
                    while (i5 < 5) {
                        int i16 = i5 * 2;
                        int[][] arr = l.c;
                        iArr[i16] = arr[Character.digit(string.charAt(i7), i14)][i5];
                        iArr[i16 += i13] = arr[Character.digit(string.charAt(i7 + 1), i14)][i5];
                        i5++;
                    }
                    i3 += i;
                    i7 += 2;
                    i16 = i5 * 2;
                    arr = l.c;
                    iArr[i16] = arr[digit2][i5];
                    iArr[i16 += i13] = arr[digit][i5];
                    i5++;
                }
                n.b(zArr, i3, l.b, i13);
                return zArr;
            }
            IllegalArgumentException obj14 = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            throw obj14;
        }
        obj14 = new IllegalArgumentException("The length of the input should be even");
        throw obj14;
    }
}
