package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

/* loaded from: classes2.dex */
final class tm implements com.google.android.gms.internal.firebase-auth-api.ym {

    final PhoneAuthCredential a;
    tm(com.google.android.gms.internal.firebase-auth-api.xm xm, PhoneAuthCredential phoneAuthCredential2) {
        this.a = phoneAuthCredential2;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ym
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks, Object... object2Arr2) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.a);
    }
}
