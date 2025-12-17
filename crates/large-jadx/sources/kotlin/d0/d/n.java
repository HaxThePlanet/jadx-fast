package kotlin.d0.d;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes3.dex */
public class n {
    public static boolean a(Double double, Double double2) {
        int i;
        double doubleValue;
        int obj4;
        i = 1;
        if (double == 0) {
            if (double2 == null) {
            } else {
                i = i2;
            }
        } else {
            if (double2 != null && Double.compare(doubleValue, obj4) == 0) {
                if (Double.compare(doubleValue, obj4) == 0) {
                } else {
                }
            } else {
            }
        }
        return i;
    }

    public static boolean b(Object object, Object object2) {
        int obj0;
        if (object == null) {
            obj0 = object2 == null ? 1 : 0;
        } else {
            obj0 = object.equals(object2);
        }
        return obj0;
    }

    public static void c(Object object, String string2) {
        if (object == null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        IllegalStateException obj1 = new IllegalStateException(stringBuilder.toString());
        n.m(obj1);
        throw (IllegalStateException)obj1;
    }

    public static void d(Object object) {
        if (object == null) {
        } else {
        }
        n.p();
        throw 0;
    }

    public static void e(Object object, String string2) {
        if (object == null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        NullPointerException obj1 = new NullPointerException(stringBuilder.toString());
        n.m(obj1);
        throw (NullPointerException)obj1;
    }

    public static void f(Object object, String string2) {
        if (object == null) {
        } else {
        }
        n.s(string2);
        throw 0;
    }

    public static void g(Object object, String string2) {
        if (object == null) {
        } else {
        }
        n.r(string2);
        throw 0;
    }

    public static int h(int i, int i2) {
        int obj0;
        obj0 = i < i2 ? -1 : i == i2 ? 0 : 1;
        return obj0;
    }

    public static int i(long l, long l2) {
        int obj0;
        obj0 = Long.compare(l, obj2);
        obj0 = obj0 < 0 ? -1 : obj0 == null ? 0 : 1;
        return obj0;
    }

    private static String j(String string) {
        java.lang.StackTraceElement stack = Thread.currentThread().getStackTrace()[4];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append(stack.getClassName());
        stringBuilder.append(".");
        stringBuilder.append(stack.getMethodName());
        stringBuilder.append(", parameter ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static void k() {
        n.t();
        throw 0;
    }

    public static void l(int i, String string2) {
        n.t();
        throw 0;
    }

    private static <T extends Throwable> T m(T t) {
        n.n(t, n.class.getName());
        return t;
    }

    static <T extends Throwable> T n(T t, String string2) {
        int i;
        int i2;
        boolean equals;
        final java.lang.StackTraceElement[] stackTrace = t.getStackTrace();
        final int length = stackTrace.length;
        i = -1;
        i2 = 0;
        while (i2 < length) {
            if (string2.equals(stackTrace[i2].getClassName())) {
            }
            i2++;
            i = i2;
        }
        t.setStackTrace((StackTraceElement[])Arrays.copyOfRange(stackTrace, i++, length));
        return t;
    }

    public static String o(String string, Object object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(object2);
        return stringBuilder.toString();
    }

    public static void p() {
        NullPointerException nullPointerException = new NullPointerException();
        n.m(nullPointerException);
        throw (NullPointerException)nullPointerException;
    }

    public static void q() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        n.m(kotlinNullPointerException);
        throw (KotlinNullPointerException)kotlinNullPointerException;
    }

    private static void r(String string) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.j(string));
        n.m(illegalArgumentException);
        throw (IllegalArgumentException)illegalArgumentException;
    }

    private static void s(String string) {
        NullPointerException nullPointerException = new NullPointerException(n.j(string));
        n.m(nullPointerException);
        throw (NullPointerException)nullPointerException;
    }

    public static void t() {
        n.u("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        throw 0;
    }

    public static void u(String string) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string);
        throw unsupportedOperationException;
    }

    public static void v(String string) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(string);
        n.m(uninitializedPropertyAccessException);
        throw (UninitializedPropertyAccessException)uninitializedPropertyAccessException;
    }

    public static void w(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lateinit property ");
        stringBuilder.append(string);
        stringBuilder.append(" has not been initialized");
        n.v(stringBuilder.toString());
        throw 0;
    }
}
