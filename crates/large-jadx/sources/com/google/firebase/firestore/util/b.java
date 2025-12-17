package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.firebase.firestore.util.AsyncQueue a;
    public final com.google.firebase.firestore.util.AsyncQueue.TimerId b;
    public b(com.google.firebase.firestore.util.AsyncQueue asyncQueue, com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId2) {
        super();
        this.a = asyncQueue;
        this.b = timerId2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.g(this.b);
    }
}
