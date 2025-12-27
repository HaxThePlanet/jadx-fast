package i.b.m0.g;

import i.b.j0.b;
import i.b.m0.b.a;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AbstractDirectTask.java */
/* loaded from: classes3.dex */
abstract class a extends AtomicReference<Future<?>> implements b {

    protected static final FutureTask<Void> a = null;
    protected static final FutureTask<Void> b = null;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;
    static {
        final Runnable runnable = a.b;
        final Object obj = null;
        a.a = new FutureTask(runnable, obj);
        a.b = new FutureTask(runnable, obj);
    }

    a(Runnable runnable) {
        super();
        this.runnable = runnable;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final void a(Future<?> future) {
        boolean compareAndSet = false;
        Object obj = get();
        while (obj == a.a) {
            if (obj == a.b) {
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final void dispose() {
        boolean z = false;
        final Object obj = get();
        if (obj != a.a && obj != a.b && this.compareAndSet(obj, a.b) && obj != null) {
            int r1 = this.runner != Thread.currentThread() ? 1 : 0;
            obj.cancel((this.runner != Thread.currentThread() ? 1 : 0));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final boolean isDisposed() {
        boolean z = false;
        FutureTask futureTask;
        Object obj = get();
        if (obj == a.a || obj == a.b) {
            int i2 = 1;
        }
        return z;
    }
}
