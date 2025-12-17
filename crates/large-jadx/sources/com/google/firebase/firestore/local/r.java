package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final class r implements Supplier {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final com.google.firebase.firestore.local.LruGarbageCollector b;
    public r(com.google.firebase.firestore.local.LocalStore localStore, com.google.firebase.firestore.local.LruGarbageCollector lruGarbageCollector2) {
        super();
        this.a = localStore;
        this.b = lruGarbageCollector2;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return this.a.k(this.b);
    }
}
