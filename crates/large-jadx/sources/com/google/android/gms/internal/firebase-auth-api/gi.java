package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;

/* loaded from: classes2.dex */
final class gi extends com.google.android.gms.internal.firebase-auth-api.an<AuthResult, zzg> {

    final com.google.android.gms.internal.firebase-auth-api.rd v;
    public gi(String string, String string2, String string3) {
        super(2);
        r.g(string, "email cannot be null or empty");
        r.g(string2, "password cannot be null or empty");
        rd rdVar = new rd(string, string2, string3);
        this.v = rdVar;
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
        fi fiVar = new fi(this);
        builder.b(fiVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "createUserWithEmailAndPassword";
    }
}
