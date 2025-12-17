package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class hg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.yn> {

    final com.google.android.gms.internal.firebase-auth-api.nl a;
    hg(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        this.a = nl2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        this.a.c((yn)object);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.h(zzai.zza(string));
    }
}
