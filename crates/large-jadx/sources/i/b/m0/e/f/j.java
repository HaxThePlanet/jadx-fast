package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.d.y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class j<T, U>  extends a0<T> {

    final g0<T> a;
    final g0<U> b;

    static final class a extends AtomicReference<b> implements d0<U>, b {

        private static final long serialVersionUID = -8565274649390031272L;
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
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(U u) {
            y yVar = new y(this, this.downstream);
            this.source.subscribe(yVar);
        }
    }
    public j(g0<T> g0, g0<U> g02) {
        super();
        this.a = g0;
        this.b = g02;
    }

    protected void subscribeActual(d0<? super T> d0) {
        j.a aVar = new j.a(d0, this.a);
        this.b.subscribe(aVar);
    }
}
