package i.b.t0;

import i.b.j0.b;
import i.b.m0.b.b;
import i.b.m0.j.a;
import i.b.m0.j.a.a;
import i.b.m0.j.k;
import i.b.m0.j.n;
import i.b.p0.a;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes3.dex */
public final class a<T>  extends i.b.t0.d<T> {

    static final i.b.t0.a.a[] A;
    static final i.b.t0.a.a[] B;
    private static final Object[] z;
    final AtomicReference<Object> a;
    final AtomicReference<i.b.t0.a.a<T>[]> b;
    final ReadWriteLock c;
    final Lock v;
    final Lock w;
    final AtomicReference<Throwable> x;
    long y;

    static final class a implements b, a.a<Object> {

        final y<? super T> a;
        final i.b.t0.a<T> b;
        boolean c;
        boolean v;
        a<Object> w;
        boolean x;
        volatile boolean y;
        long z;
        a(y<? super T> y, i.b.t0.a<T> a2) {
            super();
            this.a = y;
            this.b = a2;
        }

        @Override // i.b.j0.b
        void a() {
            Object test;
            int i;
            if (this.y) {
            }
            synchronized (this) {
            }
            if (test(test)) {
            }
            b();
        }

        @Override // i.b.j0.b
        void b() {
            while (this.y) {
                a aVar = this.w;
                this.w = 0;
                aVar.d(this);
            }
        }

        @Override // i.b.j0.b
        void c(Object object, long l2) {
            boolean z;
            a obj4;
            int obj5;
            if (this.y) {
            }
            if (!this.x && this.y) {
                synchronized (this) {
                }
            }
            test(object);
        }

        @Override // i.b.j0.b
        public void dispose() {
            boolean z;
            if (!this.y) {
                this.y = true;
                this.b.f(this);
            }
        }

        @Override // i.b.j0.b
        public boolean isDisposed() {
            return this.y;
        }

        @Override // i.b.j0.b
        public boolean test(Object object) {
            y z;
            int obj2;
            if (!this.y) {
                if (n.accept(object, this.a)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }
    }
    static {
        int i = 0;
        a.z = new Object[i];
        a.A = new a.a[i];
        a.B = new a.a[i];
    }

    a() {
        super();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.v = reentrantReadWriteLock.readLock();
        this.w = reentrantReadWriteLock.writeLock();
        AtomicReference atomicReference = new AtomicReference(a.A);
        this.b = atomicReference;
        AtomicReference atomicReference2 = new AtomicReference();
        this.a = atomicReference2;
        AtomicReference atomicReference3 = new AtomicReference();
        this.x = atomicReference3;
    }

    public static <T> i.b.t0.a<T> e() {
        a aVar = new a();
        return aVar;
    }

    boolean d(i.b.t0.a.a<T> a$a) {
        Object obj = this.b.get();
        final int i = 0;
        while ((a.a[])obj == a.B) {
            int length = obj.length;
            i.b.t0.a.a[] arr = new a.a[length + 1];
            System.arraycopy((a.a[])obj, i, arr, i, length);
            arr[length] = a;
            obj = this.b.get();
            i = 0;
        }
        return i;
    }

    void f(i.b.t0.a.a<T> a$a) {
        i.b.t0.a.a[] objArr;
        int i3;
        int i;
        int i2;
        Object arr;
        Object obj = this.b.get();
        int length = obj.length;
        while (length == 0) {
            i3 = -1;
            i = 0;
            i2 = i;
            while (i2 < length) {
                if ((a.a[])obj[i2] == a) {
                    break loop_3;
                } else {
                }
                i2++;
            }
            int i6 = 1;
            if (length == i6) {
            } else {
            }
            arr = new a.a[length + -1];
            System.arraycopy(obj, i, arr, i, i3);
            System.arraycopy(obj, i3 + 1, arr, i3, i4 -= i6);
            objArr = arr;
            obj = this.b.get();
            length = obj.length;
            objArr = a.A;
            if ((a.a[])obj[i2] == a) {
            } else {
            }
            i2++;
            i3 = i2;
        }
    }

    @Override // i.b.t0.d
    void g(Object object) {
        this.w.lock();
        this.y = l += i2;
        this.a.lazySet(object);
        this.w.unlock();
    }

    i.b.t0.a.a<T>[] h(Object object) {
        final i.b.t0.a.a[] objArr = a.B;
        Object andSet = this.b.getAndSet(objArr);
        if ((a.a[])andSet != objArr) {
            g(object);
        }
        return (a.a[])andSet;
    }

    @Override // i.b.t0.d
    public void onComplete() {
        int i;
        i.b.t0.a.a aVar;
        long l;
        if (!this.x.compareAndSet(0, k.a)) {
        }
        Object complete = n.complete();
        i.b.t0.a.a[] objArr = h(complete);
        i = 0;
        while (i < objArr.length) {
            objArr[i].c(complete, this.y);
            i++;
        }
    }

    @Override // i.b.t0.d
    public void onError(Throwable throwable) {
        int i;
        i.b.t0.a.a aVar;
        long l;
        b.e(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.x.compareAndSet(0, throwable)) {
            a.t(throwable);
        }
        final Object obj7 = n.error(throwable);
        i.b.t0.a.a[] objArr = h(obj7);
        i = 0;
        while (i < objArr.length) {
            objArr[i].c(obj7, this.y);
            i++;
        }
    }

    public void onNext(T t) {
        int i;
        Object obj;
        long l;
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.x.get() != null) {
        }
        final Object obj7 = n.next(t);
        g(obj7);
        Object obj3 = this.b.get();
        i = 0;
        while (i < obj3.length) {
            (a.a[])obj3[i].c(obj7, this.y);
            i++;
        }
    }

    @Override // i.b.t0.d
    public void onSubscribe(b b) {
        if (this.x.get() != null) {
            b.dispose();
        }
    }

    protected void subscribeActual(y<? super T> y) {
        Object aVar;
        boolean z;
        boolean obj3;
        aVar = new a.a(y, this);
        y.onSubscribe(aVar);
        if (d(aVar)) {
            if (aVar.y) {
                f(aVar);
            } else {
                aVar.a();
            }
        } else {
            aVar = this.x.get();
            if ((Throwable)aVar == k.a) {
                y.onComplete();
            } else {
                y.onError((Throwable)aVar);
            }
        }
    }
}
