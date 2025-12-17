package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.firebase.auth.internal.zzan;

/* loaded from: classes2.dex */
final class ii extends com.google.android.gms.internal.firebase-auth-api.an<Void, zzan> {
    public ii() {
        super(5);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        (zzan)this.e.zza();
        j(0);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        hi hiVar = new hi(this);
        builder.b(hiVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "delete";
    }
}
