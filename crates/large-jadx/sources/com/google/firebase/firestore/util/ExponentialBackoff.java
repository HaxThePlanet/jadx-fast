package com.google.firebase.firestore.util;

import java.util.Date;

/* loaded from: classes2.dex */
public class ExponentialBackoff {

    public static final double DEFAULT_BACKOFF_FACTOR = 1.5d;
    public static final long DEFAULT_BACKOFF_INITIAL_DELAY_MS = 1000L;
    public static final long DEFAULT_BACKOFF_MAX_DELAY_MS = 60000L;
    private final double backoffFactor;
    private long currentBaseMs;
    private final long initialDelayMs;
    private long lastAttemptTime;
    private final long maxDelayMs;
    private long nextMaxDelayMs;
    private final com.google.firebase.firestore.util.AsyncQueue queue;
    private final com.google.firebase.firestore.util.AsyncQueue.TimerId timerId;
    private com.google.firebase.firestore.util.AsyncQueue.DelayedTask timerTask;
    public ExponentialBackoff(com.google.firebase.firestore.util.AsyncQueue asyncQueue, com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId2) {
        super(asyncQueue, timerId2, 1000, obj4, 4609434218613702656L, obj6, 60000, obj8);
    }

    public ExponentialBackoff(com.google.firebase.firestore.util.AsyncQueue asyncQueue, com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId2, long l3, double d4, long l5) {
        super();
        this.queue = asyncQueue;
        this.timerId = timerId2;
        this.initialDelayMs = l3;
        this.backoffFactor = l5;
        this.maxDelayMs = obj7;
        this.nextMaxDelayMs = obj7;
        Date obj1 = new Date();
        this.lastAttemptTime = obj1.getTime();
        reset();
    }

    private void a(Runnable runnable) {
        Date date = new Date();
        this.lastAttemptTime = date.getTime();
        runnable.run();
    }

    private long jitterDelayMs() {
        return (long)i2;
    }

    public void b(Runnable runnable) {
        a(runnable);
    }

    public void backoffAndRun(Runnable runnable) {
        int str;
        long valueOf;
        long initialDelayMs;
        int simpleName;
        long arr;
        long currentBaseMs;
        Long valueOf2;
        int obj12;
        cancel();
        currentBaseMs2 += jitterDelayMs;
        Date date = new Date();
        int i4 = 0;
        long l2 = Math.max(i4, obj5);
        long l3 = Math.max(i4, obj5);
        if (Long.compare(currentBaseMs, i4) > 0) {
            arr = new Object[4];
            Logger.debug(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(l3), Long.valueOf(this.currentBaseMs), Long.valueOf(str), Long.valueOf(l2));
        }
        m mVar = new m(this, runnable);
        this.timerTask = this.queue.enqueueAfterDelay(this.timerId, l3, obj7);
        long l = (long)i2;
        this.currentBaseMs = l;
        initialDelayMs = this.initialDelayMs;
        if (Long.compare(l, initialDelayMs) < 0) {
            this.currentBaseMs = initialDelayMs;
        } else {
            initialDelayMs = this.nextMaxDelayMs;
            if (Long.compare(l, initialDelayMs) > 0) {
                this.currentBaseMs = initialDelayMs;
            }
        }
        this.nextMaxDelayMs = this.maxDelayMs;
    }

    public void cancel() {
        com.google.firebase.firestore.util.AsyncQueue.DelayedTask timerTask;
        timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.timerTask = 0;
        }
    }

    public void reset() {
        this.currentBaseMs = 0;
    }

    public void resetToMax() {
        this.currentBaseMs = this.nextMaxDelayMs;
    }

    public void setTemporaryMaxDelay(long l) {
        this.nextMaxDelayMs = l;
    }
}
