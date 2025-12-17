package com.google.firebase.firestore.core;

import java.util.List;

/* loaded from: classes2.dex */
public final class m implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final List b;
    public m(com.google.firebase.firestore.core.FirestoreClient firestoreClient, List list2) {
        super();
        this.a = firestoreClient;
        this.b = list2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b);
    }
}
