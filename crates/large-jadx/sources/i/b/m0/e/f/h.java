package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.d.y;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class h<T, U>  extends a0<T> {

    final g0<T> a;
    final w<U> b;

    static final class a extends AtomicReference<b> implements y<U>, b {

        private static final long serialVersionUID = -8565274649390031272L;
        boolean done;
        final d0<? super T> downstream;
        final g0<T> source;
        a(d0<? super T> d0, g0<T> g02) {
            super();
            this.downstream = d0;
            this.source = g02;
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
            }
            this.done = true;
            y yVar = new y(this, this.downstream);
            this.source.subscribe(yVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            if (this.done) {
                a.t(throwable);
            }
            this.done = true;
            this.downstream.onError(throwable);
        }

        public void onNext(U u) {
            (b)get().dispose();
            onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.set(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }
    }
    public h(g0<T> g0, w<U> w2) {
        super();
        this.a = g0;
        this.b = w2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        h.a aVar = new h.a(d0, this.a);
        this.b.subscribe(aVar);
    }
}
