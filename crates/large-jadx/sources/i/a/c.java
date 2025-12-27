package i.a;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: PerfMark.java */
/* loaded from: classes3.dex */
public final class c {

    private static final a a;
    static {
        Level wARNING2;
        int i = 0;
        Class cls;
        Throwable th3;
        wARNING2 = Level.WARNING;
        i = 0;
        try {
            cls = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
        } catch (Throwable th) {
        }
        if ("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl" != null) {
            try {
                int i3 = 1;
                Class[] arr2 = new Class[i3];
                obj = d.class;
                int i2 = 0;
                arr2[i2] = obj;
                Object[] arr = new Object[i3];
                arr[i2] = a.a;
            } catch (Throwable th) {
            }
        }
        if (i != 0) {
            c.a = i;
        } else {
            c.a = new a(a.a);
        }
        if (th3 != null) {
            Logger.getLogger(c.class.getName()).log(wARNING2, "Error during PerfMark.<clinit>", th3);
        }
    }

    private c() {
        super();
    }

    public static d a(String str) {
        return c.a.a(str, Long.MIN_VALUE);
    }

    public static d b(String str, long j) {
        return c.a.a(str, j);
    }

    public static void c(String str, d dVar) {
        c.a.b(str, dVar);
    }

    public static void d(b bVar) {
        c.a.c(bVar);
    }

    public static b e() {
        return c.a.d();
    }

    public static void f(String str) {
        c.a.e(str);
    }

    public static void g(String str, d dVar) {
        c.a.f(str, dVar);
    }

    public static void h(String str) {
        c.a.g(str);
    }

    public static void i(String str, d dVar) {
        c.a.h(str, dVar);
    }
}
