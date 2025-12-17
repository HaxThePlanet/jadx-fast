package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class k extends b {

    final f a;
    final z b;

    static final class a extends AtomicReference<b> implements d, b, Runnable {

        private static final long serialVersionUID = 8571289934935992137L;
        final d downstream;
        Throwable error;
        final z scheduler;
        a(d d, z z2) {
            super();
            this.downstream = d;
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
        public void onComplete() {
            c.replace(this, this.scheduler.c(this));
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

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            Object downstream2;
            d downstream;
            downstream2 = this.error;
            if (downstream2 != null) {
                this.error = 0;
                this.downstream.onError(downstream2);
            } else {
                this.downstream.onComplete();
            }
        }
    }
    public k(f f, z z2) {
        super();
        this.a = f;
        this.b = z2;
    }

    @Override // i.b.b
    protected void x(d d) {
        k.a aVar = new k.a(d, this.b);
        this.a.b(aVar);
    }
}
