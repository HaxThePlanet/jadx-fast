package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.firebase.auth.internal.zzg;

/* loaded from: classes2.dex */
final class rj extends com.google.android.gms.internal.firebase-auth-api.an<Void, zzg> {
    public rj() {
        super(2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        (zzg)this.e.zza(this.i, kl.v(this.c, this.j));
        j(0);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        qj qjVar = new qj(this);
        builder.b(qjVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "reload";
    }
}
