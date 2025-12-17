package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
final class fl extends com.google.android.gms.internal.firebase-auth-api.an<Void, Void> {

    private final com.google.android.gms.internal.firebase-auth-api.tf v;
    public fl(String string, String string2, ActionCodeSettings actionCodeSettings3) {
        super(6);
        r.f(string);
        r.f(string2);
        r.j(actionCodeSettings3);
        tf tfVar = new tf(string, string2, actionCodeSettings3);
        this.v = tfVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        j(0);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().D(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        el elVar = new el(this);
        builder.b(elVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "verifyBeforeUpdateEmail";
    }
}
