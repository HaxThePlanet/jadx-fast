package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class ah implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.yp> {

    final com.google.android.gms.internal.firebase-auth-api.nl a;
    final com.google.android.gms.internal.firebase-auth-api.sh b;
    ah(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        this.b = sh;
        this.a = nl2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        to toVar = new to((yp)object.zzd(), object.zzc(), Long.valueOf(object.j2()), "Bearer");
        sh.r(this.b, toVar, 0, 0, Boolean.valueOf(object.zze()), 0, this.a, this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.h(zzai.zza(string));
    }
}
