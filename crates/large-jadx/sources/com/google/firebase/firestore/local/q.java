package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final class q implements Supplier {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final String b;
    public q(com.google.firebase.firestore.local.LocalStore localStore, String string2) {
        super();
        this.a = localStore;
        this.b = string2;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return this.a.o(this.b);
    }
}
