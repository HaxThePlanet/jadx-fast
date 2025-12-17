package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;

/* loaded from: classes2.dex */
final class yi extends com.google.android.gms.internal.firebase-auth-api.an<AuthResult, zzg> {

    private final EmailAuthCredential v;
    public yi(EmailAuthCredential emailAuthCredential) {
        super(2);
        r.k(emailAuthCredential, "credential cannot be null");
        this.v = (EmailAuthCredential)emailAuthCredential;
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
        EmailAuthCredential emailAuthCredential = this.v;
        emailAuthCredential.zzb(this.d);
        df obj4 = new df(emailAuthCredential);
        ol.j().G1(obj4, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, AuthResult> zza() {
        t.a builder = t.builder();
        xi xiVar = new xi(this);
        builder.b(xiVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "linkEmailAuthCredential";
    }
}
