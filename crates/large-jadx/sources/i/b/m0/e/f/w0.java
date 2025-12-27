package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleUnsubscribeOn.java */
/* loaded from: classes3.dex */
public final class w0<T> extends a0<T> {

    final g0<T> a;
    final z b;

    static final class a<T> extends AtomicReference<b> implements d0<T>, b, Runnable {

        private static final long serialVersionUID = 3256698449646456986L;
        final d0<? super T> downstream;
        b ds;
        final z scheduler;
        a(d0<? super T> d0Var, z zVar) {
            super();
            this.downstream = d0Var;
            this.scheduler = zVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            dISPOSED2 = c.DISPOSED;
            final Object andSet = getAndSet(dISPOSED2);
            if (andSet != c.DISPOSED) {
                this.ds = andSet;
                this.scheduler.c(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
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

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.ds.dispose();
        }
    }
    public w0(g0<T> g0Var, z zVar) {
        super();
        this.a = g0Var;
        this.b = zVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new w0.a(d0Var, this.b));
    }
}
