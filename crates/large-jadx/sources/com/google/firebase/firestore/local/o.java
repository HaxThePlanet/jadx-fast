package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final class o implements Supplier {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final MutationBatchResult b;
    public o(com.google.firebase.firestore.local.LocalStore localStore, MutationBatchResult mutationBatchResult2) {
        super();
        this.a = localStore;
        this.b = mutationBatchResult2;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return this.a.b(this.b);
    }
}
