package com.google.firebase.auth.api.fallback.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.firebase-auth-api.rl;

/* loaded from: classes2.dex */
final class zza extends f {

    final com.google.firebase.auth.api.fallback.service.FirebaseAuthFallbackService zza;
    protected zza(com.google.firebase.auth.api.fallback.service.FirebaseAuthFallbackService firebaseAuthFallbackService, Context context2) {
        this.zza = firebaseAuthFallbackService;
        super();
    }

    @Override // com.google.android.gms.common.internal.f
    public final void getService(l l, g g2) {
        Bundle obj4 = g2.j2();
        if (obj4 == null) {
        } else {
            obj4 = obj4.getString("com.google.firebase.auth.API_KEY");
            if (TextUtils.isEmpty(obj4)) {
            } else {
                rl rlVar = new rl(this.zza, obj4);
                l.L0(0, rlVar, 0);
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("ApiKey must not be empty.");
            throw obj3;
        }
        obj3 = new IllegalArgumentException("ExtraArgs is null.");
        throw obj3;
    }
}
