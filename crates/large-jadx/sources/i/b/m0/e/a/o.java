package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class o extends b {

    final f a;
    final z b;

    static final class a extends AtomicReference<b> implements d, b, Runnable {

        private static final long serialVersionUID = 7000911171163930287L;
        final d downstream;
        final f source;
        final g task;
        a(d d, f f2) {
            super();
            this.downstream = d;
            this.source = f2;
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
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.source.b(this);
        }
    }
    public o(f f, z z2) {
        super();
        this.a = f;
        this.b = z2;
    }

    @Override // i.b.b
    protected void x(d d) {
        o.a aVar = new o.a(d, this.a);
        d.onSubscribe(aVar);
        aVar.task.a(this.b.c(aVar));
    }
}
