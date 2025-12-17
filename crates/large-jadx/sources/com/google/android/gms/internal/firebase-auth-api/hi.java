package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.p;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes2.dex */
public final class hi implements p {

    public final com.google.android.gms.internal.firebase-auth-api.ii a;
    public hi(com.google.android.gms.internal.firebase-auth-api.ii ii) {
        super();
        this.a = ii;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void a(Object object, Object object2) {
        com.google.android.gms.internal.firebase-auth-api.ii iiVar = this.a;
        zm zmVar = new zm(iiVar, (k)object2);
        iiVar.u = zmVar;
        td obj4 = new td(iiVar.d.zzf());
        (ol)object.j().C1(obj4, iiVar.b);
    }
}
