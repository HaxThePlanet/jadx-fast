package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
final class zzy implements c<com.google.firebase.auth.GetTokenResult, j<Void>> {

    final String zza;
    final com.google.firebase.auth.ActionCodeSettings zzb;
    final com.google.firebase.auth.FirebaseUser zzc;
    zzy(com.google.firebase.auth.FirebaseUser firebaseUser, String string2, com.google.firebase.auth.ActionCodeSettings actionCodeSettings3) {
        this.zzc = firebaseUser;
        this.zza = string2;
        this.zzb = actionCodeSettings3;
        super();
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        String obj4 = (GetTokenResult)j.getResult().getToken();
        r.j(obj4);
        return FirebaseAuth.getInstance(this.zzc.zza()).zzr((String)obj4, this.zza, this.zzb);
    }
}
