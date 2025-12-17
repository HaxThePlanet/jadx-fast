package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class bh implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.eo> {

    final com.google.android.gms.internal.firebase-auth-api.ch a;
    bh(com.google.android.gms.internal.firebase-auth-api.ch ch) {
        this.a = ch;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        to toVar = new to(object.b(), object.a(), Long.valueOf(vo.a((eo)object.a())), "Bearer");
        com.google.android.gms.internal.firebase-auth-api.ch obj11 = this.a;
        sh.r(obj11.c, toVar, 0, 0, Boolean.FALSE, 0, obj11.b, this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        chVar.b.h(zzai.zza(string));
    }
}
