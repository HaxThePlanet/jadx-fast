package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzx;

/* loaded from: classes2.dex */
final class jj extends com.google.android.gms.internal.firebase-auth-api.an<Void, zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.bf v;
    public jj(String string, String string2, String string3) {
        super(2);
        r.g(string, "email cannot be null or empty");
        r.g(string2, "password cannot be null or empty");
        bf bfVar = new bf(string, string2, string3);
        this.v = bfVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        zzx zzx = kl.v(this.c, this.j);
        if (this.d.getUid().equalsIgnoreCase(zzx.getUid())) {
            (zzg)this.e.zza(this.i, zzx);
            j(0);
        }
        Status status = new Status(17024);
        i(status);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().t0(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        ij ijVar = new ij(this);
        builder.b(ijVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "reauthenticateWithEmailPassword";
    }
}
