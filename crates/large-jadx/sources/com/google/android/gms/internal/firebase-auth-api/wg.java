package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class wg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.gq> {

    final com.google.android.gms.internal.firebase-auth-api.xg a;
    wg(com.google.android.gms.internal.firebase-auth-api.xg xg) {
        this.a = xg;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        boolean empty;
        if (!TextUtils.isEmpty((gq)object.a()) && TextUtils.isEmpty(object.b())) {
            if (TextUtils.isEmpty(object.b())) {
            }
            to toVar = new to(object.b(), object.a(), Long.valueOf(vo.a(object.a())), "Bearer");
            com.google.android.gms.internal.firebase-auth-api.xg obj11 = this.a;
            sh.r(obj11.c, toVar, 0, 0, Boolean.FALSE, 0, obj11.b, this);
        }
        obj11.b.h(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        xgVar.b.h(zzai.zza(string));
    }
}
