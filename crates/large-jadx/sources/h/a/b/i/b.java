package h.a.b.i;

import android.util.Log;

/* compiled from: Log.java */
/* loaded from: classes2.dex */
public class b {

    private static int a = 10;
    private static boolean b;
    private static boolean c;
    public static String d;
    private static String a(String str) {
        String formatted;
        if (b.b) {
            int i4 = 3;
            java.lang.StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i4];
            int i = 1;
            int i2 = 0;
            int i3 = 2;
            if (b.c) {
                Object[] arr2 = new Object[i4];
                return String.format("[%s:%s] %s", new Object[] { stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()), str });
            }
            Object[] arr = new Object[i3];
            formatted = String.format("[%s] %s", new Object[] { stackTraceElement.getMethodName(), str });
        }
        return formatted;
    }

    public static void b(String str, Object... objectArr) {
        if (b.g()) {
            Log.d(b.e(), b.d(str, objectArr));
        }
    }

    public static void c(String str, Object... objectArr) {
        if (b.h()) {
            Log.e(b.e(), b.d(str, objectArr));
        }
    }

    static String d(String str, Object... objectArr) {
        int length;
        String formatted;
        if (objectArr != null) {
            length = objectArr.length;
            if (objectArr.length != 0) {
                formatted = String.format(str, objectArr);
            }
        }
        return b.a(formatted);
    }

    private static String e() {
        String str = b.d;
        if (b.d != null) {
            return b.d;
        }
        String fileName = new Throwable().getStackTrace()[2].getFileName();
        if (fileName == null) {
            return "SourceFile";
        }
        return fileName.split("[.]")[0];
    }

    public static void f(String str, Object... objectArr) {
        if (b.i()) {
            Log.i(b.e(), b.d(str, objectArr));
        }
    }

    public static boolean g() {
        boolean z = true;
        int r0 = b.a <= 3 ? 1 : 0;
        return (b.a <= 3 ? 1 : 0);
    }

    public static boolean h() {
        boolean z = true;
        int r0 = b.a <= 6 ? 1 : 0;
        return (b.a <= 6 ? 1 : 0);
    }

    public static boolean i() {
        boolean z = true;
        int r0 = b.a <= 4 ? 1 : 0;
        return (b.a <= 4 ? 1 : 0);
    }

    public static boolean j() {
        boolean z = true;
        int r0 = b.a <= 2 ? 1 : 0;
        return (b.a <= 2 ? 1 : 0);
    }

    public static boolean k() {
        boolean z = true;
        int r0 = b.a <= 5 ? 1 : 0;
        return (b.a <= 5 ? 1 : 0);
    }

    public static void l(String str) {
        b.d = str;
    }

    public static void m(String str, Object... objectArr) {
        if (b.j()) {
            Log.v(b.e(), b.d(str, objectArr));
        }
    }

    public static void n(String str, Object... objectArr) {
        if (b.k()) {
            Log.w(b.e(), b.d(str, objectArr));
        }
    }

    public static void o(String str, Object... objectArr) {
        if (b.h()) {
            Log.wtf(b.e(), b.d(str, objectArr));
        }
    }

}
