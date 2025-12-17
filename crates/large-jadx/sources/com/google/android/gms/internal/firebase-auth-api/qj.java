package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.p;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes2.dex */
public final class qj implements p {

    public final com.google.android.gms.internal.firebase-auth-api.rj a;
    public qj(com.google.android.gms.internal.firebase-auth-api.rj rj) {
        super();
        this.a = rj;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void a(Object object, Object object2) {
        com.google.android.gms.internal.firebase-auth-api.rj rjVar = this.a;
        zm zmVar = new zm(rjVar, (k)object2);
        rjVar.u = zmVar;
        ke obj4 = new ke(rjVar.d.zzf());
        (ol)object.j().y(obj4, rjVar.b);
    }
}
