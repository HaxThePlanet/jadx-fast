package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
final class zzw implements c<com.google.firebase.auth.GetTokenResult, j<Void>> {

    final com.google.firebase.auth.FirebaseUser zza;
    zzw(com.google.firebase.auth.FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
        super();
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        String obj3 = (GetTokenResult)j.getResult().getToken();
        r.j(obj3);
        return FirebaseAuth.getInstance(this.zza.zza()).zzi(0, (String)obj3);
    }
}
