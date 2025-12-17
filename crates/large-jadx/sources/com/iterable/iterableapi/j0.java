package com.iterable.iterableapi;

import android.util.Log;

/* loaded from: classes2.dex */
public class j0 {
    public static void a(String string, String string2) {
        boolean stringBuilder;
        String str;
        String obj3;
        if (j0.f(3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" 💚 ");
            stringBuilder.append(string2);
            Log.d(string, stringBuilder.toString());
        }
    }

    public static void b(String string, String string2, Throwable throwable3) {
        boolean stringBuilder;
        String str;
        String obj3;
        if (j0.f(3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" 💚 ");
            stringBuilder.append(string2);
            Log.d(string, stringBuilder.toString(), throwable3);
        }
    }

    public static void c(String string, String string2) {
        boolean stringBuilder;
        String str;
        String obj3;
        if (j0.f(6)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" ❤️ ");
            stringBuilder.append(string2);
            Log.e(string, stringBuilder.toString());
        }
    }

    public static void d(String string, String string2, Throwable throwable3) {
        boolean stringBuilder;
        String str;
        String obj3;
        if (j0.f(6)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" ❤️ ");
            stringBuilder.append(string2);
            Log.e(string, stringBuilder.toString(), throwable3);
        }
    }

    private static int e() {
        if (j.p != null && j.p.n()) {
            if (j.p.n()) {
                return 2;
            }
            return qVar.e;
        }
        return 6;
    }

    private static boolean f(int i) {
        int obj1;
        obj1 = i >= j0.e() ? 1 : 0;
        return obj1;
    }

    public static void g() {
        String string;
        String str2 = " => ";
        StringBuilder stringBuilder = new StringBuilder();
        final int i = 3;
        stringBuilder.append(Thread.currentThread().getStackTrace()[i].getFileName());
        stringBuilder.append(str2);
        stringBuilder.append(Thread.currentThread().getStackTrace()[i].getClassName());
        stringBuilder.append(str2);
        stringBuilder.append(Thread.currentThread().getStackTrace()[i].getMethodName());
        stringBuilder.append(" => Line #");
        stringBuilder.append(Thread.currentThread().getStackTrace()[i].getLineNumber());
        j0.h("Iterable Call", stringBuilder.toString());
    }

    public static void h(String string, String string2) {
        boolean stringBuilder;
        String str;
        String obj3;
        if (j0.f(2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" 💛 ");
            stringBuilder.append(string2);
            Log.v(string, stringBuilder.toString());
        }
    }

    public static void i(String string, String string2) {
        boolean stringBuilder;
        String str;
        String obj3;
        if (j0.f(5)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" 🧡️ ");
            stringBuilder.append(string2);
            Log.w(string, stringBuilder.toString());
        }
    }

    public static void j(String string, String string2, Throwable throwable3) {
        boolean stringBuilder;
        String str;
        String obj3;
        if (j0.f(5)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" 🧡 ");
            stringBuilder.append(string2);
            Log.w(string, stringBuilder.toString(), throwable3);
        }
    }
}
