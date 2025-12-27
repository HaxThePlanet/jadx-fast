package i.b.m0.e.f;

import i.b.a0;
import i.b.d;
import i.b.d0;
import i.b.f;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.d.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithCompletable.java */
/* loaded from: classes3.dex */
public final class g<T> extends a0<T> {

    final g0<T> a;
    final f b;

    static final class a<T> extends AtomicReference<b> implements d, b {

        private static final long serialVersionUID = -8565274649390031272L;
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
            this.source.subscribe(new y(this, this.downstream));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }
    }
    public g(g0<T> g0Var, f fVar) {
        super();
        this.a = g0Var;
        this.b = fVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.b.b(new g.a(d0Var, this.a));
    }
}
