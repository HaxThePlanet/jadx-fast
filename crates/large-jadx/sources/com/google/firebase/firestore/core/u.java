package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class u implements Callable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final DocumentKey b;
    public u(com.google.firebase.firestore.core.FirestoreClient firestoreClient, DocumentKey documentKey2) {
        super();
        this.a = firestoreClient;
        this.b = documentKey2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.k(this.b);
    }
}
