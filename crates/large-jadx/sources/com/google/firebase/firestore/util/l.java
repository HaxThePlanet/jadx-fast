package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public final class l implements Runnable {

    public final com.google.firebase.firestore.util.BackgroundQueue a;
    public final Runnable b;
    public l(com.google.firebase.firestore.util.BackgroundQueue backgroundQueue, Runnable runnable2) {
        super();
        this.a = backgroundQueue;
        this.b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
