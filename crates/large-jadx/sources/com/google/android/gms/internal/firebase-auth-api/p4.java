package com.google.android.gms.internal.firebase-auth-api;

import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class p4 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.d8, com.google.android.gms.internal.firebase-auth-api.a8> {
    p4(com.google.android.gms.internal.firebase-auth-api.r4 r4, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return d8.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        final com.google.android.gms.internal.firebase-auth-api.z7 z7Var = a8.A();
        z7Var.j(wq.v(cd.a((d8)y.z())));
        z7Var.m(0);
        return (a8)z7Var.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.d8>> d() {
        HashMap hashMap = new HashMap();
        com.google.android.gms.internal.firebase-auth-api.c8 c8Var = d8.A();
        int i = 64;
        c8Var.j(i);
        g2 g2Var = new g2((d8)c8Var.e(), 1);
        hashMap.put("AES256_SIV", g2Var);
        com.google.android.gms.internal.firebase-auth-api.c8 c8Var2 = d8.A();
        c8Var2.j(i);
        g2 g2Var2 = new g2((d8)c8Var2.e(), 3);
        hashMap.put("AES256_SIV_RAW", g2Var2);
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        if ((d8)y.z() != 64) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder(61);
        stringBuilder.append("invalid key size: ");
        stringBuilder.append(y.z());
        stringBuilder.append(". Valid keys must have 64 bytes.");
        InvalidAlgorithmParameterException invalidAlgorithmParameterException = new InvalidAlgorithmParameterException(stringBuilder.toString());
        throw invalidAlgorithmParameterException;
    }
}
