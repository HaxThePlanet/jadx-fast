package com.google.firebase.auth;

/* loaded from: classes2.dex */
final class zzj implements Runnable {

    final com.google.firebase.auth.FirebaseAuth.IdTokenListener zza;
    final com.google.firebase.auth.FirebaseAuth zzb;
    zzj(com.google.firebase.auth.FirebaseAuth firebaseAuth, com.google.firebase.auth.FirebaseAuth.IdTokenListener firebaseAuth$IdTokenListener2) {
        this.zzb = firebaseAuth;
        this.zza = idTokenListener2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onIdTokenChanged(this.zzb);
    }
}
