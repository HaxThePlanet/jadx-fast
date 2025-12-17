package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class PhoneMultiFactorGenerator {

    public static final String FACTOR_ID = "phone";
    public static com.google.firebase.auth.PhoneMultiFactorAssertion getAssertion(com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential) {
        r.j(phoneAuthCredential);
        PhoneMultiFactorAssertion phoneMultiFactorAssertion = new PhoneMultiFactorAssertion(phoneAuthCredential);
        return phoneMultiFactorAssertion;
    }
}
