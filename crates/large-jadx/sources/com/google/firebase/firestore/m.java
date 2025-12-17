package com.google.firebase.firestore;

/* loaded from: classes2.dex */
public final class m implements Runnable {

    public final com.google.firebase.firestore.LoadBundleTask.ManagedListener a;
    public final com.google.firebase.firestore.LoadBundleTaskProgress b;
    public m(com.google.firebase.firestore.LoadBundleTask.ManagedListener loadBundleTask$ManagedListener, com.google.firebase.firestore.LoadBundleTaskProgress loadBundleTaskProgress2) {
        super();
        this.a = managedListener;
        this.b = loadBundleTaskProgress2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
