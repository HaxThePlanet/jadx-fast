package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class h4 extends com.google.android.gms.internal.firebase-auth-api.h2<com.google.android.gms.internal.firebase-auth-api.fb, com.google.android.gms.internal.firebase-auth-api.cb> {
    h4(com.google.android.gms.internal.firebase-auth-api.i4 i4, Class class2) {
        super(class2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final com.google.android.gms.internal.firebase-auth-api.y a(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        return fb.C(wq, lr.a());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final Object c(com.google.android.gms.internal.firebase-auth-api.y y) {
        final com.google.android.gms.internal.firebase-auth-api.bb bbVar = cb.A();
        bbVar.j((fb)y);
        bbVar.m(0);
        return (cb)bbVar.e();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.h2
    public final void e(com.google.android.gms.internal.firebase-auth-api.y y) {
        boolean obj2;
        if ((fb)y.D().isEmpty()) {
        } else {
            if (!y.E()) {
            } else {
            }
        }
        obj2 = new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        throw obj2;
    }
}
