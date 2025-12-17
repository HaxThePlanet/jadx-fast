package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final class p implements Supplier {

    public final com.google.firebase.firestore.local.IndexBackfiller a;
    public p(com.google.firebase.firestore.local.IndexBackfiller indexBackfiller) {
        super();
        this.a = indexBackfiller;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return LocalStore.i(this.a);
    }
}
