package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;
import java.util.List;

/* loaded from: classes2.dex */
public final class p0 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteMutationQueue a;
    public final List b;
    public p0(com.google.firebase.firestore.local.SQLiteMutationQueue sQLiteMutationQueue, List list2) {
        super();
        this.a = sQLiteMutationQueue;
        this.b = list2;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.b(this.b, (Cursor)object);
    }
}
