package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class ct {
    private static int AFInAppEventType(int i, int[][] i2Arr2Arr2) {
        return i5 += obj4;
    }

    public static void AFInAppEventType(int i, int i2, boolean z3, int i4, int[] i5Arr5, int[][] i6Arr6Arr6, int[] i7Arr7) {
        int i5;
        int i3;
        int i6;
        int obj4;
        int obj5;
        if (!z3) {
            ct.values(i5Arr5);
        }
        final int i7 = 0;
        i5 = i7;
        while (i5 < i4) {
            obj4 ^= i8;
            i5++;
            obj5 = obj4;
            obj4 = i6;
        }
        final int obj9 = 1;
        if (!z3) {
            ct.values(i5Arr5);
        }
        i7Arr7[i7] = obj5 ^= obj7;
        i7Arr7[obj9] = obj4 ^= obj7;
    }

    private static void values(int[] iArr) {
        int i3;
        int i2;
        int i;
        i3 = 0;
        for (int i2 : iArr) {
            iArr[i3] = iArr[i5--];
            iArr[i8--] = i2;
        }
    }
}
