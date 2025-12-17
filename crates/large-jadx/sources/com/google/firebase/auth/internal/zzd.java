package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
final class zzd implements g<String> {

    final k zza;
    zzd(com.google.firebase.auth.internal.zzf zzf, k k2) {
        this.zza = k2;
        super();
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        zze zze = new zze(0, (String)object);
        this.zza.c(zze);
    }
}
