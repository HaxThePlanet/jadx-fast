package com.google.android.gms.internal.firebase-auth-api;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class w4 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.r8, com.google.android.gms.internal.firebase-auth-api.y8> {
    w4(com.google.android.gms.internal.firebase-auth-api.x4 x4, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return r8.B(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        Object obj = mc.h.a("EC");
        (KeyPairGenerator)obj.initialize(kc.f(g5.c((r8)y.C().E().C())));
        KeyPair keyPair = obj.generateKeyPair();
        ECPoint eCPoint = (ECPublicKey)keyPair.getPublic().getW();
        com.google.android.gms.internal.firebase-auth-api.a9 a9Var = b9.B();
        final int i2 = 0;
        a9Var.m(i2);
        a9Var.j(y.C());
        a9Var.s(wq.v(eCPoint.getAffineX().toByteArray()));
        a9Var.t(wq.v(eCPoint.getAffineY().toByteArray()));
        com.google.android.gms.internal.firebase-auth-api.x8 x8Var = y8.A();
        x8Var.s(i2);
        x8Var.m((b9)a9Var.e());
        x8Var.j(wq.v((ECPrivateKey)keyPair.getPrivate().getS().toByteArray()));
        return (y8)x8Var.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.r8>> d() {
        HashMap hashMap = new HashMap();
        final com.google.android.gms.internal.firebase-auth-api.g9 zzb = g9.zzb;
        final com.google.android.gms.internal.firebase-auth-api.l9 zzd = l9.zzd;
        final com.google.android.gms.internal.firebase-auth-api.l8 zzb2 = l8.zzb;
        String str10 = "AES128_GCM";
        com.google.android.gms.internal.firebase-auth-api.l8 l8Var = zzb2;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", x4.k(zzb, zzd, l8Var, f2.a(str10), x4.j(), 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", x4.k(zzb, zzd, l8Var, f2.a(str10), x4.j(), 3));
        final com.google.android.gms.internal.firebase-auth-api.l8 zzc = l8.zzc;
        com.google.android.gms.internal.firebase-auth-api.l8 l8Var2 = zzc;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", x4.k(zzb, zzd, l8Var2, f2.a(str10), x4.j(), 1));
        int i4 = 3;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", x4.k(zzb, zzd, l8Var2, f2.a(str10), x4.j(), i4));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", x4.k(zzb, zzd, l8Var2, f2.a(str10), x4.j(), i4));
        String str11 = "AES128_CTR_HMAC_SHA256";
        com.google.android.gms.internal.firebase-auth-api.l8 l8Var3 = zzb2;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", x4.k(zzb, zzd, l8Var3, f2.a(str11), x4.j(), 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", x4.k(zzb, zzd, l8Var3, f2.a(str11), x4.j(), 3));
        com.google.android.gms.internal.firebase-auth-api.l8 l8Var4 = zzc;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", x4.k(zzb, zzd, l8Var4, f2.a(str11), x4.j(), 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", x4.k(zzb, zzd, l8Var4, f2.a(str11), x4.j(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        g5.b((r8)y.C());
    }
}
