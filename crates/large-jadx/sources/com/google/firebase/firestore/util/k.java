package com.google.firebase.firestore.util;

import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public final class k implements Runnable {

    public final Runnable a;
    public final Throwable[] b;
    public final Semaphore c;
    public k(Runnable runnable, Throwable[] throwable2Arr2, Semaphore semaphore3) {
        super();
        this.a = runnable;
        this.b = throwable2Arr2;
        this.c = semaphore3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsyncQueue.h(this.a, this.b, this.c);
    }
}
