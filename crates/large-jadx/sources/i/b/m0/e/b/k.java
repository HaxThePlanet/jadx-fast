package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.c.f;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.i.g;
import i.b.m0.j.d;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMap.java */
/* loaded from: classes3.dex */
public final class k<T, U> extends a<T, U> {

    final n<? super T, ? extends m.c.a<? extends U>> c;
    final boolean v;
    final int w;
    final int x;

    static final class a<T, U> extends AtomicReference<m.c.c> implements i.b.k<U>, i.b.j0.b {

        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final k.b<T, U> parent;
        long produced;
        volatile j<U> queue;
        a(k.b<T, U> bVar, long j) {
            super();
            this.id = j;
            this.parent = bVar;
            this.bufferSize = bVar.bufferSize;
            this.limit = bufferSize2 >> 2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(long j) {
            final int i = 1;
            if (this.fusionMode != i) {
                long l2 = (long)this.limit;
                if (this.fusionMode >= this.limit) {
                    this.produced = 0L;
                    (c)get().request(l);
                } else {
                    this.produced += j;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            g.cancel(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() == g.CANCELLED ? 1 : 0;
            return (get() == g.CANCELLED ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.done = true;
            this.parent.f();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            lazySet(g.CANCELLED);
            this.parent.j(this, th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.l(u, this);
            } else {
                this.parent.f();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(m.c.c cVar) {
            int requestFusion;
            int i = 2;
            if (g.setOnce(this, cVar)) {
                z = cVar instanceof g;
                if (cVar instanceof g) {
                    m.c.c cVar2 = cVar;
                    requestFusion = cVar2.requestFusion(7);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.fusionMode = requestFusion;
                        this.queue = cVar2;
                        this.done = true;
                        this.parent.f();
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = cVar2;
                    }
                }
                cVar.request((long)this.bufferSize);
            }
        }
    }

    static final class b<T, U> extends AtomicInteger implements i.b.k<T>, m.c.c {

        static final k.a<?, ?>[] a;
        static final k.a<?, ?>[] b;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final m.c.b<? super U> downstream;
        final i.b.m0.j.c errs = new c();
        long lastId;
        int lastIndex;
        final n<? super T, ? extends m.c.a<? extends U>> mapper;
        final int maxConcurrency;
        volatile i<U> queue;
        final AtomicLong requested = new AtomicLong();
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<k.a<?, ?>[]> subscribers = new AtomicReference<>();
        long uniqueId;
        m.c.c upstream;
        static {
            int i = 0;
            k.b.a = new k.a[i];
            k.b.b = new k.a[i];
        }

        b(m.c.b<? super U> bVar, n<? super T, ? extends m.c.a<? extends U>> nVar, boolean z, int i, int i2) {
            super();
            i.b.m0.j.c cVar = new c();
            final AtomicLong atomicLong = new AtomicLong();
            this.downstream = bVar;
            this.mapper = nVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = Math.max(1, i >> 1);
            new AtomicReference().lazySet(k.b.a);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean a(k.a<T, U> aVar) {
            Object obj = this.subscribers.get();
            final int i = 0;
            while (obj == k.b.b) {
                int length = obj.length;
                i.b.m0.e.b.k.a[] arr = new k.a[length + 1];
                System.arraycopy(obj, i, arr, i, length);
                arr[length] = aVar;
                if (this.subscribers.compareAndSet(obj, arr)) {
                    return true;
                }
                obj = this.subscribers.get();
                i = 0;
            }
            aVar.dispose();
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean b() {
            final boolean z = true;
            if (this.cancelled) {
                d();
                return true;
            }
            if (!this.delayErrors) {
                if (this.errs.get() != null) {
                    d();
                    Throwable th2 = this.errs.b();
                    if (th2 != k.a) {
                        this.downstream.onError(th2);
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                e();
                if (getAndIncrement() == 0 && this.queue != null) {
                    this.queue.clear();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            if (this.queue != null) {
                this.queue.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e() {
            int i = 0;
            Object obj;
            objArr = k.b.b;
            if ((k.a[])this.subscribers.get() != k.b.b) {
                Object andSet = this.subscribers.getAndSet(k.b.b);
                if (andSet != k.b.b) {
                    i = 0;
                    for (Object obj : andSet) {
                        obj.dispose();
                    }
                    Throwable th = this.errs.b();
                    if (th != null && th != k.a) {
                        a.t(th);
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g() {
            boolean empty;
            int cmp;
            int lastIndex2;
            int cmp2 = 0;
            int i;
            int andGet = 1;
            long andGet2;
            long l = 0;
            int i2;
            int i3 = 1;
            int cmp3;
            int i4;
            int i5 = 0;
            Throwable th;
            int length;
            long l3 = 1;
            Object poll;
            j queue22;
            long cmp4;
            int i7 = 0;
            long cmp5 = 1;
            boolean z;
            int cmp6;
            long l4;
            int cmp7;
            final Object obj4 = this;
            andGet = 1;
            while (b()) {
                andGet2 = obj4.requested.get();
                long l2 = Long.MAX_VALUE;
                int r9 = andGet2 == Long.MAX_VALUE ? 1 : 0;
                cmp5 = 1L;
                l = 0L;
                i = l;
                while (/* condition */) {
                    while (obj4.requested != l) {
                        poll = obj4.queue.poll();
                        if (poll == null) {
                        }
                    }
                    poll = obj4.queue.poll();
                    if (poll == null) {
                    }
                }
                while (obj4.requested != l) {
                    poll = obj4.queue.poll();
                    if (poll == null) {
                    }
                }
                poll = obj4.queue.poll();
                if (poll == null) {
                }
                a.b(th);
                aVar.dispose();
                obj3.errs.a(th);
                th = b();
                if (obj3.errs != null) {
                    return;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        j<U> h(k.a<T, U> aVar) {
            j queue2;
            if (aVar.queue == null) {
                aVar.queue = new b(this.bufferSize);
            }
            return queue2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        j<U> i() {
            i.b.m0.f.b bVar;
            i queue2;
            int maxConcurrency2;
            if (this.queue == null) {
                if (this.maxConcurrency == 0x7fffffff /* Unknown resource */) {
                    i.b.m0.f.c cVar = new c(this.bufferSize);
                } else {
                    bVar = new b(this.maxConcurrency);
                }
                this.queue = bVar;
            }
            return queue2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void j(k.a<T, U> aVar, Throwable th) {
            int i = 0;
            boolean z;
            Object obj;
            boolean delayErrors2;
            boolean z2 = true;
            if (this.errs.a(th)) {
                z2 = true;
                aVar.done = z2;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    Object andSet = this.subscribers.getAndSet(k.b.b);
                    i = 0;
                    for (Object obj : andSet) {
                        obj.dispose();
                    }
                }
                f();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void k(k.a<T, U> aVar) {
            i.b.m0.e.b.k.a[] arr;
            int i = -1;
            Object obj;
            Object obj2 = this.subscribers.get();
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
                if (this.subscribers.compareAndSet(obj2, arr)) {
                    return;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void l(U u, k.a<T, U> aVar) {
            j queue2;
            long l = 1;
            j queue22;
            int bufferSize2 = 1;
            int cmp;
            int cmp2;
            final String str = "Inner queue full?!";
            if (get() == 0) {
                bufferSize2 = 1;
                if (compareAndSet(0, bufferSize2)) {
                    long l3 = this.requested.get();
                    if (l3 == 0 || aVar.queue != null) {
                        if (aVar.queue == null) {
                            queue22 = h(aVar);
                        }
                        if (!queue22.offer(u)) {
                            onError(new MissingBackpressureException(str));
                            return;
                        }
                    } else {
                        if (aVar.queue.isEmpty()) {
                            this.downstream.onNext(u);
                            if (l3 != 9223372036854775807L) {
                                this.requested.decrementAndGet();
                            }
                            l = 1L;
                            aVar.a(l);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    if (aVar.queue == null) {
                        aVar.queue = new b(this.bufferSize);
                    }
                    if (!queue2.offer(u)) {
                        onError(new MissingBackpressureException(str));
                        return;
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            }
            g();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void m(U u) {
            int i = 0;
            String str;
            int i2 = 1;
            boolean compareAndSet;
            i queue2;
            int cmp;
            str = "Scalar queue full?!";
            if (get() == 0) {
                i = 0;
                i2 = 1;
                if (compareAndSet(i, i2)) {
                    long l2 = this.requested.get();
                    if (l2 == 0 || this.queue != null) {
                        if (this.queue == null) {
                            j jVar2 = i();
                        }
                        if (!queue2.offer(u)) {
                            onError(new IllegalStateException(str));
                            return;
                        }
                    } else {
                        if (this.queue.isEmpty()) {
                            this.downstream.onNext(u);
                            long l3 = Long.MAX_VALUE;
                            if (l2 != Long.MAX_VALUE) {
                                this.requested.decrementAndGet();
                            }
                            if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled && this.requested == this.scalarLimit) {
                                this.scalarEmitted = i;
                                this.upstream.request((long)scalarLimit2);
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    if (!i().offer(u)) {
                        onError(new IllegalStateException(str));
                        return;
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            }
            g();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            f();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            boolean z;
            int i;
            Object obj;
            boolean delayErrors2;
            if (this.done) {
                a.t(th);
                return;
            }
            if (this.errs.a(th)) {
                this.done = true;
                if (!this.delayErrors) {
                    Object andSet = this.subscribers.getAndSet(k.b.b);
                    i = 0;
                    for (Object obj : andSet) {
                        obj.dispose();
                    }
                }
                f();
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
                Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null Publisher");
            } catch (Throwable th) {
                a.b(th);
                this.errs.a(th);
                f();
                return;
            }
            if (apply instanceof Callable) {
                try {
                    apply = apply.call();
                } catch (Throwable th) {
                    a.b(th);
                    this.errs.a(th);
                    f();
                    return;
                }
                if (apply != null) {
                    m(apply);
                } else {
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        this.scalarEmitted++;
                        if (this.scalarEmitted == this.scalarLimit) {
                            this.scalarEmitted = 0;
                            this.upstream.request((long)scalarLimit2);
                        }
                    }
                }
            } else {
                l = 1L + uniqueId2;
                this.uniqueId = l;
                i.b.m0.e.b.k.a aVar = new k.a(this, uniqueId2, r2);
                if (a(aVar)) {
                    apply.a(aVar);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(m.c.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    int i = Integer.MAX_VALUE;
                    if (this.maxConcurrency == Integer.MAX_VALUE) {
                        cVar.request(Long.MAX_VALUE);
                    } else {
                        cVar.request((long)maxConcurrency2);
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                f();
            }
        }
    }
    public k(h<T> hVar, n<? super T, ? extends m.c.a<? extends U>> nVar, boolean z, int i, int i2) {
        super(hVar);
        this.c = nVar;
        this.v = z;
        this.w = i;
        this.x = i2;
    }

    public static <T, U> i.b.k<T> g0(m.c.b<? super U> bVar, n<? super T, ? extends m.c.a<? extends U>> nVar, boolean z, int i, int i2) {
        k.b bVar2 = new k.b(bVar, nVar, z, i, i2);
        return bVar2;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super U> bVar) {
        if (i0.b(this.b, bVar, this.c)) {
            return;
        }
        this.b.b0(k.g0(bVar, this.c, this.v, this.w, this.x));
    }
}
