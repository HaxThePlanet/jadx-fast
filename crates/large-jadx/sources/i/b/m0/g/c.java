package i.b.m0.g;

import i.b.j0.b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InstantPeriodicTask.java */
/* loaded from: classes3.dex */
final class c implements Callable<Void>, b {

    static final FutureTask<Void> x = new FutureTask<>();
    final Runnable a;
    final AtomicReference<Future<?>> b = new AtomicReference<>();
    final AtomicReference<Future<?>> c = new AtomicReference<>();
    final ExecutorService v;
    Thread w;
    static {
    }

    c(Runnable runnable, ExecutorService executorService) {
        super();
        this.a = runnable;
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        this.v = executorService;
    }

    public Void a() {
        this.w = Thread.currentThread();
        Thread thread2 = null;
        try {
            this.a.run();
            c(this.v.submit(this));
            this.w = thread2;
        } catch (Throwable th) {
            this.w = thread;
            a.t(th);
        }
        return thread2;
    }

    void b(Future<?> future) {
        boolean z = false;
        Object obj = this.c.get();
        while (obj == c.x) {
            if (this.c.compareAndSet(obj, future)) {
                return;
            }
            obj = this.c.get();
        }
        int r0 = this.w != Thread.currentThread() ? 1 : 0;
        future.cancel((this.w != Thread.currentThread() ? 1 : 0));
    }

    void c(Future<?> future) {
        boolean z = false;
        Object obj = this.b.get();
        while (obj == c.x) {
            if (this.b.compareAndSet(obj, future)) {
                return;
            }
            obj = this.b.get();
        }
        int r0 = this.w != Thread.currentThread() ? 1 : 0;
        future.cancel((this.w != Thread.currentThread() ? 1 : 0));
    }

    public void dispose() {
        boolean z2 = true;
        boolean z;
        futureTask = c.x;
        Object andSet = this.c.getAndSet(futureTask);
        int i = 1;
        final int i2 = 0;
        if (andSet != null && andSet != c.x) {
            int r4 = this.w != Thread.currentThread() ? 1 : i2;
            andSet.cancel((this.w != Thread.currentThread() ? 1 : i2));
        }
        Object andSet2 = this.b.getAndSet(c.x);
        if (andSet2 != null && andSet2 != c.x) {
            if (this.w == Thread.currentThread()) {
            }
            andSet2.cancel(z2);
        }
    }

    public boolean isDisposed() {
        boolean z = true;
        int r0 = this.c.get() == c.x ? 1 : 0;
        return (this.c.get() == c.x ? 1 : 0);
    }
}
