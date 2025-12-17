package com.google.firebase.auth;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class zzl implements Runnable {

    final com.google.firebase.auth.FirebaseAuth zza;
    final InternalTokenResult zzb;
    zzl(com.google.firebase.auth.FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult2) {
        this.zza = firebaseAuth;
        this.zzb = internalTokenResult2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object next2;
        boolean next;
        InternalTokenResult zza;
        Iterator iterator = FirebaseAuth.zzz(this.zza).iterator();
        for (IdTokenListener next2 : iterator) {
            next2.onIdTokenChanged(this.zzb);
        }
        Iterator iterator2 = FirebaseAuth.zzA(this.zza).iterator();
        for (FirebaseAuth.IdTokenListener next : iterator2) {
            next.onIdTokenChanged(this.zza);
        }
    }
}
