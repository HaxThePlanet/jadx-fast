package i.b.m0.e.d;

import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.j.c;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class h<T, R>  extends r<R> {

    final r<T> a;
    final n<? super T, ? extends g0<? extends R>> b;
    final boolean c;

    static final class a extends AtomicInteger implements y<T>, b {

        static final i.b.m0.e.d.h.a.a<Object> a = null;
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final y<? super R> downstream;
        final c errors;
        final AtomicReference<i.b.m0.e.d.h.a.a<R>> inner;
        final n<? super T, ? extends g0<? extends R>> mapper;
        b upstream;
        static {
            h.a.a aVar = new h.a.a(0);
            h.a.a = aVar;
        }

        a(y<? super R> y, n<? super T, ? extends g0<? extends R>> n2, boolean z3) {
            super();
            this.downstream = y;
            this.mapper = n2;
            this.delayErrors = z3;
            c obj1 = new c();
            this.errors = obj1;
            obj1 = new AtomicReference();
            this.inner = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            final i.b.m0.e.d.h.a.a aVar = h.a.a;
            Object andSet = this.inner.getAndSet(aVar);
            if ((h.a.a)andSet != null && (h.a.a)andSet != aVar) {
                if ((h.a.a)andSet != aVar) {
                    (h.a.a)andSet.a();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            Object done;
            Object delayErrors;
            Object obj;
            int i;
            if (getAndIncrement() != 0) {
            }
            y downstream = this.downstream;
            c errors = this.errors;
            final AtomicReference inner = this.inner;
            final int i2 = 1;
            andGet = i2;
            while (this.cancelled) {
                obj = inner.get();
                if ((h.a.a)obj == null) {
                } else {
                }
                i = 0;
                inner.compareAndSet((h.a.a)obj, 0);
                downstream.onNext(obj.item);
                i = i2;
            }
        }

        void c(i.b.m0.e.d.h.a.a<R> h$a$a, Throwable throwable2) {
            boolean obj3;
            if (this.inner.compareAndSet(a, 0) && this.errors.a(throwable2) && !this.delayErrors) {
                if (this.errors.a(throwable2)) {
                    if (!this.delayErrors) {
                        this.upstream.dispose();
                        a();
                    }
                    b();
                }
            }
            a.t(throwable2);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            int obj2;
            if (this.errors.a(throwable)) {
                if (!this.delayErrors) {
                    a();
                }
                this.done = true;
                b();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            i.b.m0.e.d.h.a.a compareAndSet;
            AtomicReference inner;
            Object obj = this.inner.get();
            if ((h.a.a)obj != null) {
                (h.a.a)obj.a();
            }
            final Object obj4 = this.mapper.apply(t);
            b.e(obj4, "The mapper returned a null SingleSource");
            h.a.a aVar = new h.a.a(this);
            compareAndSet = this.inner.get();
            while ((h.a.a)compareAndSet == h.a.a) {
                compareAndSet = this.inner.get();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public h(r<T> r, n<? super T, ? extends g0<? extends R>> n2, boolean z3) {
        super();
        this.a = r;
        this.b = n2;
        this.c = z3;
    }

    protected void subscribeActual(y<? super R> y) {
        boolean z2;
        Object aVar;
        n nVar;
        boolean z;
        if (!i.c(this.a, this.b, y)) {
            aVar = new h.a(y, this.b, this.c);
            this.a.subscribe(aVar);
        }
    }
}
