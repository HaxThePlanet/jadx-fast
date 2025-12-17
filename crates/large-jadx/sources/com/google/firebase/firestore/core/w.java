package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.k;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Listener;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class w implements Listener {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final AtomicBoolean b;
    public final k c;
    public final AsyncQueue d;
    public w(com.google.firebase.firestore.core.FirestoreClient firestoreClient, AtomicBoolean atomicBoolean2, k k3, AsyncQueue asyncQueue4) {
        super();
        this.a = firestoreClient;
        this.b = atomicBoolean2;
        this.c = k3;
        this.d = asyncQueue4;
    }

    @Override // com.google.firebase.firestore.util.Listener
    public final void onValue(Object object) {
        this.a.y(this.b, this.c, this.d, (User)object);
    }
}
