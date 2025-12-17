package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.internal.zzo;

/* loaded from: classes2.dex */
final class hl extends com.google.android.gms.internal.firebase-auth-api.an<String, com.google.firebase.auth.internal.zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.nd v;
    public hl(String string, String string2) {
        super(4);
        r.g(string, "code cannot be null or empty");
        nd ndVar = new nd(string, string2);
        this.v = ndVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        zzo zzo = new zzo(this.l);
        if (zzo.getOperation() != 0) {
            Status status = new Status(17499);
            i(status);
        }
        j(this.l.zzc());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().g1(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, String> zza() {
        t.a builder = t.builder();
        gl glVar = new gl(this);
        builder.b(glVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "verifyPasswordResetCode";
    }
}
