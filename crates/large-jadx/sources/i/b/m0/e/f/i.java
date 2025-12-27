package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.k;
import i.b.m0.d.y;
import i.b.m0.i.g;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithPublisher.java */
/* loaded from: classes3.dex */
public final class i<T, U> extends a0<T> {

    final g0<T> a;
    final m.c.a<U> b;

    static final class a<T, U> extends AtomicReference<b> implements k<U>, b {

        private static final long serialVersionUID = -8565274649390031272L;
        boolean done;
        final d0<? super T> downstream;
        final g0<T> source;
        m.c.c upstream;
        a(d0<? super T> d0Var, g0<T> g0Var) {
            super();
            this.downstream = d0Var;
            this.source = g0Var;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            this.upstream.cancel();
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.subscribe(new y(this, this.downstream));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            if (this.done) {
                a.t(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(U u) {
            this.upstream.cancel();
            onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(m.c.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }
    public i(g0<T> g0Var, m.c.a<U> aVar) {
        super();
        this.a = g0Var;
        this.b = aVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.b.a(new i.a(d0Var, this.a));
    }
}
