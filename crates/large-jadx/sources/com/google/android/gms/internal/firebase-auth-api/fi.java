package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.p;

/* loaded from: classes2.dex */
public final class fi implements p {

    public final com.google.android.gms.internal.firebase-auth-api.gi a;
    public fi(com.google.android.gms.internal.firebase-auth-api.gi gi) {
        super();
        this.a = gi;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void a(Object object, Object object2) {
        com.google.android.gms.internal.firebase-auth-api.gi giVar = this.a;
        zm zmVar = new zm(giVar, (k)object2);
        giVar.u = zmVar;
        (ol)object.j().B0(giVar.v, giVar.b);
    }
}
