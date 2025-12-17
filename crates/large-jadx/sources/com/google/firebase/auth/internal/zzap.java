package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
final class zzap implements f {

    final k zza;
    final Context zzb;
    zzap(com.google.firebase.auth.internal.zzax zzax, k k2, Context context3) {
        this.zza = k2;
        this.zzb = context3;
        super();
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        this.zza.b(exception);
        zzax.zze(this.zzb);
    }
}
