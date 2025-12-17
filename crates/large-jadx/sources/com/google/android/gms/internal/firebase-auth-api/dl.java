package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzg;

/* loaded from: classes2.dex */
final class dl extends com.google.android.gms.internal.firebase-auth-api.an<Void, zzg> {

    private final UserProfileChangeRequest v;
    public dl(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        r.k(userProfileChangeRequest, "request cannot be null");
        this.v = (UserProfileChangeRequest)userProfileChangeRequest;
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
        rf obj4 = new rf(this.v, this.d.zzf());
        ol.j().v1(obj4, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        cl clVar = new cl(this);
        builder.b(clVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "updateProfile";
    }
}
