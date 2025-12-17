package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;

/* loaded from: classes2.dex */
final class zj extends com.google.android.gms.internal.firebase-auth-api.an<AuthResult, zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.ue v;
    public zj(String string) {
        super(2);
        ue ueVar = new ue(string);
        this.v = ueVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        com.google.firebase.auth.internal.zzx zzx = kl.v(this.c, this.j);
        (zzg)this.e.zza(this.i, zzx);
        zzr zzr = new zzr(zzx);
        j(zzr);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().o(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, AuthResult> zza() {
        t.a builder = t.builder();
        yj yjVar = new yj(this);
        builder.b(yjVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "signInAnonymously";
    }
}
