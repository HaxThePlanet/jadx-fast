package com.google.android.gms.internal.firebase-auth-api;

import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class c5 implements com.google.android.gms.internal.firebase-auth-api.v2<com.google.android.gms.internal.firebase-auth-api.z1, com.google.android.gms.internal.firebase-auth-api.z1> {

    private static final Logger a;
    static {
        c5.a = Logger.getLogger(c5.class.getName());
    }

    static Logger b() {
        return c5.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v2
    public final Object a(com.google.android.gms.internal.firebase-auth-api.u2 u2) {
        b5 b5Var = new b5(u2);
        return b5Var;
    }

    public final Class<com.google.android.gms.internal.firebase-auth-api.z1> zza() {
        return z1.class;
    }

    public final Class<com.google.android.gms.internal.firebase-auth-api.z1> zzb() {
        return z1.class;
    }
}
