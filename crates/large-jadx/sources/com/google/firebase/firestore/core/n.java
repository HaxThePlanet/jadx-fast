package com.google.firebase.firestore.core;

import com.google.firebase.firestore.LoadBundleTask;
import com.google.firebase.firestore.bundle.BundleReader;

/* loaded from: classes2.dex */
public final class n implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final BundleReader b;
    public final LoadBundleTask c;
    public n(com.google.firebase.firestore.core.FirestoreClient firestoreClient, BundleReader bundleReader2, LoadBundleTask loadBundleTask3) {
        super();
        this.a = firestoreClient;
        this.b = bundleReader2;
        this.c = loadBundleTask3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.s(this.b, this.c);
    }
}
