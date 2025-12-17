package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
final class or {

    private static final com.google.android.gms.internal.firebase-auth-api.mr<?> a;
    private static final com.google.android.gms.internal.firebase-auth-api.mr<?> b = null;
    static {
        nr nrVar = new nr();
        or.a = nrVar;
        int i2 = 0;
        Object instance = Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[i2]).newInstance(new Object[i2]);
    }

    static com.google.android.gms.internal.firebase-auth-api.mr<?> a() {
        com.google.android.gms.internal.firebase-auth-api.mr mrVar = or.b;
        if (mrVar == null) {
        } else {
            return mrVar;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw illegalStateException;
    }

    static com.google.android.gms.internal.firebase-auth-api.mr<?> b() {
        return or.a;
    }
}
