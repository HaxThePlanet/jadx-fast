package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
final class jl extends com.google.android.gms.internal.firebase-auth-api.an<Void, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks> {

    private final com.google.android.gms.internal.firebase-auth-api.qe v;
    public jl(com.google.android.gms.internal.firebase-auth-api.hp hp) {
        super(8);
        r.j(hp);
        qe qeVar = new qe(hp);
        this.v = qeVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().h0(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        il ilVar = new il(this);
        builder.b(ilVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "verifyPhoneNumber";
    }
}
