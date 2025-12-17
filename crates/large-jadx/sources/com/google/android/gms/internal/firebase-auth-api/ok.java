package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* loaded from: classes2.dex */
final class ok extends com.google.android.gms.internal.firebase-auth-api.an<Void, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks> {

    private final com.google.android.gms.internal.firebase-auth-api.jf v;
    public ok(PhoneMultiFactorInfo phoneMultiFactorInfo, String string2, String string3, long l4, boolean z5, boolean z6, String string7, String string8, boolean z9) {
        super(8);
        r.j(phoneMultiFactorInfo);
        r.f(string2);
        super(phoneMultiFactorInfo, string2, string3, l4, obj7, z6, string7, string8, z9, obj23);
        obj.v = jfVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void a() {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final void l(com.google.android.gms.internal.firebase-auth-api.ol ol, k k2) {
        zm zmVar = new zm(this, k2);
        this.u = zmVar;
        ol.j().K(this.v, this.b);
    }

    public final t<com.google.android.gms.internal.firebase-auth-api.ol, Void> zza() {
        t.a builder = t.builder();
        nk nkVar = new nk(this);
        builder.b(nkVar);
        return builder.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.an
    public final String zzb() {
        return "startMfaSignInWithPhoneNumber";
    }
}
