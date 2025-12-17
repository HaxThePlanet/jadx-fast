package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public final class f implements java.lang.Thread.UncaughtExceptionHandler {

    public final com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor a;
    public f(com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor asyncQueue$SynchronizedShutdownAwareExecutor) {
        super();
        this.a = synchronizedShutdownAwareExecutor;
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable throwable2) {
        this.a.d(thread, throwable2);
    }
}
