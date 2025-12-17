package com.google.android.gms.internal.firebase-auth-api;

import java.security.InvalidKeyException;

/* loaded from: classes2.dex */
public final class r4 extends com.google.android.gms.internal.firebase-auth-api.j2<com.google.android.gms.internal.firebase-auth-api.a8> {
    r4() {
        com.google.android.gms.internal.firebase-auth-api.i2[] arr = new i2[1];
        o4 o4Var = new o4(y1.class);
        super(a8.class, arr);
    }

    public final com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.d8, com.google.android.gms.internal.firebase-auth-api.a8> a() {
        p4 p4Var = new p4(this, d8.class);
        return p4Var;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.z9 b() {
        return z9.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final com.google.android.gms.internal.firebase-auth-api.y c(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return a8.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final String g() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.j2
    public final void i(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.c((a8)y.z(), 0);
        if (y.D().g() != 64) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder(61);
        stringBuilder.append("invalid key size: ");
        stringBuilder.append(y.D().g());
        stringBuilder.append(". Valid keys must have 64 bytes.");
        InvalidKeyException invalidKeyException = new InvalidKeyException(stringBuilder.toString());
        throw invalidKeyException;
    }
}
