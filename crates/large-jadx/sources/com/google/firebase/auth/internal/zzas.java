package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthResult;

/* loaded from: classes2.dex */
final class zzas implements g<AuthResult> {

    final k zza;
    final Context zzb;
    zzas(com.google.firebase.auth.internal.zzax zzax, k k2, Context context3) {
        this.zza = k2;
        this.zzb = context3;
        super();
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.zza.c((AuthResult)object);
        zzax.zze(this.zzb);
    }
}
