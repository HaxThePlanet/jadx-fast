package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

/* loaded from: classes2.dex */
final class in extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {

    final PhoneAuthProvider.OnVerificationStateChangedCallbacks a;
    final String b;
    in(PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks, String string2) {
        this.a = onVerificationStateChangedCallbacks;
        this.b = string2;
        super();
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
    public final void onCodeAutoRetrievalTimeOut(String string) {
        kn.b(this.b);
        this.a.onCodeAutoRetrievalTimeOut(string);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
    public final void onCodeSent(String string, PhoneAuthProvider.ForceResendingToken phoneAuthProvider$ForceResendingToken2) {
        this.a.onCodeSent(string, forceResendingToken2);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        kn.b(this.b);
        this.a.onVerificationCompleted(phoneAuthCredential);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
    public final void onVerificationFailed(FirebaseException firebaseException) {
        kn.b(this.b);
        this.a.onVerificationFailed(firebaseException);
    }
}
