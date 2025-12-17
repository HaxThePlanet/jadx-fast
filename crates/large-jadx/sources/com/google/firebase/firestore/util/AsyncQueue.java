package com.google.firebase.firestore.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AsyncQueue {

    private final ArrayList<com.google.firebase.firestore.util.AsyncQueue.DelayedTask> delayedTasks;
    private final com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor executor;
    private final ArrayList<com.google.firebase.firestore.util.AsyncQueue.TimerId> timerIdsToSkip;

    public class DelayedTask {

        private ScheduledFuture scheduledFuture;
        private final long targetTimeMs;
        private final Runnable task;
        final com.google.firebase.firestore.util.AsyncQueue this$0;
        private final com.google.firebase.firestore.util.AsyncQueue.TimerId timerId;
        private DelayedTask(com.google.firebase.firestore.util.AsyncQueue asyncQueue, com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId2, long l3, Runnable runnable4) {
            this.this$0 = asyncQueue;
            super();
            this.timerId = timerId2;
            this.targetTimeMs = l3;
            this.task = obj5;
        }

        DelayedTask(com.google.firebase.firestore.util.AsyncQueue asyncQueue, com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId2, long l3, Runnable runnable4, com.google.firebase.firestore.util.AsyncQueue.1 asyncQueue$15) {
            super(asyncQueue, timerId2, l3, runnable4, 15);
        }

        public static void a(com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask) {
            delayedTask.handleDelayElapsed();
        }

        static void access$1200(com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask, long l2) {
            delayedTask.start(l2);
        }

        static long access$1300(com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask) {
            return delayedTask.targetTimeMs;
        }

        static com.google.firebase.firestore.util.AsyncQueue.TimerId access$900(com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask) {
            return delayedTask.timerId;
        }

        private void handleDelayElapsed() {
            Object scheduledFuture;
            this.this$0.verifyIsCurrentThread();
            if (this.scheduledFuture != null) {
                markDone();
                this.task.run();
            }
        }

        private void markDone() {
            int i;
            int i3 = 0;
            i = this.scheduledFuture != null ? 1 : i3;
            Assert.hardAssert(i, "Caller should have verified scheduledFuture is non-null.", new Object[i3]);
            this.scheduledFuture = 0;
            AsyncQueue.access$200(this.this$0, this);
        }

        private void start(long l) {
            c cVar = new c(this);
            this.scheduledFuture = AsyncQueue.SynchronizedShutdownAwareExecutor.access$100(AsyncQueue.access$000(this.this$0), cVar, l, obj5);
        }

        public void cancel() {
            int i;
            this.this$0.verifyIsCurrentThread();
            ScheduledFuture scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                markDone();
            }
        }

        void skipDelay() {
            handleDelayElapsed();
        }
    }

    private class SynchronizedShutdownAwareExecutor implements Executor {

        private final ScheduledThreadPoolExecutor internalExecutor;
        private boolean isShuttingDown = false;
        final com.google.firebase.firestore.util.AsyncQueue this$0;
        private final Thread thread;
        SynchronizedShutdownAwareExecutor(com.google.firebase.firestore.util.AsyncQueue asyncQueue) {
            this.this$0 = asyncQueue;
            super();
            AsyncQueue.SynchronizedShutdownAwareExecutor.DelayedStartFactory delayedStartFactory = new AsyncQueue.SynchronizedShutdownAwareExecutor.DelayedStartFactory(this, 0);
            Thread thread = Executors.defaultThreadFactory().newThread(delayedStartFactory);
            this.thread = thread;
            thread.setName("FirestoreWorker");
            int i2 = 1;
            thread.setDaemon(i2);
            f fVar = new f(this);
            thread.setUncaughtExceptionHandler(fVar);
            AsyncQueue.SynchronizedShutdownAwareExecutor.1 anon = new AsyncQueue.SynchronizedShutdownAwareExecutor.1(this, i2, delayedStartFactory, asyncQueue);
            this.internalExecutor = anon;
            anon.setKeepAliveTime(3, fVar);
            int obj5 = 0;
        }

        static Void a(Runnable runnable) {
            runnable.run();
            return null;
        }

        static ScheduledFuture access$100(com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor asyncQueue$SynchronizedShutdownAwareExecutor, Runnable runnable2, long l3, TimeUnit timeUnit4) {
            return synchronizedShutdownAwareExecutor.schedule(runnable2, l3, timeUnit4);
        }

        static void access$1000(com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor asyncQueue$SynchronizedShutdownAwareExecutor, int i2) {
            synchronizedShutdownAwareExecutor.setCorePoolSize(i2);
        }

        static Thread access$300(com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor asyncQueue$SynchronizedShutdownAwareExecutor) {
            return synchronizedShutdownAwareExecutor.thread;
        }

        static j access$500(com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor asyncQueue$SynchronizedShutdownAwareExecutor, Callable callable2) {
            return synchronizedShutdownAwareExecutor.executeAndReportResult(callable2);
        }

        static j access$600(com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor asyncQueue$SynchronizedShutdownAwareExecutor, Runnable runnable2) {
            return synchronizedShutdownAwareExecutor.executeAndInitiateShutdown(runnable2);
        }

        static boolean access$700(com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor asyncQueue$SynchronizedShutdownAwareExecutor) {
            return synchronizedShutdownAwareExecutor.isShuttingDown();
        }

        static void access$800(com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor asyncQueue$SynchronizedShutdownAwareExecutor) {
            synchronizedShutdownAwareExecutor.shutdownNow();
        }

        static void b(k k, Callable callable2) {
            try {
                k.c(callable2.call());
                k.b(callable2);
                k = new RuntimeException(callable2);
                throw k;
            }
        }

        private void c(Thread thread, Throwable throwable2) {
            this.this$0.panic(throwable2);
        }

        private j<Void> executeAndInitiateShutdown(Runnable runnable) {
            synchronized (this) {
                try {
                    k obj2 = new k();
                    obj2.c(0);
                    return obj2.a();
                    e eVar = new e(runnable);
                    this.isShuttingDown = true;
                    return executeAndReportResult(eVar);
                    throw runnable;
                }
            }
        }

        private <T> j<T> executeAndReportResult(Callable<T> callable) {
            com.google.firebase.firestore.util.g gVar;
            String str;
            Callable obj4;
            k kVar = new k();
            gVar = new g(kVar, callable);
            execute(gVar);
            return kVar.a();
        }

        private boolean isShuttingDown() {
            return this.isShuttingDown;
            synchronized (this) {
                return this.isShuttingDown;
            }
        }

        private ScheduledFuture<?> schedule(Runnable runnable, long l2, TimeUnit timeUnit3) {
            synchronized (this) {
                try {
                    return this.internalExecutor.schedule(runnable, l2, timeUnit3);
                    return 0;
                    throw runnable;
                }
            }
        }

        private void setCorePoolSize(int i) {
            this.internalExecutor.setCorePoolSize(i);
        }

        private void shutdownNow() {
            this.internalExecutor.shutdownNow();
        }

        @Override // java.util.concurrent.Executor
        public void d(Thread thread, Throwable throwable2) {
            c(thread, throwable2);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            boolean internalExecutor;
            synchronized (this) {
                try {
                    this.internalExecutor.execute(runnable);
                    throw runnable;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void executeEvenAfterShutdown(Runnable runnable) {
            ScheduledThreadPoolExecutor internalExecutor;
            String str;
            Runnable obj3;
            try {
                this.internalExecutor.execute(runnable);
                runnable = AsyncQueue.class;
                runnable = runnable.getSimpleName();
                int arr = 0;
                arr = new Object[arr];
                Logger.warn(runnable, "Refused to enqueue task after panic", arr);
            }
        }
    }

    public static enum TimerId {

        ALL,
        LISTEN_STREAM_IDLE,
        LISTEN_STREAM_CONNECTION_BACKOFF,
        WRITE_STREAM_IDLE,
        WRITE_STREAM_CONNECTION_BACKOFF,
        HEALTH_CHECK_TIMEOUT,
        ONLINE_STATE_TIMEOUT,
        GARBAGE_COLLECTION,
        RETRY_TRANSACTION,
        CONNECTIVITY_ATTEMPT_TIMER,
        INDEX_BACKFILL;
    }
    public AsyncQueue() {
        super();
        ArrayList arrayList = new ArrayList();
        this.timerIdsToSkip = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.delayedTasks = arrayList2;
        AsyncQueue.SynchronizedShutdownAwareExecutor synchronizedShutdownAwareExecutor = new AsyncQueue.SynchronizedShutdownAwareExecutor(this);
        this.executor = synchronizedShutdownAwareExecutor;
    }

    static Void a(k k, j j2) {
        Object obj2;
        if (j2.isSuccessful()) {
            k.c(j2.getResult());
        } else {
            k.b(j2.getException());
        }
        return null;
    }

    static com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor access$000(com.google.firebase.firestore.util.AsyncQueue asyncQueue) {
        return asyncQueue.executor;
    }

    static void access$200(com.google.firebase.firestore.util.AsyncQueue asyncQueue, com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask2) {
        asyncQueue.removeDelayedTask(delayedTask2);
    }

    static void b(Callable callable, Executor executor2, k k3) {
        com.google.firebase.firestore.util.a aVar;
        Object obj1;
        Executor obj2;
        try {
            aVar = new a(k3);
            (j)callable.call().continueWith(executor2, aVar);
            executor2 = new IllegalStateException("Unhandled throwable in callTask.", callable);
            k3.b(executor2);
            k3.b(callable);
        }
    }

    static Void c(Runnable runnable) {
        runnable.run();
        return null;
    }

    public static <TResult> j<TResult> callTask(Executor executor, Callable<j<TResult>> callable2) {
        k kVar = new k();
        i iVar = new i(callable2, executor, kVar);
        executor.execute(iVar);
        return kVar.a();
    }

    private com.google.firebase.firestore.util.AsyncQueue.DelayedTask createAndScheduleDelayedTask(com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId, long l2, Runnable runnable3) {
        super(this, timerId, currentTimeMillis + l2, obj6, obj13, 0);
        AsyncQueue.DelayedTask.access$1200(delayedTask, l2);
        return delayedTask;
    }

    static void d(Throwable throwable) {
        if (throwable instanceof OutOfMemoryError != null) {
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (24.0.0) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
            outOfMemoryError.initCause(throwable);
            throw outOfMemoryError;
        }
        RuntimeException runtimeException = new RuntimeException("Internal error in Cloud Firestore (24.0.0).", throwable);
        throw runtimeException;
    }

    static int e(com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask, com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask2) {
        return Long.compare(AsyncQueue.DelayedTask.access$1300(delayedTask), obj1);
    }

    private void f(com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId) {
        int i;
        com.google.firebase.firestore.util.AsyncQueue.TimerId delayedTask;
        ArrayList delayedTasks;
        Object[] aLL;
        int i2 = 0;
        int i3 = 1;
        if (timerId != AsyncQueue.TimerId.ALL) {
            if (containsDelayedTask(timerId)) {
                i = i3;
            } else {
                i = i2;
            }
        } else {
        }
        aLL = new Object[i3];
        aLL[i2] = timerId;
        Assert.hardAssert(i, "Attempted to run tasks until missing TimerId: %s", aLL);
        Collections.sort(this.delayedTasks, d.a);
        ArrayList arrayList = new ArrayList(this.delayedTasks);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            delayedTasks = iterator.next();
            (AsyncQueue.DelayedTask)delayedTasks.skipDelay();
            if (timerId != AsyncQueue.TimerId.ALL) {
            } else {
            }
            if (AsyncQueue.DelayedTask.access$900(delayedTasks) != timerId) {
            }
        }
    }

    static void h(Runnable runnable, Throwable[] throwable2Arr2, Semaphore semaphore3) {
        int i;
        Throwable obj1;
        try {
            runnable.run();
            throwable2Arr2[0] = runnable;
            semaphore3.release();
        }
    }

    private void removeDelayedTask(com.google.firebase.firestore.util.AsyncQueue.DelayedTask asyncQueue$DelayedTask) {
        Assert.hardAssert(this.delayedTasks.remove(delayedTask), "Delayed task not found.", new Object[0]);
    }

    public boolean containsDelayedTask(com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId) {
        com.google.firebase.firestore.util.AsyncQueue.TimerId queue;
        Iterator iterator = this.delayedTasks.iterator();
        for (AsyncQueue.DelayedTask next2 : iterator) {
        }
        return 0;
    }

    public j<Void> enqueue(Runnable runnable) {
        h hVar = new h(runnable);
        return enqueue(hVar);
    }

    public <T> j<T> enqueue(Callable<T> callable) {
        return AsyncQueue.SynchronizedShutdownAwareExecutor.access$500(this.executor, callable);
    }

    public com.google.firebase.firestore.util.AsyncQueue.DelayedTask enqueueAfterDelay(com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId, long l2, Runnable runnable3) {
        int obj3;
        if (this.timerIdsToSkip.contains(timerId)) {
            obj3 = 0;
        }
        final com.google.firebase.firestore.util.AsyncQueue.DelayedTask obj2 = createAndScheduleDelayedTask(timerId, obj3, runnable3);
        this.delayedTasks.add(obj2);
        return obj2;
    }

    public void enqueueAndForget(Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueueAndForgetEvenAfterShutdown(Runnable runnable) {
        this.executor.executeEvenAfterShutdown(runnable);
    }

    public j<Void> enqueueAndInitiateShutdown(Runnable runnable) {
        return AsyncQueue.SynchronizedShutdownAwareExecutor.access$600(this.executor, runnable);
    }

    public void g(com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId) {
        f(timerId);
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public boolean isShuttingDown() {
        return AsyncQueue.SynchronizedShutdownAwareExecutor.access$700(this.executor);
    }

    public void panic(Throwable throwable) {
        AsyncQueue.SynchronizedShutdownAwareExecutor.access$800(this.executor);
        Handler handler = new Handler(Looper.getMainLooper());
        j jVar = new j(throwable);
        handler.post(jVar);
    }

    public void runDelayedTasksUntil(com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId) {
        b bVar = new b(this, timerId);
        runSync(bVar);
    }

    public void runSync(Runnable runnable) {
        int i = 0;
        Semaphore semaphore = new Semaphore(i);
        final int i2 = 1;
        final Throwable[] arr = new Throwable[i2];
        k kVar = new k(runnable, arr, semaphore);
        enqueueAndForget(kVar);
        semaphore.acquire(i2);
        if (arr[i] != null) {
        } else {
        }
        RuntimeException obj6 = new RuntimeException("Synchronous task failed", arr[i]);
        throw obj6;
    }

    public void shutdown() {
        AsyncQueue.SynchronizedShutdownAwareExecutor.access$1000(this.executor, 0);
    }

    public void skipDelaysForTimerId(com.google.firebase.firestore.util.AsyncQueue.TimerId asyncQueue$TimerId) {
        this.timerIdsToSkip.add(timerId);
    }

    public void verifyIsCurrentThread() {
        Thread currentThread = Thread.currentThread();
        if (AsyncQueue.SynchronizedShutdownAwareExecutor.access$300(this.executor) != currentThread) {
        } else {
        }
        Object[] arr = new Object[4];
        throw Assert.fail("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", AsyncQueue.SynchronizedShutdownAwareExecutor.access$300(this.executor).getName(), Long.valueOf(AsyncQueue.SynchronizedShutdownAwareExecutor.access$300(this.executor).getId()), currentThread.getName(), Long.valueOf(currentThread.getId()));
    }
}
