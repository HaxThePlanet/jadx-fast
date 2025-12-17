package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
final class ei extends com.google.android.gms.internal.firebase-auth-api.an<Void, com.google.firebase.auth.internal.zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.pd v;
    public ei(String string, String string2, String string3) {
        super(4);
        r.g(string, "code cannot be null or empty");
        r.g(string2, "new password cannot be null or empty");
        pd pdVar = new pd(string, string2, string3);
        this.v = pdVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        j(0);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().q(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        di diVar = new di(this);
        builder.b(diVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "confirmPasswordReset";
    }
}
