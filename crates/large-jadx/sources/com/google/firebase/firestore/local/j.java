package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final class j implements Supplier {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final int b;
    public j(com.google.firebase.firestore.local.LocalStore localStore, int i2) {
        super();
        this.a = localStore;
        this.b = i2;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return this.a.u(this.b);
    }
}
