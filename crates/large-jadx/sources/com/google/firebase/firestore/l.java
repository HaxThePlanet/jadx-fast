package com.google.firebase.firestore;

/* loaded from: classes2.dex */
public final class l implements Runnable {

    public final com.google.firebase.firestore.LoadBundleTask a;
    public final com.google.firebase.firestore.OnProgressListener b;
    public l(com.google.firebase.firestore.LoadBundleTask loadBundleTask, com.google.firebase.firestore.OnProgressListener onProgressListener2) {
        super();
        this.a = loadBundleTask;
        this.b = onProgressListener2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
