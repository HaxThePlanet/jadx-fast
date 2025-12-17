package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.h;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.i.a;
import i.b.m0.i.g;
import i.b.m0.j.d;
import io.reactivex.exceptions.a;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import m.c.b;

/* loaded from: classes3.dex */
public final class z<T, R>  extends h<R> {

    final g0<T> b;
    final n<? super T, ? extends Iterable<? extends R>> c;

    static final class a extends a<R> implements d0<T> {

        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final b<? super R> downstream;
        volatile Iterator<? extends R> it;
        final n<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested;
        b upstream;
        a(b<? super R> b, n<? super T, ? extends Iterable<? extends R>> n2) {
            super();
            this.downstream = b;
            this.mapper = n2;
            AtomicLong obj1 = new AtomicLong();
            this.requested = obj1;
        }

        @Override // i.b.m0.i.a
        void a() {
            Iterator it;
            int andGet;
            int requested;
            int i2;
            int i;
            int next;
            String str;
            if (getAndIncrement() != 0) {
            }
            b downstream = this.downstream;
            if (this.outputFused && this.it != null) {
                if (this.it != null) {
                    downstream.onNext(0);
                    downstream.onComplete();
                }
            }
            andGet = 1;
            while (it != null) {
                long l = this.requested.get();
                if (Long.compare(l, l2) != 0) {
                }
                i2 = 0;
                i = i2;
                while (Long.compare(i, l) != 0) {
                    Object next2 = it.next();
                    b.e(next2, "The iterator returned a null value");
                    downstream.onNext(next2);
                    i += i5;
                }
                if (Long.compare(i, i2) != 0) {
                }
                if (it == null) {
                }
                it = this.it;
                d.d(this.requested, i);
                next2 = it.next();
                b.e(next2, "The iterator returned a null value");
                downstream.onNext(next2);
                i += i5;
            }
            b(downstream, it);
        }

        void b(b<? super R> b, Iterator<? extends R> iterator2) {
            while (this.cancelled) {
                b.onNext(iterator2.next());
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
            this.it = 0;
        }

        @Override // i.b.m0.i.a
        public boolean isEmpty() {
            int i;
            i = this.it == null ? 1 : 0;
            return i;
        }

        @Override // i.b.m0.i.a
        public void onError(Throwable throwable) {
            this.upstream = c.DISPOSED;
            this.downstream.onError(throwable);
        }

        @Override // i.b.m0.i.a
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                Iterator obj2 = (Iterable)this.mapper.apply(t).iterator();
                if (!obj2.hasNext()) {
                }
                this.downstream.onComplete();
                this.it = obj2;
                a();
                a.b(t);
                this.downstream.onError(t);
            }
        }

        public R poll() {
            Iterator it = this.it;
            final int i = 0;
            final Object next2 = it.next();
            b.e(next2, "The iterator returned a null value");
            if (it != null && !it.hasNext()) {
                next2 = it.next();
                b.e(next2, "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.it = i;
                }
                return next2;
            }
            return i;
        }

        @Override // i.b.m0.i.a
        public void request(long l) {
            boolean requested;
            if (g.validate(l)) {
                d.a(this.requested, l);
                a();
            }
        }

        @Override // i.b.m0.i.a
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i &= i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }
    }
    public z(g0<T> g0, n<? super T, ? extends Iterable<? extends R>> n2) {
        super();
        this.b = g0;
        this.c = n2;
    }

    protected void c0(b<? super R> b) {
        z.a aVar = new z.a(b, this.c);
        this.b.subscribe(aVar);
    }
}
