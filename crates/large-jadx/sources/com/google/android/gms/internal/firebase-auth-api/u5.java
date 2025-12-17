package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class u5 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.f6> {
    u5() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        s5 s5Var = new s5(q2.class);
        super(f6.class, arr);
    }

    static void j(com.google.android.gms.internal.firebase-auth-api.l6 l6) {
        u5.l(l6);
    }

    static void k(int i) {
        u5.m(i);
    }

    private static void l(com.google.android.gms.internal.firebase-auth-api.l6 l6) {
        if (l6.z() < 10) {
        } else {
            if (l6.z() > 16) {
            } else {
            }
            GeneralSecurityException obj2 = new GeneralSecurityException("tag size too long");
            throw obj2;
        }
        obj2 = new GeneralSecurityException("tag size too short");
        throw obj2;
    }

    private static void m(int i) {
        if (i != 32) {
        } else {
        }
        GeneralSecurityException obj1 = new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        throw obj1;
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.i6, com.google.android.gms.internal.firebase-auth-api.f6> a() {
        t5 t5Var = new t5(this, i6.class);
        return t5Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return f6.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((f6)y.z(), 0);
        u5.m(y.E().g());
        u5.l(y.D());
    }
}
