package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class o implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final k b;
    public o(com.google.firebase.firestore.core.FirestoreClient firestoreClient, k k2) {
        super();
        this.a = firestoreClient;
        this.b = k2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.J(this.b);
    }
}
