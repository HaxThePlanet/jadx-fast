package com.google.firebase.auth;

/* loaded from: classes2.dex */
public final class FirebaseAuthUserCollisionException extends com.google.firebase.auth.FirebaseAuthException {

    private com.google.firebase.auth.AuthCredential zza;
    private String zzb;
    private String zzc;
    public FirebaseAuthUserCollisionException(String string, String string2) {
        super(string, string2);
    }

    @Override // com.google.firebase.auth.FirebaseAuthException
    public String getEmail() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.FirebaseAuthException
    public com.google.firebase.auth.AuthCredential getUpdatedCredential() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseAuthException
    public final com.google.firebase.auth.FirebaseAuthUserCollisionException zza(com.google.firebase.auth.AuthCredential authCredential) {
        this.zza = authCredential;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseAuthException
    public final com.google.firebase.auth.FirebaseAuthUserCollisionException zzb(String string) {
        this.zzb = string;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseAuthException
    public final com.google.firebase.auth.FirebaseAuthUserCollisionException zzc(String string) {
        this.zzc = string;
        return this;
    }
}
