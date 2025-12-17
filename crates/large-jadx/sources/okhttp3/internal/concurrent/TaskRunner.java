package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 02\u00020\u0001:\u0003102B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\u0008.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000cH\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000c¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0015¢\u0006\u0004\u0008\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\u0008\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u001d\u0010\u001eR\u001c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008 \u0010!R\u001c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\"\u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008'\u0010(R\u0019\u0010*\u001a\u00020)8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008*\u0010+\u001a\u0004\u0008,\u0010-¨\u00063", d2 = {"Lokhttp3/internal/concurrent/TaskRunner;", "", "Lokhttp3/internal/concurrent/Task;", "task", "Lkotlin/w;", "beforeRun", "(Lokhttp3/internal/concurrent/Task;)V", "runTask", "", "delayNanos", "afterRun", "(Lokhttp3/internal/concurrent/Task;J)V", "Lokhttp3/internal/concurrent/TaskQueue;", "taskQueue", "kickCoordinator$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "kickCoordinator", "awaitTaskToRun", "()Lokhttp3/internal/concurrent/Task;", "newQueue", "()Lokhttp3/internal/concurrent/TaskQueue;", "", "activeQueues", "()Ljava/util/List;", "cancelAll", "()V", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Runnable;", "coordinatorWakeUpAt", "J", "", "readyQueues", "Ljava/util/List;", "busyQueues", "", "coordinatorWaiting", "Z", "", "nextQueueName", "I", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "Companion", "Backend", "RealBackend", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class TaskRunner {

    public static final okhttp3.internal.concurrent.TaskRunner.Companion Companion;
    public static final okhttp3.internal.concurrent.TaskRunner INSTANCE;
    private static final Logger logger;
    private final okhttp3.internal.concurrent.TaskRunner.Backend backend;
    private final List<okhttp3.internal.concurrent.TaskQueue> busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int nextQueueName = 10000;
    private final List<okhttp3.internal.concurrent.TaskQueue> readyQueues;
    private final Runnable runnable;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0008\u001a\u00020\u0007H&¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\n\u0010\u0006J\u001f\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\u0008\u0010\u0010\u0011¨\u0006\u0012", d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lkotlin/w;", "beforeTask", "(Lokhttp3/internal/concurrent/TaskRunner;)V", "", "nanoTime", "()J", "coordinatorNotify", "nanos", "coordinatorWait", "(Lokhttp3/internal/concurrent/TaskRunner;J)V", "Ljava/lang/Runnable;", "runnable", "execute", "(Ljava/lang/Runnable;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Backend {
        public abstract void beforeTask(okhttp3.internal.concurrent.TaskRunner taskRunner);

        public abstract void coordinatorNotify(okhttp3.internal.concurrent.TaskRunner taskRunner);

        public abstract void coordinatorWait(okhttp3.internal.concurrent.TaskRunner taskRunner, long l2);

        public abstract void execute(Runnable runnable);

        public abstract long nanoTime();
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0008\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "Lokhttp3/internal/concurrent/TaskRunner;", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final Logger getLogger() {
            return TaskRunner.access$getLogger$cp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\n\u0010\u0006J\u001f\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016¨\u0006\u001b", d2 = {"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lkotlin/w;", "beforeTask", "(Lokhttp3/internal/concurrent/TaskRunner;)V", "", "nanoTime", "()J", "coordinatorNotify", "nanos", "coordinatorWait", "(Lokhttp3/internal/concurrent/TaskRunner;J)V", "Ljava/lang/Runnable;", "runnable", "execute", "(Ljava/lang/Runnable;)V", "shutdown", "()V", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class RealBackend implements okhttp3.internal.concurrent.TaskRunner.Backend {

        private final ThreadPoolExecutor executor;
        public RealBackend(ThreadFactory threadFactory) {
            n.f(threadFactory, "threadFactory");
            super();
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            super(0, Integer.MAX_VALUE, 60, obj5, TimeUnit.SECONDS, synchronousQueue, threadFactory);
            this.executor = threadPoolExecutor;
        }

        @Override // okhttp3.internal.concurrent.TaskRunner$Backend
        public void beforeTask(okhttp3.internal.concurrent.TaskRunner taskRunner) {
            n.f(taskRunner, "taskRunner");
        }

        @Override // okhttp3.internal.concurrent.TaskRunner$Backend
        public void coordinatorNotify(okhttp3.internal.concurrent.TaskRunner taskRunner) {
            n.f(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner$Backend
        public void coordinatorWait(okhttp3.internal.concurrent.TaskRunner taskRunner, long l2) {
            int obj9;
            n.f(taskRunner, "taskRunner");
            int i = 1000000;
            final int i4 = l2 / i;
            final int i5 = 0;
            if (Long.compare(i4, i5) <= 0) {
                if (Long.compare(l2, i5) > 0) {
                    taskRunner.wait(i4, obj3);
                }
            } else {
            }
        }

        @Override // okhttp3.internal.concurrent.TaskRunner$Backend
        public void execute(Runnable runnable) {
            n.f(runnable, "runnable");
            this.executor.execute(runnable);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner$Backend
        public long nanoTime() {
            return System.nanoTime();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner$Backend
        public final void shutdown() {
            this.executor.shutdown();
        }
    }
    static {
        TaskRunner.Companion companion = new TaskRunner.Companion(0);
        TaskRunner.Companion = companion;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Util.okHttpName);
        stringBuilder.append(" TaskRunner");
        TaskRunner.RealBackend realBackend = new TaskRunner.RealBackend(Util.threadFactory(stringBuilder.toString(), true));
        TaskRunner taskRunner = new TaskRunner(realBackend);
        TaskRunner.INSTANCE = taskRunner;
        Logger logger = Logger.getLogger(TaskRunner.class.getName());
        n.e(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        TaskRunner.logger = logger;
    }

    public TaskRunner(okhttp3.internal.concurrent.TaskRunner.Backend taskRunner$Backend) {
        n.f(backend, "backend");
        super();
        this.backend = backend;
        int obj2 = 10000;
        obj2 = new ArrayList();
        this.busyQueues = obj2;
        obj2 = new ArrayList();
        this.readyQueues = obj2;
        obj2 = new TaskRunner.runnable.1(this);
        this.runnable = obj2;
    }

    public static final Logger access$getLogger$cp() {
        return TaskRunner.logger;
    }

    public static final void access$runTask(okhttp3.internal.concurrent.TaskRunner taskRunner, okhttp3.internal.concurrent.Task task2) {
        taskRunner.runTask(task2);
    }

    private final void afterRun(okhttp3.internal.concurrent.Task task, long l2) {
        boolean assertionsEnabled;
        int i;
        boolean cancelActiveTask$okhttp;
        int obj7;
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder obj8 = new StringBuilder();
            obj8.append("Thread ");
            Thread obj9 = Thread.currentThread();
            n.e(obj9, "Thread.currentThread()");
            obj8.append(obj9.getName());
            obj8.append(" MUST hold lock on ");
            obj8.append(this);
            obj7 = new AssertionError(obj8.toString());
            throw obj7;
        }
        okhttp3.internal.concurrent.TaskQueue queue$okhttp = task.getQueue$okhttp();
        n.d(queue$okhttp);
        int i2 = 0;
        final int i4 = 1;
        i = queue$okhttp.getActiveTask$okhttp() == task ? i4 : i2;
        if (i == 0) {
        } else {
            queue$okhttp.setCancelActiveTask$okhttp(i2);
            queue$okhttp.setActiveTask$okhttp(0);
            this.busyQueues.remove(queue$okhttp);
            if (Long.compare(l2, i5) != 0 && !queue$okhttp.getCancelActiveTask$okhttp() && !queue$okhttp.getShutdown$okhttp()) {
                if (!queue$okhttp.getCancelActiveTask$okhttp()) {
                    if (!queue$okhttp.getShutdown$okhttp()) {
                        queue$okhttp.scheduleAndDecide$okhttp(task, l2, obj9);
                    }
                }
            }
            if (obj7 ^= i4 != 0) {
                this.readyQueues.add(queue$okhttp);
            }
        }
        obj7 = new IllegalStateException("Check failed.".toString());
        throw obj7;
    }

    private final void beforeRun(okhttp3.internal.concurrent.Task task) {
        boolean assertionsEnabled;
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(this);
            AssertionError obj4 = new AssertionError(stringBuilder.toString());
            throw obj4;
        }
        task.setNextExecuteNanoTime$okhttp(-1);
        okhttp3.internal.concurrent.TaskQueue queue$okhttp = task.getQueue$okhttp();
        n.d(queue$okhttp);
        queue$okhttp.getFutureTasks$okhttp().remove(task);
        this.readyQueues.remove(queue$okhttp);
        queue$okhttp.setActiveTask$okhttp(task);
        this.busyQueues.add(queue$okhttp);
    }

    private final void runTask(okhttp3.internal.concurrent.Task task) {
        boolean assertionsEnabled;
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread2 = Thread.currentThread();
            n.e(currentThread2, "Thread.currentThread()");
            stringBuilder.append(currentThread2.getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            AssertionError obj6 = new AssertionError(stringBuilder.toString());
            throw obj6;
        }
        Thread currentThread = Thread.currentThread();
        n.e(currentThread, "currentThread");
        currentThread.setName(task.getName());
        int i = -1;
        afterRun(task, task.runOnce());
        obj6 = w.a;
        currentThread.setName(currentThread.getName());
        return;
        synchronized (this) {
            currentThread = Thread.currentThread();
            n.e(currentThread, "currentThread");
            currentThread.setName(task.getName());
            i = -1;
            afterRun(task, task.runOnce());
            obj6 = w.a;
            currentThread.setName(currentThread.getName());
        }
    }

    public final List<okhttp3.internal.concurrent.TaskQueue> activeQueues() {
        return p.t0(this.busyQueues, this.readyQueues);
        synchronized (this) {
            return p.t0(this.busyQueues, this.readyQueues);
        }
    }

    public final okhttp3.internal.concurrent.Task awaitTaskToRun() {
        boolean assertionsEnabled;
        int coordinatorWaiting;
        int backend;
        int runnable;
        int i3;
        long l;
        int i;
        boolean next;
        int i2;
        boolean z;
        long l2;
        int cmp;
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(this);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        runnable = 0;
        while (this.readyQueues.isEmpty()) {
            long nanoTime = this.backend.nanoTime();
            l = Long.MAX_VALUE;
            Iterator iterator = this.readyQueues.iterator();
            i = runnable;
            i2 = 1;
            z = 0;
            for (TaskQueue next2 : iterator) {
                next = next2.getFutureTasks$okhttp().get(z);
                int i6 = 0;
                l2 = Math.max(i6, obj13);
                i = next;
                i2 = 1;
                z = 0;
                l = Math.min(l2, obj11);
            }
            coordinatorWaiting = z;
            this.coordinatorWaiting = i2;
            this.coordinatorWakeUpAt = nanoTime += l;
            this.backend.coordinatorWait(this, l);
            this.coordinatorWaiting = z;
            runnable = 0;
            next = (TaskQueue)iterator.next().getFutureTasks$okhttp().get(z);
            i6 = 0;
            l2 = Math.max(i6, obj13);
            if (Long.compare(l2, i6) > 0) {
            } else {
            }
            if (i != 0) {
            } else {
            }
            i = next;
            coordinatorWaiting = i2;
            l = Math.min(l2, obj11);
            cancelAll();
        }
        return runnable;
    }

    public final void cancelAll() {
        int i;
        int i2;
        Object readyQueues;
        size--;
        while (i >= 0) {
            (TaskQueue)this.busyQueues.get(i).cancelAllAndDecide$okhttp();
            i--;
        }
        size2--;
        while (i2 >= 0) {
            Object obj = this.readyQueues.get(i2);
            (TaskQueue)obj.cancelAllAndDecide$okhttp();
            if (obj.getFutureTasks$okhttp().isEmpty()) {
            }
            i2--;
            this.readyQueues.remove(i2);
        }
    }

    public final okhttp3.internal.concurrent.TaskRunner.Backend getBackend() {
        return this.backend;
    }

    public final void kickCoordinator$okhttp(okhttp3.internal.concurrent.TaskQueue taskQueue) {
        boolean assertionsEnabled;
        Object activeTask$okhttp;
        okhttp3.internal.concurrent.TaskRunner.Backend obj4;
        n.f(taskQueue, "taskQueue");
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(this);
            obj4 = new AssertionError(stringBuilder.toString());
            throw obj4;
        }
        if (taskQueue.getActiveTask$okhttp() == null) {
            if (empty ^= 1 != 0) {
                Util.addIfAbsent(this.readyQueues, taskQueue);
            } else {
                this.readyQueues.remove(taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.coordinatorNotify(this);
        } else {
            this.backend.execute(this.runnable);
        }
    }

    public final okhttp3.internal.concurrent.TaskQueue newQueue() {
        int nextQueueName = this.nextQueueName;
        this.nextQueueName = nextQueueName + 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('Q');
        stringBuilder.append(nextQueueName);
        TaskQueue taskQueue = new TaskQueue(this, stringBuilder.toString());
        return taskQueue;
        synchronized (this) {
            nextQueueName = this.nextQueueName;
            this.nextQueueName = nextQueueName + 1;
            stringBuilder = new StringBuilder();
            stringBuilder.append('Q');
            stringBuilder.append(nextQueueName);
            taskQueue = new TaskQueue(this, stringBuilder.toString());
            return taskQueue;
        }
    }
}
