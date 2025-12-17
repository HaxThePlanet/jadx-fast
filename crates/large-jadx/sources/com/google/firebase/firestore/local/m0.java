package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class m0 implements Function {

    public final com.google.firebase.firestore.local.SQLiteMutationQueue a;
    public m0(com.google.firebase.firestore.local.SQLiteMutationQueue sQLiteMutationQueue) {
        super();
        this.a = sQLiteMutationQueue;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return this.a.l((Cursor)object);
    }
}
