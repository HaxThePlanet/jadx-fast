package i.b.m0.e.a;

import i.b.d;
import i.b.f;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableDelay.java */
/* loaded from: classes3.dex */
public final class c extends i.b.b {

    final f a;
    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    static final class a extends AtomicReference<i.b.j0.b> implements d, Runnable, i.b.j0.b {

        private static final long serialVersionUID = 465972761105851022L;
        final long delay;
        final boolean delayError;
        final d downstream;
        Throwable error;
        final z scheduler;
        final TimeUnit unit;
        a(d dVar, long j, TimeUnit timeUnit, z zVar, boolean z) {
            super();
            this.downstream = dVar;
            this.delay = j;
            this.unit = timeUnit;
            this.scheduler = zVar;
            this.delayError = z;
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
            c.replace(this, this.scheduler.d(this, this.delay, this.unit));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            long delay2 = 0;
            this.error = th;
            long r0 = this.delayError != null ? this.delay : 0;
            c.replace(this, this.scheduler.d(this, (this.delayError != null ? this.delay : 0), timeUnit, this.unit));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.error = null;
            if (this.error != null) {
                this.downstream.onError(this.error);
            } else {
                this.downstream.onComplete();
            }
        }
    }
    public c(f fVar, long j, TimeUnit timeUnit, z zVar, boolean z) {
        super();
        this.a = fVar;
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
        this.w = z;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        c.a aVar = new c.a(dVar, this.b, timeUnit, this.c, this.v, this.w);
        this.a.b(aVar);
    }
}
