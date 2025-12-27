package i.b.m0.e.e;

import i.b.f;
import i.b.l0.n;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableFlatMapCompletable.java */
/* loaded from: classes3.dex */
public final class w0<T> extends a<T, T> {

    final n<? super T, ? extends f> b;
    final boolean c;

    static final class a<T> extends i.b.m0.d.b<T> implements y<T> {

        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final y<? super T> downstream;
        final i.b.m0.j.c errors = new c();
        final n<? super T, ? extends f> mapper;
        final i.b.j0.a set = new a();
        i.b.j0.b upstream;
        a(y<? super T> yVar, n<? super T, ? extends f> nVar, boolean z) {
            super();
            this.downstream = yVar;
            this.mapper = nVar;
            this.delayErrors = z;
            i.b.m0.j.c cVar = new c();
            i.b.j0.a aVar = new a();
            lazySet(1);
        }

        @Override // i.b.m0.d.b
        void a(w0.a.a<T> a.a) {
            this.set.c(a.a);
            onComplete();
        }

        @Override // i.b.m0.d.b
        void b(w0.a.a<T> a.a, Throwable th) {
            this.set.c(a.a);
            onError(th);
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // i.b.m0.d.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // i.b.m0.d.b
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

        @Override // i.b.m0.d.b
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

        @Override // i.b.m0.d.b
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
            i.b.m0.e.e.w0.a.a aVar = new w0.a.a(this);
            if (!this.disposed) {
                if (this.set.b(aVar)) {
                    apply.b(aVar);
                }
            }
        }

        @Override // i.b.m0.d.b
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // i.b.m0.d.b
        public void clear() {
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            return true;
        }

        @Override // i.b.m0.d.b
        public T poll() {
            return null;
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            return i & 2;
        }
    }
    public w0(w<T> wVar, n<? super T, ? extends f> nVar, boolean z) {
        super(wVar);
        this.b = nVar;
        this.c = z;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new w0.a(yVar, this.b, this.c));
    }
}
