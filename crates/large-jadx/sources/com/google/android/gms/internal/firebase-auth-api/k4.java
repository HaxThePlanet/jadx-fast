package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class k4 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.qb, com.google.android.gms.internal.firebase-auth-api.nb> {
    k4(com.google.android.gms.internal.firebase-auth-api.l4 l4, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return qb.B(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        com.google.android.gms.internal.firebase-auth-api.mb obj2 = nb.A();
        obj2.m(0);
        obj2.j(wq.v(cd.a(32)));
        return (nb)obj2.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.qb>> d() {
        HashMap hashMap = new HashMap();
        g2 g2Var = new g2(qb.A(), 1);
        hashMap.put("XCHACHA20_POLY1305", g2Var);
        g2 g2Var2 = new g2(qb.A(), 3);
        hashMap.put("XCHACHA20_POLY1305_RAW", g2Var2);
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
    }
}
