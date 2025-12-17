package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class gh implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> {

    final com.google.android.gms.internal.firebase-auth-api.nl a;
    final com.google.android.gms.internal.firebase-auth-api.sh b;
    gh(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        this.b = sh;
        this.a = nl2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        jo joVar = new jo((to)object.zze());
        fh fhVar = new fh(this, this, object);
        sh.q(this.b).g(joVar, fhVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.h(zzai.zza(string));
    }
}
