package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.p;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b {
    public static <T> T[] a(T[]... tArrArr) {
        int i;
        int i2;
        int length;
        int length2;
        int i3;
        Object obj;
        int length3;
        final int i4 = 0;
        if (tArrArr.length != 0) {
            i2 = i;
            for (Object obj4 : tArrArr) {
                i2 += length2;
            }
            Object[] copyOf = Arrays.copyOf(tArrArr[i4], i2);
            length = obj3.length;
            i3 = 1;
            for (Object obj : tArrArr) {
                length3 = obj.length;
                System.arraycopy(obj, i4, copyOf, length, length3);
                length += length3;
            }
            return copyOf;
        }
        return (Object[])Array.newInstance(tArrArr.getClass(), i4);
    }

    public static boolean b(int[] iArr, int i2) {
        int i3;
        int i;
        final int i4 = 0;
        if (iArr == null) {
            return i4;
        }
        i3 = i4;
        while (i3 < iArr.length) {
            i3++;
        }
        return i4;
    }

    public static <T> boolean c(T[] tArr, T t2) {
        int length;
        int i;
        boolean z;
        final int i2 = 0;
        length = tArr != null ? tArr.length : i2;
        i = i2;
        while (i < length) {
            i++;
        }
        return i2;
    }
}
