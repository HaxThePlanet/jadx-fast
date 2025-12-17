package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

/* loaded from: classes2.dex */
final class vm implements com.google.android.gms.internal.firebase-auth-api.ym {

    final Status a;
    vm(com.google.android.gms.internal.firebase-auth-api.xm xm, Status status2) {
        this.a = status2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ym
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks, Object... object2Arr2) {
        onVerificationStateChangedCallbacks.onVerificationFailed(ql.a(this.a));
    }
}
