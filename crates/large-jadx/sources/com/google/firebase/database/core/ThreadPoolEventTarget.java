package com.google.firebase.database.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class ThreadPoolEventTarget implements com.google.firebase.database.core.EventTarget {

    private final ThreadPoolExecutor executor;
    public ThreadPoolEventTarget(ThreadFactory threadFactory, com.google.firebase.database.core.ThreadInitializer threadInitializer2) {
        super();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadPoolEventTarget.1 anon = new ThreadPoolEventTarget.1(this, threadFactory, threadInitializer2);
        final int i2 = 1;
        super(i2, i2, 3, obj4, TimeUnit.SECONDS, linkedBlockingQueue, anon);
        this.executor = threadPoolExecutor2;
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void postEvent(Runnable runnable) {
        this.executor.execute(runnable);
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void restart() {
        this.executor.setCorePoolSize(1);
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }
}
