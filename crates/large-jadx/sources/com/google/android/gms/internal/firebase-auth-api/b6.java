package com.google.android.gms.internal.firebase-auth-api;

import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class b6 implements com.google.android.gms.internal.firebase-auth-api.v2<com.google.android.gms.internal.firebase-auth-api.q2, com.google.android.gms.internal.firebase-auth-api.q2> {

    private static final Logger a;
    static {
        b6.a = Logger.getLogger(b6.class.getName());
    }

    static Logger b() {
        return b6.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v2
    public final Object a(com.google.android.gms.internal.firebase-auth-api.u2 u2) {
        a6 a6Var = new a6(u2, 0);
        return a6Var;
    }

    public final Class<com.google.android.gms.internal.firebase-auth-api.q2> zza() {
        return q2.class;
    }

    public final Class<com.google.android.gms.internal.firebase-auth-api.q2> zzb() {
        return q2.class;
    }
}
