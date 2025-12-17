package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class rg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.wp> {

    final com.google.android.gms.internal.firebase-auth-api.cn a;
    final com.google.android.gms.internal.firebase-auth-api.sg b;
    rg(com.google.android.gms.internal.firebase-auth-api.sg sg, com.google.android.gms.internal.firebase-auth-api.cn cn2) {
        this.b = sg;
        this.a = cn2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        com.google.android.gms.internal.firebase-auth-api.sg sgVar = this.b;
        sh.s(sgVar.c, (wp)object, sgVar.b, this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.zza(string);
    }
}
