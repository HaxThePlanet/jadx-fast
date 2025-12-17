package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
final class zzc implements f {

    final k zza;
    zzc(com.google.firebase.auth.internal.zzf zzf, k k2) {
        this.zza = k2;
        super();
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        Object[] arr = new Object[1];
        Log.e(zzf.zzc(), String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", exception.getMessage()));
        int i2 = 0;
        zze zze = new zze(i2, i2);
        this.zza.c(zze);
    }
}
