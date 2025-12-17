package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0010!\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001:\u0001?B\u0019\u0008\u0000\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008=\u0010>J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008J5\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u000e\u0008\u0004\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000bH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\rJ?\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\u0008\u0004\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000bH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\u0008\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eH\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\u0008\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\u0008\u001b\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u001f\u0010 R\"\u0010!\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008!\u0010\"\u001a\u0004\u0008#\u0010\u001d\"\u0004\u0008$\u0010%R\u001c\u0010'\u001a\u00020&8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008'\u0010(\u001a\u0004\u0008)\u0010*R\u001c\u0010\n\u001a\u00020\t8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\n\u0010+\u001a\u0004\u0008,\u0010 R\"\u0010\u001b\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u001b\u0010\"\u001a\u0004\u0008-\u0010\u001d\"\u0004\u0008.\u0010%R\u0019\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00020/8F@\u0006¢\u0006\u0006\u001a\u0004\u00080\u00101R$\u00103\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u00083\u00104\u001a\u0004\u00085\u00106\"\u0004\u00087\u00108R\"\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u0002098\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008:\u0010;\u001a\u0004\u0008<\u00101\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006@", d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "Lokhttp3/internal/concurrent/Task;", "task", "", "delayNanos", "Lkotlin/w;", "schedule", "(Lokhttp3/internal/concurrent/Task;J)V", "", "name", "Lkotlin/Function0;", "block", "(Ljava/lang/String;JLkotlin/d0/c/a;)V", "", "cancelable", "execute", "(Ljava/lang/String;JZLkotlin/d0/c/a;)V", "Ljava/util/concurrent/CountDownLatch;", "idleLatch", "()Ljava/util/concurrent/CountDownLatch;", "recurrence", "scheduleAndDecide$okhttp", "(Lokhttp3/internal/concurrent/Task;JZ)Z", "scheduleAndDecide", "cancelAll", "()V", "shutdown", "cancelAllAndDecide$okhttp", "()Z", "cancelAllAndDecide", "toString", "()Ljava/lang/String;", "cancelActiveTask", "Z", "getCancelActiveTask$okhttp", "setCancelActiveTask$okhttp", "(Z)V", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "Ljava/lang/String;", "getName$okhttp", "getShutdown$okhttp", "setShutdown$okhttp", "", "getScheduledTasks", "()Ljava/util/List;", "scheduledTasks", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "", "futureTasks", "Ljava/util/List;", "getFutureTasks$okhttp", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "AwaitIdleTask", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class TaskQueue {

    private okhttp3.internal.concurrent.Task activeTask;
    private boolean cancelActiveTask;
    private final List<okhttp3.internal.concurrent.Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final okhttp3.internal.concurrent.TaskRunner taskRunner;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "", "runOnce", "()J", "Ljava/util/concurrent/CountDownLatch;", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class AwaitIdleTask extends okhttp3.internal.concurrent.Task {

        private final CountDownLatch latch;
        public AwaitIdleTask() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Util.okHttpName);
            stringBuilder.append(" awaitIdle");
            super(stringBuilder.toString(), 0);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.latch = countDownLatch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }
    public TaskQueue(okhttp3.internal.concurrent.TaskRunner taskRunner, String string2) {
        n.f(taskRunner, "taskRunner");
        n.f(string2, "name");
        super();
        this.taskRunner = taskRunner;
        this.name = string2;
        ArrayList obj2 = new ArrayList();
        this.futureTasks = obj2;
    }

    public static void execute$default(okhttp3.internal.concurrent.TaskQueue taskQueue, String string2, long l3, boolean z4, a a5, int i6, Object object7) {
        int obj8;
        int obj10;
        if (object7 & 2 != 0) {
            obj8 = 0;
        }
        if (object7 &= 4 != 0) {
            obj10 = 1;
        }
        final int i2 = obj10;
        n.f(string2, "name");
        n.f(i6, "block");
        super(i6, string2, i2, string2, i2);
        taskQueue.schedule(obj10, obj8);
    }

    public static void schedule$default(okhttp3.internal.concurrent.TaskQueue taskQueue, String string2, long l3, a a4, int i5, Object object6) {
        int obj2;
        if (object6 &= 2 != 0) {
            obj2 = 0;
        }
        n.f(string2, "name");
        n.f(i5, "block");
        TaskQueue.schedule.2 obj5 = new TaskQueue.schedule.2(i5, string2, string2);
        taskQueue.schedule(obj5, obj2);
    }

    public static void schedule$default(okhttp3.internal.concurrent.TaskQueue taskQueue, okhttp3.internal.concurrent.Task task2, long l3, int i4, Object object5) {
        int obj2;
        if (object5 &= 2 != 0) {
            obj2 = 0;
        }
        taskQueue.schedule(task2, obj2);
    }

    public final void cancelAll() {
        boolean assertionsEnabled;
        boolean cancelAllAndDecide$okhttp;
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        okhttp3.internal.concurrent.TaskRunner taskRunner = this.taskRunner;
        synchronized (taskRunner) {
            this.taskRunner.kickCoordinator$okhttp(this);
            w wVar = w.a;
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        okhttp3.internal.concurrent.Task activeTask;
        int i;
        int i2;
        boolean cancelable;
        Level fINE;
        activeTask = this.activeTask;
        final int i3 = 1;
        n.d(activeTask);
        if (activeTask != null && activeTask.getCancelable()) {
            n.d(activeTask);
            if (activeTask.getCancelable()) {
                this.cancelActiveTask = i3;
            }
        }
        i = 0;
        size -= i3;
        while (i2 >= 0) {
            if ((Task)this.futureTasks.get(i2).getCancelable() && TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            }
            i2--;
            if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            }
            this.futureTasks.remove(i2);
            i = i3;
            TaskLoggerKt.access$log((Task)this.futureTasks.get(i2), this, "canceled");
        }
        return i;
    }

    public final void execute(String string, long l2, boolean z3, a<w> a4) {
        n.f(string, "name");
        n.f(obj12, "block");
        super(obj12, string, a4, string, a4);
        schedule(anon, l2);
    }

    public final okhttp3.internal.concurrent.Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<okhttp3.internal.concurrent.Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<okhttp3.internal.concurrent.Task> getScheduledTasks() {
        final okhttp3.internal.concurrent.TaskRunner taskRunner = this.taskRunner;
        return p.L0(this.futureTasks);
        synchronized (taskRunner) {
            taskRunner = this.taskRunner;
            return p.L0(this.futureTasks);
        }
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final okhttp3.internal.concurrent.TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        okhttp3.internal.concurrent.Task activeTask;
        boolean scheduleAndDecide$okhttp;
        boolean next;
        boolean z;
        final okhttp3.internal.concurrent.TaskRunner taskRunner = this.taskRunner;
        int i = 0;
        synchronized (taskRunner) {
            if (this.futureTasks.isEmpty()) {
                CountDownLatch countDownLatch = new CountDownLatch(i);
                return countDownLatch;
            }
            try {
                okhttp3.internal.concurrent.Task activeTask2 = this.activeTask;
                if (activeTask2 instanceof TaskQueue.AwaitIdleTask) {
                }
                return (TaskQueue.AwaitIdleTask)activeTask2.getLatch();
                Iterator iterator = this.futureTasks.iterator();
                for (Task next : iterator) {
                }
                next = iterator.next();
                if (next instanceof TaskQueue.AwaitIdleTask) {
                } else {
                }
                return (TaskQueue.AwaitIdleTask)(Task)next.getLatch();
                TaskQueue.AwaitIdleTask awaitIdleTask = new TaskQueue.AwaitIdleTask();
                if (scheduleAndDecide$okhttp(awaitIdleTask, 0, z)) {
                }
                this.taskRunner.kickCoordinator$okhttp(this);
                return awaitIdleTask.getLatch();
                throw th;
            }
        }
    }

    public final void schedule(String string, long l2, a<Long> a3) {
        n.f(string, "name");
        n.f(obj5, "block");
        TaskQueue.schedule.2 anon = new TaskQueue.schedule.2(obj5, string, string);
        schedule(anon, l2);
    }

    public final void schedule(okhttp3.internal.concurrent.Task task, long l2) {
        boolean obj3;
        boolean obj4;
        n.f(task, "task");
        okhttp3.internal.concurrent.TaskRunner taskRunner = this.taskRunner;
        synchronized (taskRunner) {
            if (task.getCancelable()) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "schedule canceled (queue is shutdown)");
                }
            }
            if (!TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            } else {
                TaskLoggerKt.access$log(task, this, "schedule failed (queue is shutdown)");
            }
            obj3 = new RejectedExecutionException();
            throw obj3;
        }
    }

    public final boolean scheduleAndDecide$okhttp(okhttp3.internal.concurrent.Task task, long l2, boolean z3) {
        int formatDuration;
        int size;
        long next;
        boolean loggable;
        int i;
        List futureTasks;
        Level fINE;
        int obj11;
        String obj13;
        n.f(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        formatDuration = nanoTime + l2;
        int indexOf = this.futureTasks.indexOf(task);
        final int i4 = -1;
        i = 0;
        if (indexOf != i4 && Long.compare(nextExecuteNanoTime$okhttp2, formatDuration) <= 0 && TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (Long.compare(nextExecuteNanoTime$okhttp2, formatDuration) <= 0) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log(task, this, "already scheduled");
                }
                return i;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(formatDuration);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (obj13 != null) {
                obj13 = new StringBuilder();
                obj13.append("run again after ");
                obj13.append(TaskLoggerKt.formatDuration(formatDuration -= nanoTime));
                obj13 = obj13.toString();
            } else {
                obj13 = new StringBuilder();
                obj13.append("scheduled after ");
                obj13.append(TaskLoggerKt.formatDuration(formatDuration -= nanoTime));
                obj13 = obj13.toString();
            }
            TaskLoggerKt.access$log(task, this, obj13);
        }
        obj13 = this.futureTasks.iterator();
        size = i;
        loggable = true;
        while (obj13.hasNext()) {
            if (Long.compare(fINE, l2) > 0) {
            } else {
            }
            next = i;
            size++;
            loggable = true;
            next = loggable;
        }
        size = i4;
        if (size == i4) {
            size = this.futureTasks.size();
        }
        this.futureTasks.add(size, task);
        if (size == 0) {
            i = loggable;
        }
        return i;
    }

    public final void setActiveTask$okhttp(okhttp3.internal.concurrent.Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z) {
        this.cancelActiveTask = z;
    }

    public final void setShutdown$okhttp(boolean z) {
        this.shutdown = z;
    }

    public final void shutdown() {
        boolean assertionsEnabled;
        boolean cancelAllAndDecide$okhttp;
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        okhttp3.internal.concurrent.TaskRunner taskRunner = this.taskRunner;
        this.shutdown = true;
        synchronized (taskRunner) {
            this.taskRunner.kickCoordinator$okhttp(this);
            w wVar = w.a;
        }
    }

    public String toString() {
        return this.name;
    }
}
