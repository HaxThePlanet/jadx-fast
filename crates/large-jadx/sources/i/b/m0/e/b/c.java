package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.i.g;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableConcatMapEager.java */
/* loaded from: classes3.dex */
public final class c<T, R> extends a<T, R> {

    final n<? super T, ? extends m.c.a<? extends R>> c;
    final int v;
    final int w;
    final i.b.m0.j.j x;

    static final class a<T, R> extends AtomicInteger implements k<T>, m.c.c, i.b.m0.h.d<R> {

        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile i.b.m0.h.c<R> current;
        volatile boolean done;
        final m.c.b<? super R> downstream;
        final i.b.m0.j.j errorMode;
        final i.b.m0.j.c errors = new c();
        final n<? super T, ? extends m.c.a<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested = new AtomicLong();
        final i.b.m0.f.c<i.b.m0.h.c<R>> subscribers = new c<>();
        m.c.c upstream;
        a(m.c.b<? super R> bVar, n<? super T, ? extends m.c.a<? extends R>> nVar, int i, int i2, i.b.m0.j.j jVar) {
            super();
            this.downstream = bVar;
            this.mapper = nVar;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = jVar;
            i.b.m0.f.c cVar = new c(Math.min(i2, i));
            i.b.m0.j.c cVar2 = new c();
            AtomicLong atomicLong = new AtomicLong();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void a() {
            i.b.m0.h.c current2;
            int i = 0;
            int andGet;
            int i2 = 0;
            Object poll;
            int i3;
            i.b.m0.c.j jVar;
            int i4 = 0;
            int cmp;
            final Object obj4 = this;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            long l2 = obj4.requested.get();
            while (obj4.current == null) {
                if (obj4.errorMode == j.END) {
                    Object poll2 = obj4.subscribers.poll();
                }
            }
            f();
            obj4.downstream.onError(obj4.errors.b());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void b(i.b.m0.h.c<R> cVar) {
            cVar.e();
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            g();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void d(i.b.m0.h.c<R> cVar, R r) {
            if (cVar.b().offer(r)) {
                a();
            } else {
                cVar.cancel();
                e(cVar, new MissingBackpressureException());
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void e(i.b.m0.h.c<R> cVar, Throwable th) {
            i.b.m0.j.j errorMode2;
            if (this.errors.a(th)) {
                cVar.e();
                if (this.errorMode != j.END) {
                    this.upstream.cancel();
                }
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f() {
            this.current = null;
            if (this.current != null) {
                this.current.cancel();
            }
            i.b.m0.h.c poll = this.subscribers.poll();
            while (poll != null) {
                poll.cancel();
                poll = this.subscribers.poll();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g() {
            if (getAndIncrement() == 0) {
                f();
                while (decrementAndGet() == 0) {
                    f();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.errors.a(th)) {
                boolean z = true;
                this.done = z;
                a();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            try {
                Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null Publisher");
            } catch (Throwable th) {
                a.b(th);
                this.upstream.cancel();
                onError(th);
                return;
            }
            i.b.m0.h.c cVar = new c(this, this.prefetch);
            if (this.cancelled) {
                return;
            }
            this.subscribers.offer(cVar);
            apply.a(cVar);
            if (this.cancelled) {
                cVar.cancel();
                g();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(m.c.c cVar) {
            long l = 9223372036854775807L;
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                int i = Integer.MAX_VALUE;
                int r0 = this.maxConcurrency == Integer.MAX_VALUE ? 9223372036854775807L : (long)maxConcurrency2;
                cVar.request((this.maxConcurrency == Integer.MAX_VALUE ? 9223372036854775807L : (long)maxConcurrency2));
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                a();
            }
        }
    }
    public c(h<T> hVar, n<? super T, ? extends m.c.a<? extends R>> nVar, int i, int i2, i.b.m0.j.j jVar) {
        super(hVar);
        this.c = nVar;
        this.v = i;
        this.w = i2;
        this.x = jVar;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(m.c.b<? super R> bVar) {
        c.a aVar = new c.a(bVar, this.c, this.v, this.w, this.x);
        this.b.b0(aVar);
    }
}
