package net.time4j.android.spi;

import android.os.SystemClock;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.time4j.f1.c;
import net.time4j.i1.e;

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
        Method method = SystemClock.class.getMethod("elapsedRealtimeNanos", arr2);
        method.invoke(0, arr);
        a.c = method;
    }

    @Override // net.time4j.i1.e
    public long a() {
        Method method;
        java.io.PrintStream err;
        method = a.c;
        if (method != null) {
            return (Long)method.invoke(0, a.b).longValue();
        }
        return c.i(SystemClock.elapsedRealtime(), err);
    }

    @Override // net.time4j.i1.e
    public String b() {
        return "Dalvik";
    }
}
