package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

/* loaded from: classes2.dex */
final class sm implements com.google.android.gms.internal.firebase-auth-api.ym {

    final String a;
    sm(com.google.android.gms.internal.firebase-auth-api.xm xm, String string2) {
        this.a = string2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ym
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks, Object... object2Arr2) {
        onVerificationStateChangedCallbacks.onCodeSent(this.a, PhoneAuthProvider.ForceResendingToken.zza());
    }
}
