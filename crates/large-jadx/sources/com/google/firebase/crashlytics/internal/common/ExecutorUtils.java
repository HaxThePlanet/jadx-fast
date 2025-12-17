package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class ExecutorUtils {

    private static final long DEFAULT_TERMINATION_TIMEOUT = 2L;
    private static void addDelayedShutdownHook(String string, ExecutorService executorService2) {
        ExecutorUtils.addDelayedShutdownHook(string, executorService2, 2, obj2);
    }

    private static void addDelayedShutdownHook(String string, ExecutorService executorService2, long l3, TimeUnit timeUnit4) {
        super(string, executorService2, l3, obj6, obj13);
        StringBuilder obj10 = new StringBuilder();
        obj10.append("Crashlytics Shutdown Hook for ");
        obj10.append(string);
        Thread thread = new Thread(anon2, obj10.toString());
        Runtime.getRuntime().addShutdownHook(thread);
    }

    public static ExecutorService buildSingleThreadExecutorService(String string) {
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        ExecutorService singleThreadExecutor = ExecutorUtils.newSingleThreadExecutor(ExecutorUtils.getNamedThreadFactory(string), discardPolicy);
        ExecutorUtils.addDelayedShutdownHook(string, singleThreadExecutor);
        return singleThreadExecutor;
    }

    public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String string) {
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(ExecutorUtils.getNamedThreadFactory(string));
        ExecutorUtils.addDelayedShutdownHook(string, singleThreadScheduledExecutor);
        return singleThreadScheduledExecutor;
    }

    public static ThreadFactory getNamedThreadFactory(String string) {
        AtomicLong atomicLong = new AtomicLong(1, obj2);
        ExecutorUtils.1 anon = new ExecutorUtils.1(string, atomicLong);
        return anon;
    }

    private static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler2) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(1, 1, 0, obj4, TimeUnit.MILLISECONDS, linkedBlockingQueue, threadFactory, rejectedExecutionHandler2);
        return Executors.unconfigurableExecutorService(threadPoolExecutor2);
    }
}
