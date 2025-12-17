package com.google.firebase.firestore.core;

import com.google.firebase.firestore.auth.User;

/* loaded from: classes2.dex */
public final class i implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final User b;
    public i(com.google.firebase.firestore.core.FirestoreClient firestoreClient, User user2) {
        super();
        this.a = firestoreClient;
        this.b = user2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.w(this.b);
    }
}
