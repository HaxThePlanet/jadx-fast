package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.firebase.auth.internal.zzbk;

/* loaded from: classes2.dex */
final class zzt implements zzbk {

    final com.google.firebase.auth.FirebaseAuth zza;
    zzt(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
        super();
    }

    @Override // com.google.firebase.auth.internal.zzbk
    public final void zza(to to, com.google.firebase.auth.FirebaseUser firebaseUser2) {
        r.j(to);
        r.j(firebaseUser2);
        firebaseUser2.zzh(to);
        final int i = 1;
        FirebaseAuth.zzG(this.zza, firebaseUser2, to, i, i);
    }

    @Override // com.google.firebase.auth.internal.zzbk
    public final void zzb(Status status) {
        int i;
        int i2;
        int obj3;
        if (status.k2() != 17011 && status.k2() != 17021 && status.k2() != 17005 && status.k2() == 17091) {
            if (status.k2() != 17021) {
                if (status.k2() != 17005) {
                    if (status.k2() == 17091) {
                    }
                }
            }
        }
        this.zza.signOut();
    }
}
