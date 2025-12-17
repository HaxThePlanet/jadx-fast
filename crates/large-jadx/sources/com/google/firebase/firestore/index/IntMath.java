package com.google.firebase.firestore.index;

import java.math.RoundingMode;

/* loaded from: classes2.dex */
public final class IntMath {
    public static int divide(int i, int i2, RoundingMode roundingMode3) {
        int i5;
        int i4;
        int i3;
        int obj6;
        RoundingMode obj7;
        if (i2 == 0) {
        } else {
            i5 = i / i2;
            i4 = i - i7;
            if (i4 == 0) {
                return i5;
            }
            i3 = 1;
            obj5 |= i3;
            int i10 = 0;
            switch (i9) {
                case 1:
                    i3 = i10;
                    return i5;
                case 2:
                    return i5;
                case 3:
                    i3 = i10;
                    return i5;
                case 4:
                    i3 = i10;
                    return i5;
                case 5:
                    int i8 = Math.abs(i4);
                    i8 -= obj6;
                    obj6 = i3;
                    obj6 = i10;
                    obj7 = i3;
                    obj7 = i10;
                    i3 = i10;
                    return i5;
                default:
                    AssertionError obj5 = new AssertionError();
                    throw obj5;
            }
            i5 += obj5;
        }
        obj5 = new ArithmeticException("/ by zero");
        throw obj5;
    }
}
