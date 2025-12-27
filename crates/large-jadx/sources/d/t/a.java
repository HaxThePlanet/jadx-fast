package d.t;

import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Trace.java */
/* loaded from: classes.dex */
public final class a {

    private static long a;
    private static Method b;
    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.b();
        }
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw cause;
            }
            throw new RuntimeException(cause);
        }
        StringBuilder stringBuilder = new StringBuilder();
        final String str3 = "Unable to call ";
        String str4 = " via reflection";
        str5 = str3 + str + str4;
        Log.v("Trace", str5, exc);
    }

    public static boolean d() {
        try {
        } catch (java.lang.NoSuchMethodError | java.lang.NoClassDefFoundError unused) {
            return a.e();
        }
        return Trace.isEnabled();
    }

    private static boolean e() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchFieldException, java.lang.NoSuchMethodException {
        long l2;
        final int i = 0;
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                int i3 = 1;
                final Object obj3 = null;
                if (a.b == null) {
                    a.a = Trace.class.getField("TRACE_TAG_APP").getLong(obj3);
                    Class[] arr = new Class[i3];
                    a.b = Trace.class.getMethod("isTagEnabled", new Class[] { Long.TYPE });
                }
                Object[] arr2 = new Object[i3];
            } catch (Exception e) {
                a.c(str, e);
            }
            return (Boolean)a.b.invoke(obj3, new Object[] { Long.valueOf(a.a) }).booleanValue();
        }
        return false;
    }
}
