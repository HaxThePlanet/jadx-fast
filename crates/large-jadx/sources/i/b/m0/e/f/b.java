package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class b<T>  extends a0<T> implements d0<T> {

    static final i.b.m0.e.f.b.a[] x;
    static final i.b.m0.e.f.b.a[] y;
    final g0<? extends T> a;
    final AtomicInteger b;
    final AtomicReference<i.b.m0.e.f.b.a<T>[]> c;
    T v;
    Throwable w;

    static final class a extends AtomicBoolean implements b {

        private static final long serialVersionUID = 7514387411091976596L;
        final d0<? super T> downstream;
        final i.b.m0.e.f.b<T> parent;
        a(d0<? super T> d0, i.b.m0.e.f.b<T> b2) {
            super();
            this.downstream = d0;
            this.parent = b2;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            boolean compareAndSet;
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

    public b(g0<? extends T> g0) {
        super();
        this.a = g0;
        AtomicInteger obj2 = new AtomicInteger();
        this.b = obj2;
        obj2 = new AtomicReference(b.x);
        this.c = obj2;
    }

    boolean d(i.b.m0.e.f.b.a<T> b$a) {
        Object obj = this.c.get();
        final int i = 0;
        while ((b.a[])obj == b.y) {
            int length = obj.length;
            i.b.m0.e.f.b.a[] arr = new b.a[length + 1];
            System.arraycopy((b.a[])obj, i, arr, i, length);
            arr[length] = a;
            obj = this.c.get();
            i = 0;
        }
        return i;
    }

    void e(i.b.m0.e.f.b.a<T> b$a) {
        i.b.m0.e.f.b.a[] objArr;
        int i2;
        int i;
        int i3;
        Object arr;
        Object obj = this.c.get();
        int length = obj.length;
        while (length == 0) {
            i2 = -1;
            i = 0;
            i3 = i;
            while (i3 < length) {
                if ((b.a[])obj[i3] == a) {
                    break loop_3;
                } else {
                }
                i3++;
            }
            int i6 = 1;
            if (length == i6) {
            } else {
            }
            arr = new b.a[length + -1];
            System.arraycopy(obj, i, arr, i, i2);
            System.arraycopy(obj, i2 + 1, arr, i2, i4 -= i6);
            objArr = arr;
            obj = this.c.get();
            length = obj.length;
            objArr = b.x;
            if ((b.a[])obj[i3] == a) {
            } else {
            }
            i3++;
            i2 = i3;
        }
    }

    @Override // i.b.a0
    public void onError(Throwable throwable) {
        int i;
        Object downstream;
        boolean disposed;
        this.w = throwable;
        Object andSet = this.c.getAndSet(b.y);
        i = 0;
        while (i < andSet.length) {
            downstream = (b.a[])andSet[i];
            if (!downstream.isDisposed()) {
            }
            i++;
            downstream.downstream.onError(throwable);
        }
    }

    @Override // i.b.a0
    public void onSubscribe(b b) {
    }

    public void onSuccess(T t) {
        int i;
        Object downstream;
        boolean disposed;
        this.v = t;
        Object andSet = this.c.getAndSet(b.y);
        i = 0;
        while (i < andSet.length) {
            downstream = (b.a[])andSet[i];
            if (!downstream.isDisposed()) {
            }
            i++;
            downstream.downstream.onSuccess(t);
        }
    }

    protected void subscribeActual(d0<? super T> d0) {
        Object th;
        int obj3;
        b.a aVar = new b.a(d0, this);
        d0.onSubscribe(aVar);
        if (d(aVar) && aVar.isDisposed()) {
            if (aVar.isDisposed()) {
                e(aVar);
            }
            if (this.b.getAndIncrement() == 0) {
                this.a.subscribe(this);
            }
        }
        th = this.w;
        if (th != null) {
            d0.onError(th);
        } else {
            d0.onSuccess(this.v);
        }
    }
}
