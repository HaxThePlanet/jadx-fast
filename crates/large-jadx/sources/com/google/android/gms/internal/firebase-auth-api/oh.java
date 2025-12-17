package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class oh implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> {

    final String a;
    final com.google.android.gms.internal.firebase-auth-api.nl b;
    final com.google.android.gms.internal.firebase-auth-api.sh c;
    oh(com.google.android.gms.internal.firebase-auth-api.sh sh, String string2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        this.c = sh;
        this.a = string2;
        this.b = nl3;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        kp kpVar = new kp();
        kpVar.d((to)object.zze());
        kpVar.c(this.a);
        sh.t(this.c, this.b, object, kpVar, this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.b.h(zzai.zza(string));
    }
}
