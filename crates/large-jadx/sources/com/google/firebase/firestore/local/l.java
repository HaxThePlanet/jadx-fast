package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final class l implements Supplier {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final ImmutableSortedMap b;
    public final com.google.firebase.firestore.local.TargetData c;
    public l(com.google.firebase.firestore.local.LocalStore localStore, ImmutableSortedMap immutableSortedMap2, com.google.firebase.firestore.local.TargetData targetData3) {
        super();
        this.a = localStore;
        this.b = immutableSortedMap2;
        this.c = targetData3;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return this.a.f(this.b, this.c);
    }
}
