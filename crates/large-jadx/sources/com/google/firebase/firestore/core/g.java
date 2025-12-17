package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final String b;
    public final k c;
    public g(com.google.firebase.firestore.core.FirestoreClient firestoreClient, String string2, k k3) {
        super();
        this.a = firestoreClient;
        this.b = string2;
        this.c = k3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.o(this.b, this.c);
    }
}
