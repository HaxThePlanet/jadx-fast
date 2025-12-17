package i.b.m0.g;

import i.b.j0.b;
import i.b.m0.b.a;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
abstract class a extends AtomicReference<Future<?>> implements b {

    protected static final FutureTask<Void> a = null;
    protected static final FutureTask<Void> b = null;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;
    static {
        final Runnable runnable = a.b;
        final int i = 0;
        FutureTask futureTask = new FutureTask(runnable, i);
        a.a = futureTask;
        FutureTask futureTask2 = new FutureTask(runnable, i);
        a.b = futureTask2;
    }

    a(Runnable runnable) {
        super();
        this.runnable = runnable;
    }

    public final void a(Future<?> future) {
        int compareAndSet;
        Object currentThread;
        compareAndSet = get();
        while ((Future)compareAndSet == a.a) {
            if (!compareAndSet((Future)compareAndSet, future)) {
                break;
            }
            compareAndSet = get();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final void dispose() {
        int compareAndSet;
        Thread currentThread;
        final Object obj = get();
        compareAndSet = a.b;
        if (obj != a.a && obj != compareAndSet && compareAndSet((Future)obj, compareAndSet) && obj != null) {
            compareAndSet = a.b;
            if (obj != compareAndSet) {
                if (compareAndSet(obj, compareAndSet)) {
                    if (obj != null) {
                        compareAndSet = this.runner != Thread.currentThread() ? 1 : 0;
                        obj.cancel(compareAndSet);
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final boolean isDisposed() {
        int i;
        FutureTask future;
        Object obj = get();
        if ((Future)obj != a.a) {
            if ((Future)obj == a.b) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
