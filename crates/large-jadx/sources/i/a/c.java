package i.a;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class c {

    private static final i.a.a a;
    static {
        Level wARNING;
        int aVar;
        Throwable th2;
        Class forName;
        Throwable th3;
        int i2;
        Object[] arr;
        i.a.d dVar;
        Class<i.a.d> obj;
        int i;
        wARNING = Level.WARNING;
        forName = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
        i2 = aVar;
        if (forName != null) {
            int i3 = 1;
            Class[] arr2 = new Class[i3];
            i = 0;
            arr2[i] = d.class;
            arr = new Object[i3];
            arr[i] = a.a;
            aVar = forName;
        }
        if (aVar != 0) {
            c.a = aVar;
        } else {
            aVar = new a(a.a);
            c.a = aVar;
        }
        if (i2 != 0) {
            Logger.getLogger(c.class.getName()).log(wARNING, "Error during PerfMark.<clinit>", i2);
        }
    }

    public static i.a.d a(String string) {
        return c.a.a(string, Long.MIN_VALUE);
    }

    public static i.a.d b(String string, long l2) {
        return c.a.a(string, l2);
    }

    public static void c(String string, i.a.d d2) {
        c.a.b(string, d2);
    }

    public static void d(i.a.b b) {
        c.a.c(b);
    }

    public static i.a.b e() {
        return c.a.d();
    }

    public static void f(String string) {
        c.a.e(string);
    }

    public static void g(String string, i.a.d d2) {
        c.a.f(string, d2);
    }

    public static void h(String string) {
        c.a.g(string);
    }

    public static void i(String string, i.a.d d2) {
        c.a.h(string, d2);
    }
}
