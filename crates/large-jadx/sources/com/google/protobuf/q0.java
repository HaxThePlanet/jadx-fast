package com.google.protobuf;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
final class q0 {

    private static final com.google.protobuf.o0 a;
    private static final com.google.protobuf.o0 b;
    static {
        q0.a = q0.c();
        p0 p0Var = new p0();
        q0.b = p0Var;
    }

    static com.google.protobuf.o0 a() {
        return q0.a;
    }

    static com.google.protobuf.o0 b() {
        return q0.b;
    }

    private static com.google.protobuf.o0 c() {
        try {
            int i2 = 0;
            return (o0)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[i2]).newInstance(new Object[i2]);
            return null;
        }
    }
}
