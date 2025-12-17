package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.firebase.firestore.util.AsyncQueue.DelayedTask a;
    public c(com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask) {
        super();
        this.a = delayedTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsyncQueue.DelayedTask.a(this.a);
    }
}
