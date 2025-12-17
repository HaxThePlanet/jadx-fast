package com.google.protobuf;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
final class t {

    private static final com.google.protobuf.r<?> a;
    private static final com.google.protobuf.r<?> b;
    static {
        s sVar = new s();
        t.a = sVar;
        t.b = t.c();
    }

    static com.google.protobuf.r<?> a() {
        com.google.protobuf.r rVar = t.b;
        if (rVar == null) {
        } else {
            return rVar;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw illegalStateException;
    }

    static com.google.protobuf.r<?> b() {
        return t.a;
    }

    private static com.google.protobuf.r<?> c() {
        try {
            int i2 = 0;
            return (r)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[i2]).newInstance(new Object[i2]);
            return 0;
        }
    }
}
