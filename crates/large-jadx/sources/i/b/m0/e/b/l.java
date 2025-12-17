package i.b.m0.e.b;

import i.b.h;
import i.b.j0.a;
import i.b.k;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.m0.i.g;
import i.b.m0.j.c;
import i.b.m0.j.d;
import i.b.p;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class l<T, R>  extends i.b.m0.e.b.a<T, R> {

    final n<? super T, ? extends p<? extends R>> c;
    final boolean v;
    final int w;

    static final class a extends AtomicInteger implements k<T>, c {

        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final boolean delayErrors;
        final b<? super R> downstream;
        final c errors;
        final n<? super T, ? extends p<? extends R>> mapper;
        final int maxConcurrency;
        final AtomicReference<c<R>> queue;
        final AtomicLong requested;
        final a set;
        c upstream;
        a(b<? super R> b, n<? super T, ? extends p<? extends R>> n2, boolean z3, int i4) {
            super();
            this.downstream = b;
            this.mapper = n2;
            this.delayErrors = z3;
            this.maxConcurrency = i4;
            AtomicLong obj1 = new AtomicLong();
            this.requested = obj1;
            obj1 = new a();
            this.set = obj1;
            obj1 = new c();
            this.errors = obj1;
            obj1 = new AtomicInteger(1);
            this.active = obj1;
            obj1 = new AtomicReference();
            this.queue = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            Object obj = this.queue.get();
            if ((c)obj != null) {
                (c)obj.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            int andGet;
            int maxConcurrency;
            long l;
            boolean delayErrors2;
            Object empty;
            int i3;
            int i5;
            int cmp;
            int i;
            int i4;
            boolean delayErrors;
            Object poll;
            int i2;
            final Object obj = this;
            final b downstream = obj.downstream;
            AtomicInteger active = obj.active;
            final AtomicReference queue = obj.queue;
            final int i6 = 1;
            andGet = i6;
            while (/* condition */) {
                cmp = Long.compare(i5, l);
                i = 0;
                while (cmp != 0) {
                    if (active.get() == 0) {
                    } else {
                    }
                    i4 = i;
                    Object obj2 = queue.get();
                    if ((c)obj2 != null) {
                    } else {
                    }
                    poll = 0;
                    if (poll == null) {
                    } else {
                    }
                    i2 = i;
                    downstream.onNext(poll);
                    i5 += cmp;
                    cmp = Long.compare(i5, l);
                    i = 0;
                    i2 = i6;
                    poll = (c)obj2.poll();
                    i4 = i6;
                }
                d.d(obj.requested, i5);
                if (Long.compare(i5, i3) != 0 && obj.maxConcurrency != Integer.MAX_VALUE) {
                }
                i3 = 0;
                i5 = i3;
                d.d(obj.requested, i5);
                if (obj.maxConcurrency != Integer.MAX_VALUE) {
                }
                obj.upstream.request(i5);
                if (active.get() == 0) {
                } else {
                }
                l = i;
                empty = queue.get();
                if ((c)empty != null) {
                } else {
                }
                i = i6;
                if ((c)empty.isEmpty()) {
                }
                l = i6;
                if (active.get() == 0) {
                } else {
                }
                i4 = i;
                obj2 = queue.get();
                if ((c)obj2 != null) {
                } else {
                }
                poll = 0;
                if (poll == null) {
                } else {
                }
                i2 = i;
                downstream.onNext(poll);
                i5 += cmp;
                i2 = i6;
                poll = (c)obj2.poll();
                i4 = i6;
            }
            a();
        }

        c<R> e() {
            Object obj = this.queue.get();
            while ((c)obj != null) {
                c cVar = new c(h.b());
                obj = this.queue.get();
            }
            return (c)(c)obj;
        }

        void f(i.b.m0.e.b.l.a.a<T, R> l$a.a) {
            int downstream;
            int i;
            boolean decrementAndGet;
            int obj6;
            this.set.c(a.a);
            downstream = 1;
            final int i2 = Integer.MAX_VALUE;
            i = 1;
            if (get() == 0 && compareAndSet(0, i)) {
                i = 1;
                if (compareAndSet(0, i)) {
                    if (this.active.decrementAndGet() == 0) {
                        obj6 = i;
                    }
                    i = this.queue.get();
                    if (obj6 != null) {
                        if ((c)i != null) {
                            if ((c)i.isEmpty()) {
                                obj6 = this.errors.b();
                                if (obj6 != null) {
                                    this.downstream.onError(obj6);
                                } else {
                                    this.downstream.onComplete();
                                }
                            }
                        } else {
                        }
                    }
                    if (this.maxConcurrency != i2) {
                        this.upstream.request(downstream);
                    }
                    if (decrementAndGet() == 0) {
                    }
                    d();
                } else {
                    this.active.decrementAndGet();
                    if (this.maxConcurrency != i2) {
                        this.upstream.request(downstream);
                    }
                    b();
                }
            } else {
            }
        }

        void g(i.b.m0.e.b.l.a.a<T, R> l$a.a, Throwable throwable2) {
            a set;
            boolean obj3;
            Throwable obj4;
            this.set.c(a.a);
            if (this.errors.a(throwable2)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    this.set.dispose();
                } else {
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1);
                    }
                }
                this.active.decrementAndGet();
                b();
            } else {
                a.t(throwable2);
            }
        }

        void h(i.b.m0.e.b.l.a.a<T, R> l$a.a, R r2) {
            int set;
            int decrementAndGet;
            int i;
            int obj5;
            Object obj6;
            this.set.c(a.a);
            set = 1;
            if (get() == 0 && compareAndSet(0, set)) {
                set = 1;
                if (compareAndSet(0, set)) {
                    decrementAndGet = this.active.decrementAndGet();
                    if (decrementAndGet == 0) {
                        obj5 = set;
                    }
                    if (Long.compare(l, i) != 0) {
                        this.downstream.onNext(r2);
                        obj6 = this.queue.get();
                        if (obj5 != null) {
                            if ((c)obj6 != null) {
                                if ((c)obj6.isEmpty()) {
                                    obj5 = this.errors.b();
                                    if (obj5 != null) {
                                        this.downstream.onError(obj5);
                                    } else {
                                        this.downstream.onComplete();
                                    }
                                }
                            } else {
                            }
                        }
                        set = 1;
                        d.d(this.requested, set);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.request(set);
                        }
                    } else {
                        obj5 = e();
                        obj5.offer(r2);
                        synchronized (obj5) {
                            obj5 = e();
                            obj5.offer(r2);
                        }
                    }
                    if (decrementAndGet() == 0) {
                    }
                } else {
                    obj5 = e();
                    obj5.offer(r2);
                    this.active.decrementAndGet();
                    synchronized (obj5) {
                        obj5 = e();
                        obj5.offer(r2);
                        this.active.decrementAndGet();
                    }
                }
            } else {
            }
            d();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.active.decrementAndGet();
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            boolean obj2;
            this.active.decrementAndGet();
            if (this.errors.a(throwable)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                b();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            boolean cancelled;
            try {
                final Object obj3 = this.mapper.apply(t);
                b.e(obj3, "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                l.a.a aVar = new l.a.a(this);
                if (!this.cancelled && this.set.b(aVar)) {
                }
                if (this.set.b(aVar)) {
                }
                (p)obj3.b(aVar);
                a.b(t);
                this.upstream.cancel();
                onError(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c c) {
            boolean validate;
            int i;
            if (g.validate(this.upstream, c)) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                int maxConcurrency = this.maxConcurrency;
                i = Integer.MAX_VALUE;
                if (maxConcurrency == i) {
                    c.request(Long.MAX_VALUE);
                } else {
                    c.request((long)maxConcurrency);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void request(long l) {
            boolean requested;
            if (g.validate(l)) {
                d.a(this.requested, l);
                b();
            }
        }
    }
    public l(h<T> h, n<? super T, ? extends p<? extends R>> n2, boolean z3, int i4) {
        super(h);
        this.c = n2;
        this.v = z3;
        this.w = i4;
    }

    protected void c0(b<? super R> b) {
        l.a aVar = new l.a(b, this.c, this.v, this.w);
        this.b.b0(aVar);
    }
}
