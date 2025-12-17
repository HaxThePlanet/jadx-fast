package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class i4 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.cb> {
    i4() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        g4 g4Var = new g4(u1.class);
        super(cb.class, arr);
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.fb, com.google.android.gms.internal.firebase-auth-api.cb> a() {
        h4 h4Var = new h4(this, fb.class);
        return h4Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zze;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return cb.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((cb)y.z(), 0);
    }
}
