package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class s0 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteMutationQueue a;
    public final Set b;
    public final List c;
    public s0(com.google.firebase.firestore.local.SQLiteMutationQueue sQLiteMutationQueue, Set set2, List list3) {
        super();
        this.a = sQLiteMutationQueue;
        this.b = set2;
        this.c = list3;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.f(this.b, this.c, (Cursor)object);
    }
}
