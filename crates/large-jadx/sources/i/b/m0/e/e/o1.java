package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableInterval.java */
/* loaded from: classes3.dex */
public final class o1 extends r<Long> {

    final z a;
    final long b;
    final long c;
    final TimeUnit v;

    static final class a extends AtomicReference<b> implements b, Runnable {

        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final y<? super Long> downstream;
        a(y<? super Long> yVar) {
            super();
            this.downstream = yVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(b bVar) {
            c.setOnce(this, bVar);
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
            if (get() != c.DISPOSED) {
                l = 1L + count2;
                this.count = l;
                this.downstream.onNext(Long.valueOf(this.count));
            }
        }
    }
    public o1(long j, long j2, TimeUnit timeUnit, z zVar) {
        super();
        this.b = j;
        this.c = j2;
        this.v = timeUnit;
        this.a = zVar;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super Long> yVar) {
        final i.b.m0.e.e.o1.a aVar = new o1.a(yVar);
        yVar.onSubscribe(aVar);
        z = zVar instanceof n;
        if (zVar instanceof n) {
            z.c cVar = this.a.a();
            aVar.a(cVar);
            cVar.d(aVar, this.b, this.c, this.v);
        } else {
            aVar.a(this.a.e(aVar, this.b, this.c, this.v));
        }
    }
}
