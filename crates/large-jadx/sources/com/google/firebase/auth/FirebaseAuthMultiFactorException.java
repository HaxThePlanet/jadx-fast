package com.google.firebase.auth;

/* loaded from: classes2.dex */
public class FirebaseAuthMultiFactorException extends com.google.firebase.auth.FirebaseAuthException {

    private com.google.firebase.auth.MultiFactorResolver zza;
    public FirebaseAuthMultiFactorException(String string, String string2, com.google.firebase.auth.MultiFactorResolver multiFactorResolver3) {
        super(string, string2);
        this.zza = multiFactorResolver3;
    }

    @Override // com.google.firebase.auth.FirebaseAuthException
    public com.google.firebase.auth.MultiFactorResolver getResolver() {
        return this.zza;
    }
}
