package i.b.m0.e.d;

import i.b.g0;
import i.b.l0.n;
import i.b.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSwitchMapSingle.java */
/* loaded from: classes3.dex */
public final class h<T, R> extends r<R> {

    final r<T> a;
    final n<? super T, ? extends g0<? extends R>> b;
    final boolean c;

    static final class a<T, R> extends AtomicInteger implements y<T>, i.b.j0.b {

        static final h.a.a<Object> a = null;
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final y<? super R> downstream;
        final i.b.m0.j.c errors = new c();
        final AtomicReference<h.a.a<R>> inner = new AtomicReference<>();
        final n<? super T, ? extends g0<? extends R>> mapper;
        i.b.j0.b upstream;
        static {
            h.a.a = new h.a.a(null);
        }

        a(y<? super R> yVar, n<? super T, ? extends g0<? extends R>> nVar, boolean z) {
            super();
            this.downstream = yVar;
            this.mapper = nVar;
            this.delayErrors = z;
            i.b.m0.j.c cVar = new c();
            AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            final i.b.m0.e.d.h.a.a aVar = h.a.a;
            Object andSet = this.inner.getAndSet(aVar);
            if (andSet != null && andSet != h.a.a) {
                andSet.a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            Object item2;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (this.cancelled) {
                Object obj2 = this.inner.get();
                int r7 = obj2 == null ? andGet : 0;
                if (andGet != 0 || obj2.item == null) {
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(h.a.a<R> aVar, Throwable th) {
            if (this.inner.compareAndSet(aVar, null)) {
                if (this.errors.a(th) && !this.delayErrors) {
                    this.upstream.dispose();
                    a();
                    b();
                    return;
                }
            }
            a.t(th);
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
        public void onError(Throwable th) {
            if (this.errors.a(th)) {
                if (!this.delayErrors) {
                    a();
                }
                boolean z = true;
                this.done = z;
                b();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            Object obj = this.inner.get();
            if (obj != null) {
                obj.a();
            }
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null SingleSource");
            } catch (Throwable th) {
                a.b(th);
                this.upstream.dispose();
                this.upstream.getAndSet(h.a.a);
                onError(th);
                return;
            }
            i.b.m0.e.d.h.a.a aVar = new h.a.a(this);
            Object obj2 = this.inner.get();
            while (obj2 == h.a.a) {
                if (this.inner.compareAndSet(obj2, aVar)) {
                    apply.subscribe(aVar);
                }
                obj2 = this.inner.get();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public h(r<T> rVar, n<? super T, ? extends g0<? extends R>> nVar, boolean z) {
        super();
        this.a = rVar;
        this.b = nVar;
        this.c = z;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super R> yVar) {
        if (!i.c(this.a, this.b, yVar)) {
            this.a.subscribe(new h.a(yVar, this.b, this.c));
        }
    }
}
