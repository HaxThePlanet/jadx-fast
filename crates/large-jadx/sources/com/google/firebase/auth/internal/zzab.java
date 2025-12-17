package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* loaded from: classes2.dex */
final class zzab implements c<GetTokenResult, j<MultiFactorSession>> {
    zzab(com.google.firebase.auth.internal.zzac zzac) {
        super();
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        j obj2;
        if (!j.isSuccessful()) {
            obj2 = m.d(j.getException());
        } else {
            obj2 = m.e(zzag.zza((GetTokenResult)j.getResult().getToken()));
        }
        return obj2;
    }
}
