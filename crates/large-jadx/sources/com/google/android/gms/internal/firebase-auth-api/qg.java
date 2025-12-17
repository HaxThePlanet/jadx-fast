package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class qg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> {

    final com.google.android.gms.internal.firebase-auth-api.cq a;
    final com.google.android.gms.internal.firebase-auth-api.nl b;
    final com.google.android.gms.internal.firebase-auth-api.sh c;
    qg(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.cq cq2, Context context3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        this.c = sh;
        this.a = cq2;
        this.b = nl4;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        this.a.c((to)object.zze());
        pg pgVar = new pg(this, this);
        sh.q(this.c).s(0, this.a, pgVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.b.h(zzai.zza(string));
    }
}
