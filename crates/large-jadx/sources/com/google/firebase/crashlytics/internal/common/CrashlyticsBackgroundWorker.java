package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class CrashlyticsBackgroundWorker {

    private final Executor executor;
    private final java.lang.ThreadLocal<Boolean> isExecutorThread;
    private j<Void> tail;
    private final Object tailLock;
    public CrashlyticsBackgroundWorker(Executor executor) {
        super();
        this.tail = m.e(0);
        Object object = new Object();
        this.tailLock = object;
        ThreadLocal threadLocal = new ThreadLocal();
        this.isExecutorThread = threadLocal;
        this.executor = executor;
        CrashlyticsBackgroundWorker.1 anon = new CrashlyticsBackgroundWorker.1(this);
        executor.execute(anon);
    }

    static java.lang.ThreadLocal access$000(com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        return crashlyticsBackgroundWorker.isExecutorThread;
    }

    private <T> j<Void> ignoreResult(j<T> j) {
        CrashlyticsBackgroundWorker.4 anon = new CrashlyticsBackgroundWorker.4(this);
        return j.continueWith(this.executor, anon);
    }

    private boolean isRunningOnThread() {
        return Boolean.TRUE.equals(this.isExecutorThread.get());
    }

    private <T> c<Void, T> newContinuation(Callable<T> callable) {
        CrashlyticsBackgroundWorker.3 anon = new CrashlyticsBackgroundWorker.3(this, callable);
        return anon;
    }

    public void checkRunningOnThread() {
        if (!isRunningOnThread()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not running on background worker thread as intended.");
        throw illegalStateException;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    j<Void> submit(Runnable runnable) {
        CrashlyticsBackgroundWorker.2 anon = new CrashlyticsBackgroundWorker.2(this, runnable);
        return submit(anon);
    }

    public <T> j<T> submit(Callable<T> callable) {
        final Object tailLock = this.tailLock;
        j obj4 = this.tail.continueWith(this.executor, newContinuation(callable));
        this.tail = ignoreResult(obj4);
        return obj4;
        synchronized (tailLock) {
            tailLock = this.tailLock;
            obj4 = this.tail.continueWith(this.executor, newContinuation(callable));
            this.tail = ignoreResult(obj4);
            return obj4;
        }
    }

    public <T> j<T> submitTask(Callable<j<T>> callable) {
        final Object tailLock = this.tailLock;
        j obj4 = this.tail.continueWithTask(this.executor, newContinuation(callable));
        this.tail = ignoreResult(obj4);
        return obj4;
        synchronized (tailLock) {
            tailLock = this.tailLock;
            obj4 = this.tail.continueWithTask(this.executor, newContinuation(callable));
            this.tail = ignoreResult(obj4);
            return obj4;
        }
    }
}
