package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
abstract class r8<T extends com.google.android.gms.internal.measurement.j8>  {

    private static final Logger a;
    private static final String b;
    static {
        r8.a = Logger.getLogger(e8.class.getName());
        r8.b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
    }

    static <T extends com.google.android.gms.internal.measurement.j8> T b(Class<T> class) {
        java.lang.ClassLoader arrayList;
        Throwable th2;
        String format;
        String str;
        String str2;
        int str3;
        Throwable th;
        Class<com.google.android.gms.internal.measurement.r8> obj = r8.class;
        final int i2 = 1;
        final int i3 = 0;
        if (class.equals(j8.class)) {
            format = r8.b;
            return (j8)class.cast((r8)Class.forName(format, i2, obj.getClassLoader()).getConstructor(new Class[i3]).newInstance(new Object[i3]).a());
        } else {
            if (!class.getPackage().equals(obj.getPackage())) {
            } else {
                Object[] arr = new Object[2];
                arr[i3] = class.getPackage().getName();
                arr[i2] = class.getSimpleName();
                format = String.format("%s.BlazeGenerated%sLoader", arr);
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(class.getName());
        throw illegalArgumentException;
    }

    protected abstract T a();
}
