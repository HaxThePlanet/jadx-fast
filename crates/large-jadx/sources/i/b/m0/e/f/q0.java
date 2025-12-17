package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class q0<T>  extends a0<T> {

    final g0<? extends T> a;
    final z b;

    static final class a extends AtomicReference<b> implements d0<T>, b, Runnable {

        private static final long serialVersionUID = 7000911171163930287L;
        final d0<? super T> downstream;
        final g0<? extends T> source;
        final g task;
        a(d0<? super T> d0, g0<? extends T> g02) {
            super();
            this.downstream = d0;
            this.source = g02;
            g obj1 = new g();
            this.task = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            this.task.dispose();
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
            c.setOnce(this, b);
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.source.subscribe(this);
        }
    }
    public q0(g0<? extends T> g0, z z2) {
        super();
        this.a = g0;
        this.b = z2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        q0.a aVar = new q0.a(d0, this.a);
        d0.onSubscribe(aVar);
        aVar.task.a(this.b.c(aVar));
    }
}
