package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class w5 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.r9, com.google.android.gms.internal.firebase-auth-api.o9> {
    w5(com.google.android.gms.internal.firebase-auth-api.x5 x5, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return r9.D(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        final com.google.android.gms.internal.firebase-auth-api.n9 n9Var = o9.A();
        n9Var.s(0);
        n9Var.m((r9)y.E());
        n9Var.j(wq.v(cd.a(y.z())));
        return (o9)n9Var.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.r9>> d() {
        HashMap hashMap = new HashMap();
        com.google.android.gms.internal.firebase-auth-api.l9 zzd = l9.zzd;
        int i = 32;
        int i2 = 16;
        final int i3 = 1;
        hashMap.put("HMAC_SHA256_128BITTAG", x5.k(i, i2, zzd, i3));
        int i4 = 3;
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", x5.k(i, i2, zzd, i4));
        hashMap.put("HMAC_SHA256_256BITTAG", x5.k(i, i, zzd, i3));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", x5.k(i, i, zzd, i4));
        com.google.android.gms.internal.firebase-auth-api.l9 zze = l9.zze;
        int i5 = 64;
        hashMap.put("HMAC_SHA512_128BITTAG", x5.k(i5, i2, zze, i3));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", x5.k(i5, i2, zze, i4));
        hashMap.put("HMAC_SHA512_256BITTAG", x5.k(i5, i, zze, i3));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", x5.k(i5, i, zze, i4));
        hashMap.put("HMAC_SHA512_512BITTAG", x5.k(i5, i5, zze, i3));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", x5.k(i5, i5, zze, i4));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        if ((r9)y.z() < 16) {
        } else {
            x5.j(y.E());
        }
        GeneralSecurityException obj3 = new GeneralSecurityException("key too short");
        throw obj3;
    }
}
