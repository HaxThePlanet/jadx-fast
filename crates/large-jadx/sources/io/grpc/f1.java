package io.grpc;

import com.google.common.base.n;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class f1 implements Executor {

    private final java.lang.Thread.UncaughtExceptionHandler a;
    private final Queue<Runnable> b;
    private final AtomicReference<Thread> c;

    class a implements Runnable {

        final io.grpc.f1.b a;
        final Runnable b;
        final io.grpc.f1 c;
        a(io.grpc.f1 f1, io.grpc.f1.b f1$b2, Runnable runnable3) {
            this.c = f1;
            this.a = b2;
            this.b = runnable3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.execute(this.a);
        }

        @Override // java.lang.Runnable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.toString());
            stringBuilder.append("(scheduled in SynchronizationContext)");
            return stringBuilder.toString();
        }
    }

    private static class b implements Runnable {

        final Runnable a;
        boolean b;
        boolean c;
        b(Runnable runnable) {
            super();
            n.p(runnable, "task");
            this.a = (Runnable)runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (!this.b) {
                this.c = true;
                this.a.run();
            }
        }
    }

    public static final class c {

        private final io.grpc.f1.b a;
        private final ScheduledFuture<?> b;
        private c(io.grpc.f1.b f1$b, ScheduledFuture<?> scheduledFuture2) {
            super();
            n.p(b, "runnable");
            this.a = (f1.b)b;
            n.p(scheduledFuture2, "future");
            this.b = (ScheduledFuture)scheduledFuture2;
        }

        c(io.grpc.f1.b f1$b, ScheduledFuture scheduledFuture2, io.grpc.f1.a f1$a3) {
            super(b, scheduledFuture2);
        }

        public void a() {
            bVar.b = true;
            this.b.cancel(false);
        }

        public boolean b() {
            io.grpc.f1.b bVar;
            int i;
            bVar = this.a;
            if (!bVar.c && !bVar.b) {
                i = !bVar.b ? 1 : 0;
            } else {
            }
            return i;
        }
    }
    public f1(java.lang.Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler) {
        super();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.b = concurrentLinkedQueue;
        AtomicReference atomicReference = new AtomicReference();
        this.c = atomicReference;
        n.p(uncaughtExceptionHandler, "uncaughtExceptionHandler");
        this.a = (Thread.UncaughtExceptionHandler)uncaughtExceptionHandler;
    }

    @Override // java.util.concurrent.Executor
    public final void a() {
        boolean compareAndSet;
        Thread currentThread2;
        Thread currentThread;
        final int i = 0;
        while (!this.c.compareAndSet(i, Thread.currentThread())) {
            compareAndSet = this.b.poll();
            while ((Runnable)compareAndSet != null) {
                (Runnable)compareAndSet.run();
                compareAndSet = this.b.poll();
            }
            this.c.set(i);
            i = 0;
            (Runnable)compareAndSet.run();
            java.lang.Thread.UncaughtExceptionHandler exc = this.a;
            exc.uncaughtException(Thread.currentThread(), th);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void b(Runnable runnable) {
        n.p(runnable, "runnable is null");
        this.b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public final io.grpc.f1.c c(Runnable runnable, long l2, TimeUnit timeUnit3, ScheduledExecutorService scheduledExecutorService4) {
        f1.b bVar = new f1.b(runnable);
        f1.a aVar = new f1.a(this, bVar, runnable);
        f1.c obj4 = new f1.c(bVar, obj7.schedule(aVar, l2, timeUnit3), 0);
        return obj4;
    }

    @Override // java.util.concurrent.Executor
    public void d() {
        int i;
        i = Thread.currentThread() == this.c.get() ? 1 : 0;
        n.v(i, "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
