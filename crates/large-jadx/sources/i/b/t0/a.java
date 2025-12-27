package i.b.t0;

import i.b.m0.j.a.a;
import i.b.m0.j.k;
import i.b.m0.j.n;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorSubject.java */
/* loaded from: classes3.dex */
public final class a<T> extends d<T> {

    static final a.a[] A;
    static final a.a[] B;
    private static final Object[] z;
    final AtomicReference<Object> a = new AtomicReference<>();
    final AtomicReference<a.a<T>[]> b = new AtomicReference<>();
    final ReadWriteLock c = new ReentrantReadWriteLock();
    final Lock v;
    final Lock w;
    final AtomicReference<Throwable> x = new AtomicReference<>();
    long y;

    static final class a<T> implements i.b.j0.b, a.a<Object> {

        final y<? super T> a;
        final a<T> b;
        boolean c;
        boolean v;
        i.b.m0.j.a<Object> w;
        boolean x;
        volatile boolean y;
        long z;
        a(y<? super T> yVar, a<T> aVar) {
            super();
            this.a = yVar;
            this.b = aVar;
        }

        void a() {
            int i = 0;
            if (this.y) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.y) {
                        return;
                    }
                    if (this.c) {
                        return;
                    }
                    i = z4;
                    i = 0;
                    this.v = i;
                    this.c = z4;
                } catch (Throwable th) {
                }
            }
            if (this.y != null && this.test(this.c)) {
                return;
            }
        }

        void b() {
            while (this.y) {
                try {
                    this.v = false;
                    return;
                } catch (Throwable th) {
                }
                this.w.d(this);
            }
        }

        void c(Object object, long j) {
            i.b.m0.j.a aVar;
            if (this.y) {
                return;
            }
            if (!this.x) {
                synchronized (this) {
                    try {
                        if (this.y) {
                            return;
                        }
                        if (this.z == j) {
                            return;
                        }
                        if (this.v && this.w == null) {
                            int i = 4;
                            this.w = new a(i);
                            aVar.c(object);
                            return;
                        }
                    } catch (Throwable th) {
                    }
                }
                this.x = z2;
            }
            test(th);
        }

        public void dispose() {
            if (!this.y) {
                this.y = true;
                this.b.f(this);
            }
        }

        public boolean isDisposed() {
            return this.y;
        }

        public boolean test(Object object) {
            boolean z;
            boolean z2 = false;
            if (!this.y) {
                if (n.accept(object, this.a)) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
            return z2;
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
        this.v = reentrantReadWriteLock.readLock();
        this.w = reentrantReadWriteLock.writeLock();
        AtomicReference atomicReference = new AtomicReference(a.A);
        AtomicReference atomicReference2 = new AtomicReference();
        AtomicReference atomicReference3 = new AtomicReference();
    }

    public static <T> a<T> e() {
        return new a();
    }

    @Override // i.b.t0.d
    boolean d(a.a<T> aVar) {
        Object obj = this.b.get();
        final int i = 0;
        while (obj == a.B) {
            int length = obj.length;
            i.b.t0.a.a[] arr = new a.a[length + 1];
            System.arraycopy(obj, i, arr, i, length);
            arr[length] = aVar;
            if (this.b.compareAndSet(obj, arr)) {
                return true;
            }
            obj = this.b.get();
            i = 0;
        }
        return false;
    }

    @Override // i.b.t0.d
    void f(a.a<T> aVar) {
        i.b.t0.a.a[] arr;
        int i = -1;
        Object obj;
        Object obj2 = this.b.get();
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
            if (this.b.compareAndSet(obj2, arr)) {
                return;
            }
        }
    }

    @Override // i.b.t0.d
    void g(Object object) {
        this.w.lock();
        this.y++;
        this.a.lazySet(object);
        this.w.unlock();
    }

    @Override // i.b.t0.d
    a.a<T>[] h(Object object) {
        final i.b.t0.a.a[] objArr = a.B;
        Object andSet = this.b.getAndSet(objArr);
        if (andSet != a.B) {
            g(object);
        }
        return andSet;
    }

    @Override // i.b.t0.d
    public void onComplete() {
        int i = 0;
        if (!this.x.compareAndSet(null, k.a)) {
            return;
        }
        Object complete = n.complete();
        i.b.t0.a.a[] objArr = h(complete);
        i = 0;
        for (i.b.t0.a.a aVar : objArr) {
            aVar.c(complete, this.y);
        }
    }

    @Override // i.b.t0.d
    public void onError(Throwable th) {
        int i = 0;
        b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.x.compareAndSet(null, th)) {
            a.t(th);
            return;
        }
        final Object error = n.error(th);
        i.b.t0.a.a[] objArr = h(error);
        i = 0;
        for (i.b.t0.a.a aVar : objArr) {
            aVar.c(error, this.y);
        }
    }

    @Override // i.b.t0.d
    public void onNext(T t) {
        int i = 0;
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.x.get() != null) {
            return;
        }
        final Object next = n.next(t);
        g(next);
        Object obj3 = this.b.get();
        i = 0;
        for (Object obj : obj3) {
            obj.c(next, this.y);
        }
    }

    @Override // i.b.t0.d
    public void onSubscribe(i.b.j0.b bVar) {
        if (this.x.get() != null) {
            bVar.dispose();
        }
    }

    @Override // i.b.t0.d
    protected void subscribeActual(y<? super T> yVar) {
        i.b.t0.a.a aVar = new a.a(yVar, this);
        yVar.onSubscribe(aVar);
        if (d(aVar)) {
            if (aVar.y) {
                f(aVar);
            } else {
                aVar.a();
            }
        } else {
            Object obj = this.x.get();
            if (obj == k.a) {
                yVar.onComplete();
            } else {
                yVar.onError(obj);
            }
        }
    }
}
