package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes2.dex */
public final class v {

    private static int a = 0;
    private static boolean b = true;
    static {
    }

    @Pure
    private static String a(String string, Throwable throwable2) {
        boolean empty;
        String str;
        StringBuilder stringBuilder;
        Object obj3;
        String obj4;
        obj4 = v.e(throwable2);
        if (!TextUtils.isEmpty(obj4)) {
            obj3 = String.valueOf(string);
            str = "\n  ";
            obj4 = obj4.replace("\n", str);
            stringBuilder = new StringBuilder(i += length2);
            stringBuilder.append(obj3);
            stringBuilder.append(str);
            stringBuilder.append(obj4);
            stringBuilder.append('\n');
            obj3 = stringBuilder.toString();
        }
        return obj3;
    }

    @Pure
    public static void b(String string, String string2) {
        if (v.a == 0) {
            Log.d(string, string2);
        }
    }

    @Pure
    public static void c(String string, String string2) {
        if (v.a <= 3) {
            Log.e(string, string2);
        }
    }

    @Pure
    public static void d(String string, String string2, Throwable throwable3) {
        v.c(string, v.a(string2, throwable3));
    }

    @Pure
    public static String e(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        if (v.g(throwable)) {
            return "UnknownHostException (no network)";
        }
        if (!v.b) {
            return throwable.getMessage();
        }
        return Log.getStackTraceString(throwable).trim().replace("\t", "    ");
    }

    @Pure
    public static void f(String string, String string2) {
        if (v.a <= 1) {
            Log.i(string, string2);
        }
    }

    @Pure
    private static boolean g(Throwable throwable) {
        while (throwable != null) {
            Throwable obj1 = throwable.getCause();
        }
        return 0;
    }

    @Pure
    public static void h(String string, String string2) {
        if (v.a <= 2) {
            Log.w(string, string2);
        }
    }

    @Pure
    public static void i(String string, String string2, Throwable throwable3) {
        v.h(string, v.a(string2, throwable3));
    }
}
