package i.b.m0.g;

import i.b.p0.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ScheduledRunnable.java */
/* loaded from: classes3.dex */
public final class k extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, i.b.j0.b {

    static final Object a = null;
    static final Object b = null;
    static final Object c = null;
    private static final long serialVersionUID = -6120223772001106981L;
    static final Object v = new Object();
    final Runnable actual;
    static {
        k.a = new Object();
        k.b = new Object();
        k.c = new Object();
    }

    public k(Runnable runnable, i.b.m0.a.b bVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, bVar);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public void a(Future<?> future) {
        int i = 1;
        final Object obj = get(i);
        while (obj == k.v) {
            if (compareAndSet(i, obj, future)) {
                return;
            }
            i = 1;
            obj = get(i);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public Object call() {
        run();
        return null;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public void dispose() {
        Object obj3;
        boolean z;
        Thread currentThread;
        int i = 1;
        Object obj = get(i);
        final int i2 = 0;
        while (obj != k.v) {
            obj3 = k.c;
            int r5 = get(2) != Thread.currentThread() ? i : i2;
            if (compareAndSet(i, obj, obj3) && obj != null) {
                break;
            }
        }
        Object obj4 = get(i2);
        while (obj4 != k.v) {
            obj2 = k.a;
            if (compareAndSet(i2, obj4, obj2)) {
                obj4.c(this);
            }
            obj4 = get(i2);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean isDisposed() {
        boolean z = false;
        Object obj;
        final Object obj2 = get(0);
        int r0 = 1;
        return true;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public void run() {
        int i2;
        Throwable th;
        int i3 = 2;
        lazySet(i3, Thread.currentThread());
        final int i5 = 1;
        final int i7 = 0;
        try {
            this.actual.run();
        } catch (Throwable th) {
            lazySet(i2, compareAndSet);
            Object compareAndSet = get(i6);
            i2 = k.a;
        }
        lazySet(i3, null);
        Object obj = get(i7);
        if (obj != k.a && this.compareAndSet(i7, obj, k.v) && obj != null) {
            obj.c(this);
        }
        Object obj2 = get(i5);
        while (obj2 != k.b) {
            if (obj2 == k.c) {
                return;
            }
        }
    }
}
