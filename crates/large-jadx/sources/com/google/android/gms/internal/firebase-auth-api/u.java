package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
final class u {

    private static final com.google.android.gms.internal.firebase-auth-api.t a = null;
    private static final com.google.android.gms.internal.firebase-auth-api.t b;
    static {
        try {
            int i = 0;
            Object instance = Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
            int tVar = 0;
            tVar = new t();
            u.b = tVar;
        }
    }

    static com.google.android.gms.internal.firebase-auth-api.t a() {
        return u.a;
    }

    static com.google.android.gms.internal.firebase-auth-api.t b() {
        return u.b;
    }
}
