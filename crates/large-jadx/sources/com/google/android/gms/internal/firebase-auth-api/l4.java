package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class l4 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.nb> {
    l4() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        j4 j4Var = new j4(u1.class);
        super(nb.class, arr);
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.qb, com.google.android.gms.internal.firebase-auth-api.nb> a() {
        k4 k4Var = new k4(this, qb.class);
        return k4Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return nb.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((nb)y.z(), 0);
        if (y.D().g() != 32) {
        } else {
        }
        GeneralSecurityException obj3 = new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        throw obj3;
    }
}
