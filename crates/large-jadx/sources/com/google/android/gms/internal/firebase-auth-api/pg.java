package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
final class pg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.dq> {

    final com.google.android.gms.internal.firebase-auth-api.cn a;
    final com.google.android.gms.internal.firebase-auth-api.qg b;
    pg(com.google.android.gms.internal.firebase-auth-api.qg qg, com.google.android.gms.internal.firebase-auth-api.cn cn2) {
        this.b = qg;
        this.a = cn2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        if (!TextUtils.isEmpty((dq)object.e())) {
            Status status = new Status(17025);
            qgVar2.b.g(status, PhoneAuthCredential.zzd(object.c(), object.e()));
        }
        to toVar = new to(object.d(), object.b(), Long.valueOf(object.a()), "Bearer");
        sh.r(qgVar.c, toVar, 0, "phone", Boolean.valueOf(object.f()), 0, obj11.b, this.a);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.zza(string);
    }
}
