package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class lh implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.wp> {

    final com.google.android.gms.internal.firebase-auth-api.nl a;
    final com.google.android.gms.internal.firebase-auth-api.sh b;
    lh(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        this.b = sh;
        this.a = nl2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        if (!(wp)object.l()) {
            sh.s(this.b, object, this.a, this);
        }
        yf yfVar = new yf(object.f(), object.k(), object.b());
        this.a.f(yfVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.h(zzai.zza(string));
    }
}
