package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.internal.zzw;

/* loaded from: classes2.dex */
final class zzq extends com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks {

    final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
    final com.google.firebase.auth.FirebaseAuth zzb;
    zzq(com.google.firebase.auth.FirebaseAuth firebaseAuth, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks2) {
        this.zzb = firebaseAuth;
        this.zza = onVerificationStateChangedCallbacks2;
        super();
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
    public final void onCodeAutoRetrievalTimeOut(String string) {
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
    public final void onCodeSent(String string, com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken phoneAuthProvider$ForceResendingToken2) {
        String str = FirebaseAuth.zzv(this.zzb).zzb();
        r.j(str);
        this.zza.onVerificationCompleted(PhoneAuthProvider.getCredential(string, (String)str));
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
    public final void onVerificationCompleted(com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential) {
        this.zza.onVerificationCompleted(phoneAuthCredential);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
    public final void onVerificationFailed(FirebaseException firebaseException) {
        this.zza.onVerificationFailed(firebaseException);
    }
}
