package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.bundle.NamedQuery;

/* loaded from: classes2.dex */
public final class u implements Runnable {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final NamedQuery b;
    public final com.google.firebase.firestore.local.TargetData c;
    public final int v;
    public final ImmutableSortedSet w;
    public u(com.google.firebase.firestore.local.LocalStore localStore, NamedQuery namedQuery2, com.google.firebase.firestore.local.TargetData targetData3, int i4, ImmutableSortedSet immutableSortedSet5) {
        super();
        this.a = localStore;
        this.b = namedQuery2;
        this.c = targetData3;
        this.v = i4;
        this.w = immutableSortedSet5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.A(this.b, this.c, this.v, this.w);
    }
}
