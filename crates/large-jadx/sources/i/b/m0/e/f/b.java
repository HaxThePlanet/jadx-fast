package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleCache.java */
/* loaded from: classes3.dex */
public final class b<T> extends a0<T> implements d0<T> {

    static final b.a[] x;
    static final b.a[] y;
    final g0<? extends T> a;
    final AtomicInteger b = new AtomicInteger();
    final AtomicReference<b.a<T>[]> c = new AtomicReference<>();
    T v;
    Throwable w;

    static final class a<T> extends AtomicBoolean implements b {

        private static final long serialVersionUID = 7514387411091976596L;
        final d0<? super T> downstream;
        final b<T> parent;
        a(d0<? super T> d0Var, b<T> bVar) {
            super();
            this.downstream = d0Var;
            this.parent = bVar;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.e(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return get();
        }
    }
    static {
        int i = 0;
        b.x = new b.a[i];
        b.y = new b.a[i];
    }

    public b(g0<? extends T> g0Var) {
        super();
        this.a = g0Var;
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicReference atomicReference = new AtomicReference(b.x);
    }

    @Override // i.b.a0
    boolean d(b.a<T> aVar) {
        Object obj = this.c.get();
        final int i = 0;
        while (obj == b.y) {
            int length = obj.length;
            i.b.m0.e.f.b.a[] arr = new b.a[length + 1];
            System.arraycopy(obj, i, arr, i, length);
            arr[length] = aVar;
            if (this.c.compareAndSet(obj, arr)) {
                return true;
            }
            obj = this.c.get();
            i = 0;
        }
        return false;
    }

    @Override // i.b.a0
    void e(b.a<T> aVar) {
        i.b.m0.e.f.b.a[] arr;
        int i = -1;
        Object obj;
        Object obj2 = this.c.get();
        int length = obj2.length;
        while (length == 0) {
            i = -1;
            i = 0;
            for (Object obj : obj2) {
                if (obj == aVar) {
                    break loop_3;
                }
            }
            int i4 = 1;
            if (this.c.compareAndSet(obj2, arr)) {
                return;
            }
        }
    }

    @Override // i.b.a0
    public void onError(Throwable th) {
        int i = 0;
        Object obj;
        this.w = th;
        Object andSet = this.c.getAndSet(b.y);
        i = 0;
        for (Object obj : andSet) {
        }
    }

    @Override // i.b.a0
    public void onSuccess(T t) {
        int i = 0;
        Object obj;
        this.v = t;
        Object andSet = this.c.getAndSet(b.y);
        i = 0;
        for (Object obj : andSet) {
        }
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        i.b.m0.e.f.b.a aVar = new b.a(d0Var, this);
        d0Var.onSubscribe(aVar);
        if (d(aVar) && aVar.isDisposed()) {
            e(aVar);
            if (this.b.getAndIncrement() == 0) {
                this.a.subscribe(this);
            }
            return;
        }
        if (this.w != null) {
            d0Var.onError(this.w);
        } else {
            d0Var.onSuccess(this.v);
        }
    }

    @Override // i.b.a0
    public void onSubscribe(b bVar) {
    }
}
