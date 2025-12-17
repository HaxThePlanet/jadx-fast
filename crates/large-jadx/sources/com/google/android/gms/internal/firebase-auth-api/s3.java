package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class s3 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.e7> {
    s3() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        q3 q3Var = new q3(u1.class);
        super(e7.class, arr);
    }

    static com.google.android.gms.internal.firebase-auth-api.g2 j(int i, int i2, int i3) {
        com.google.android.gms.internal.firebase-auth-api.g7 obj2 = h7.A();
        obj2.j(i);
        com.google.android.gms.internal.firebase-auth-api.j7 obj1 = k7.A();
        obj1.j(16);
        obj2.m((k7)obj1.e());
        obj2 = new g2((h7)obj2.e(), i3);
        return obj2;
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.h7, com.google.android.gms.internal.firebase-auth-api.e7> a() {
        r3 r3Var = new r3(this, h7.class);
        return r3Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return e7.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        int i;
        int obj3;
        ed.c((e7)y.z(), 0);
        ed.b(y.E().g());
        if (y.D().z() != 12) {
            if (y.D().z() != 16) {
            } else {
            }
            obj3 = new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            throw obj3;
        }
    }
}
