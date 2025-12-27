package net.time4j.android.spi;

import android.os.SystemClock;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.time4j.f1.c;
import net.time4j.i1.e;

/* compiled from: AndroidTickerSPI.java */
/* loaded from: classes3.dex */
class a implements e {

    private static final Class[] a;
    private static final Object[] b;
    private static final Method c;
    static {
        int i = 0;
        Class[] arr2 = new Class[i];
        a.a = arr2;
        Object[] arr = new Object[i];
        a.b = arr;
        try {
            Method method = SystemClock.class.getMethod("elapsedRealtimeNanos", arr2);
            method.invoke(null, arr);
        } catch (java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException | java.lang.IllegalAccessException | RuntimeException unused) {
            a.c = method;
            return;
        }
    }

    a() {
        super();
    }

    public long a() {
        long l2;
        method = a.c;
        if (a.c != null) {
            try {
            } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                java.io.PrintStream err2 = System.err;
                invocationTarget.printStackTrace(err2);
            } catch (java.lang.IllegalAccessException illegalAccess1) {
                err2 = System.err;
                illegalAccess1.printStackTrace(err2);
            }
            return (Long)a.c.invoke(null, a.b).longValue();
        }
        return c.i(SystemClock.elapsedRealtime(), 1000000L);
    }

    public String b() {
        return "Dalvik";
    }
}
