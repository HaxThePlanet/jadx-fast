package com.google.protobuf;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
final class a1 {

    private static final com.google.protobuf.y0 a;
    private static final com.google.protobuf.y0 b;
    static {
        a1.a = a1.c();
        z0 z0Var = new z0();
        a1.b = z0Var;
    }

    static com.google.protobuf.y0 a() {
        return a1.a;
    }

    static com.google.protobuf.y0 b() {
        return a1.b;
    }

    private static com.google.protobuf.y0 c() {
        try {
            int i2 = 0;
            return (y0)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[i2]).newInstance(new Object[i2]);
            return null;
        }
    }
}
