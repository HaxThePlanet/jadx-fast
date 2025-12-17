package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class w0<T>  extends a0<T> {

    final g0<T> a;
    final z b;

    static final class a extends AtomicReference<b> implements d0<T>, b, Runnable {

        private static final long serialVersionUID = 3256698449646456986L;
        final d0<? super T> downstream;
        b ds;
        final z scheduler;
        a(d0<? super T> d0, z z2) {
            super();
            this.downstream = d0;
            this.scheduler = z2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            Object dISPOSED;
            dISPOSED = c.DISPOSED;
            final Object andSet = getAndSet(dISPOSED);
            if ((b)andSet != dISPOSED) {
                this.ds = (b)andSet;
                this.scheduler.c(this);
            }
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

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.ds.dispose();
        }
    }
    public w0(g0<T> g0, z z2) {
        super();
        this.a = g0;
        this.b = z2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        w0.a aVar = new w0.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
