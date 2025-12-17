package com.google.firebase.firestore.local;

import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public final class i implements Supplier {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final BundleMetadata b;
    public i(com.google.firebase.firestore.local.LocalStore localStore, BundleMetadata bundleMetadata2) {
        super();
        this.a = localStore;
        this.b = bundleMetadata2;
    }

    @Override // com.google.firebase.firestore.util.Supplier
    public final Object get() {
        return this.a.q(this.b);
    }
}
