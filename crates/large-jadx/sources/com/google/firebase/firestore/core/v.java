package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
public final class v implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public v(com.google.firebase.firestore.core.FirestoreClient firestoreClient) {
        super();
        this.a = firestoreClient;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h();
    }
}
