package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.i.g;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* compiled from: FlowableFlattenIterable.java */
/* loaded from: classes3.dex */
public final class n<T, R> extends a<T, R> {

    final n<? super T, ? extends Iterable<? extends R>> c;
    final int v;

    static final class a<T, R> extends i.b.m0.i.a<R> implements i.b.k<T> {

        private static final long serialVersionUID = -3096000382929934955L;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final m.c.b<? super R> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        int fusionMode;
        final int limit;
        final n<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        j<T> queue;
        final AtomicLong requested = new AtomicLong();
        c upstream;
        a(m.c.b<? super R> bVar, n<? super T, ? extends Iterable<? extends R>> nVar, int i) {
            super();
            this.downstream = bVar;
            this.mapper = nVar;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            AtomicReference atomicReference = new AtomicReference();
            AtomicLong atomicLong = new AtomicLong();
        }

        @Override // i.b.m0.i.a
        boolean a(boolean z, boolean z2, m.c.b<?> bVar, j<?> jVar) {
            final Iterator it = null;
            final boolean z3 = true;
            if (this.cancelled) {
                this.current = it;
                jVar.clear();
                return true;
            }
            if (z) {
                if ((Throwable)this.error.get() != null) {
                    this.current = it;
                    jVar.clear();
                    bVar.onError(k.b(this.error));
                    return true;
                }
                if (z2) {
                    bVar.onComplete();
                    return true;
                }
            }
            return false;
        }

        @Override // i.b.m0.i.a
        void b(boolean z) {
            if (z) {
                if (this.consumed == this.limit) {
                    this.consumed = 0;
                    l = (long)i;
                    this.upstream.request(l);
                } else {
                    this.consumed++;
                }
            }
        }

        @Override // i.b.m0.i.a
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // i.b.m0.i.a
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        @Override // i.b.m0.i.a
        void d() {
            boolean z3;
            int andGet = 1;
            Iterator current2;
            boolean hasNext;
            long l;
            Object poll;
            boolean z2;
            long l2 = 0;
            int i;
            int cmp2;
            boolean z = true;
            long l3;
            final Object obj2 = this;
            if (getAndIncrement() != 0) {
                return;
            }
            z = false;
            andGet = 1;
            Throwable th = obj2.fusionMode != andGet ? andGet : z;
            current2 = null;
            while (obj2.current == null) {
                try {
                    poll = obj2.queue.poll();
                } catch (Throwable th) {
                    a.b(th);
                    obj.upstream.cancel();
                    k.a(obj.upstream, th);
                    th = k.b(th);
                    obj3.onError(th);
                    return;
                }
                int r11 = poll == null ? andGet : z;
                if (poll == null) {
                }
            }
        }

        @Override // i.b.m0.i.a
        public boolean isEmpty() {
            boolean z = false;
            if (this.current == null) {
                int r0 = this.queue.isEmpty() ? 1 : 0;
            }
            return (this.queue.isEmpty() ? 1 : 0);
        }

        @Override // i.b.m0.i.a
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            d();
        }

        @Override // i.b.m0.i.a
        public void onError(Throwable th) {
            boolean done2;
            if (!this.done) {
                if (k.a(this.error, th)) {
                    boolean z = true;
                    this.done = z;
                    d();
                } else {
                    a.t(th);
                }
            }
        }

        @Override // i.b.m0.i.a
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                if (!this.queue.offer(t)) {
                    onError(new MissingBackpressureException("Queue is full?!"));
                    return;
                }
            }
            d();
        }

        @Override // i.b.m0.i.a
        public void onSubscribe(c cVar) {
            int i = 2;
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                z = cVar instanceof g;
                if (cVar instanceof g) {
                    c cVar2 = cVar;
                    int requestFusion = cVar2.requestFusion(3);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.fusionMode = requestFusion;
                        this.queue = cVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = cVar2;
                        this.downstream.onSubscribe(this);
                        cVar.request((long)this.prefetch);
                        return;
                    }
                }
                this.queue = new b(prefetch2);
                this.downstream.onSubscribe(this);
                cVar.request((long)this.prefetch);
            }
        }

        @Override // i.b.m0.i.a
        public R poll() {
            Iterator current2;
            boolean hasNext;
            current2 = null;
            while (this.current == null) {
                Object poll = this.queue.poll();
                current2 = (Iterable)this.mapper.apply(poll).iterator();
                if (current2.hasNext()) {
                    break;
                }
            }
            Object item = current2.next();
            b.e(item, "The iterator returned a null value");
            if (!current2.hasNext()) {
                this.current = current2;
            }
            return item;
        }

        @Override // i.b.m0.i.a
        public void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                d();
            }
        }

        @Override // i.b.m0.i.a
        public int requestFusion(int i) {
            final int i2 = 1;
            fusionMode2 = i & i2;
            if (i & i2 != 0 && this.fusionMode == i2) {
                return i2;
            }
            return 0;
        }
    }
    public n(h<T> hVar, n<? super T, ? extends Iterable<? extends R>> nVar, int i) {
        super(hVar);
        this.c = nVar;
        this.v = i;
    }

    @Override // i.b.m0.e.b.a
    public void c0(m.c.b<? super R> bVar) {
        if (hVar instanceof Callable) {
            try {
                Object call = hVar.call();
            } catch (Throwable th) {
                a.b(th);
                d.error(th, bVar);
                return;
            }
            if (call == null) {
                d.complete(bVar);
                return;
            }
            try {
            } catch (Throwable th) {
                a.b(th);
                d.error(th, bVar);
                return;
            }
            q.g0(bVar, (Iterable)this.c.apply(call).iterator());
            return;
        }
        hVar.b0(new n.a(bVar, this.c, this.v));
    }
}
