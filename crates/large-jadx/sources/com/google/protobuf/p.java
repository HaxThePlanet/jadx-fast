package com.google.protobuf;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class p {

    static final Class<?> a;
    static {
        p.a = p.c();
    }

    public static com.google.protobuf.q a() {
        com.google.protobuf.q qVar;
        if (p.b("getEmptyRegistry") != null) {
        } else {
            qVar = q.d;
        }
        return qVar;
    }

    private static final com.google.protobuf.q b(String string) {
        Class cls = p.a;
        final int i = 0;
        if (cls == null) {
            return i;
        }
        final int i2 = 0;
        return (q)cls.getDeclaredMethod(string, new Class[i2]).invoke(i, new Object[i2]);
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
            return 0;
        }
    }
}
