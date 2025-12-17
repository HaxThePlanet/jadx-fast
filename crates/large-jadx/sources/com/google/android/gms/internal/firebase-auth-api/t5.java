package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class t5 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.i6, com.google.android.gms.internal.firebase-auth-api.f6> {
    t5(com.google.android.gms.internal.firebase-auth-api.u5 u5, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return i6.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        final com.google.android.gms.internal.firebase-auth-api.e6 e6Var = f6.A();
        e6Var.s(0);
        e6Var.j(wq.v(cd.a((i6)y.z())));
        e6Var.m(y.D());
        return (f6)e6Var.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.i6>> d() {
        HashMap hashMap = new HashMap();
        com.google.android.gms.internal.firebase-auth-api.h6 h6Var = i6.A();
        int i = 32;
        h6Var.j(i);
        com.google.android.gms.internal.firebase-auth-api.k6 k6Var2 = l6.A();
        final int i4 = 16;
        k6Var2.j(i4);
        h6Var.m((l6)k6Var2.e());
        int i3 = 1;
        g2 g2Var = new g2((i6)h6Var.e(), i3);
        hashMap.put("AES_CMAC", g2Var);
        com.google.android.gms.internal.firebase-auth-api.h6 h6Var2 = i6.A();
        h6Var2.j(i);
        com.google.android.gms.internal.firebase-auth-api.k6 k6Var3 = l6.A();
        k6Var3.j(i4);
        h6Var2.m((l6)k6Var3.e());
        g2 g2Var2 = new g2((i6)h6Var2.e(), i3);
        hashMap.put("AES256_CMAC", g2Var2);
        com.google.android.gms.internal.firebase-auth-api.h6 h6Var3 = i6.A();
        h6Var3.j(i);
        com.google.android.gms.internal.firebase-auth-api.k6 k6Var = l6.A();
        k6Var.j(i4);
        h6Var3.m((l6)k6Var.e());
        g2 g2Var3 = new g2((i6)h6Var3.e(), 3);
        hashMap.put("AES256_CMAC_RAW", g2Var3);
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        u5.j((i6)y.D());
        u5.k(y.z());
    }
}
