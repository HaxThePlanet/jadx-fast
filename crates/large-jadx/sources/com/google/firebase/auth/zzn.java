package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.firebase.auth.internal.zzbk;

/* loaded from: classes2.dex */
final class zzn implements zzbk {

    final com.google.firebase.auth.FirebaseAuth zza;
    zzn(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
        super();
    }

    @Override // com.google.firebase.auth.internal.zzbk
    public final void zza(to to, com.google.firebase.auth.FirebaseUser firebaseUser2) {
        final int i = 1;
        FirebaseAuth.zzG(this.zza, firebaseUser2, to, i, i);
    }

    @Override // com.google.firebase.auth.internal.zzbk
    public final void zzb(Status status) {
        int i;
        int obj2 = status.k2();
        if (obj2 != 17011 && obj2 != 17021 && obj2 == 17005) {
            if (obj2 != 17021) {
                if (obj2 == 17005) {
                }
            }
        }
        this.zza.signOut();
    }
}
