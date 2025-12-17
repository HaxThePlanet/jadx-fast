package com.google.android.gms.internal.firebase-auth-api;

import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class u4 implements com.google.android.gms.internal.firebase-auth-api.v2<com.google.android.gms.internal.firebase-auth-api.y1, com.google.android.gms.internal.firebase-auth-api.y1> {

    private static final Logger a;
    static {
        u4.a = Logger.getLogger(u4.class.getName());
    }

    static Logger b() {
        return u4.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v2
    public final Object a(com.google.android.gms.internal.firebase-auth-api.u2 u2) {
        t4 t4Var = new t4(u2);
        return t4Var;
    }

    public final Class<com.google.android.gms.internal.firebase-auth-api.y1> zza() {
        return y1.class;
    }

    public final Class<com.google.android.gms.internal.firebase-auth-api.y1> zzb() {
        return y1.class;
    }
}
