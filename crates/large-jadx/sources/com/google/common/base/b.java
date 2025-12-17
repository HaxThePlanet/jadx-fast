package com.google.common.base;

/* loaded from: classes2.dex */
public final class b {
    public static boolean a(char c) {
        int i;
        int obj1;
        if (c >= 97 && c <= 122) {
            obj1 = c <= 122 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean b(char c) {
        int i;
        int obj1;
        if (c >= 65 && c <= 90) {
            obj1 = c <= 90 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static String c(String string) {
        int i;
        boolean z;
        boolean z2;
        final int length = string.length();
        i = 0;
        while (i < length) {
            if (b.b(string.charAt(i))) {
                break;
            } else {
            }
            i++;
        }
        return string;
    }

    public static char d(char c) {
        char obj1;
        if (b.a(c)) {
            obj1 = (char)obj1;
        }
        return obj1;
    }

    public static String e(String string) {
        int i;
        boolean z;
        boolean z2;
        final int length = string.length();
        i = 0;
        while (i < length) {
            if (b.a(string.charAt(i))) {
                break;
            } else {
            }
            i++;
        }
        return string;
    }
}
