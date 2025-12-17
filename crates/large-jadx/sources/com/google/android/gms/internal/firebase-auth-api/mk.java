package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.internal.zzag;

/* loaded from: classes2.dex */
final class mk extends com.google.android.gms.internal.firebase-auth-api.an<Void, com.google.firebase.auth.internal.zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.hf v;
    public mk(zzag zzag, String string2, String string3, long l4, boolean z5, boolean z6, String string7, String string8, boolean z9) {
        super(8);
        r.j(zzag);
        r.f(string2);
        super(zzag.zzc(), string2, string3, l4, obj7, z6, string7, string8, z9, obj23);
        obj.v = hfVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().I1(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        lk lkVar = new lk(this);
        builder.b(lkVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "startMfaEnrollmentWithPhoneNumber";
    }
}
