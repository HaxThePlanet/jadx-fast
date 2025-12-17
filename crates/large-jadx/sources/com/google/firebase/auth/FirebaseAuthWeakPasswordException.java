package com.google.firebase.auth;

/* loaded from: classes2.dex */
public final class FirebaseAuthWeakPasswordException extends com.google.firebase.auth.FirebaseAuthInvalidCredentialsException {

    private final String zza;
    public FirebaseAuthWeakPasswordException(String string, String string2, String string3) {
        super(string, string2);
        this.zza = string3;
    }

    @Override // com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
    public String getReason() {
        return this.zza;
    }
}
