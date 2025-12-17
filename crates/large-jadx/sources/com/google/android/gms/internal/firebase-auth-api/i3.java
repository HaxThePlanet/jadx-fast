package com.google.android.gms.internal.firebase-auth-api;

import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class i3 implements com.google.android.gms.internal.firebase-auth-api.v2<com.google.android.gms.internal.firebase-auth-api.u1, com.google.android.gms.internal.firebase-auth-api.u1> {

    private static final Logger a;
    static {
        i3.a = Logger.getLogger(i3.class.getName());
    }

    static Logger b() {
        return i3.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.v2
    public final Object a(com.google.android.gms.internal.firebase-auth-api.u2 u2) {
        h3 h3Var = new h3(u2, 0);
        return h3Var;
    }

    public final Class<com.google.android.gms.internal.firebase-auth-api.u1> zza() {
        return u1.class;
    }

    public final Class<com.google.android.gms.internal.firebase-auth-api.u1> zzb() {
        return u1.class;
    }
}
