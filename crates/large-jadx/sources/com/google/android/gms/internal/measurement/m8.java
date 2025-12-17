package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
final class m8 {

    private static final com.google.android.gms.internal.measurement.k8<?> a;
    private static final com.google.android.gms.internal.measurement.k8<?> b = null;
    static {
        l8 l8Var = new l8();
        m8.a = l8Var;
        int i2 = 0;
        Object instance = Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[i2]).newInstance(new Object[i2]);
    }

    static com.google.android.gms.internal.measurement.k8<?> a() {
        com.google.android.gms.internal.measurement.k8 k8Var = m8.b;
        if (k8Var == null) {
        } else {
            return k8Var;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw illegalStateException;
    }

    static com.google.android.gms.internal.measurement.k8<?> b() {
        return m8.a;
    }
}
