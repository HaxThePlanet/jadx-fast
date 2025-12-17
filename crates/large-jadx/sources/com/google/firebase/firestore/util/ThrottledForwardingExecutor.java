package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
class ThrottledForwardingExecutor implements Executor {

    private final Semaphore availableSlots;
    private final Executor executor;
    ThrottledForwardingExecutor(int i, Executor executor2) {
        super();
        Semaphore semaphore = new Semaphore(i);
        this.availableSlots = semaphore;
        this.executor = executor2;
    }

    private void a(Runnable runnable) {
        runnable.run();
        this.availableSlots.release();
    }

    @Override // java.util.concurrent.Executor
    public void b(Runnable runnable) {
        a(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        boolean tryAcquire;
        com.google.firebase.firestore.util.o oVar;
        if (this.availableSlots.tryAcquire()) {
            oVar = new o(this, runnable);
            this.executor.execute(oVar);
        } else {
            runnable.run();
        }
    }
}
