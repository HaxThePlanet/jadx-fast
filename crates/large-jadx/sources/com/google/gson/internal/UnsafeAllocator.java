package com.google.gson.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes2.dex */
public abstract class UnsafeAllocator {
    static void assertInstantiable(Class<?> class) {
        int modifiers = class.getModifiers();
        if (Modifier.isInterface(modifiers)) {
        } else {
            if (Modifier.isAbstract(modifiers)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Abstract class can't be instantiated! Class name: ");
            stringBuilder.append(class.getName());
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
            throw unsupportedOperationException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Interface can't be instantiated! Interface name: ");
        stringBuilder2.append(class.getName());
        UnsupportedOperationException unsupportedOperationException2 = new UnsupportedOperationException(stringBuilder2.toString());
        throw unsupportedOperationException2;
    }

    public static com.google.gson.internal.UnsafeAllocator create() {
        final String str = "newInstance";
        final int i4 = 1;
        Class forName = Class.forName("sun.misc.Unsafe");
        Field declaredField = forName.getDeclaredField("theUnsafe");
        declaredField.setAccessible(i4);
        final Class[] arr2 = new Class[i4];
        arr2[0] = Class.class;
        UnsafeAllocator.1 anon4 = new UnsafeAllocator.1(forName.getMethod("allocateInstance", arr2), declaredField.get(0));
        return anon4;
    }

    public abstract <T> T newInstance(Class<T> class);
}
