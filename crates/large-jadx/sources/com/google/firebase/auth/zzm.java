package com.google.firebase.auth;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class zzm implements Runnable {

    final com.google.firebase.auth.FirebaseAuth zza;
    zzm(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object next;
        com.google.firebase.auth.FirebaseAuth zza;
        Iterator iterator = FirebaseAuth.zzB(this.zza).iterator();
        for (FirebaseAuth.AuthStateListener next : iterator) {
            next.onAuthStateChanged(this.zza);
        }
    }
}
