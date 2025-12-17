package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class b4 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.g8> {
    b4() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        z3 z3Var = new z3(u1.class);
        super(g8.class, arr);
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.j8, com.google.android.gms.internal.firebase-auth-api.g8> a() {
        a4 a4Var = new a4(this, j8.class);
        return a4Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return g8.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((g8)y.z(), 0);
        if (y.D().g() != 32) {
        } else {
        }
        GeneralSecurityException obj3 = new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        throw obj3;
    }
}
