package i.b.m0.g;

import i.b.j0.b;
import i.b.m0.b.a;
import i.b.p0.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
final class c implements Callable<Void>, b {

    static final FutureTask<Void> x;
    final Runnable a;
    final AtomicReference<Future<?>> b;
    final AtomicReference<Future<?>> c;
    final ExecutorService v;
    Thread w;
    static {
        FutureTask futureTask = new FutureTask(a.b, 0);
        c.x = futureTask;
    }

    c(Runnable runnable, ExecutorService executorService2) {
        super();
        this.a = runnable;
        AtomicReference obj1 = new AtomicReference();
        this.c = obj1;
        obj1 = new AtomicReference();
        this.b = obj1;
        this.v = executorService2;
    }

    @Override // java.util.concurrent.Callable
    public Void a() {
        Future submit;
        this.w = Thread.currentThread();
        int i = 0;
        this.a.run();
        c(this.v.submit(this));
        this.w = i;
        return i;
    }

    void b(Future<?> future) {
        int i;
        Object obj = this.c.get();
        while ((Future)obj == c.x) {
            obj = this.c.get();
        }
        i = this.w != Thread.currentThread() ? 1 : 0;
        future.cancel(i);
    }

    void c(Future<?> future) {
        int i;
        Object obj = this.b.get();
        while ((Future)obj == c.x) {
            obj = this.b.get();
        }
        i = this.w != Thread.currentThread() ? 1 : 0;
        future.cancel(i);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return a();
    }

    @Override // java.util.concurrent.Callable
    public void dispose() {
        Object future;
        int i;
        int currentThread;
        Thread currentThread2;
        future = c.x;
        Object andSet = this.c.getAndSet(future);
        final int i2 = 0;
        if ((Future)andSet != null && (Future)andSet != future) {
            if ((Future)andSet != future) {
                currentThread = this.w != Thread.currentThread() ? i : i2;
                (Future)andSet.cancel(currentThread);
            }
        }
        Object andSet2 = this.b.getAndSet(future);
        if ((Future)andSet2 != null && (Future)andSet2 != future) {
            if ((Future)andSet2 != future) {
                if (this.w != Thread.currentThread()) {
                } else {
                    i = i2;
                }
                (Future)andSet2.cancel(i);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public boolean isDisposed() {
        int i;
        i = this.c.get() == c.x ? 1 : 0;
        return i;
    }
}
