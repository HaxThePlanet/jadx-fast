package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleSubscribeOn.java */
/* loaded from: classes3.dex */
public final class q0<T> extends a0<T> {

    final g0<? extends T> a;
    final z b;

    static final class a<T> extends AtomicReference<b> implements d0<T>, b, Runnable {

        private static final long serialVersionUID = 7000911171163930287L;
        final d0<? super T> downstream;
        final g0<? extends T> source;
        final g task = new g();
        a(d0<? super T> d0Var, g0<? extends T> g0Var) {
            super();
            this.downstream = d0Var;
            this.source = g0Var;
            final g gVar = new g();
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
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.source.subscribe(this);
        }
    }
    public q0(g0<? extends T> g0Var, z zVar) {
        super();
        this.a = g0Var;
        this.b = zVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        i.b.m0.e.f.q0.a aVar = new q0.a(d0Var, this.a);
        d0Var.onSubscribe(aVar);
        aVar.task.a(this.b.c(aVar));
    }
}
