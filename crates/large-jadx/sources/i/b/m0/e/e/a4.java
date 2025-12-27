package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.r;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimer.java */
/* loaded from: classes3.dex */
public final class a4 extends r<Long> {

    final z a;
    final long b;
    final TimeUnit c;

    static final class a extends AtomicReference<b> implements b, Runnable {

        private static final long serialVersionUID = -2809475196591179431L;
        final y<? super Long> downstream;
        a(y<? super Long> yVar) {
            super();
            this.downstream = yVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(b bVar) {
            c.trySet(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = get() == c.DISPOSED ? 1 : 0;
            return (get() == c.DISPOSED ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            if (!isDisposed()) {
                this.downstream.onNext(Long.valueOf(0L));
                lazySet(d.INSTANCE);
                this.downstream.onComplete();
            }
        }
    }
    public a4(long j, TimeUnit timeUnit, z zVar) {
        super();
        this.b = j;
        this.c = timeUnit;
        this.a = zVar;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super Long> yVar) {
        final i.b.m0.e.e.a4.a aVar = new a4.a(yVar);
        yVar.onSubscribe(aVar);
        aVar.a(this.a.d(aVar, this.b, this.c));
    }
}
