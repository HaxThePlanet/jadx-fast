package io.grpc.j1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class x1 implements io.grpc.j1.e1 {

    private static final Logger b;
    private static final Constructor<?> c = null;
    private static final Method d = null;
    private static final RuntimeException e = null;
    private static final Object[] f;
    private final Object a;
    static {
        int i;
        Throwable th;
        int i3;
        String str;
        Method method;
        int length;
        int i2;
        Object str2;
        int length2;
        x1.b = Logger.getLogger(x1.class.getName());
        int i4 = 1;
        final int i5 = 0;
        i = 0;
        Class forName = Class.forName("java.util.concurrent.atomic.LongAdder");
        Class[] arr2 = new Class[i4];
        arr2[i5] = Long.TYPE;
        method = forName.getMethod("add", arr2);
        forName.getMethod("sum", new Class[i5]);
        Constructor[] constructors = forName.getConstructors();
        i2 = i5;
        while (i2 < constructors.length) {
            i2++;
        }
        str2 = i;
        i3 = i;
        Object[] arr = new Object[i4];
        arr[i5] = Long.valueOf(1);
        x1.f = arr;
    }

    x1() {
        super();
        RuntimeException exc = x1.e;
        if (exc != null) {
        } else {
            this.a = x1.c.newInstance(new Object[0]);
        }
        throw exc;
    }

    static boolean a() {
        int i;
        i = x1.e == null ? 1 : 0;
        return i;
    }

    @Override // io.grpc.j1.e1
    public void add(long l) {
        int cmp;
        int i;
        Object[] obj5;
        try {
            if (Long.compare(l, i2) == 0) {
            } else {
            }
            obj5 = x1.f;
            cmp = new Object[1];
            obj5 = cmp;
            x1.d.invoke(this.a, obj5);
            obj6 = new RuntimeException(l);
            throw obj6;
            obj6 = new RuntimeException(l);
            throw obj6;
        }
    }
}
