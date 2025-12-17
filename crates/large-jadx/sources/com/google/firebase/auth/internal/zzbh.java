package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.d.a;

/* loaded from: classes2.dex */
final class zzbh implements d.a {

    final com.google.firebase.auth.internal.zzbi zza;
    zzbh(com.google.firebase.auth.internal.zzbi zzbi) {
        this.zza = zzbi;
        super();
    }

    @Override // com.google.android.gms.common.api.internal.d$a
    public final void onBackgroundStateChanged(boolean z) {
        boolean obj2;
        if (z) {
            zzbi.zze(this.zza, true);
            this.zza.zzb();
        }
        zzbi.zze(this.zza, false);
        if (zzbi.zzf(this.zza)) {
            zzbi.zza(this.zza).zzc();
        }
    }
}
