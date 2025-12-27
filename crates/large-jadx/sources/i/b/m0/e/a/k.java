package i.b.m0.e.a;

import i.b.d;
import i.b.f;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableObserveOn.java */
/* loaded from: classes3.dex */
public final class k extends i.b.b {

    final f a;
    final z b;

    static final class a extends AtomicReference<i.b.j0.b> implements d, i.b.j0.b, Runnable {

        private static final long serialVersionUID = 8571289934935992137L;
        final d downstream;
        Throwable error;
        final z scheduler;
        a(d dVar, z zVar) {
            super();
            this.downstream = dVar;
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
        public void onComplete() {
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.error = th;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            if (this.error != null) {
                this.error = null;
                this.downstream.onError(this.error);
            } else {
                this.downstream.onComplete();
            }
        }
    }
    public k(f fVar, z zVar) {
        super();
        this.a = fVar;
        this.b = zVar;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        this.a.b(new k.a(dVar, this.b));
    }
}
