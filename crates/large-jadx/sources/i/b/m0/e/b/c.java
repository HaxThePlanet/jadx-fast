package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.m0.f.c;
import i.b.m0.h.c;
import i.b.m0.h.d;
import i.b.m0.i.g;
import i.b.m0.j.c;
import i.b.m0.j.d;
import i.b.m0.j.j;
import i.b.p0.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class c<T, R>  extends i.b.m0.e.b.a<T, R> {

    final n<? super T, ? extends a<? extends R>> c;
    final int v;
    final int w;
    final j x;

    static final class a extends AtomicInteger implements k<T>, c, d<R> {

        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile c<R> current;
        volatile boolean done;
        final b<? super R> downstream;
        final j errorMode;
        final c errors;
        final n<? super T, ? extends a<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested;
        final c<c<R>> subscribers;
        c upstream;
        a(b<? super R> b, n<? super T, ? extends a<? extends R>> n2, int i3, int i4, j j5) {
            super();
            this.downstream = b;
            this.mapper = n2;
            this.maxConcurrency = i3;
            this.prefetch = i4;
            this.errorMode = j5;
            c obj1 = new c(Math.min(i4, i3));
            this.subscribers = obj1;
            obj1 = new c();
            this.errors = obj1;
            obj1 = new AtomicLong();
            this.requested = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void a() {
            c current;
            Object eND;
            int i;
            Object iMMEDIATE2;
            int requested;
            int i3;
            int andGet;
            long l;
            c poll;
            Object poll2;
            Object iMMEDIATE;
            int empty;
            c cVar;
            j jVar;
            int i2;
            int cmp;
            int i4;
            final Object obj = this;
            if (getAndIncrement() != 0) {
            }
            current = obj.current;
            final b downstream = obj.downstream;
            final j errorMode = obj.errorMode;
            andGet = 1;
            l = obj.requested.get();
            while (current == null) {
                poll = obj.subscribers.poll();
                if ((c)poll != null) {
                }
                cVar = 0;
                i4 = andGet;
                i = 0;
                i3 = 0;
                i2 = 0;
                if (Long.compare(i2, i3) != 0 && Long.compare(l, l2) != 0) {
                }
                current = poll;
                l = obj.requested.get();
                poll = current;
                current = poll;
                andGet = i4;
                if (Long.compare(l, l2) != 0) {
                }
                obj.requested.addAndGet(-i2);
                jVar = poll.b();
                i2 = 0;
                cmp = Long.compare(i2, l);
                requested = 1;
                while (cmp != 0) {
                    poll2 = jVar.poll();
                    if (poll2 == null) {
                    } else {
                    }
                    empty = 0;
                    downstream.onNext(poll2);
                    i2 += requested;
                    poll.d();
                    andGet = i4;
                    cmp = Long.compare(i2, l);
                    requested = 1;
                    empty = 1;
                }
                i = 0;
                i3 = 0;
                if (poll.a() && jVar.isEmpty()) {
                }
                if (jVar.isEmpty()) {
                }
                obj.current = cVar;
                obj.upstream.request(requested);
                poll = cVar;
                i = 1;
                poll2 = jVar.poll();
                if (poll2 == null) {
                } else {
                }
                empty = 0;
                downstream.onNext(poll2);
                i2 += requested;
                poll.d();
                andGet = i4;
                obj.current = cVar;
                obj.upstream.request(requested);
                poll = cVar;
                i = 1;
                empty = 1;
                obj.current = (c)poll;
            }
            f();
            downstream.onError(obj.errors.b());
        }

        public void b(c<R> c) {
            c.e();
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            if (this.cancelled) {
            }
            this.cancelled = true;
            this.upstream.cancel();
            g();
        }

        public void d(c<R> c, R r2) {
            boolean obj3;
            if (c.b().offer(r2)) {
                a();
            } else {
                c.cancel();
                obj3 = new MissingBackpressureException();
                e(c, obj3);
            }
        }

        public void e(c<R> c, Throwable throwable2) {
            Object obj2;
            Object obj3;
            if (this.errors.a(throwable2)) {
                c.e();
                if (this.errorMode != j.END) {
                    this.upstream.cancel();
                }
                a();
            } else {
                a.t(throwable2);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f() {
            c current;
            current = this.current;
            this.current = 0;
            if (current != null) {
                current.cancel();
            }
            current = this.subscribers.poll();
            while ((c)current != null) {
                (c)current.cancel();
                current = this.subscribers.poll();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g() {
            int decrementAndGet;
            if (getAndIncrement() == 0) {
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            int obj2;
            if (this.errors.a(throwable)) {
                this.done = true;
                a();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            try {
                Object obj3 = this.mapper.apply(t);
                b.e(obj3, "The mapper returned a null Publisher");
                c cVar = new c(this, this.prefetch);
                if (this.cancelled) {
                }
                this.subscribers.offer(cVar);
                (a)obj3.a(cVar);
                if (this.cancelled) {
                }
                cVar.cancel();
                g();
                a.b(t);
                this.upstream.cancel();
                onError(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c c) {
            long validate;
            int i;
            if (g.validate(this.upstream, c)) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                int maxConcurrency = this.maxConcurrency;
                i = Integer.MAX_VALUE;
                validate = maxConcurrency == i ? 9223372036854775807L : (long)maxConcurrency;
                c.request(validate);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long l) {
            boolean requested;
            if (g.validate(l)) {
                d.a(this.requested, l);
                a();
            }
        }
    }
    public c(h<T> h, n<? super T, ? extends a<? extends R>> n2, int i3, int i4, j j5) {
        super(h);
        this.c = n2;
        this.v = i3;
        this.w = i4;
        this.x = j5;
    }

    protected void c0(b<? super R> b) {
        super(b, this.c, this.v, this.w, this.x);
        this.b.b0(aVar2);
    }
}
