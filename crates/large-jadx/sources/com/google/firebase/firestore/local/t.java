package com.google.firebase.firestore.local;

import com.google.firebase.firestore.bundle.BundleMetadata;

/* loaded from: classes2.dex */
public final class t implements Runnable {

    public final com.google.firebase.firestore.local.LocalStore a;
    public final BundleMetadata b;
    public t(com.google.firebase.firestore.local.LocalStore localStore, BundleMetadata bundleMetadata2) {
        super();
        this.a = localStore;
        this.b = bundleMetadata2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.y(this.b);
    }
}
