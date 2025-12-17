package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class k3 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.r6, com.google.android.gms.internal.firebase-auth-api.o6> {
    k3(com.google.android.gms.internal.firebase-auth-api.l3 l3, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return r6.B(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        o3 o3Var = new o3();
        x5 x5Var = new x5();
        com.google.android.gms.internal.firebase-auth-api.n6 n6Var = o6.A();
        n6Var.j(n3.g((r6)y.C()));
        n6Var.m((o9)x5Var.a().c(y.D()));
        n6Var.s(0);
        return (o6)n6Var.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.r6>> d() {
        HashMap hashMap = new HashMap();
        final int i9 = 32;
        int i10 = 16;
        final com.google.android.gms.internal.firebase-auth-api.l9 l9Var = zzd;
        hashMap.put("AES128_CTR_HMAC_SHA256", l3.j(16, 16, i9, i10, l9Var, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", l3.j(16, 16, i9, i10, l9Var, 3));
        int i11 = 32;
        hashMap.put("AES256_CTR_HMAC_SHA256", l3.j(32, 16, i9, i11, l9Var, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", l3.j(32, 16, i9, i11, l9Var, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        o3 o3Var = new o3();
        (n3)o3Var.a().f((r6)y.C());
        x5 x5Var = new x5();
        x5Var.a().e(y.D());
        ed.b(y.C().z());
    }
}
