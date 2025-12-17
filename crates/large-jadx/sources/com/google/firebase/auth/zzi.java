package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzan;

/* loaded from: classes2.dex */
final class zzi implements zzan {

    final com.google.firebase.auth.FirebaseUser zza;
    final com.google.firebase.auth.FirebaseAuth zzb;
    zzi(com.google.firebase.auth.FirebaseAuth firebaseAuth, com.google.firebase.auth.FirebaseUser firebaseUser2) {
        this.zzb = firebaseAuth;
        this.zza = firebaseUser2;
        super();
    }

    @Override // com.google.firebase.auth.internal.zzan
    public final void zza() {
        com.google.firebase.auth.FirebaseUser equalsIgnoreCase;
        String uid;
        if (FirebaseAuth.zzs(this.zzb) != null && FirebaseAuth.zzs(this.zzb).getUid().equalsIgnoreCase(this.zza.getUid())) {
            if (FirebaseAuth.zzs(this.zzb).getUid().equalsIgnoreCase(this.zza.getUid())) {
                this.zzb.zzC();
            }
        }
    }

    @Override // com.google.firebase.auth.internal.zzan
    public final void zzb(Status status) {
        int i;
        int i2;
        int obj3;
        if (status.k2() != 17011 && status.k2() != 17021 && status.k2() == 17005) {
            if (status.k2() != 17021) {
                if (status.k2() == 17005) {
                }
            }
        }
        this.zzb.signOut();
    }
}
