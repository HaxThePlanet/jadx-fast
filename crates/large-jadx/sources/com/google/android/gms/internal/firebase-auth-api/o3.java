package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class o3 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.v6> {
    o3() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        m3 m3Var = new m3(uc.class);
        super(v6.class, arr);
    }

    static void j(com.google.android.gms.internal.firebase-auth-api.o3 o3, com.google.android.gms.internal.firebase-auth-api.b7 b72) {
        o3.l(b72);
    }

    public static final void k(com.google.android.gms.internal.firebase-auth-api.v6 v6) {
        ed.c(v6.z(), 0);
        ed.b(v6.F().g());
        o3.l(v6.E());
    }

    private static final void l(com.google.android.gms.internal.firebase-auth-api.b7 b7) {
        int i;
        int obj2;
        if (b7.z() < 12) {
        } else {
            if (b7.z() > 16) {
            } else {
            }
        }
        obj2 = new GeneralSecurityException("invalid IV size");
        throw obj2;
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.y6, com.google.android.gms.internal.firebase-auth-api.v6> a() {
        n3 n3Var = new n3(this, y6.class);
        return n3Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return v6.D(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        o3.k((v6)y);
    }
}
