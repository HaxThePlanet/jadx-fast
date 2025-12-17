package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
final class zzx implements c<com.google.firebase.auth.GetTokenResult, j<Void>> {

    final com.google.firebase.auth.ActionCodeSettings zza;
    final com.google.firebase.auth.FirebaseUser zzb;
    zzx(com.google.firebase.auth.FirebaseUser firebaseUser, com.google.firebase.auth.ActionCodeSettings actionCodeSettings2) {
        this.zzb = firebaseUser;
        this.zza = actionCodeSettings2;
        super();
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        String obj3 = (GetTokenResult)j.getResult().getToken();
        r.j(obj3);
        return FirebaseAuth.getInstance(this.zzb.zza()).zzi(this.zza, (String)obj3);
    }
}
