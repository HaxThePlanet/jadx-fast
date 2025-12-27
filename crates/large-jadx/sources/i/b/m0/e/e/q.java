package i.b.m0.e.e;

import i.b.j0.b;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCache.java */
/* loaded from: classes3.dex */
public final class q<T> extends a<T, T> implements y<T> {

    static final q.a[] C;
    static final q.a[] D;
    Throwable A;
    volatile boolean B;
    final AtomicBoolean b = new AtomicBoolean();
    final int c;
    final AtomicReference<q.a<T>[]> v = new AtomicReference<>();
    volatile long w;
    final q.b<T> x = new q$b<>();
    q.b<T> y = new q$b<>();
    int z;

    static final class b<T> {

        final T[] a;
        volatile q.b<T> b;
        b(int i) {
            super();
            this.a = new Object[i];
        }
    }

    static final class a<T> extends AtomicInteger implements b {

        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final y<? super T> downstream;
        long index;
        q.b<T> node;
        int offset;
        final q<T> parent;
        a(y<? super T> yVar, q<T> qVar) {
            super();
            this.downstream = yVar;
            this.parent = qVar;
            this.node = qVar.x;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
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

    public q(r<T> rVar, int i) {
        super(rVar);
        this.c = i;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        i.b.m0.e.e.q.b bVar = new q.b(i);
        AtomicReference atomicReference = new AtomicReference(q.C);
    }

    @Override // i.b.m0.e.e.a
    void c(q.a<T> aVar) {
        Object obj = this.v.get();
        while (obj == q.D) {
            int length = obj.length;
            i.b.m0.e.e.q.a[] arr = new q.a[length + 1];
            final int i2 = 0;
            System.arraycopy(obj, i2, arr, i2, length);
            arr[length] = aVar;
            if (this.v.compareAndSet(obj, arr)) {
                return;
            }
            obj = this.v.get();
        }
    }

    @Override // i.b.m0.e.e.a
    void d(q.a<T> aVar) {
        i.b.m0.e.e.q.a[] arr;
        int i = -1;
        Object obj;
        Object obj2 = this.v.get();
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
            if (this.v.compareAndSet(obj2, arr)) {
                return;
            }
        }
    }

    @Override // i.b.m0.e.e.a
    void e(q.a<T> aVar) {
        long index2;
        int andGet;
        i.b.m0.e.e.q.b node2;
        if (aVar.getAndIncrement() != 0) {
            return;
        }
        andGet = 1;
        i.b.m0.e.e.q.b bVar = null;
        while (aVar.disposed) {
            andGet = 0;
            int r10 = andGet;
            if (this.w != 0) {
                aVar.index = index2;
                aVar.offset = andGet;
                aVar.node = node2;
            }
        }
        aVar.node = bVar;
    }

    @Override // i.b.m0.e.e.a
    public void onComplete() {
        int i = 0;
        this.B = true;
        Object andSet = this.v.getAndSet(q.D);
        i = 0;
        for (Object obj : andSet) {
            e(obj);
        }
    }

    @Override // i.b.m0.e.e.a
    public void onError(Throwable th) {
        int i = 0;
        this.A = th;
        this.B = true;
        Object andSet = this.v.getAndSet(q.D);
        i = 0;
        for (Object obj : andSet) {
            e(obj);
        }
    }

    @Override // i.b.m0.e.e.a
    public void onNext(T t) {
        i.b.m0.e.e.q.b bVar;
        int i = 0;
        i = 0;
        int i5 = 1;
        if (this.z == this.c) {
            bVar = new q.b(i2);
            bVar.a[0] = t;
            this.z = i5;
            this.y.b = bVar;
            this.y = bVar;
        } else {
            this.y.a[this.z] = t;
            this.z += i5;
        }
        this.w++;
        Object obj2 = this.v.get();
        for (Object obj : obj2) {
            e(obj);
        }
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        boolean z = false;
        boolean z2 = true;
        boolean compareAndSet;
        final i.b.m0.e.e.q.a aVar = new q.a(yVar, this);
        yVar.onSubscribe(aVar);
        c(aVar);
        if (!this.b.get()) {
            z = false;
            z2 = true;
            if (this.b.compareAndSet(z, z2)) {
                this.a.subscribe(this);
            } else {
                e(aVar);
            }
        }
    }

    @Override // i.b.m0.e.e.a
    public void onSubscribe(b bVar) {
    }
}
