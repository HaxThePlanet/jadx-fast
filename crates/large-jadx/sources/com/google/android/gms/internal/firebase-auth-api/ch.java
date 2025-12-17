package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class ch implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> {

    final com.google.android.gms.internal.firebase-auth-api.do a;
    final com.google.android.gms.internal.firebase-auth-api.nl b;
    final com.google.android.gms.internal.firebase-auth-api.sh c;
    ch(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.do do2, Context context3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        this.c = sh;
        this.a = do2;
        this.b = nl4;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        this.a.b((to)object.zze());
        bh bhVar = new bh(this);
        sh.q(this.c).d(0, this.a, bhVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.b.h(zzai.zza(string));
    }
}
