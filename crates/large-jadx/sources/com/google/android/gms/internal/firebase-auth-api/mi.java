package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;

/* loaded from: classes2.dex */
final class mi extends com.google.android.gms.internal.firebase-auth-api.an<Void, zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.wd v;
    public mi(PhoneMultiFactorAssertion phoneMultiFactorAssertion, String string2, String string3) {
        super(2);
        r.j(phoneMultiFactorAssertion);
        r.f(string2);
        wd wdVar = new wd(phoneMultiFactorAssertion.zza(), string2, string3);
        this.v = wdVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        (zzg)this.e.zza(this.i, kl.v(this.c, this.j));
        j(0);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().m0(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        li liVar = new li(this);
        builder.b(liVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "finalizeMfaEnrollment";
    }
}
