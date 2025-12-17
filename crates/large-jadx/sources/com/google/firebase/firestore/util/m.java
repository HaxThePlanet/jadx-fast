package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public final class m implements Runnable {

    public final com.google.firebase.firestore.util.ExponentialBackoff a;
    public final Runnable b;
    public m(com.google.firebase.firestore.util.ExponentialBackoff exponentialBackoff, Runnable runnable2) {
        super();
        this.a = exponentialBackoff;
        this.b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
