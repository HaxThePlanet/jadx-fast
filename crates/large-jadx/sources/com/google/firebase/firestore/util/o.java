package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public final class o implements Runnable {

    public final com.google.firebase.firestore.util.ThrottledForwardingExecutor a;
    public final Runnable b;
    public o(com.google.firebase.firestore.util.ThrottledForwardingExecutor throttledForwardingExecutor, Runnable runnable2) {
        super();
        this.a = throttledForwardingExecutor;
        this.b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
