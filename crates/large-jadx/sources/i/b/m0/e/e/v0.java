package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.c.f;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.j.k;
import i.b.w;
import i.b.y;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMap.java */
/* loaded from: classes3.dex */
public final class v0<T, U> extends a<T, U> {

    final n<? super T, ? extends w<? extends U>> b;
    final boolean c;
    final int v;
    final int w;

    static final class a<T, U> extends AtomicReference<i.b.j0.b> implements y<U> {

        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final v0.b<T, U> parent;
        volatile j<U> queue;
        a(v0.b<T, U> bVar, long j) {
            super();
            this.id = j;
            this.parent = bVar;
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
        public void onError(Throwable th) {
            if (this.parent.errors.a(th)) {
                if (!parent23.delayErrors) {
                    this.parent.c();
                }
                this.done = true;
                this.parent.d();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.h(u, this);
            } else {
                this.parent.d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this, bVar)) {
                once = bVar instanceof e;
                if (bVar instanceof e) {
                    int requestFusion = bVar.requestFusion(7);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.fusionMode = requestFusion;
                        this.queue = bVar;
                        this.done = true;
                        this.parent.d();
                        return;
                    }
                    int i = 2;
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = bVar;
                    }
                }
            }
        }
    }

    static final class b<T, U> extends AtomicInteger implements i.b.j0.b, y<T> {

        static final v0.a<?, ?>[] a;
        static final v0.a<?, ?>[] b;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final y<? super U> downstream;
        final i.b.m0.j.c errors = new c();
        long lastId;
        int lastIndex;
        final n<? super T, ? extends w<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<v0.a<?, ?>[]> observers = new AtomicReference<>();
        volatile i<U> queue;
        Queue<w<? extends U>> sources = new ArrayDeque<>();
        long uniqueId;
        i.b.j0.b upstream;
        int wip;
        static {
            int i = 0;
            v0.b.a = new v0.a[i];
            v0.b.b = new v0.a[i];
        }

        b(y<? super U> yVar, n<? super T, ? extends w<? extends U>> nVar, boolean z, int i, int i2) {
            super();
            final i.b.m0.j.c cVar = new c();
            this.downstream = yVar;
            this.mapper = nVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            i = Integer.MAX_VALUE;
            if (i != Integer.MAX_VALUE) {
                ArrayDeque arrayDeque = new ArrayDeque(i);
            }
            AtomicReference atomicReference = new AtomicReference(v0.b.a);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean a(v0.a<T, U> aVar) {
            Object obj = this.observers.get();
            final int i = 0;
            while (obj == v0.b.b) {
                int length = obj.length;
                i.b.m0.e.e.v0.a[] arr = new v0.a[length + 1];
                System.arraycopy(obj, i, arr, i, length);
                arr[length] = aVar;
                if (this.observers.compareAndSet(obj, arr)) {
                    return true;
                }
                obj = this.observers.get();
                i = 0;
            }
            aVar.a();
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean b() {
            final boolean z = true;
            if (this.cancelled) {
                return true;
            }
            if (!this.delayErrors && (Throwable)this.errors.get() != null) {
                c();
                Throwable th2 = this.errors.b();
                if (th2 != k.a) {
                    this.downstream.onError(th2);
                }
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean c() {
            int i = 0;
            this.upstream.dispose();
            i.b.m0.e.e.v0.a[] objArr = v0.b.b;
            i = 0;
            if ((v0.a[])this.observers.get() != v0.b.b) {
                Object andSet = this.observers.getAndSet(v0.b.b);
                if (andSet != v0.b.b) {
                    for (Object obj : andSet) {
                        obj.a();
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (c()) {
                    Throwable th2 = this.errors.b();
                    if (th2 != null && th2 != k.a) {
                        a.t(th2);
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e() {
            int andGet;
            boolean empty;
            int size;
            i queue2;
            Object obj;
            int cmp;
            boolean empty2;
            j queue22;
            andGet = 1;
            while (b()) {
                obj = this.observers.get();
                length = obj.length;
                int i = Integer.MAX_VALUE;
                size = 0;
                while (b()) {
                    Object poll = this.queue.poll();
                }
                poll = this.queue.poll();
                a.b(th4);
                aVar.a();
                this.errors.a(th4);
                Throwable th4 = b();
                if (th4 != null) {
                    return;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f(v0.a<T, U> aVar) {
            i.b.m0.e.e.v0.a[] arr;
            int i = -1;
            Object obj;
            Object obj2 = this.observers.get();
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
                if (this.observers.compareAndSet(obj2, arr)) {
                    return;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g(w<? extends U> wVar) {
            int i = 0;
            while (wVar instanceof Callable) {
                i = 0;
                try {
                    i = 1;
                } catch (Throwable th) {
                }
                if (this.maxConcurrency != 0) {
                    d();
                }
            }
            l = 1L + uniqueId2;
            this.uniqueId = l;
            i.b.m0.e.e.v0.a aVar = new v0.a(this, uniqueId2, r2);
            if (a(aVar)) {
                th.subscribe(aVar);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void h(U u, v0.a<T, U> aVar) {
            j queue2;
            int bufferSize2 = 1;
            if (get() == 0) {
                bufferSize2 = 1;
                if (compareAndSet(0, bufferSize2)) {
                    this.downstream.onNext(u);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    if (aVar.queue == null) {
                        aVar.queue = new c(this.bufferSize);
                    }
                    queue2.offer(u);
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            }
            e();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean i(Callable<? extends U> callable) {
            i.b.m0.f.b bVar;
            i queue2;
            int maxConcurrency2;
            final int i2 = 1;
            try {
                Object call = callable.call();
            } catch (Throwable th) {
                a.b(th);
                this.errors.a(th);
                d();
                return z;
            }
            if (call == null) {
                return true;
            }
            final int i3 = 0;
            if (get() != 0 || !this.compareAndSet(i3, i2)) {
                if (this.queue == null) {
                    if (this.maxConcurrency == 0x7fffffff /* Unknown resource */) {
                        i.b.m0.f.c cVar = new c(this.bufferSize);
                    } else {
                        bVar = new b(this.maxConcurrency);
                    }
                    this.queue = bVar;
                }
                if (!queue2.offer(call)) {
                    onError(new IllegalStateException("Scalar queue full?!"));
                    return true;
                }
                if (getAndIncrement() != 0) {
                    return false;
                }
            } else {
                this.downstream.onNext(call);
                if (decrementAndGet() == 0) {
                    return true;
                }
            }
            e();
            return true;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            d();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.done) {
                a.t(th);
                return;
            }
            if (this.errors.a(th)) {
                boolean z = true;
                this.done = z;
                d();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null ObservableSource");
            } catch (Throwable unused) {
            }
            int maxConcurrency22 = Integer.MAX_VALUE;
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                synchronized (this) {
                    try {
                        if (this.wip == this.maxConcurrency) {
                            this.sources.offer(apply);
                            return;
                        }
                        this.wip++;
                    } catch (Throwable th) {
                    }
                }
            }
            g(apply);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public v0(w<T> wVar, n<? super T, ? extends w<? extends U>> nVar, boolean z, int i, int i2) {
        super(wVar);
        this.b = nVar;
        this.c = z;
        this.v = i;
        this.w = i2;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super U> yVar) {
        if (y2.b(this.a, yVar, this.b)) {
            return;
        }
        v0.b bVar = new v0.b(yVar, this.b, this.c, this.v, this.w);
        this.a.subscribe(bVar);
    }
}
