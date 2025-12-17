package com.google.firebase.auth.internal;

import com.google.android.gms.common.l.a;
import com.google.android.gms.tasks.f;

/* loaded from: classes2.dex */
final class zzak implements f {

    final com.google.firebase.auth.internal.zzal zza;
    zzak(com.google.firebase.auth.internal.zzal zzal) {
        this.zza = zzal;
        super();
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        Object[] arr;
        String str;
        boolean obj3;
        if (exception instanceof FirebaseNetworkException != null) {
            zzam.zza().g("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            obj3.zza.zzd();
        }
    }
}
