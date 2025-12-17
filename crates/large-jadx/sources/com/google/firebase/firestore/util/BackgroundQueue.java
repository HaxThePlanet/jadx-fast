package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class BackgroundQueue implements Executor {

    private Semaphore completedTasks;
    private int pendingTaskCount = 0;
    public BackgroundQueue() {
        super();
        Semaphore semaphore = new Semaphore(0);
        this.completedTasks = semaphore;
    }

    private void a(Runnable runnable) {
        runnable.run();
        this.completedTasks.release();
    }

    @Override // java.util.concurrent.Executor
    public void b(Runnable runnable) {
        a(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void drain() {
        this.completedTasks.acquire(this.pendingTaskCount);
        this.pendingTaskCount = 0;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.pendingTaskCount = pendingTaskCount++;
        l lVar = new l(this, runnable);
        Executors.BACKGROUND_EXECUTOR.execute(lVar);
    }
}
