package d.t;

import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a {

    private static long a;
    private static Method b;
    public static void a(String string) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(string);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.b();
        }
    }

    private static void c(String string, Exception exception2) {
        Throwable obj2 = exception2.getCause();
        if (exception2 instanceof InvocationTargetException != null && obj2 instanceof RuntimeException != null) {
            obj2 = exception2.getCause();
            if (obj2 instanceof RuntimeException != null) {
                throw (RuntimeException)obj2;
            }
            RuntimeException obj3 = new RuntimeException(obj2);
            throw obj3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to call ");
        stringBuilder.append(string);
        stringBuilder.append(" via reflection");
        Log.v("Trace", stringBuilder.toString(), exception2);
    }

    public static boolean d() {
        try {
            if (a.b == null) {
            }
            return Trace.isEnabled();
            return a.e();
        }
    }

    private static boolean e() {
        int sDK_INT;
        Method method;
        Class[] arr;
        Class tYPE;
        final int i = 0;
        int i3 = 1;
        final int i4 = 0;
        if (Build.VERSION.SDK_INT >= 18 && a.b == null) {
            i3 = 1;
            i4 = 0;
            if (a.b == null) {
                a.a = Trace.class.getField("TRACE_TAG_APP").getLong(i4);
                arr = new Class[i3];
                arr[i] = Long.TYPE;
                a.b = Trace.class.getMethod("isTagEnabled", arr);
            }
            Object[] arr2 = new Object[i3];
            arr2[i] = Long.valueOf(a.a);
            return (Boolean)a.b.invoke(i4, arr2).booleanValue();
        }
        return i;
    }
}
