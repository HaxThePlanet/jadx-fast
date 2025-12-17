package i.b.m0.g;

import i.b.j0.b;
import i.b.m0.a.b;
import i.b.p0.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class k extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, b {

    static final Object a = null;
    static final Object b = null;
    static final Object c = null;
    private static final long serialVersionUID = -6120223772001106981L;
    static final Object v;
    final Runnable actual;
    static {
        Object object = new Object();
        k.a = object;
        Object object2 = new Object();
        k.b = object2;
        Object object3 = new Object();
        k.c = object3;
        Object object4 = new Object();
        k.v = object4;
    }

    public k(Runnable runnable, b b2) {
        super(3);
        this.actual = runnable;
        lazySet(0, b2);
    }

    public void a(Future<?> future) {
        int i = 1;
        final Object obj = get(i);
        while (obj == k.v) {
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
        int compareAndSet;
        Object compareAndSet2;
        Object obj;
        Object obj2;
        int i;
        Thread currentThread;
        compareAndSet = 1;
        compareAndSet2 = get(compareAndSet);
        final int i2 = 0;
        while (compareAndSet2 != k.v) {
            if (compareAndSet2 != k.b) {
                break;
            }
            obj2 = k.c;
            if (get(2) != Thread.currentThread()) {
            } else {
            }
            i = i2;
            if (i != 0) {
            }
            compareAndSet = 1;
            compareAndSet2 = get(compareAndSet);
            i2 = 0;
            obj = obj2;
            i = compareAndSet;
        }
        compareAndSet = get(i2);
        while (compareAndSet != k.v) {
            compareAndSet2 = k.a;
            if (compareAndSet != compareAndSet2) {
                break;
            }
            compareAndSet = get(i2);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean isDisposed() {
        int i;
        Object obj;
        final Object obj2 = get(0);
        if (obj2 != k.a) {
            if (obj2 == k.v) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public void run() {
        Object compareAndSet2;
        int i;
        Object compareAndSet3;
        Throwable th;
        Runnable actual;
        int i3 = 2;
        lazySet(i3, Thread.currentThread());
        final int i4 = 1;
        final int i5 = 0;
        this.actual.run();
        lazySet(i3, 0);
        compareAndSet2 = get(i5);
        if (compareAndSet2 != k.a && compareAndSet(i5, compareAndSet2, k.v) && compareAndSet2 != null) {
            if (compareAndSet(i5, compareAndSet2, k.v)) {
                if (compareAndSet2 != null) {
                    (b)compareAndSet2.c(this);
                }
            }
        }
        compareAndSet2 = get(i4);
        while (compareAndSet2 != k.b) {
            if (compareAndSet2 != k.c) {
            }
            if (compareAndSet(i4, compareAndSet2, k.v) == null) {
            }
            compareAndSet2 = get(i4);
        }
    }
}
