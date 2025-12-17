package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;

/* loaded from: classes2.dex */
public final class q implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final EventListener b;
    public q(com.google.firebase.firestore.core.FirestoreClient firestoreClient, EventListener eventListener2) {
        super();
        this.a = firestoreClient;
        this.b = eventListener2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.B(this.b);
    }
}
