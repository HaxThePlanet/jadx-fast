package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zzay;
import com.google.firebase.auth.internal.zzg;

/* loaded from: classes2.dex */
final class qi extends com.google.android.gms.internal.firebase-auth-api.an<GetTokenResult, zzg> {

    private final com.google.android.gms.internal.firebase-auth-api.ae v;
    public qi(String string) {
        super(1);
        r.g(string, "refresh token cannot be null");
        ae aeVar = new ae(string);
        this.v = aeVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
        boolean empty;
        String str;
        if (TextUtils.isEmpty(this.i.zzf())) {
            this.i.m2(this.v.zza());
        }
        (zzg)this.e.zza(this.i, this.d);
        j(zzay.zza(this.i.zze()));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().O(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, GetTokenResult> zza() {
        t.a builder = t.builder();
        pi piVar = new pi(this);
        builder.b(piVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "getAccessToken";
    }
}
