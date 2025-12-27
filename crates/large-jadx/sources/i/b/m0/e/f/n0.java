package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleObserveOn.java */
/* loaded from: classes3.dex */
public final class n0<T> extends a0<T> {

    final g0<T> a;
    final z b;

    static final class a<T> extends AtomicReference<b> implements d0<T>, b, Runnable {

        private static final long serialVersionUID = 3528003840217436037L;
        final d0<? super T> downstream;
        Throwable error;
        final z scheduler;
        T value;
        a(d0<? super T> d0Var, z zVar) {
            super();
            this.downstream = d0Var;
            this.scheduler = zVar;
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
        public void onError(Throwable th) {
            this.error = th;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.value = t;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            if (this.error != null) {
                this.downstream.onError(this.error);
            } else {
                this.downstream.onSuccess(this.value);
            }
        }
    }
    public n0(g0<T> g0Var, z zVar) {
        super();
        this.a = g0Var;
        this.b = zVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new n0.a(d0Var, this.b));
    }
}
