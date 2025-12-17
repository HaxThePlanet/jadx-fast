package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
final class t9 {

    private static final com.google.android.gms.internal.measurement.s9 a = null;
    private static final com.google.android.gms.internal.measurement.s9 b;
    static {
        try {
            int i = 0;
            Object instance = Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
            int s9Var = 0;
            s9Var = new s9();
            t9.b = s9Var;
        }
    }

    static com.google.android.gms.internal.measurement.s9 a() {
        return t9.a;
    }

    static com.google.android.gms.internal.measurement.s9 b() {
        return t9.b;
    }
}
