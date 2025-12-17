package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class l3 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.o6> {
    l3() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        j3 j3Var = new j3(u1.class);
        super(o6.class, arr);
    }

    static com.google.android.gms.internal.firebase-auth-api.g2 j(int i, int i2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.l9 l95, int i6) {
        com.google.android.gms.internal.firebase-auth-api.x6 obj4 = y6.A();
        com.google.android.gms.internal.firebase-auth-api.a7 a7Var = b7.A();
        a7Var.j(16);
        obj4.m((b7)a7Var.e());
        obj4.j(i);
        obj4 = r9.A();
        com.google.android.gms.internal.firebase-auth-api.t9 t9Var = u9.B();
        t9Var.j(l95);
        t9Var.m(i4);
        obj4.m((u9)t9Var.e());
        obj4.j(32);
        com.google.android.gms.internal.firebase-auth-api.q6 obj5 = r6.z();
        obj5.j((y6)obj4.e());
        obj5.m((r9)obj4.e());
        g2 obj3 = new g2((r6)obj5.e(), i6);
        return obj3;
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.r6, com.google.android.gms.internal.firebase-auth-api.o6> a() {
        k3 k3Var = new k3(this, r6.class);
        return k3Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return o6.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((o6)y.z(), 0);
        o3 o3Var = new o3();
        o3.k(y.D());
        x5 x5Var = new x5();
        x5.l(y.E());
    }
}
