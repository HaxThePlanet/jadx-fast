package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;

/* loaded from: classes2.dex */
final class sk extends com.google.android.gms.internal.firebase-auth-api.an<AuthResult, zzg> {
    public sk() {
        super(2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        com.google.firebase.auth.internal.zzx zzx = kl.v(this.c, this.j);
        (zzg)this.e.zza(this.i, zzx);
        zzr zzr = new zzr(zzx);
        j(zzr);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, AuthResult> zza() {
        t.a builder = t.builder();
        rk rkVar = new rk(this);
        builder.b(rkVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "unlinkEmailCredential";
    }
}
