package i.b.m0.e.e;

import i.b.j0.b;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class q<T>  extends i.b.m0.e.e.a<T, T> implements y<T> {

    static final i.b.m0.e.e.q.a[] C;
    static final i.b.m0.e.e.q.a[] D;
    Throwable A;
    volatile boolean B;
    final AtomicBoolean b;
    final int c;
    final AtomicReference<i.b.m0.e.e.q.a<T>[]> v;
    volatile long w;
    final i.b.m0.e.e.q.b<T> x;
    i.b.m0.e.e.q.b<T> y;
    int z;

    static final class b {

        final T[] a;
        volatile i.b.m0.e.e.q.b<T> b;
        b(int i) {
            super();
            this.a = new Object[i];
        }
    }

    static final class a extends AtomicInteger implements b {

        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final y<? super T> downstream;
        long index;
        i.b.m0.e.e.q.b<T> node;
        int offset;
        final i.b.m0.e.e.q<T> parent;
        a(y<? super T> y, i.b.m0.e.e.q<T> q2) {
            super();
            this.downstream = y;
            this.parent = q2;
            this.node = q2.x;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean disposed;
            if (!this.disposed) {
                this.disposed = true;
                this.parent.d(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.disposed;
        }
    }
    static {
        int i = 0;
        q.C = new q.a[i];
        q.D = new q.a[i];
    }

    public q(r<T> r, int i2) {
        super(r);
        this.c = i2;
        AtomicBoolean obj1 = new AtomicBoolean();
        this.b = obj1;
        obj1 = new q.b(i2);
        this.x = obj1;
        this.y = obj1;
        obj1 = new AtomicReference(q.C);
        this.v = obj1;
    }

    void c(i.b.m0.e.e.q.a<T> q$a) {
        Object obj = this.v.get();
        while ((q.a[])obj == q.D) {
            int length = obj.length;
            i.b.m0.e.e.q.a[] arr = new q.a[length + 1];
            final int i2 = 0;
            System.arraycopy((q.a[])obj, i2, arr, i2, length);
            arr[length] = a;
            obj = this.v.get();
        }
    }

    void d(i.b.m0.e.e.q.a<T> q$a) {
        i.b.m0.e.e.q.a[] objArr;
        int i3;
        int i;
        int i2;
        Object arr;
        Object obj = this.v.get();
        int length = obj.length;
        while (length == 0) {
            i3 = -1;
            i = 0;
            i2 = i;
            while (i2 < length) {
                if ((q.a[])obj[i2] == a) {
                    break loop_3;
                } else {
                }
                i2++;
            }
            int i6 = 1;
            if (length == i6) {
            } else {
            }
            arr = new q.a[length + -1];
            System.arraycopy(obj, i, arr, i, i3);
            System.arraycopy(obj, i3 + 1, arr, i3, i4 -= i6);
            objArr = arr;
            obj = this.v.get();
            length = obj.length;
            objArr = q.C;
            if ((q.a[])obj[i2] == a) {
            } else {
            }
            i2++;
            i3 = i2;
        }
    }

    void e(i.b.m0.e.e.q.a<T> q$a) {
        long index;
        int offset;
        i.b.m0.e.e.q.b node;
        int andGet;
        int i3;
        int i4;
        int i;
        int i2;
        if (a.getAndIncrement() != 0) {
        }
        index = a.index;
        offset = a.offset;
        node = a.node;
        final y downstream = a.downstream;
        final int i6 = 1;
        andGet = i6;
        i4 = 0;
        while (a.disposed) {
            i2 = 0;
            if (Long.compare(l, index) == 0) {
            } else {
            }
            i = i2;
            a.index = index;
            a.offset = offset;
            a.node = node;
            i4 = 0;
            if (offset == this.c) {
            }
            downstream.onNext(node.a[offset]);
            offset += i6;
            index += i3;
            node = bVar;
            offset = i2;
            i = i6;
        }
        a.node = i4;
    }

    @Override // i.b.m0.e.e.a
    public void onComplete() {
        int i;
        Object obj;
        this.B = true;
        Object andSet = this.v.getAndSet(q.D);
        i = 0;
        while (i < andSet.length) {
            e((q.a[])andSet[i]);
            i++;
        }
    }

    @Override // i.b.m0.e.e.a
    public void onError(Throwable throwable) {
        int i;
        Object obj;
        this.A = throwable;
        this.B = true;
        Object obj4 = this.v.getAndSet(q.D);
        i = 0;
        while (i < obj4.length) {
            e((q.a[])obj4[i]);
            i++;
        }
    }

    public void onNext(T t) {
        Object[] objArr;
        i.b.m0.e.e.q.b bVar;
        int i;
        Object obj6;
        int i2 = this.z;
        int i5 = 1;
        if (i2 == this.c) {
            bVar = new q.b(i2);
            bVar.a[0] = t;
            this.z = i5;
            obj6.b = bVar;
            this.y = bVar;
        } else {
            bVar2.a[i2] = t;
            this.z = i2 += i5;
        }
        this.w = l += i6;
        obj6 = this.v.get();
        while (i < obj6.length) {
            e((q.a[])obj6[i]);
            i++;
        }
    }

    @Override // i.b.m0.e.e.a
    public void onSubscribe(b b) {
    }

    protected void subscribeActual(y<? super T> y) {
        int i;
        int i2;
        boolean obj4;
        q.a aVar = new q.a(y, this);
        y.onSubscribe(aVar);
        c(aVar);
        if (!this.b.get() && this.b.compareAndSet(false, true)) {
            if (this.b.compareAndSet(false, true)) {
                this.a.subscribe(this);
            } else {
                e(aVar);
            }
        } else {
        }
    }
}
