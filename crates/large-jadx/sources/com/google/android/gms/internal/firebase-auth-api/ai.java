package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
final class ai extends com.google.android.gms.internal.firebase-auth-api.an<Void, com.google.firebase.auth.internal.zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.hd v;
    public ai(String string, String string2) {
        super(7);
        r.g(string, "code cannot be null or empty");
        hd hdVar = new hd(string, string2);
        this.v = hdVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        j(0);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().H0(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        zh zhVar = new zh(this);
        builder.b(zhVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "applyActionCode";
    }
}
