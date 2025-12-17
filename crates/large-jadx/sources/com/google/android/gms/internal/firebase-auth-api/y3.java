package com.google.android.gms.internal.firebase-auth-api;

import javax.crypto.Cipher;

/* loaded from: classes2.dex */
public final class y3 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.u7> {
    y3() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        w3 w3Var = new w3(u1.class);
        super(u7.class, arr);
    }

    public static void j(boolean z) {
        int i;
        boolean obj1;
        if (y3.l()) {
            obj1 = new y3();
            c3.m(obj1, true);
        }
    }

    static com.google.android.gms.internal.firebase-auth-api.g2 k(int i, int i2) {
        com.google.android.gms.internal.firebase-auth-api.w7 w7Var = x7.A();
        w7Var.j(i);
        g2 g2Var = new g2((x7)w7Var.e(), i2);
        return g2Var;
    }

    private static boolean l() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return 1;
            return 0;
        }
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.x7, com.google.android.gms.internal.firebase-auth-api.u7> a() {
        x3 x3Var = new x3(this, x7.class);
        return x3Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return u7.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((u7)y.z(), 0);
        ed.b(y.D().g());
    }
}
