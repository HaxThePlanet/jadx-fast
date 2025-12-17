package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzx;

/* loaded from: classes2.dex */
final class bj extends com.google.android.gms.internal.firebase-auth-api.an<Void, zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.xe v;
    public bj(AuthCredential authCredential, String string2) {
        super(2);
        r.k(authCredential, "credential cannot be null");
        final com.google.android.gms.internal.firebase-auth-api.up obj2 = zzh.zza(authCredential, string2);
        obj2.j2(false);
        xe obj3 = new xe(obj2);
        this.v = obj3;
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
        ol.j().t1(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        aj ajVar = new aj(this);
        builder.b(ajVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "reauthenticateWithCredential";
    }
}
