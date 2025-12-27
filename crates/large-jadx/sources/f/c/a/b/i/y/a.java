package f.c.a.b.i.y;

import android.util.Log;

/* compiled from: Logging.java */
/* loaded from: classes.dex */
public final class a {
    public static void a(String str, String str2, Object object) {
        Object[] arr = new Object[1];
        Log.d(a.d(str), String.format(str2, new Object[] { object }));
    }

    public static void b(String str, String str2, Object... objectArr) {
        Log.d(a.d(str), String.format(str2, objectArr));
    }

    public static void c(String str, String str2, Throwable th) {
        Log.e(a.d(str), str2, th);
    }

    private static String d(String str) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str2 = "TransportRuntime.";
        str3 = str2 + str;
        return str3;
    }

    public static void e(String str, String str2) {
        Log.i(a.d(str), str2);
    }

    public static void f(String str, String str2, Object object) {
        Object[] arr = new Object[1];
        Log.w(a.d(str), String.format(str2, new Object[] { object }));
    }
}
