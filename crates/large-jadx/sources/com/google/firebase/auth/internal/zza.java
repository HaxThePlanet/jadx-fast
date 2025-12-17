package com.google.firebase.auth.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: classes2.dex */
final class zza implements f {

    final FirebaseAuth zza;
    final com.google.firebase.auth.internal.zzbm zzb;
    final Activity zzc;
    final k zzd;
    final com.google.firebase.auth.internal.zzf zze;
    zza(com.google.firebase.auth.internal.zzf zzf, FirebaseAuth firebaseAuth2, com.google.firebase.auth.internal.zzbm zzbm3, Activity activity4, k k5) {
        this.zze = zzf;
        this.zza = firebaseAuth2;
        this.zzb = zzbm3;
        this.zzc = activity4;
        this.zzd = k5;
        super();
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        String obj5;
        obj5 = String.valueOf(exception.getMessage());
        String str2 = "Problem retrieving SafetyNet Token: ";
        if (obj5.length() != 0) {
            obj5 = str2.concat(obj5);
        } else {
            obj5 = new String(str2);
        }
        Log.e(zzf.zzc(), obj5);
        zzf.zzd(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
