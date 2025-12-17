package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class cg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> {

    final EmailAuthCredential a;
    final com.google.android.gms.internal.firebase-auth-api.nl b;
    final com.google.android.gms.internal.firebase-auth-api.sh c;
    cg(com.google.android.gms.internal.firebase-auth-api.sh sh, EmailAuthCredential emailAuthCredential2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        this.c = sh;
        this.a = emailAuthCredential2;
        this.b = nl3;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        bo boVar = new bo(this.a, (to)object.zze());
        sh.u(this.c, boVar, this.b);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.b.h(zzai.zza(string));
    }
}
