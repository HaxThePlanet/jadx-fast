package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class r3 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.h7, com.google.android.gms.internal.firebase-auth-api.e7> {
    r3(com.google.android.gms.internal.firebase-auth-api.s3 s3, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return h7.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        final com.google.android.gms.internal.firebase-auth-api.d7 d7Var = e7.A();
        d7Var.j(wq.v(cd.a((h7)y.z())));
        d7Var.m(y.D());
        d7Var.s(0);
        return (e7)d7Var.e();
    }

    public final Map<String, com.google.android.gms.internal.firebase-auth-api.g2<com.google.android.gms.internal.firebase-auth-api.h7>> d() {
        HashMap hashMap = new HashMap();
        int i = 16;
        int i2 = 1;
        hashMap.put("AES128_EAX", s3.j(i, i, i2));
        int i3 = 3;
        hashMap.put("AES128_EAX_RAW", s3.j(i, i, i3));
        int i4 = 32;
        hashMap.put("AES256_EAX", s3.j(i4, i, i2));
        hashMap.put("AES256_EAX_RAW", s3.j(i4, i, i3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        int i;
        int obj3;
        ed.b((h7)y.z());
        if (y.D().z() != 12) {
            if (y.D().z() != 16) {
            } else {
            }
            obj3 = new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            throw obj3;
        }
    }
}
