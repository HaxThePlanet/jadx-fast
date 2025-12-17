package com.google.firebase.firestore.core;

import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.firebase.firestore.core.AsyncEventListener a;
    public final Object b;
    public final FirebaseFirestoreException c;
    public c(com.google.firebase.firestore.core.AsyncEventListener asyncEventListener, Object object2, FirebaseFirestoreException firebaseFirestoreException3) {
        super();
        this.a = asyncEventListener;
        this.b = object2;
        this.c = firebaseFirestoreException3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b, this.c);
    }
}
