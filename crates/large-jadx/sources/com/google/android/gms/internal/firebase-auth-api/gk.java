package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;

/* loaded from: classes2.dex */
final class gk extends com.google.android.gms.internal.firebase-auth-api.an<AuthResult, zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.bf v;
    public gk(String string, String string2, String string3) {
        super(2);
        r.g(string, "email cannot be null or empty");
        r.g(string2, "password cannot be null or empty");
        bf bfVar = new bf(string, string2, string3);
        this.v = bfVar;
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
        ol.j().t0(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, AuthResult> zza() {
        t.a builder = t.builder();
        fk fkVar = new fk(this);
        builder.b(fkVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "signInWithEmailAndPassword";
    }
}
