package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.i.g;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableConcatMap.java */
/* loaded from: classes3.dex */
public final class b<T, R> extends a<T, R> {

    final n<? super T, ? extends m.c.a<? extends R>> c;
    final int v;
    final i.b.m0.j.j w;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[j.values().length];
            b.a.a = iArr;
            try {
                iArr[j.BOUNDARY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[j.END.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    interface f<T> {
        void a(Throwable th);

        void b(T t);

        void d();
    }

    static final class g<T> implements m.c.c {

        final m.c.b<? super T> a;
        final T b;
        boolean c;
        g(T t, m.c.b<? super T> bVar) {
            super();
            this.b = t;
            this.a = bVar;
        }

        public void request(long j) {
            if (this.c > 0 && !this.c) {
                this.c = true;
                this.a.onNext(this.b);
                this.a.onComplete();
            }
        }

        public void cancel() {
        }
    }

    static abstract class b<T, R> extends AtomicInteger implements k<T>, b.f<R>, m.c.c {

        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final i.b.m0.j.c errors = new c();
        final b.e<R> inner = new b$e<>();
        final int limit;
        final n<? super T, ? extends m.c.a<? extends R>> mapper;
        final int prefetch;
        i.b.m0.c.j<T> queue;
        int sourceMode;
        m.c.c upstream;
        b(n<? super T, ? extends m.c.a<? extends R>> nVar, int i) {
            super();
            this.mapper = nVar;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            i.b.m0.e.b.b.e eVar = new b.e(this);
            i.b.m0.j.c cVar = new c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public final void d() {
            this.active = false;
            e();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public final void onComplete() {
            this.done = true;
            e();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public final void onNext(T t) {
            if (this.sourceMode != 2) {
                if (!this.queue.offer(t)) {
                    this.upstream.cancel();
                    onError(new IllegalStateException("Queue full?!"));
                    return;
                }
            }
            e();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public final void onSubscribe(m.c.c cVar) {
            int i = 2;
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                z = cVar instanceof g;
                if (cVar instanceof g) {
                    m.c.c cVar2 = cVar;
                    int requestFusion = cVar2.requestFusion(7);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = requestFusion;
                        this.queue = cVar2;
                        this.done = true;
                        f();
                        e();
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = cVar2;
                        f();
                        cVar.request((long)this.prefetch);
                        return;
                    }
                }
                this.queue = new b(prefetch2);
                f();
                cVar.request((long)this.prefetch);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        abstract void e();

        @Override // java.util.concurrent.atomic.AtomicInteger
        abstract void f();
    }

    static final class e<R> extends i.b.m0.i.f implements k<R> {

        private static final long serialVersionUID = 897683679971470653L;
        final b.f<R> parent;
        long produced;
        e(b.f<R> fVar) {
            super(false);
            this.parent = fVar;
        }

        @Override // i.b.m0.i.f
        public void onComplete() {
            final long l = 0L;
            if (this.produced != l) {
                this.produced = l;
                f(this.produced);
            }
            this.parent.d();
        }

        @Override // i.b.m0.i.f
        public void onError(Throwable th) {
            final long l = 0L;
            if (this.produced != l) {
                this.produced = l;
                f(this.produced);
            }
            this.parent.a(th);
        }

        @Override // i.b.m0.i.f
        public void onNext(R r) {
            this.produced++;
            this.parent.b(r);
        }

        @Override // i.b.m0.i.f
        public void onSubscribe(m.c.c cVar) {
            g(cVar);
        }
    }

    static final class c<T, R> extends b.b<T, R> {

        private static final long serialVersionUID = -2945777694260521066L;
        final m.c.b<? super R> downstream;
        final boolean veryEnd;
        c(m.c.b<? super R> bVar, n<? super T, ? extends m.c.a<? extends R>> nVar, int i, boolean z) {
            super(nVar, i);
            this.downstream = bVar;
            this.veryEnd = z;
        }

        @Override // i.b.m0.e.b.b$b
        public void a(Throwable th) {
            if (this.errors.a(th)) {
                if (!this.veryEnd) {
                    this.upstream.cancel();
                    boolean veryEnd2 = true;
                    this.done = veryEnd2;
                }
                boolean z = false;
                this.active = z;
                e();
            } else {
                a.t(th);
            }
        }

        @Override // i.b.m0.e.b.b$b
        public void b(R r) {
            this.downstream.onNext(r);
        }

        @Override // i.b.m0.e.b.b$b
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.inner.cancel();
                this.upstream.cancel();
            }
        }

        @Override // i.b.m0.e.b.b$b
        void e() {
            Object call;
            m.c.b downstream2;
            int limit2;
            if (getAndIncrement() == 0) {
                while (this.cancelled) {
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    try {
                        Object poll = this.queue.poll();
                    } catch (Throwable th) {
                        a.b(th);
                        this.upstream.cancel();
                        this.upstream.a(th);
                        i.b.m0.j.c cVar = this.upstream.b();
                        this.downstream.onError(this.upstream);
                        return;
                    }
                    limit2 = 0;
                    limit2 = 1;
                    int r4 = limit2;
                    if (limit2 != 0) {
                    }
                    a.b(this.downstream);
                    this.upstream.a(this.downstream);
                    th = null;
                }
                return;
            }
        }

        @Override // i.b.m0.e.b.b$b
        void f() {
            this.downstream.onSubscribe(this);
        }

        @Override // i.b.m0.e.b.b$b
        public void onError(Throwable th) {
            if (this.errors.a(th)) {
                boolean z = true;
                this.done = z;
                e();
            } else {
                a.t(th);
            }
        }

        @Override // i.b.m0.e.b.b$b
        public void request(long j) {
            this.inner.request(j);
        }
    }

    static final class d<T, R> extends b.b<T, R> {

        private static final long serialVersionUID = 7898995095634264146L;
        final m.c.b<? super R> downstream;
        final AtomicInteger wip = new AtomicInteger();
        d(m.c.b<? super R> bVar, n<? super T, ? extends m.c.a<? extends R>> nVar, int i) {
            super(nVar, i);
            this.downstream = bVar;
            final AtomicInteger atomicInteger = new AtomicInteger();
        }

        @Override // i.b.m0.e.b.b$b
        public void a(Throwable th) {
            if (!this.errors.a(th)) {
                a.t(th);
            } else {
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.downstream.onError(this.errors.b());
                }
            }
        }

        @Override // i.b.m0.e.b.b$b
        public void b(R r) {
            if (get() == 0) {
                int i = 0;
                int i2 = 1;
                if (compareAndSet(i, i2)) {
                    this.downstream.onNext(r);
                    if (compareAndSet(i2, i)) {
                        return;
                    }
                    this.downstream.onError(this.errors.b());
                }
            }
        }

        @Override // i.b.m0.e.b.b$b
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.inner.cancel();
                this.upstream.cancel();
            }
        }

        @Override // i.b.m0.e.b.b$b
        void e() {
            int i;
            int limit2 = 0;
            long l;
            if (this.wip.getAndIncrement() == 0) {
                while (this.cancelled) {
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                    try {
                        Object poll = this.queue.poll();
                    } catch (Throwable th) {
                        a.b(th);
                        this.upstream.cancel();
                        this.upstream.a(th);
                        m.c.c cVar = this.upstream.b();
                        this.downstream.onError(this.upstream);
                        return;
                    }
                    limit2 = 0;
                    limit2 = 1;
                    int r4 = limit2;
                    try {
                        Object apply = this.mapper.apply(poll);
                        b.e(apply, "The mapper returned a null Publisher");
                    } catch (Throwable th) {
                        a.b(this.downstream);
                        this.upstream.cancel();
                        this.upstream.a(this.downstream);
                        cVar = this.upstream.b();
                        this.downstream.onError(this.upstream);
                        return;
                    }
                    try {
                        Object call = apply.call();
                    } catch (Throwable th) {
                        a.b(this.downstream);
                        this.upstream.cancel();
                        this.upstream.a(this.downstream);
                        cVar = this.upstream.b();
                        this.downstream.onError(this.upstream);
                        return;
                    }
                    if (this.wip != null) {
                    }
                    this.active = true;
                    apply.a(this.inner);
                }
                return;
            }
        }

        @Override // i.b.m0.e.b.b$b
        void f() {
            this.downstream.onSubscribe(this);
        }

        @Override // i.b.m0.e.b.b$b
        public void onError(Throwable th) {
            if (!this.errors.a(th)) {
                a.t(th);
            } else {
                this.inner.cancel();
                if (getAndIncrement() == 0) {
                    this.downstream.onError(this.errors.b());
                }
            }
        }

        @Override // i.b.m0.e.b.b$b
        public void request(long j) {
            this.inner.request(j);
        }
    }
    public b(h<T> hVar, n<? super T, ? extends m.c.a<? extends R>> nVar, int i, i.b.m0.j.j jVar) {
        super(hVar);
        this.c = nVar;
        this.v = i;
        this.w = jVar;
    }

    public static <T, R> m.c.b<T> g0(m.c.b<? super R> bVar, n<? super T, ? extends m.c.a<? extends R>> nVar, int i, i.b.m0.j.j jVar) {
        int i5 = b.a.a[jVar.ordinal()];
        i = 1;
        if (i5 != i && i5 != 2) {
            return new b.d(bVar, nVar, i);
        }
        return new b.c(bVar, nVar, i, false);
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super R> bVar) {
        if (i0.b(this.b, bVar, this.c)) {
            return;
        }
        this.b.a(b.g0(bVar, this.c, this.v, this.w));
    }
}
