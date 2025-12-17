package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class bg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.bq> {

    final com.google.android.gms.internal.firebase-auth-api.nl a;
    final com.google.android.gms.internal.firebase-auth-api.sh b;
    bg(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        this.b = sh;
        this.a = nl2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        if ((bq)object.f()) {
            yf yfVar = new yf(object.c(), object.e(), 0);
            this.a.f(yfVar);
        }
        to toVar = new to(object.d(), object.b(), Long.valueOf(object.a()), "Bearer");
        sh.r(this.b, toVar, 0, 0, Boolean.FALSE, 0, this.a, this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.h(zzai.zza(string));
    }
}
