package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final com.google.firebase.firestore.core.QueryListener b;
    public h(com.google.firebase.firestore.core.FirestoreClient firestoreClient, com.google.firebase.firestore.core.QueryListener queryListener2) {
        super();
        this.a = firestoreClient;
        this.b = queryListener2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.q(this.b);
    }
}
