package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zzaj;

/* loaded from: classes2.dex */
final class ki extends com.google.android.gms.internal.firebase-auth-api.an<SignInMethodQueryResult, com.google.firebase.auth.internal.zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.ce v;
    public ki(String string, String string2) {
        super(3);
        r.g(string, "email cannot be null or empty");
        ce ceVar = new ce(string, string2);
        this.v = ceVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        zzaj zzaj = new zzaj(this.k.j2());
        j(zzaj);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().N0(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, SignInMethodQueryResult> zza() {
        t.a builder = t.builder();
        ji jiVar = new ji(this);
        builder.b(jiVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "fetchSignInMethodsForEmail";
    }
}
