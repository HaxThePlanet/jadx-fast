package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.c.f;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.f.b;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class v0<T, U>  extends i.b.m0.e.e.a<T, U> {

    final n<? super T, ? extends w<? extends U>> b;
    final boolean c;
    final int v;
    final int w;

    static final class a extends AtomicReference<b> implements y<U> {

        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final i.b.m0.e.e.v0.b<T, U> parent;
        volatile j<U> queue;
        a(i.b.m0.e.e.v0.b<T, U> v0$b, long l2) {
            super();
            this.id = l2;
            this.parent = b;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.done = true;
            this.parent.d();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            boolean delayErrors;
            Object obj2;
            if (parent.errors.a(throwable)) {
                obj2 = this.parent;
                if (!obj2.delayErrors) {
                    obj2.c();
                }
                this.done = true;
                this.parent.d();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(U u) {
            i.b.m0.e.e.v0.b fusionMode;
            Object obj2;
            if (this.fusionMode == 0) {
                this.parent.h(u, this);
            } else {
                this.parent.d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean requestFusion;
            int i;
            requestFusion = (e)b.requestFusion(7);
            int i3 = 1;
            if (c.setOnce(this, b) && b instanceof e && requestFusion == i3) {
                if (b instanceof e) {
                    requestFusion = (e)b.requestFusion(7);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.fusionMode = requestFusion;
                        this.queue = b;
                        this.done = i3;
                        this.parent.d();
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = b;
                    }
                }
            }
        }
    }

    static final class b extends AtomicInteger implements b, y<T> {

        static final i.b.m0.e.e.v0.a<?, ?>[] a = null;
        static final i.b.m0.e.e.v0.a<?, ?>[] b = null;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final y<? super U> downstream;
        final c errors;
        long lastId;
        int lastIndex;
        final n<? super T, ? extends w<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<i.b.m0.e.e.v0.a<?, ?>[]> observers;
        volatile i<U> queue;
        Queue<w<? extends U>> sources;
        long uniqueId;
        b upstream;
        int wip;
        static {
            int i = 0;
            v0.b.a = new v0.a[i];
            v0.b.b = new v0.a[i];
        }

        b(y<? super U> y, n<? super T, ? extends w<? extends U>> n2, boolean z3, int i4, int i5) {
            int obj2;
            super();
            c cVar = new c();
            this.errors = cVar;
            this.downstream = y;
            this.mapper = n2;
            this.delayErrors = z3;
            this.maxConcurrency = i4;
            this.bufferSize = i5;
            if (i4 != Integer.MAX_VALUE) {
                obj2 = new ArrayDeque(i4);
                this.sources = obj2;
            }
            obj2 = new AtomicReference(v0.b.a);
            this.observers = obj2;
        }

        boolean a(i.b.m0.e.e.v0.a<T, U> v0$a) {
            Object obj = this.observers.get();
            final int i = 0;
            while ((v0.a[])obj == v0.b.b) {
                int length = obj.length;
                i.b.m0.e.e.v0.a[] arr = new v0.a[length + 1];
                System.arraycopy((v0.a[])obj, i, arr, i, length);
                arr[length] = a;
                obj = this.observers.get();
                i = 0;
            }
            a.a();
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean b() {
            Object downstream;
            final int i2 = 1;
            if (this.cancelled) {
                return i2;
            }
            c();
            Throwable th = this.errors.b();
            if (!this.delayErrors && (Throwable)this.errors.get() != null && th != k.a) {
                if ((Throwable)this.errors.get() != null) {
                    c();
                    th = this.errors.b();
                    if (th != k.a) {
                        this.downstream.onError(th);
                    }
                    return i2;
                }
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean c() {
            Object andSet;
            int i;
            Object obj;
            this.upstream.dispose();
            i.b.m0.e.e.v0.a[] objArr = v0.b.b;
            andSet = this.observers.getAndSet(objArr);
            if ((v0.a[])this.observers.get() != objArr && (v0.a[])andSet != objArr) {
                andSet = this.observers.getAndSet(objArr);
                if ((v0.a[])(v0.a[])andSet != objArr) {
                    while (i < andSet.length) {
                        (v0.a[])(v0.a[])andSet[i].a();
                        i++;
                    }
                    return 1;
                }
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean cancelled;
            Throwable th;
            this.cancelled = true;
            cancelled = this.errors.b();
            if (!this.cancelled && c() && cancelled != null && cancelled != k.a) {
                this.cancelled = true;
                if (c()) {
                    cancelled = this.errors.b();
                    if (cancelled != null) {
                        if (cancelled != k.a) {
                            a.t(cancelled);
                        }
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e() {
            int andGet;
            boolean maxConcurrency;
            long lastId;
            int i3;
            int queue;
            Object obj;
            int length;
            int lastIndex;
            int i;
            int i2;
            i.b.m0.e.e.v0.a cmp;
            Throwable empty;
            c errors;
            final y downstream = this.downstream;
            int i4 = 1;
            andGet = i4;
            while (b()) {
                i queue2 = this.queue;
                queue = this.queue;
                obj = this.observers.get();
                length = obj.length;
                i = Integer.MAX_VALUE;
                i2 = 0;
                if (this.maxConcurrency != i) {
                } else {
                }
                lastIndex = i2;
                if (this.maxConcurrency != i) {
                }
                while (i2 != 0) {
                    queue = this.sources.poll();
                    if ((w)queue == null) {
                    } else {
                    }
                    g((w)queue);
                    i2 = maxConcurrency;
                    this.wip = wip -= i4;
                }
                queue = this.sources.poll();
                if ((w)queue == null) {
                } else {
                }
                g((w)queue);
                i2 = maxConcurrency;
                this.wip = wip -= i4;
                lastId = this.lastId;
                lastIndex = this.lastIndex;
                if (length > lastIndex) {
                } else {
                }
                if (length <= lastIndex) {
                }
                cmp = i2;
                while (cmp < length) {
                    if (Long.compare(l2, lastId) == 0) {
                        break loop_29;
                    } else {
                    }
                    if (lastIndex++ == length) {
                    }
                    cmp++;
                    lastIndex = i2;
                }
                this.lastIndex = lastIndex;
                this.lastId = obj2.id;
                queue = i3;
                while (i3 < length) {
                    cmp = obj[lastIndex];
                    j queue3 = cmp.queue;
                    errors = cmp.queue;
                    if (lastIndex++ == length) {
                    }
                    i3++;
                    lastIndex = i2;
                    f(cmp);
                    queue++;
                    errors = queue3.poll();
                    while (errors == null) {
                        downstream.onNext(errors);
                        errors = queue3.poll();
                    }
                    downstream.onNext(errors);
                    a.b(empty);
                    obj10.a();
                    this.errors.a(empty);
                    empty = b();
                    f(obj10);
                    lastIndex++;
                    if (lastIndex == obj6) {
                    }
                }
                this.lastIndex = lastIndex;
                this.lastId = maxConcurrency.id;
                i2 = queue;
                cmp = obj[lastIndex];
                queue3 = cmp.queue;
                errors = cmp.queue;
                if (lastIndex++ == length) {
                }
                i3++;
                lastIndex = i2;
                f(cmp);
                queue++;
                errors = queue3.poll();
                while (errors == null) {
                    downstream.onNext(errors);
                    errors = queue3.poll();
                }
                downstream.onNext(errors);
                if (Long.compare(l2, lastId) == 0) {
                } else {
                }
                if (lastIndex++ == length) {
                }
                cmp++;
                lastIndex = i2;
                lastIndex = i2;
                if (Long.compare(l, lastId) != 0 && length <= lastIndex) {
                }
                lastIndex = this.sources.size();
                while (b()) {
                    queue = queue2.poll();
                    downstream.onNext(queue);
                }
                queue = queue2.poll();
                downstream.onNext(queue);
                a.b(empty);
                obj10.a();
                this.errors.a(empty);
                empty = b();
                f(obj10);
                lastIndex++;
                if (lastIndex == obj6) {
                }
            }
        }

        void f(i.b.m0.e.e.v0.a<T, U> v0$a) {
            i.b.m0.e.e.v0.a[] objArr;
            int i3;
            int i2;
            int i;
            Object arr;
            Object obj = this.observers.get();
            int length = obj.length;
            while (length == 0) {
                i3 = -1;
                i2 = 0;
                i = i2;
                while (i < length) {
                    if ((v0.a[])obj[i] == a) {
                        break loop_3;
                    } else {
                    }
                    i++;
                }
                int i6 = 1;
                if (length == i6) {
                } else {
                }
                arr = new v0.a[length + -1];
                System.arraycopy(obj, i2, arr, i2, i3);
                System.arraycopy(obj, i3 + 1, arr, i3, i4 -= i6);
                objArr = arr;
                obj = this.observers.get();
                length = obj.length;
                objArr = v0.b.a;
                if ((v0.a[])obj[i] == a) {
                } else {
                }
                i++;
                i3 = i;
            }
        }

        void g(w<? extends U> w) {
            i.b.m0.e.e.v0.a aVar;
            boolean z;
            int i;
            Object obj6;
            while (w instanceof Callable) {
                if (i((Callable)w)) {
                    break;
                }
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    break;
                }
                obj6 = 0;
                aVar = this.sources.poll();
                z = 1;
                if ((w)aVar == null) {
                }
                obj6 = aVar;
                this.wip = obj6 -= z;
                obj6 = z;
            }
            long uniqueId = this.uniqueId;
            this.uniqueId = i2 += uniqueId;
            aVar = new v0.a(this, uniqueId, obj2);
            if (a(aVar)) {
                w.subscribe(aVar);
            }
        }

        void h(U u, i.b.m0.e.e.v0.a<T, U> v0$a2) {
            boolean compareAndSet;
            int bufferSize;
            int obj3;
            Object obj4;
            if (get() == 0 && compareAndSet(0, 1)) {
                if (compareAndSet(0, 1)) {
                    this.downstream.onNext(u);
                    if (decrementAndGet() == 0) {
                    }
                } else {
                    if (a2.queue == null) {
                        compareAndSet = new c(this.bufferSize);
                        a2.queue = compareAndSet;
                    }
                    compareAndSet.offer(u);
                    if (getAndIncrement() != 0) {
                    }
                }
            } else {
            }
            e();
        }

        boolean i(Callable<? extends U> callable) {
            int compareAndSet;
            Object downstream;
            int maxConcurrency;
            int obj5;
            final int i = 1;
            obj5 = callable.call();
            if (obj5 == null) {
                try {
                    return i;
                    final int i2 = 0;
                    this.downstream.onNext(obj5);
                }
                if (this.queue == null) {
                    if (this.maxConcurrency == Integer.MAX_VALUE) {
                        downstream = new c(this.bufferSize);
                    } else {
                        downstream = new b(this.maxConcurrency);
                    }
                    this.queue = downstream;
                }
                if (!downstream.offer(obj5)) {
                    obj5 = new IllegalStateException("Scalar queue full?!");
                    onError(obj5);
                    return i;
                }
                if (getAndIncrement() != 0) {
                    return i2;
                }
                e();
                return i;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (this.done) {
            }
            this.done = true;
            d();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            int obj2;
            if (this.done) {
                a.t(throwable);
            }
            if (this.errors.a(throwable)) {
                this.done = true;
                d();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            int maxConcurrency;
            int maxConcurrency2;
            if (this.done) {
            }
            final Object obj3 = this.mapper.apply(t);
            b.e(obj3, "The mapper returned a null ObservableSource");
            int wip = this.wip;
            if (this.maxConcurrency != Integer.MAX_VALUE && wip == this.maxConcurrency) {
                wip = this.wip;
                synchronized (this) {
                    this.sources.offer((w)obj3);
                }
            }
            g(obj3);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public v0(w<T> w, n<? super T, ? extends w<? extends U>> n2, boolean z3, int i4, int i5) {
        super(w);
        this.b = n2;
        this.c = z3;
        this.v = i4;
        this.w = i5;
    }

    public void subscribeActual(y<? super U> y) {
        if (y2.b(this.a, y, this.b)) {
        }
        super(y, this.b, this.c, this.v, this.w);
        this.a.subscribe(bVar2);
    }
}
