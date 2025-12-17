package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzg;

/* loaded from: classes2.dex */
final class wk extends com.google.android.gms.internal.firebase-auth-api.an<Void, zzg> {

    private final String v;
    public wk(String string) {
        super(2);
        r.g(string, "email cannot be null or empty");
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
        jd obj4 = new jd(this.d.zzf(), this.v);
        ol.j().R1(obj4, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        vk vkVar = new vk(this);
        builder.b(vkVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "updateEmail";
    }
}
