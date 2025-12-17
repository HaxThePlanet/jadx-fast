package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class e4 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.va> {
    e4() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        c4 c4Var = new c4(u1.class);
        super(va.class, arr);
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.za, com.google.android.gms.internal.firebase-auth-api.va> a() {
        d4 d4Var = new d4(this, za.class);
        return d4Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zze;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return va.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((va)y.z(), 0);
    }
}
