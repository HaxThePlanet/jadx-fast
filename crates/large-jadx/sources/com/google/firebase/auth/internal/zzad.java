package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/* loaded from: classes2.dex */
final class zzad implements c<AuthResult, j<AuthResult>> {

    final com.google.firebase.auth.internal.zzae zza;
    zzad(com.google.firebase.auth.internal.zzae zzae) {
        this.zza = zzae;
        super();
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        com.google.firebase.auth.internal.zzr zzr;
        com.google.android.gms.common.internal.safeparcel.a user;
        com.google.firebase.auth.zze zze;
        j obj4;
        if (zzae.zza(this.zza) == null) {
        } else {
            if (j.isSuccessful()) {
                obj4 = j.getResult();
                zzr = new zzr((zzx)(AuthResult)obj4.getUser(), (zzp)obj4.getAdditionalUserInfo(), zzae.zza(this.zza));
                obj4 = m.e(zzr);
            } else {
                obj4 = j.getException();
                if (obj4 instanceof FirebaseAuthUserCollisionException != null) {
                    (FirebaseAuthUserCollisionException)obj4.zza(zzae.zza(this.zza));
                }
                obj4 = m.d(obj4);
            }
        }
        return obj4;
    }
}
