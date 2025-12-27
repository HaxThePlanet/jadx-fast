package i.b.m0.e.e;

import i.b.f;
import i.b.l0.n;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableFlatMapCompletableCompletable.java */
/* loaded from: classes3.dex */
public final class x0<T> extends i.b.b implements i.b.m0.c.d<T> {

    final w<T> a;
    final n<? super T, ? extends f> b;
    final boolean c;

    static final class a<T> extends AtomicInteger implements i.b.j0.b, y<T> {

        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final i.b.d downstream;
        final i.b.m0.j.c errors = new c();
        final n<? super T, ? extends f> mapper;
        final i.b.j0.a set = new a();
        i.b.j0.b upstream;
        a(i.b.d dVar, n<? super T, ? extends f> nVar, boolean z) {
            super();
            this.downstream = dVar;
            this.mapper = nVar;
            this.delayErrors = z;
            i.b.m0.j.c cVar = new c();
            i.b.j0.a aVar = new a();
            lazySet(1);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(x0.a.a<T> a.a) {
            this.set.c(a.a);
            onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(x0.a.a<T> a.a, Throwable th) {
            this.set.c(a.a);
            onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable th = this.errors.b();
                if (th != null) {
                    this.downstream.onError(th);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (!this.errors.a(th)) {
                a.t(th);
            } else {
                if (this.delayErrors) {
                    if (decrementAndGet() == 0) {
                        this.downstream.onError(this.errors.b());
                    }
                } else {
                    dispose();
                    if (getAndSet(0) > 0) {
                        this.downstream.onError(this.errors.b());
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null CompletableSource");
            } catch (Throwable th) {
                a.b(th);
                this.upstream.dispose();
                onError(th);
                return;
            }
            getAndIncrement();
            i.b.m0.e.e.x0.a.a aVar = new x0.a.a(this);
            if (!this.disposed) {
                if (this.set.b(aVar)) {
                    apply.b(aVar);
                }
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
    public x0(w<T> wVar, n<? super T, ? extends f> nVar, boolean z) {
        super();
        this.a = wVar;
        this.b = nVar;
        this.c = z;
    }

    @Override // i.b.b
    public r<T> a() {
        return a.n(new w0(this.a, this.b, this.c));
    }

    @Override // i.b.b
    protected void x(i.b.d dVar) {
        this.a.subscribe(new x0.a(dVar, this.b, this.c));
    }
}
