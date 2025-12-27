package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.h;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.i.g;
import i.b.m0.j.d;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: SingleFlatMapIterableFlowable.java */
/* loaded from: classes3.dex */
public final class z<T, R> extends h<R> {

    final g0<T> b;
    final n<? super T, ? extends Iterable<? extends R>> c;

    static final class a<T, R> extends i.b.m0.i.a<R> implements d0<T> {

        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final m.c.b<? super R> downstream;
        volatile Iterator<? extends R> it;
        final n<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();
        i.b.j0.b upstream;
        a(m.c.b<? super R> bVar, n<? super T, ? extends Iterable<? extends R>> nVar) {
            super();
            this.downstream = bVar;
            this.mapper = nVar;
            final AtomicLong atomicLong = new AtomicLong();
        }

        @Override // i.b.m0.i.a
        void a() {
            Iterator it;
            int andGet = 1;
            int cmp;
            long l;
            long l2;
            int cmp2;
            String str;
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused && this.it != null) {
                this.downstream.onNext(null);
                this.downstream.onComplete();
                return;
            }
            andGet = 1;
            while (this.it != null) {
                long l3 = this.requested.get();
                l = 0L;
                int i3 = l;
                while (l2 != this.requested) {
                    try {
                        Object item = it.next();
                        str = "The iterator returned a null value";
                        b.e(item, str);
                    } catch (Throwable th) {
                        a.b(th);
                        obj.onError(th);
                        return;
                    }
                    this.downstream.onNext(item);
                    AtomicLong atomicLong = l2 + 1L;
                    try {
                    } catch (Throwable th) {
                        a.b(th);
                        obj.onError(th);
                        return;
                    }
                    if (!it.hasNext()) {
                        this.downstream.onComplete();
                        return;
                    }
                }
                if (addAndGet(-andGet) == 0) {
                    return;
                }
                try {
                    item = it.next();
                    str = "The iterator returned a null value";
                    b.e(item, str);
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                this.downstream.onNext(item);
                atomicLong = l2 + 1L;
                try {
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                if (!it.hasNext()) {
                    this.downstream.onComplete();
                    return;
                }
            }
            b(this.downstream, it);
        }

        @Override // i.b.m0.i.a
        void b(m.c.b<? super R> bVar, Iterator<? extends R> iterator) {
            while (this.cancelled) {
                try {
                } catch (Throwable th) {
                    a.b(th);
                    bVar.onError(th);
                    return;
                }
                bVar.onNext(iterator.next());
                try {
                } catch (Throwable th) {
                    a.b(th);
                    bVar.onError(th);
                    return;
                }
                if (!th.hasNext()) {
                    bVar.onComplete();
                    return;
                }
            }
        }

        @Override // i.b.m0.i.a
        public void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = c.DISPOSED;
        }

        @Override // i.b.m0.i.a
        public void clear() {
            this.it = null;
        }

        @Override // i.b.m0.i.a
        public boolean isEmpty() {
            boolean z = true;
            int r0 = this.it == null ? 1 : 0;
            return (this.it == null ? 1 : 0);
        }

        @Override // i.b.m0.i.a
        public void onError(Throwable th) {
            this.upstream = c.DISPOSED;
            this.downstream.onError(th);
        }

        @Override // i.b.m0.i.a
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // i.b.m0.i.a
        public void onSuccess(T t) {
            try {
                Iterator it = (Iterable)this.mapper.apply(t).iterator();
            } catch (Throwable th) {
                a.b(th);
                this.downstream.onError(th);
                return;
            }
            if (!it.hasNext()) {
                this.downstream.onComplete();
                return;
            }
            this.it = it;
            a();
        }

        @Override // i.b.m0.i.a
        public R poll() {
            final Iterator it2 = null;
            if (this.it != null) {
                final Object item = this.it.next();
                b.e(item, "The iterator returned a null value");
                if (!this.it.hasNext()) {
                    this.it = it2;
                }
                return item;
            }
            return it2;
        }

        @Override // i.b.m0.i.a
        public void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                a();
            }
        }

        @Override // i.b.m0.i.a
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i & i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }
    }
    public z(g0<T> g0Var, n<? super T, ? extends Iterable<? extends R>> nVar) {
        super();
        this.b = g0Var;
        this.c = nVar;
    }

    @Override // i.b.h
    protected void c0(m.c.b<? super R> bVar) {
        this.b.subscribe(new z.a(bVar, this.c));
    }
}
