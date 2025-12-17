package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final class n implements Supplier {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final RemoteEvent b;
    public final SnapshotVersion c;
    public n(com.google.firebase.firestore.local.LocalStore localStore, RemoteEvent remoteEvent2, SnapshotVersion snapshotVersion3) {
        super();
        this.a = localStore;
        this.b = remoteEvent2;
        this.c = snapshotVersion3;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return this.a.h(this.b, this.c);
    }
}
