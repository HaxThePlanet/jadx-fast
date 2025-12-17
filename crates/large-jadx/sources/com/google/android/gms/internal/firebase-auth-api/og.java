package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class og implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> {

    final String a;
    final String b;
    final com.google.android.gms.internal.firebase-auth-api.nl c;
    final com.google.android.gms.internal.firebase-auth-api.sh d;
    og(com.google.android.gms.internal.firebase-auth-api.sh sh, String string2, String string3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        this.d = sh;
        this.a = string2;
        this.b = string3;
        this.c = nl4;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        kp kpVar = new kp();
        kpVar.d((to)object.zze());
        kpVar.c(this.a);
        kpVar.f(this.b);
        sh.t(this.d, this.c, object, kpVar, this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.c.h(zzai.zza(string));
    }
}
