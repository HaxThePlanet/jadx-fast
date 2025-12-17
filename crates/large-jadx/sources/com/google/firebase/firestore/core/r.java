package com.google.firebase.firestore.core;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class r implements Callable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final com.google.firebase.firestore.core.Query b;
    public r(com.google.firebase.firestore.core.FirestoreClient firestoreClient, com.google.firebase.firestore.core.Query query2) {
        super();
        this.a = firestoreClient;
        this.b = query2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.m(this.b);
    }
}
