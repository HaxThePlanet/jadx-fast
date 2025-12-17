package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import io.grpc.h;

/* loaded from: classes2.dex */
public final class n implements e {

    public final com.google.firebase.firestore.remote.FirestoreChannel a;
    public final h[] b;
    public final com.google.firebase.firestore.remote.IncomingStreamObserver c;
    public n(com.google.firebase.firestore.remote.FirestoreChannel firestoreChannel, h[] h2Arr2, com.google.firebase.firestore.remote.IncomingStreamObserver incomingStreamObserver3) {
        super();
        this.a = firestoreChannel;
        this.b = h2Arr2;
        this.c = incomingStreamObserver3;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.b(this.b, this.c, j);
    }
}
