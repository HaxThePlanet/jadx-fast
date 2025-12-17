package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class x3 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.x7, com.google.android.gms.internal.firebase-auth-api.u7> {
    x3(com.google.android.gms.internal.firebase-auth-api.y3 y3, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return x7.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        final com.google.android.gms.internal.firebase-auth-api.s7 s7Var = u7.A();
        s7Var.j(wq.v(cd.a((x7)y.z())));
        s7Var.m(0);
        return (u7)s7Var.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.x7>> d() {
        HashMap hashMap = new HashMap();
        int i = 16;
        int i3 = 1;
        hashMap.put("AES128_GCM_SIV", y3.k(i, i3));
        int i4 = 3;
        hashMap.put("AES128_GCM_SIV_RAW", y3.k(i, i4));
        int i2 = 32;
        hashMap.put("AES256_GCM_SIV", y3.k(i2, i3));
        hashMap.put("AES256_GCM_SIV_RAW", y3.k(i2, i4));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.b((x7)y.z());
    }
}
