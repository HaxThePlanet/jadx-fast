package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class v3 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.n7> {
    v3() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        t3 t3Var = new t3(u1.class);
        super(n7.class, arr);
    }

    static com.google.android.gms.internal.firebase-auth-api.g2 j(int i, int i2) {
        com.google.android.gms.internal.firebase-auth-api.p7 p7Var = q7.A();
        p7Var.j(i);
        g2 g2Var = new g2((q7)p7Var.e(), i2);
        return g2Var;
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.q7, com.google.android.gms.internal.firebase-auth-api.n7> a() {
        u3 u3Var = new u3(this, q7.class);
        return u3Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return n7.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((n7)y.z(), 0);
        ed.b(y.D().g());
    }
}
