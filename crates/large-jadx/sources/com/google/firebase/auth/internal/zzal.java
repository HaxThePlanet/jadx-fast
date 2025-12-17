package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: classes2.dex */
final class zzal implements Runnable {

    final com.google.firebase.auth.internal.zzam zza;
    private final String zzb;
    zzal(com.google.firebase.auth.internal.zzam zzam, String string2) {
        this.zza = zzam;
        super();
        r.f(string2);
        this.zzb = string2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object accessToken;
        Object currentUser;
        Object[] arr;
        String str;
        accessToken = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzb));
        if (accessToken.getCurrentUser() != null) {
            zzam.zza().g("Token refreshing started", new Object[0]);
            currentUser = new zzak(this);
            accessToken.getAccessToken(true).addOnFailureListener(currentUser);
        }
    }
}
