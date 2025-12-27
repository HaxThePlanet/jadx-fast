package i.b.m0.e.a;

import i.b.d;
import i.b.f;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableSubscribeOn.java */
/* loaded from: classes3.dex */
public final class o extends i.b.b {

    final f a;
    final z b;

    static final class a extends AtomicReference<i.b.j0.b> implements d, i.b.j0.b, Runnable {

        private static final long serialVersionUID = 7000911171163930287L;
        final d downstream;
        final f source;
        final g task = new g();
        a(d dVar, f fVar) {
            super();
            this.downstream = dVar;
            this.source = fVar;
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
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.source.b(this);
        }
    }
    public o(f fVar, z zVar) {
        super();
        this.a = fVar;
        this.b = zVar;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        i.b.m0.e.a.o.a aVar = new o.a(dVar, this.a);
        dVar.onSubscribe(aVar);
        aVar.task.a(this.b.c(aVar));
    }
}
