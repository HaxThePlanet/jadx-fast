package com.google.firebase.auth.internal;

import android.app.Activity;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.FirebaseAuth;
import f.c.a.d.c.d;

/* loaded from: classes2.dex */
final class zzb implements g<d> {

    final k zza;
    final FirebaseAuth zzb;
    final com.google.firebase.auth.internal.zzbm zzc;
    final Activity zzd;
    final com.google.firebase.auth.internal.zzf zze;
    zzb(com.google.firebase.auth.internal.zzf zzf, k k2, FirebaseAuth firebaseAuth3, com.google.firebase.auth.internal.zzbm zzbm4, Activity activity5) {
        this.zze = zzf;
        this.zza = k2;
        this.zzb = firebaseAuth3;
        this.zzc = zzbm4;
        this.zzd = activity5;
        super();
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        if (zzbf.zza((d)object)) {
            zze zze = new zze(object.c(), 0);
            this.zza.c(zze);
        }
        zzf.zzd(this.zze, this.zzb, this.zzc, this.zzd, this.zza);
    }
}
