package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.firebase.auth.internal.zzg;

/* loaded from: classes2.dex */
class zzs implements zzg {

    final com.google.firebase.auth.FirebaseAuth zza;
    zzs(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
        super();
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(to to, com.google.firebase.auth.FirebaseUser firebaseUser2) {
        r.j(to);
        r.j(firebaseUser2);
        firebaseUser2.zzh(to);
        this.zza.zzD(firebaseUser2, to, true);
    }
}
