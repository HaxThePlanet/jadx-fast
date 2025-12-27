package i.b.m0.e.d;

import i.b.l0.n;
import i.b.m0.c.i;
import i.b.p;
import i.b.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMapMaybe.java */
/* loaded from: classes3.dex */
public final class d<T, R> extends r<R> {

    final r<T> a;
    final n<? super T, ? extends p<? extends R>> b;
    final i.b.m0.j.j c;
    final int v;

    static final class a<T, R> extends AtomicInteger implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final y<? super R> downstream;
        final i.b.m0.j.j errorMode;
        final i.b.m0.j.c errors = new c();
        final d.a.a<R> inner = new d$a$a<>();
        R item;
        final n<? super T, ? extends p<? extends R>> mapper;
        final i<T> queue = new c<>();
        volatile int state;
        i.b.j0.b upstream;
        a(y<? super R> yVar, n<? super T, ? extends p<? extends R>> nVar, int i, i.b.m0.j.j jVar) {
            super();
            this.downstream = yVar;
            this.mapper = nVar;
            this.errorMode = jVar;
            i.b.m0.j.c cVar = new c();
            i.b.m0.e.d.d.a.a aVar = new d.a.a(this);
            i.b.m0.f.c cVar2 = new c(i);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andGet;
            boolean cancelled2;
            Object poll = null;
            int i = 2;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            poll = null;
            while (this.cancelled) {
                this.queue.clear();
                this.item = poll;
                if (addAndGet(-andGet) == 0) {
                    return;
                }
                poll = null;
                if (this.errors.get() == null || this.errorMode != j.IMMEDIATE) {
                    andGet = 0;
                }
            }
            this.queue.clear();
            this.item = poll;
            this.downstream.onError(this.errors.b());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            this.state = 0;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(Throwable th) {
            if (this.errors.a(th)) {
                if (this.errorMode != j.END) {
                    this.upstream.dispose();
                }
                int i = 0;
                this.state = i;
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(R r) {
            this.item = r;
            this.state = 2;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.a();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.errors.a(th)) {
                if (this.errorMode == j.IMMEDIATE) {
                    this.inner.a();
                }
                boolean z = true;
                this.done = z;
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.queue.offer(t);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public d(r<T> rVar, n<? super T, ? extends p<? extends R>> nVar, i.b.m0.j.j jVar, int i) {
        super();
        this.a = rVar;
        this.b = nVar;
        this.c = jVar;
        this.v = i;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super R> yVar) {
        if (!i.b(this.a, this.b, yVar)) {
            this.a.subscribe(new d.a(yVar, this.b, this.v, this.c));
        }
    }
}
