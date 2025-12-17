package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class n0<T>  extends a0<T> {

    final g0<T> a;
    final z b;

    static final class a extends AtomicReference<b> implements d0<T>, b, Runnable {

        private static final long serialVersionUID = 3528003840217436037L;
        final d0<? super T> downstream;
        Throwable error;
        final z scheduler;
        T value;
        a(d0<? super T> d0, z z2) {
            super();
            this.downstream = d0;
            this.scheduler = z2;
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
            this.error = throwable;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.value = t;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            Object downstream2;
            Object downstream;
            downstream2 = this.error;
            if (downstream2 != null) {
                this.downstream.onError(downstream2);
            } else {
                this.downstream.onSuccess(this.value);
            }
        }
    }
    public n0(g0<T> g0, z z2) {
        super();
        this.a = g0;
        this.b = z2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        n0.a aVar = new n0.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
