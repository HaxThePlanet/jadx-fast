package com.google.protobuf;

/* loaded from: classes2.dex */
final class d {

    private static boolean a;
    private static final Class<?> b;
    private static final boolean c = false;
    static {
        boolean z;
        d.b = d.a("libcore.io.Memory");
        if (!d.a && d.a("org.robolectric.Robolectric") != null) {
            if (d.a("org.robolectric.Robolectric") != null) {
                int i2 = 1;
            }
        }
        int i = 0;
    }

    private static <T> Class<T> a(String string) {
        try {
            return Class.forName(string);
            string = null;
            return string;
        }
    }

    static Class<?> b() {
        return d.b;
    }

    static boolean c() {
        Class z;
        int i;
        if (!d.a) {
            if (d.b != null && !d.c) {
                if (!d.c) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
