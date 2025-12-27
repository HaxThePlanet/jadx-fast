package i.b.m0.e.d;

import i.b.d;
import i.b.l0.n;
import i.b.m0.j.k;
import i.b.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMapCompletable.java */
/* loaded from: classes3.dex */
public final class c<T> extends i.b.b {

    final r<T> a;
    final n<? super T, ? extends i.b.f> b;
    final i.b.m0.j.j c;
    final int v;

    static final class a<T> extends AtomicInteger implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final d downstream;
        final i.b.m0.j.j errorMode;
        final i.b.m0.j.c errors = new c();
        final c.a.a inner = new c$a$a();
        final n<? super T, ? extends i.b.f> mapper;
        final int prefetch;
        i.b.m0.c.j<T> queue;
        i.b.j0.b upstream;
        a(d dVar, n<? super T, ? extends i.b.f> nVar, i.b.m0.j.j jVar, int i) {
            super();
            this.downstream = dVar;
            this.mapper = nVar;
            this.errorMode = jVar;
            this.prefetch = i;
            i.b.m0.j.c cVar = new c();
            i.b.m0.e.d.c.a.a aVar = new c.a.a(this);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            boolean z;
            Object apply;
            int i;
            if (getAndIncrement() != 0) {
                return;
            }
            while (this.disposed) {
                if (decrementAndGet() == 0) {
                    return;
                }
                z = true;
                int i2 = 0;
                try {
                    Object poll = this.queue.poll();
                    b.e(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                } catch (Throwable th) {
                    a.b(th);
                    this.disposed = z2;
                    this.queue.clear();
                    this.queue.dispose();
                    th2.a(th);
                    Throwable th2 = th2.b();
                    this.downstream.onError(th2);
                    return;
                }
                i = 0;
            }
            this.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            this.active = false;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(Throwable th) {
            Throwable th2;
            if (!this.errors.a(th)) {
                a.t(th);
            } else {
                if (this.errorMode == j.IMMEDIATE) {
                    this.disposed = true;
                    this.upstream.dispose();
                    Throwable th3 = this.errors.b();
                    if (th3 != k.a) {
                        this.downstream.onError(th3);
                    }
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                    }
                } else {
                    boolean z2 = false;
                    this.active = z2;
                    a();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.a();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            Throwable th2;
            if (!this.errors.a(th)) {
                a.t(th);
            } else {
                boolean z2 = true;
                if (this.errorMode == j.IMMEDIATE) {
                    this.disposed = z2;
                    this.inner.a();
                    Throwable th3 = this.errors.b();
                    if (th3 != k.a) {
                        this.downstream.onError(th3);
                    }
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                    }
                } else {
                    this.done = z2;
                    a();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            if (t != null) {
                this.queue.offer(t);
            }
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            int i = 2;
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                z = bVar instanceof e;
                if (bVar instanceof e) {
                    int requestFusion = bVar.requestFusion(3);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.queue = bVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.queue = bVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new c(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }
    public c(r<T> rVar, n<? super T, ? extends i.b.f> nVar, i.b.m0.j.j jVar, int i) {
        super();
        this.a = rVar;
        this.b = nVar;
        this.c = jVar;
        this.v = i;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        if (!i.a(this.a, this.b, dVar)) {
            this.a.subscribe(new c.a(dVar, this.b, this.c, this.v));
        }
    }
}
