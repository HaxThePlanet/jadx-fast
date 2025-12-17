package com.google.common.base;

import java.util.Locale;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class m {

    static class a {
    }

    private static final class b implements com.google.common.base.l {
        b(com.google.common.base.m.a m$a) {
            super();
        }
    }
    static {
        Logger.getLogger(m.class.getName());
        m.c();
    }

    static String a(String string) {
        String obj1;
        if (m.d(string)) {
            obj1 = 0;
        }
        return obj1;
    }

    static String b(double d) {
        Object[] arr = new Object[1];
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    private static com.google.common.base.l c() {
        m.b bVar = new m.b(0);
        return bVar;
    }

    static boolean d(String string) {
        int obj0;
        if (string != null) {
            if (string.isEmpty()) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    static long e() {
        return System.nanoTime();
    }
}
