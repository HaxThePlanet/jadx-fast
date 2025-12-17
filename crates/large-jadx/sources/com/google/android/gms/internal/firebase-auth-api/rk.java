package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.p;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes2.dex */
public final class rk implements p {

    public final com.google.android.gms.internal.firebase-auth-api.sk a;
    public rk(com.google.android.gms.internal.firebase-auth-api.sk sk) {
        super();
        this.a = sk;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void a(Object object, Object object2) {
        com.google.android.gms.internal.firebase-auth-api.sk skVar = this.a;
        zm zmVar = new zm(skVar, (k)object2);
        skVar.u = zmVar;
        nf obj4 = new nf(skVar.d.zzf());
        (ol)object.j().j2(obj4, skVar.b);
    }
}
