package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zzo;

/* loaded from: classes2.dex */
final class ci extends com.google.android.gms.internal.firebase-auth-api.an<ActionCodeResult, com.google.firebase.auth.internal.zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.nd v;
    public ci(String string, String string2) {
        super(4);
        r.g(string, "code cannot be null or empty");
        nd ndVar = new nd(string, string2);
        this.v = ndVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        zzo zzo = new zzo(this.l);
        j(zzo);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().g1(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, ActionCodeResult> zza() {
        t.a builder = t.builder();
        bi biVar = new bi(this);
        builder.b(biVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "checkActionCode";
    }
}
