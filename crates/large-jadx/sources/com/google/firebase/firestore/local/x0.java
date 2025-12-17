package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class x0 implements Function {

    public final com.google.firebase.firestore.local.SQLiteMutationQueue a;
    public final int b;
    public x0(com.google.firebase.firestore.local.SQLiteMutationQueue sQLiteMutationQueue, int i2) {
        super();
        this.a = sQLiteMutationQueue;
        this.b = i2;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return this.a.q(this.b, (Cursor)object);
    }
}
