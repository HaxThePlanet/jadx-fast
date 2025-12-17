package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
final class tj extends com.google.android.gms.internal.firebase-auth-api.an<Void, com.google.firebase.auth.internal.zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.me v;
    public tj(String string, ActionCodeSettings actionCodeSettings2) {
        super(6);
        r.g(string, "token cannot be null or empty");
        me meVar = new me(string, actionCodeSettings2);
        this.v = meVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        j(0);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().F0(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        sj sjVar = new sj(this);
        builder.b(sjVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "sendEmailVerification";
    }
}
