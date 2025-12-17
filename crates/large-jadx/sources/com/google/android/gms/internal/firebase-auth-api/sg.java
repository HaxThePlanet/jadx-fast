package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class sg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> {

    final com.google.android.gms.internal.firebase-auth-api.up a;
    final com.google.android.gms.internal.firebase-auth-api.nl b;
    final com.google.android.gms.internal.firebase-auth-api.sh c;
    sg(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.up up2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        this.c = sh;
        this.a = up2;
        this.b = nl3;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        this.a.l2(true);
        this.a.k2((to)object.zze());
        rg rgVar = new rg(this, this);
        sh.q(this.c).p(0, this.a, rgVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.b.h(zzai.zza(string));
    }
}
