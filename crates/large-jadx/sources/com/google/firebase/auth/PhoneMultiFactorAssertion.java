package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class PhoneMultiFactorAssertion extends com.google.firebase.auth.MultiFactorAssertion {

    private final com.google.firebase.auth.PhoneAuthCredential zza;
    public PhoneMultiFactorAssertion(com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential) {
        super();
        r.j(phoneAuthCredential);
        this.zza = phoneAuthCredential;
    }

    @Override // com.google.firebase.auth.MultiFactorAssertion
    public String getFactorId() {
        return "phone";
    }

    @Override // com.google.firebase.auth.MultiFactorAssertion
    public final com.google.firebase.auth.PhoneAuthCredential zza() {
        return this.zza;
    }
}
