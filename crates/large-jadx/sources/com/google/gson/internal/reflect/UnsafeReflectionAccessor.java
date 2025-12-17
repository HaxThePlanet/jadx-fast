package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class UnsafeReflectionAccessor extends com.google.gson.internal.reflect.ReflectionAccessor {

    private static Class unsafeClass;
    private final Field overrideField;
    private final Object theUnsafe;
    UnsafeReflectionAccessor() {
        super();
        this.theUnsafe = UnsafeReflectionAccessor.getUnsafeInstance();
        this.overrideField = UnsafeReflectionAccessor.getOverrideField();
    }

    private static Field getOverrideField() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
            return null;
        }
    }

    private static Object getUnsafeInstance() {
        Class forName = Class.forName("sun.misc.Unsafe");
        UnsafeReflectionAccessor.unsafeClass = forName;
        Field declaredField = forName.getDeclaredField("theUnsafe");
        declaredField.setAccessible(true);
        return declaredField.get(0);
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject accessibleObject) {
        boolean accessibleWithUnsafe;
        if (!makeAccessibleWithUnsafe(accessibleObject)) {
            accessibleObject.setAccessible(true);
        }
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    boolean makeAccessibleWithUnsafe(AccessibleObject accessibleObject) {
        Object overrideField;
        final int i = 0;
        if (this.theUnsafe != null && this.overrideField != null) {
            if (this.overrideField != null) {
                final int i2 = 1;
                Class[] arr = new Class[i2];
                arr[i] = Field.class;
                Object[] arr2 = new Object[i2];
                Field overrideField2 = this.overrideField;
                arr2[i] = overrideField2;
                int i3 = 3;
                final Class[] arr4 = new Class[i3];
                arr4[i] = Object.class;
                arr4[i2] = Long.TYPE;
                final int i4 = 2;
                arr4[i4] = Boolean.TYPE;
                Object[] arr3 = new Object[i3];
                arr3[i] = accessibleObject;
                arr3[i2] = Long.valueOf((Long)UnsafeReflectionAccessor.unsafeClass.getMethod("objectFieldOffset", arr).invoke(this.theUnsafe, arr2).longValue());
                arr3[i4] = Boolean.TRUE;
                UnsafeReflectionAccessor.unsafeClass.getMethod("putBoolean", arr4).invoke(this.theUnsafe, arr3);
                return i2;
            }
        }
        return i;
    }
}
