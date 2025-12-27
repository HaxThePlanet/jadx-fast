package io.grpc.j1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ReflectionLongAdderCounter.java */
/* loaded from: classes3.dex */
public final class x1 implements e1 {

    private static final Logger b;
    private static final Constructor<?> c = null;
    private static final Method d = null;
    private static final RuntimeException e = new RuntimeException();
    private static final Object[] f;
    private final Object a;
    static {
        Throwable th;
        int i2;
        Method method;
        int i;
        int i3;
        int length2;
        x1.b = Logger.getLogger(x1.class.getName());
        int i4 = 1;
        i = 0;
        RuntimeException runtimeException = null;
        try {
            Class cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            Class[] arr2 = new Class[i4];
            arr2[i] = Long.TYPE;
            method = cls.getMethod("add", arr2);
        } catch (Throwable th) {
        }
        try {
            cls.getMethod("sum", new Class[i]);
            Constructor[] constructors = cls.getConstructors();
            length = constructors.length;
            length2 = constructors[i].getParameterTypes().length;
        } catch (Throwable th) {
        }
        i3 = runtimeException;
        i2 = runtimeException;
        x1.c = i3;
        x1.d = method;
        x1.e = runtimeException;
        Object[] arr = new Object[i4];
        arr[i] = Long.valueOf(1L);
        x1.f = arr;
    }

    x1() {
        super();
        RuntimeException runtimeException = x1.e;
        if (x1.e != null) {
            throw x1.e;
        } else {
            try {
                this.a = x1.c.newInstance(new Object[0]);
            } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                RuntimeException runtimeException2 = new RuntimeException(invocationTarget);
                throw runtimeException2;
            } catch (java.lang.IllegalAccessException illegalAccess1) {
                runtimeException2 = new RuntimeException(illegalAccess1);
                throw runtimeException2;
            } catch (java.lang.InstantiationException instantiation2) {
                runtimeException2 = new RuntimeException(instantiation2);
                throw runtimeException2;
            }
            return;
        }
    }

    static boolean a() {
        boolean z = true;
        int r0 = x1.e == null ? 1 : 0;
        return (x1.e == null ? 1 : 0);
    }

    public void add(long j) {
        Object[] arr;
        try {
            if (j == 1) {
                arr = x1.f;
            } else {
                arr = new Object[1];
                int i = 0;
                arr[i] = Long.valueOf(j);
            }
            x1.d.invoke(this.a, arr);
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
            r6 = new RuntimeException(invocationTarget);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) r6;
        } catch (java.lang.IllegalAccessException illegalAccess1) {
            r6 = new RuntimeException(illegalAccess1);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) r6;
        }
    }
}
