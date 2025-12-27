package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleTimer.java */
/* loaded from: classes3.dex */
public final class t0 extends a0<Long> {

    final long a;
    final TimeUnit b;
    final z c;

    static final class a extends AtomicReference<b> implements b, Runnable {

        private static final long serialVersionUID = 8465401857522493082L;
        final d0<? super Long> downstream;
        a(d0<? super Long> d0Var) {
            super();
            this.downstream = d0Var;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(b bVar) {
            c.replace(this, bVar);
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
        public void run() {
            this.downstream.onSuccess(Long.valueOf(0L));
        }
    }
    public t0(long j, TimeUnit timeUnit, z zVar) {
        super();
        this.a = j;
        this.b = timeUnit;
        this.c = zVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super Long> d0Var) {
        final i.b.m0.e.f.t0.a aVar = new t0.a(d0Var);
        d0Var.onSubscribe(aVar);
        aVar.a(this.c.d(aVar, this.a, this.b));
    }
}
