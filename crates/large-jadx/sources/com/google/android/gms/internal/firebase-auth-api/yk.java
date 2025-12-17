package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzg;

/* loaded from: classes2.dex */
final class yk extends com.google.android.gms.internal.firebase-auth-api.an<Void, zzg> {

    private final String v;
    public yk(String string) {
        super(2);
        r.g(string, "password cannot be null or empty");
        this.v = string;
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
        ld obj4 = new ld(this.d.zzf(), this.v);
        ol.j().S(obj4, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        xk xkVar = new xk(this);
        builder.b(xkVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "updatePassword";
    }
}
