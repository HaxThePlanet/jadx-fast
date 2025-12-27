package com.iterable.iterableapi;

import android.util.Log;

/* compiled from: IterableLogger.java */
/* loaded from: classes2.dex */
public class j0 {
    public static void a(String str, String str2) {
        if (j0.f(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = " 💚 ";
            str4 = str3 + str2;
            Log.d(str, str4);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (j0.f(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = " 💚 ";
            str4 = str3 + str2;
            Log.d(str, str4, th);
        }
    }

    public static void c(String str, String str2) {
        if (j0.f(6)) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = " ❤️ ";
            str4 = str3 + str2;
            Log.e(str, str4);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (j0.f(6)) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = " ❤️ ";
            str4 = str3 + str2;
            Log.e(str, str4, th);
        }
    }

    private static int e() {
        if (j.p != null) {
            if (j.p.n()) {
                return 2;
            }
            return j.p.b.e;
        }
        return 6;
    }

    private static boolean f(int i) {
        boolean z = true;
        i = i >= j0.e() ? 1 : 0;
        return (i >= j0.e() ? 1 : 0);
    }

    public static void g() {
        String str3 = " => ";
        try {
            final StringBuilder stringBuilder = new StringBuilder();
            final int i = 3;
            String fileName = Thread.currentThread().getStackTrace()[i].getFileName();
            String className = Thread.currentThread().getStackTrace()[i].getClassName();
            String methodName = Thread.currentThread().getStackTrace()[i].getMethodName();
            String str4 = " => Line #";
            int lineNumber = Thread.currentThread().getStackTrace()[i].getLineNumber();
            str = fileName + str3 + className + str3 + methodName + str4 + lineNumber;
            j0.h("Iterable Call", str);
        } catch (Exception unused) {
            j0.c(str5, "Couldn't print info");
        }
    }

    public static void h(String str, String str2) {
        if (j0.f(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = " 💛 ";
            str4 = str3 + str2;
            Log.v(str, str4);
        }
    }

    public static void i(String str, String str2) {
        if (j0.f(5)) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = " 🧡️ ";
            str4 = str3 + str2;
            Log.w(str, str4);
        }
    }

    public static void j(String str, String str2, Throwable th) {
        if (j0.f(5)) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = " 🧡 ";
            str4 = str3 + str2;
            Log.w(str, str4, th);
        }
    }
}
