package com.google.android.play.core.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class w0 {
    public static <T> com.google.android.play.core.internal.u0<T> a(Object object, String string2, Class<T> class3) {
        u0 u0Var = new u0(object, w0.h(object, string2), class3);
        return u0Var;
    }

    public static <T> com.google.android.play.core.internal.v0<T> b(Object object, String string2, Class<T> class3) {
        v0 v0Var = new v0(object, w0.h(object, string2), class3);
        return v0Var;
    }

    public static <R> R c(Class<R> class) {
        final int i2 = 0;
        Constructor declaredConstructor = class.getDeclaredConstructor(new Class[i2]);
        if (!declaredConstructor.isAccessible()) {
            declaredConstructor.setAccessible(true);
        }
        try {
            return declaredConstructor.newInstance(new Object[i2]);
            int arr = new Object[arr];
            class = class.getName();
            arr[obj1] = class;
            class = "Failed to invoke default constructor on class %s";
            class = String.format(class, arr);
            zzbx zzbx = new zzbx(class, th);
            throw zzbx;
        }
    }

    public static <R, P0> R d(Object object, String string2, Class<R> class3, Class<P0> class4, P0 p05) {
        final int i = 1;
        Class[] arr = new Class[i];
        final int i2 = 0;
        arr[i2] = class4;
        Object[] arr2 = new Object[i];
        arr2[i2] = p05;
        return class3.cast(w0.i(object.getClass(), string2, arr).invoke(object, arr2));
    }

    public static <R, P0, P1, P2> R e(Object object, String string2, Class<R> class3, Class<P0> class4, P0 p05, Class<P1> class6, P1 p17, Class<P2> class8, P2 p29) {
        int i = 3;
        final Class[] arr2 = new Class[i];
        final int i2 = 0;
        arr2[i2] = class4;
        final int obj6 = 1;
        arr2[obj6] = class6;
        final int obj8 = 2;
        arr2[obj8] = class8;
        Object[] arr = new Object[i];
        arr[i2] = p05;
        arr[obj6] = p17;
        arr[obj8] = p29;
        return class3.cast(w0.i(object.getClass(), string2, arr2).invoke(object, arr));
    }

    public static <R, P0> R f(Class class, String string2, Class<R> class3, Class<P0> class4, P0 p05) {
        final int obj4 = 1;
        Class[] arr2 = new Class[obj4];
        final int i = 0;
        arr2[i] = class4;
        final Object[] arr3 = new Object[obj4];
        arr3[i] = p05;
        return class3.cast(w0.i(class, "isDexOptNeeded", arr2).invoke(0, arr3));
    }

    public static <R, P0, P1> R g(Class class, String string2, Class<R> class3, Class<P0> class4, P0 p05, Class<P1> class6, P1 p17) {
        final int obj4 = 2;
        Class[] arr = new Class[obj4];
        final int i = 0;
        arr[i] = class4;
        final int obj6 = 1;
        arr[obj6] = class6;
        final Object[] arr2 = new Object[obj4];
        arr2[i] = p05;
        arr2[obj6] = p17;
        return class3.cast(w0.i(class, "optimizedPathFor", arr).invoke(0, arr2));
    }

    private static Field h(Object object, String string2) {
        Class class;
        class = object.getClass();
        final int i = 1;
        if (class == null) {
        } else {
            Field declaredField = class.getDeclaredField(string2);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(i);
            }
            return declaredField;
        }
        Object[] arr = new Object[2];
        arr[i] = object.getClass().getName();
        zzbx zzbx = new zzbx(String.format("Failed to find a field named %s on an object of instance %s", arr));
        throw zzbx;
    }

    private static Method i(Class<?> class, String string2, Class<?>... class3Arr3) {
        Object obj;
        obj = class;
        final int i = 1;
        if (obj == null) {
        } else {
            Method declaredMethod = obj.getDeclaredMethod(string2, class3Arr3);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(i);
            }
            try {
                return declaredMethod;
                Object[] arr = new Object[3];
                arr[i] = Arrays.asList(class3Arr3);
                arr[2] = class;
                zzbx zzbx = new zzbx(String.format("Could not find a method named %s with parameters %s in type %s", arr));
                throw zzbx;
            }
        }
    }
}
