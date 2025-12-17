package com.google.common.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class t {

    private static final Object a;
    static {
        final Object obj = t.b();
        t.a = obj;
        if (obj == null) {
        } else {
            t.a();
        }
        if (obj == null) {
        } else {
            t.d();
        }
    }

    private static Method a() {
        Class[] arr = new Class[2];
        return t.c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    private static Object b() {
        int i = 0;
        int i2 = 0;
        return Class.forName("sun.misc.SharedSecrets", i2, i).getMethod("getJavaLangAccess", new Class[i2]).invoke(i, new Object[i2]);
    }

    private static Method c(String string, Class<?>... class2Arr2) {
        return Class.forName("sun.misc.JavaLangAccess", false, 0).getMethod(string, class2Arr2);
    }

    private static Method d() {
        int i2 = 1;
        Class[] arr2 = new Class[i2];
        final int i3 = 0;
        arr2[i3] = Throwable.class;
        Method method = t.c("getStackTraceDepth", arr2);
        if (method == null) {
            try {
                return null;
                Object[] arr = new Object[i2];
                Throwable throwable = new Throwable();
                arr[i3] = throwable;
                method.invoke(t.b(), arr);
                return method;
                return obj0;
            }
        }
    }

    public static String e(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    public static void f(Throwable throwable) {
        n.o(throwable);
        if (throwable instanceof RuntimeException != null) {
        } else {
            if (throwable instanceof Error != null) {
            } else {
            }
            throw (Error)throwable;
        }
        throw (RuntimeException)throwable;
    }
}
