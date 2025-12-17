package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;

/* loaded from: classes2.dex */
final class uk extends com.google.android.gms.internal.firebase-auth-api.an<AuthResult, zzg> {

    private final String v;
    public uk(String string) {
        super(2);
        r.g(string, "provider cannot be null or empty");
        this.v = string;
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
        pf obj4 = new pf(this.v, this.d.zzf());
        ol.j().r0(obj4, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, AuthResult> zza() {
        t.a builder = t.builder();
        tk tkVar = new tk(this);
        builder.b(tkVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "unlinkFederatedCredential";
    }
}
