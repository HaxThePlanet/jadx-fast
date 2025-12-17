package com.google.firebase.auth;

/* loaded from: classes2.dex */
final class zzk implements Runnable {

    final com.google.firebase.auth.FirebaseAuth.AuthStateListener zza;
    final com.google.firebase.auth.FirebaseAuth zzb;
    zzk(com.google.firebase.auth.FirebaseAuth firebaseAuth, com.google.firebase.auth.FirebaseAuth.AuthStateListener firebaseAuth$AuthStateListener2) {
        this.zzb = firebaseAuth;
        this.zza = authStateListener2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
