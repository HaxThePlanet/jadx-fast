package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* loaded from: classes2.dex */
final class oi extends com.google.android.gms.internal.firebase-auth-api.an<AuthResult, zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.yd v;
    public oi(PhoneMultiFactorAssertion phoneMultiFactorAssertion, String string2) {
        super(2);
        r.j(phoneMultiFactorAssertion);
        r.f(string2);
        yd ydVar = new yd(phoneMultiFactorAssertion.zza(), string2);
        this.v = ydVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        FirebaseUser equalsIgnoreCase;
        String uid;
        zzx zzx = kl.v(this.c, this.j);
        equalsIgnoreCase = this.d;
        if (equalsIgnoreCase != null && equalsIgnoreCase.getUid().equalsIgnoreCase(zzx.getUid())) {
            if (equalsIgnoreCase.getUid().equalsIgnoreCase(zzx.getUid())) {
            }
            Status status = new Status(17024);
            i(status);
        }
        (zzg)this.e.zza(this.i, zzx);
        zzr zzr = new zzr(zzx);
        j(zzr);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().H1(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, AuthResult> zza() {
        t.a builder = t.builder();
        ni niVar = new ni(this);
        builder.b(niVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "finalizeMfaSignIn";
    }
}
