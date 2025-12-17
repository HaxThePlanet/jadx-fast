package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
final class q0 {
    static <T> T[] a(Object[] objectArr, int i2, int i3, T[] t4Arr4) {
        return Arrays.copyOfRange(objectArr, i2, i3, t4Arr4.getClass());
    }

    static <T> T[] b(T[] tArr, int i2) {
        return (Object[])Array.newInstance(tArr.getClass().getComponentType(), i2);
    }

    static <K, V> Map<K, V> c() {
        return k.m();
    }
}
