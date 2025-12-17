package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.r;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class a4 extends r<Long> {

    final z a;
    final long b;
    final TimeUnit c;

    static final class a extends AtomicReference<b> implements b, Runnable {

        private static final long serialVersionUID = -2809475196591179431L;
        final y<? super Long> downstream;
        a(y<? super Long> y) {
            super();
            this.downstream = y;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(b b) {
            c.trySet(this, b);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = get() == c.DISPOSED ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            boolean downstream;
            Long valueOf;
            if (!isDisposed()) {
                this.downstream.onNext(Long.valueOf(0));
                lazySet(d.INSTANCE);
                this.downstream.onComplete();
            }
        }
    }
    public a4(long l, TimeUnit timeUnit2, z z3) {
        super();
        this.b = l;
        this.c = z3;
        this.a = obj4;
    }

    public void subscribeActual(y<? super Long> y) {
        a4.a aVar = new a4.a(y);
        y.onSubscribe(aVar);
        aVar.a(this.a.d(aVar, this.b, obj2));
    }
}
