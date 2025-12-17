package com.google.common.collect;

/* loaded from: classes2.dex */
public final class o0 {
    static Object a(Object object, int i2) {
        if (object == null) {
        } else {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append("at index ");
        stringBuilder.append(i2);
        NullPointerException obj2 = new NullPointerException(stringBuilder.toString());
        throw obj2;
    }

    static Object[] b(Object... objectArr) {
        o0.c(objectArr, objectArr.length);
        return objectArr;
    }

    static Object[] c(Object[] objectArr, int i2) {
        int i;
        Object obj;
        i = 0;
        while (i < i2) {
            o0.a(objectArr[i], i);
            i++;
        }
        return objectArr;
    }

    public static <T> T[] d(T[] tArr, int i2) {
        return q0.b(tArr, i2);
    }
}
