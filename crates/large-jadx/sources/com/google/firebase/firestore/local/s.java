package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.util.Supplier;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class s implements Supplier {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final Set b;
    public final List c;
    public final Timestamp d;
    public s(com.google.firebase.firestore.local.LocalStore localStore, Set set2, List list3, Timestamp timestamp4) {
        super();
        this.a = localStore;
        this.b = set2;
        this.c = list3;
        this.d = timestamp4;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return this.a.G(this.b, this.c, this.d);
    }
}
