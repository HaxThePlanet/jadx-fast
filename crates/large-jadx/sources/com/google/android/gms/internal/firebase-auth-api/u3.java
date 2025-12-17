package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class u3 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.q7, com.google.android.gms.internal.firebase-auth-api.n7> {
    u3(com.google.android.gms.internal.firebase-auth-api.v3 v3, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return q7.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        final com.google.android.gms.internal.firebase-auth-api.m7 m7Var = n7.A();
        m7Var.j(wq.v(cd.a((q7)y.z())));
        m7Var.m(0);
        return (n7)m7Var.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.q7>> d() {
        HashMap hashMap = new HashMap();
        int i = 16;
        int i3 = 1;
        hashMap.put("AES128_GCM", v3.j(i, i3));
        int i4 = 3;
        hashMap.put("AES128_GCM_RAW", v3.j(i, i4));
        int i2 = 32;
        hashMap.put("AES256_GCM", v3.j(i2, i3));
        hashMap.put("AES256_GCM_RAW", v3.j(i2, i4));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        ed.b((q7)y.z());
    }
}
