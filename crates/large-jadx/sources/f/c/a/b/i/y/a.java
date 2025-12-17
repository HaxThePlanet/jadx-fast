package f.c.a.b.i.y;

import android.util.Log;

/* loaded from: classes.dex */
public final class a {
    public static void a(String string, String string2, Object object3) {
        Object[] arr = new Object[1];
        Log.d(a.d(string), String.format(string2, object3));
    }

    public static void b(String string, String string2, Object... object3Arr3) {
        Log.d(a.d(string), String.format(string2, object3Arr3));
    }

    public static void c(String string, String string2, Throwable throwable3) {
        Log.e(a.d(string), string2, throwable3);
    }

    private static String d(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransportRuntime.");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static void e(String string, String string2) {
        Log.i(a.d(string), string2);
    }

    public static void f(String string, String string2, Object object3) {
        Object[] arr = new Object[1];
        Log.w(a.d(string), String.format(string2, object3));
    }
}
