package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.f.b;
import i.b.m0.i.a;
import i.b.m0.i.d;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.m0.j.k;
import i.b.p0.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.a;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class n<T, R>  extends i.b.m0.e.b.a<T, R> {

    final n<? super T, ? extends Iterable<? extends R>> c;
    final int v;

    static final class a extends a<R> implements k<T> {

        private static final long serialVersionUID = -3096000382929934955L;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final b<? super R> downstream;
        final AtomicReference<Throwable> error;
        int fusionMode;
        final int limit;
        final n<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        j<T> queue;
        final AtomicLong requested;
        c upstream;
        a(b<? super R> b, n<? super T, ? extends Iterable<? extends R>> n2, int i3) {
            super();
            this.downstream = b;
            this.mapper = n2;
            this.prefetch = i3;
            this.limit = i3 -= obj1;
            AtomicReference obj1 = new AtomicReference();
            this.error = obj1;
            obj1 = new AtomicLong();
            this.requested = obj1;
        }

        boolean a(boolean z, boolean z2, b<?> b3, j<?> j4) {
            Object obj4;
            final int i = 0;
            final int i2 = 1;
            if (this.cancelled) {
                this.current = i;
                j4.clear();
                return i2;
            }
            if (z != null && (Throwable)this.error.get() != null) {
                if ((Throwable)this.error.get() != null) {
                    this.current = i;
                    j4.clear();
                    b3.onError(k.b(this.error));
                    return i2;
                }
                if (z2) {
                    b3.onComplete();
                    return i2;
                }
            }
            return 0;
        }

        @Override // i.b.m0.i.a
        void b(boolean z) {
            int upstream;
            long l;
            int obj4;
            if (z != 0) {
                obj4++;
                if (obj4 == this.limit) {
                    this.consumed = 0;
                    this.upstream.request((long)obj4);
                } else {
                    this.consumed = obj4;
                }
            }
        }

        @Override // i.b.m0.i.a
        public void cancel() {
            boolean andIncrement;
            this.cancelled = true;
            this.upstream.cancel();
            if (!this.cancelled && getAndIncrement() == 0) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // i.b.m0.i.a
        public void clear() {
            this.current = 0;
            this.queue.clear();
        }

        @Override // i.b.m0.i.a
        void d() {
            int i2;
            int requested;
            int cmp;
            Iterator iterator;
            int andGet;
            boolean next;
            Object poll;
            int i4;
            int i3;
            int next2;
            int i;
            final Object obj = this;
            if (getAndIncrement() != 0) {
            }
            final b downstream = obj.downstream;
            final j queue = obj.queue;
            final int i5 = 0;
            requested = 1;
            i2 = obj.fusionMode != requested ? requested : i5;
            iterator = obj.current;
            final int i6 = 0;
            andGet = requested;
            while (iterator == null) {
                poll = queue.poll();
                if (poll == null) {
                } else {
                }
                i4 = i5;
                requested = 1;
                next = obj.requested.get();
                i4 = 0;
                i3 = i4;
                while (Long.compare(i3, next) != 0) {
                    next2 = iterator.next();
                    b.e(next2, "The iterator returned a null value");
                    downstream.onNext(next2);
                    i3 += i;
                    requested = 1;
                }
                if (Long.compare(i3, i4) != 0 && Long.compare(next, i4) != 0) {
                }
                if (Long.compare(next, i4) != 0) {
                }
                obj.requested.addAndGet(-i3);
                if (queue.isEmpty() && iterator == null) {
                } else {
                }
                next2 = i5;
                if (iterator == null) {
                } else {
                }
                next2 = 1;
                next2 = iterator.next();
                b.e(next2, "The iterator returned a null value");
                downstream.onNext(next2);
                i3 += i;
                requested = 1;
                obj.b(i2);
                obj.current = i6;
                iterator = i6;
                iterator = (Iterable)obj.mapper.apply(poll).iterator();
                obj.current = iterator;
                obj.b(i2);
                iterator = i6;
                i4 = requested;
            }
        }

        @Override // i.b.m0.i.a
        public boolean isEmpty() {
            Iterator current;
            int i;
            if (this.current == null && this.queue.isEmpty()) {
                i = this.queue.isEmpty() ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // i.b.m0.i.a
        public void onComplete() {
            if (this.done) {
            }
            this.done = true;
            d();
        }

        @Override // i.b.m0.i.a
        public void onError(Throwable throwable) {
            boolean done;
            Throwable obj2;
            if (!this.done && k.a(this.error, throwable)) {
                if (k.a(this.error, throwable)) {
                    this.done = true;
                    d();
                } else {
                    a.t(throwable);
                }
            } else {
            }
        }

        public void onNext(T t) {
            int fusionMode;
            Object obj2;
            if (this.done) {
            }
            if (this.fusionMode == 0 && !this.queue.offer(t)) {
                if (!this.queue.offer(t)) {
                    obj2 = new MissingBackpressureException("Queue is full?!");
                    onError(obj2);
                }
            }
            d();
        }

        @Override // i.b.m0.i.a
        public void onSubscribe(c c) {
            boolean validate;
            boolean z;
            int requestFusion;
            int i;
            this.upstream = c;
            z = c;
            requestFusion = (g)z.requestFusion(3);
            int i3 = 1;
            if (g.validate(this.upstream, c) && c instanceof g && requestFusion == i3) {
                this.upstream = c;
                if (c instanceof g) {
                    z = c;
                    requestFusion = (g)z.requestFusion(3);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.fusionMode = requestFusion;
                        this.queue = z;
                        this.done = i3;
                        this.downstream.onSubscribe(this);
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = z;
                        this.downstream.onSubscribe(this);
                        c.request((long)prefetch2);
                    }
                }
                requestFusion = this.prefetch;
                b bVar = new b(requestFusion);
                this.queue = bVar;
                this.downstream.onSubscribe(this);
                c.request((long)prefetch);
            }
        }

        public R poll() {
            Iterator iterator;
            boolean next;
            iterator = this.current;
            final int i = 0;
            while (iterator == null) {
                Object poll = this.queue.poll();
                iterator = (Iterable)this.mapper.apply(poll).iterator();
                iterator = i;
            }
            Object next3 = iterator.next();
            b.e(next3, "The iterator returned a null value");
            if (!iterator.hasNext()) {
                this.current = i;
            }
            return next3;
        }

        @Override // i.b.m0.i.a
        public void request(long l) {
            boolean requested;
            if (g.validate(l)) {
                d.a(this.requested, l);
                d();
            }
        }

        @Override // i.b.m0.i.a
        public int requestFusion(int i) {
            int obj2;
            final int i2 = 1;
            if (i &= i2 != 0 && this.fusionMode == i2) {
                if (this.fusionMode == i2) {
                    return i2;
                }
            }
            return 0;
        }
    }
    public n(h<T> h, n<? super T, ? extends Iterable<? extends R>> n2, int i3) {
        super(h);
        this.c = n2;
        this.v = i3;
    }

    public void c0(b<? super R> b) {
        h hVar = this.b;
        Object call = (Callable)hVar.call();
        if (hVar instanceof Callable && call == null) {
            call = (Callable)hVar.call();
            if (call == null) {
                d.complete(b);
            }
            q.g0(b, (Iterable)this.c.apply(call).iterator());
        }
        try {
            n.a aVar = new n.a(b, this.c, this.v);
            hVar.b0(aVar);
        } catch (Throwable th) {
        }
    }
}
