package com.google.firebase.firestore.core;

import com.google.firebase.firestore.util.Function;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class s implements Callable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final Function b;
    public s(com.google.firebase.firestore.core.FirestoreClient firestoreClient, Function function2) {
        super();
        this.a = firestoreClient;
        this.b = function2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.H(this.b);
    }
}
