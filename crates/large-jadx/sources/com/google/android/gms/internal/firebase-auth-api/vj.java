package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
final class vj extends com.google.android.gms.internal.firebase-auth-api.an<Void, com.google.firebase.auth.internal.zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.oe v;
    private final String w;
    public vj(String string, ActionCodeSettings actionCodeSettings2, String string3, String string4) {
        super(4);
        r.g(string, "email cannot be null or empty");
        oe oeVar = new oe(string, actionCodeSettings2, string3);
        this.v = oeVar;
        this.w = string4;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        j(0);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().b2(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        uj ujVar = new uj(this);
        builder.b(ujVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return this.w;
    }
}
