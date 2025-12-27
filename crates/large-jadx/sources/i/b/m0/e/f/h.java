package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithObservable.java */
/* loaded from: classes3.dex */
public final class h<T, U> extends a0<T> {

    final g0<T> a;
    final w<U> b;

    static final class a<T, U> extends AtomicReference<b> implements i.b.y<U>, b {

        private static final long serialVersionUID = -8565274649390031272L;
        boolean done;
        final d0<? super T> downstream;
        final g0<T> source;
        a(d0<? super T> d0Var, g0<T> g0Var) {
            super();
            this.downstream = d0Var;
            this.source = g0Var;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
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
            (b)get().dispose();
            onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.set(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }
    }
    public h(g0<T> g0Var, w<U> wVar) {
        super();
        this.a = g0Var;
        this.b = wVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.b.subscribe(new h.a(d0Var, this.a));
    }
}
