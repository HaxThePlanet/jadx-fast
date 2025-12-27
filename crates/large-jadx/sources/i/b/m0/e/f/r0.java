package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.k;
import i.b.m0.i.g;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleTakeUntil.java */
/* loaded from: classes3.dex */
public final class r0<T, U> extends a0<T> {

    final g0<T> a;
    final m.c.a<U> b;

    static final class a<T> extends AtomicReference<b> implements d0<T>, b {

        private static final long serialVersionUID = -622603812305745221L;
        final d0<? super T> downstream;
        final r0.b other = new r0$b();
        a(d0<? super T> d0Var) {
            super();
            this.downstream = d0Var;
            final i.b.m0.e.f.r0.b bVar = new r0.b(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(Throwable th) {
            final i.b.m0.a.c dISPOSED2 = c.DISPOSED;
            if ((b)get() != c.DISPOSED) {
                Object andSet = getAndSet(c.DISPOSED);
                if (andSet != c.DISPOSED && andSet != null) {
                    andSet.dispose();
                    this.downstream.onError(th);
                    return;
                }
            }
            a.t(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            this.other.a();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.other.a();
            final i.b.m0.a.c dISPOSED2 = c.DISPOSED;
            if ((b)get() != c.DISPOSED) {
                if ((b)getAndSet(c.DISPOSED) != c.DISPOSED) {
                    this.downstream.onError(th);
                    return;
                }
            }
            a.t(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.other.a();
            dISPOSED2 = c.DISPOSED;
            if ((b)getAndSet(dISPOSED2) != c.DISPOSED) {
                this.downstream.onSuccess(t);
            }
        }
    }

    static final class b extends AtomicReference<m.c.c> implements k<Object> {

        private static final long serialVersionUID = 5170026210238877381L;
        final r0.a<?> parent;
        b(r0.a<?> aVar) {
            super();
            this.parent = aVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            g.cancel(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            cANCELLED2 = g.CANCELLED;
            if (get() != g.CANCELLED) {
                lazySet(g.CANCELLED);
                this.parent.a(new CancellationException());
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.parent.a(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            if (g.cancel(this)) {
                this.parent.a(new CancellationException());
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(m.c.c cVar) {
            g.setOnce(this, cVar, Long.MAX_VALUE);
        }
    }
    public r0(g0<T> g0Var, m.c.a<U> aVar) {
        super();
        this.a = g0Var;
        this.b = aVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        final i.b.m0.e.f.r0.a aVar = new r0.a(d0Var);
        d0Var.onSubscribe(aVar);
        this.b.a(aVar.other);
        this.a.subscribe(aVar);
    }
}
