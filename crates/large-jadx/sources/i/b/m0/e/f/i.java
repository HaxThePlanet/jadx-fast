package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.k;
import i.b.m0.a.c;
import i.b.m0.d.y;
import i.b.m0.i.g;
import i.b.p0.a;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.c;

/* loaded from: classes3.dex */
public final class i<T, U>  extends a0<T> {

    final g0<T> a;
    final a<U> b;

    static final class a extends AtomicReference<b> implements k<U>, b {

        private static final long serialVersionUID = -8565274649390031272L;
        boolean done;
        final d0<? super T> downstream;
        final g0<T> source;
        c upstream;
        a(d0<? super T> d0, g0<T> g02) {
            super();
            this.downstream = d0;
            this.source = g02;
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
            this.upstream.cancel();
            onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.upstream, c)) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }
    }
    public i(g0<T> g0, a<U> a2) {
        super();
        this.a = g0;
        this.b = a2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        i.a aVar2 = new i.a(d0, this.a);
        this.b.a(aVar2);
    }
}
