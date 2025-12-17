package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public f(com.google.firebase.firestore.core.FirestoreClient firestoreClient) {
        super();
        this.a = firestoreClient;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.F();
    }
}
