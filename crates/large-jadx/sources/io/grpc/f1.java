package io.grpc;

import com.google.common.base.n;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SynchronizationContext.java */
/* loaded from: classes2.dex */
public final class f1 implements Executor {

    private final java.lang.Thread.UncaughtExceptionHandler a;
    private final Queue<Runnable> b = new ConcurrentLinkedQueue<>();
    private final AtomicReference<Thread> c = new AtomicReference<>();

    class a implements Runnable {

        final /* synthetic */ f1.b a;
        final /* synthetic */ Runnable b;
        final /* synthetic */ f1 c;
        a(f1.b bVar, Runnable runnable) {
            this.c = f1Var;
            this.a = bVar;
            this.b = runnable;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.execute(this.a);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String object = this.b.toString();
            String str2 = "(scheduled in SynchronizationContext)";
            str = object + str2;
            return str;
        }
    }

    private static class b implements Runnable {

        final Runnable a;
        boolean b;
        boolean c;
        b(Runnable runnable) {
            super();
            n.p(runnable, "task");
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b) {
                this.c = true;
                this.a.run();
            }
        }
    }

    public static final class c {

        private final f1.b a;
        private final ScheduledFuture<?> b;
        /* synthetic */ c(f1.b bVar, ScheduledFuture scheduledFuture, f1.a aVar) {
            this(bVar, scheduledFuture);
        }

        public void a() {
            this.a.b = true;
            this.b.cancel(false);
        }

        public boolean b() {
            boolean z2 = false;
            int r0 = !bVar.c && !bVar.b ? 1 : 0;
            return (!bVar.c && !bVar.b ? 1 : 0);
        }

        private c(f1.b bVar, ScheduledFuture<?> scheduledFuture) {
            super();
            n.p(bVar, "runnable");
            this.a = bVar;
            n.p(scheduledFuture, "future");
            this.b = scheduledFuture;
        }
    }
    public f1(java.lang.Thread.UncaughtExceptionHandler exc) {
        super();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        AtomicReference atomicReference = new AtomicReference();
        n.p(exc, "uncaughtExceptionHandler");
        this.a = exc;
    }

    public final void a() {
        final Object obj2 = null;
        while (!this.c.compareAndSet(obj2, Thread.currentThread())) {
            while (/* condition */) {
            }
            this.c.set(obj2);
            if (this.b.isEmpty()) {
                return;
            }
            obj2 = null;
            try {
                this.a.uncaughtException(Thread.currentThread(), th);
            } catch (Throwable th) {
            }
        }
    }

    public final void b(Runnable runnable) {
        n.p(runnable, "runnable is null");
        this.b.add(runnable);
    }

    public final f1.c c(Runnable runnable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        final io.grpc.f1.b bVar = new f1.b(runnable);
        return new f1.c(bVar, scheduledExecutorService.schedule(new f1.a(this, bVar, runnable), j, timeUnit), null);
    }

    public void d() {
        boolean z = true;
        int r0 = Thread.currentThread() == this.c.get() ? 1 : 0;
        n.v((Thread.currentThread() == this.c.get() ? 1 : 0), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
