package com.google.firebase.firestore;

import com.google.firebase.firestore.core.Transaction;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class j implements Callable {

    public final com.google.firebase.firestore.FirebaseFirestore a;
    public final com.google.firebase.firestore.Transaction.Function b;
    public final Transaction c;
    public j(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, com.google.firebase.firestore.Transaction.Function transaction$Function2, Transaction transaction3) {
        super();
        this.a = firebaseFirestore;
        this.b = function2;
        this.c = transaction3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.i(this.b, this.c);
    }
}
