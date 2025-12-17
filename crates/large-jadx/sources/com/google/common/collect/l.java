package com.google.common.collect;

import com.google.common.base.k;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class l {
    static Object a(int i) {
        int highestOneBit;
        if (i < 2) {
        } else {
            if (i > 1073741824) {
            } else {
                if (Integer.highestOneBit(i) != i) {
                } else {
                    if (i <= 256) {
                        return new byte[i];
                    }
                    if (i <= 65536) {
                        return new short[i];
                    }
                    return new int[i];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder(52);
        stringBuilder.append("must be power of 2 between 2^1 and 2^30: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    static int b(int i, int i2) {
        return i &= obj1;
    }

    static int c(int i, int i2) {
        return i &= i2;
    }

    static int d(int i, int i2, int i3) {
        return obj1 |= obj2;
    }

    static int e(int i) {
        int i2;
        i2 = i < 32 ? 4 : 2;
        return i2 *= obj1;
    }

    static int f(Object object, Object object2, int i3, Object object4, int[] i5Arr5, Object[] object6Arr6, Object[] object7Arr7) {
        int i;
        int i4;
        int i5;
        int i6;
        int i2;
        int obj8;
        int obj9;
        int i7 = s.c(object);
        final int i9 = i7 & i3;
        final int i11 = -1;
        if (l.h(object4, i9) == 0) {
            return i11;
        }
        i4 = i11;
        i--;
        i5 = i5Arr5[i10];
        while (l.b(i5, i3) == l.b(i7, i3)) {
            int i12 = l.c(i5, i3);
            i4 = i10;
            i = i2;
            i--;
            i5 = i5Arr5[i10];
        }
        obj8 = l.c(i5, i3);
        if (i4 == i11) {
            l.i(object4, i9, obj8);
        } else {
            i5Arr5[i4] = l.d(i5Arr5[i4], obj8, i3);
        }
        return i10;
    }

    static void g(Object object) {
        boolean z;
        final int i = 0;
        if (object instanceof byte[]) {
            Arrays.fill((byte[])object, i);
        } else {
            if (object instanceof short[]) {
                Arrays.fill((short[])object, i);
            } else {
                Arrays.fill((int[])object, i);
            }
        }
    }

    static int h(Object object, int i2) {
        if (object instanceof byte[]) {
            return obj1 &= 255;
        }
        if (object instanceof short[]) {
            return obj1 &= obj2;
        }
        return (int[])object[i2];
    }

    static void i(Object object, int i2, int i3) {
        boolean z;
        byte obj3;
        if (object instanceof byte[]) {
            (byte[])object[i2] = (byte)i3;
        } else {
            if (object instanceof short[]) {
                (short[])object[i2] = (short)i3;
            } else {
                (int[])object[i2] = i3;
            }
        }
    }

    static int j(int i) {
        return Math.max(4, s.a(i++, 4607182418800017408L));
    }
}
