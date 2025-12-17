package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class q0 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteMutationQueue a;
    public q0(com.google.firebase.firestore.local.SQLiteMutationQueue sQLiteMutationQueue) {
        super();
        this.a = sQLiteMutationQueue;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.t((Cursor)object);
    }
}
