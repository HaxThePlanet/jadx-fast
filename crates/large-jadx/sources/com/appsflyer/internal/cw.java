package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class cw {
    public static int[] AFInAppEventType(char[] cArr, int[] i2Arr2, boolean z3) {
        int i3;
        int i;
        int i4;
        int valueOf;
        int i2;
        int i5 = 0;
        int i10 = 16;
        final int i15 = 1;
        i7 += c5;
        int i16 = 2;
        final int i19 = 3;
        i17 += c7;
        if (!z3) {
            cw.values(i2Arr2);
        }
        i4 = i5;
        while (i4 < i10) {
            i3 ^= i21;
            i4++;
            i = i9;
            i3 = i2;
        }
        i3 ^= i11;
        i13 ^= i;
        int[] iArr = new int[i16];
        iArr[i5] = i14;
        iArr[i15] = i8;
        cArr[i5] = (char)i20;
        cArr[i15] = (char)i14;
        cArr[i16] = (char)i6;
        cArr[i19] = (char)i8;
        if (!z3) {
            cw.values(i2Arr2);
        }
        return iArr;
    }

    public static int valueOf(int i) {
        int[][] valueOf = aFKeystoreWrapper.valueOf;
        return i5 += obj5;
    }

    public static void values(int[] iArr) {
        int i;
        int i3;
        int i2;
        i = 0;
        for (int i3 : iArr) {
            iArr[i] = iArr[i5--];
            iArr[i8--] = i3;
        }
    }
}
