package h.a.b.i;

import android.util.Log;

/* loaded from: classes2.dex */
public class b {

    private static int a = 10;
    private static boolean b;
    private static boolean c;
    public static String d;
    static {
    }

    private static String a(String string) {
        boolean methodName;
        Object[] arr;
        boolean z;
        int i2;
        int i;
        int i3;
        Object obj6;
        Throwable throwable = new Throwable();
        int i4 = 3;
        java.lang.StackTraceElement stack = throwable.getStackTrace()[i4];
        i2 = 1;
        i = 0;
        i3 = 2;
        if (b.b && b.c) {
            throwable = new Throwable();
            i4 = 3;
            stack = throwable.getStackTrace()[i4];
            i2 = 1;
            i = 0;
            i3 = 2;
            if (b.c) {
                Object[] arr2 = new Object[i4];
                arr2[i] = stack.getMethodName();
                arr2[i2] = Integer.valueOf(stack.getLineNumber());
                arr2[i3] = string;
                return String.format("[%s:%s] %s", arr2);
            }
            arr = new Object[i3];
            arr[i] = stack.getMethodName();
            arr[i2] = string;
            obj6 = String.format("[%s] %s", arr);
        }
        return obj6;
    }

    public static void b(String string, Object... object2Arr2) {
        boolean z;
        String obj1;
        if (b.g()) {
            Log.d(b.e(), b.d(string, object2Arr2));
        }
    }

    public static void c(String string, Object... object2Arr2) {
        boolean z;
        String obj1;
        if (b.h()) {
            Log.e(b.e(), b.d(string, object2Arr2));
        }
    }

    static String d(String string, Object... object2Arr2) {
        int length;
        String obj1;
        if (object2Arr2 != null && object2Arr2.length == 0) {
            if (object2Arr2.length == 0) {
            } else {
                obj1 = String.format(string, object2Arr2);
            }
        } else {
        }
        return b.a(obj1);
    }

    private static String e() {
        String str = b.d;
        if (str != null) {
            return str;
        }
        Throwable throwable = new Throwable();
        String fileName = throwable.getStackTrace()[2].getFileName();
        if (fileName == null) {
            return "SourceFile";
        }
        return fileName.split("[.]")[0];
    }

    public static void f(String string, Object... object2Arr2) {
        boolean z;
        String obj1;
        if (b.i()) {
            Log.i(b.e(), b.d(string, object2Arr2));
        }
    }

    public static boolean g() {
        int i;
        i = b.a <= 3 ? 1 : 0;
        return i;
    }

    public static boolean h() {
        int i;
        i = b.a <= 6 ? 1 : 0;
        return i;
    }

    public static boolean i() {
        int i;
        i = b.a <= 4 ? 1 : 0;
        return i;
    }

    public static boolean j() {
        int i;
        i = b.a <= 2 ? 1 : 0;
        return i;
    }

    public static boolean k() {
        int i;
        i = b.a <= 5 ? 1 : 0;
        return i;
    }

    public static void l(String string) {
        b.d = string;
    }

    public static void m(String string, Object... object2Arr2) {
        boolean z;
        String obj1;
        if (b.j()) {
            Log.v(b.e(), b.d(string, object2Arr2));
        }
    }

    public static void n(String string, Object... object2Arr2) {
        boolean z;
        String obj1;
        if (b.k()) {
            Log.w(b.e(), b.d(string, object2Arr2));
        }
    }

    public static void o(String string, Object... object2Arr2) {
        boolean z;
        String obj1;
        if (b.h()) {
            Log.wtf(b.e(), b.d(string, object2Arr2));
        }
    }
}
