package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableIntervalRange.java */
/* loaded from: classes3.dex */
public final class p1 extends r<Long> {

    final z a;
    final long b;
    final long c;
    final long v;
    final long w;
    final TimeUnit x;

    static final class a extends AtomicReference<b> implements b, Runnable {

        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final y<? super Long> downstream;
        final long end;
        a(y<? super Long> yVar, long j, long j2) {
            super();
            this.downstream = yVar;
            this.count = j;
            this.end = j2;
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
            if (!isDisposed()) {
                this.downstream.onNext(Long.valueOf(this.count));
                if (this.count == this.end) {
                    c.dispose(this);
                    this.downstream.onComplete();
                    return;
                }
                long l = 1L;
                this.count += l;
            }
        }
    }
    public p1(long j, long j2, long j3, long j4, TimeUnit timeUnit, z zVar) {
        super();
        this.v = j3;
        this.w = j4;
        this.x = timeUnit;
        this.a = zVar;
        this.b = j;
        this.c = j2;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super Long> yVar) {
        p1.a aVar = new p1.a(yVar, this.b, l4, this.c, obj);
        yVar.onSubscribe(aVar);
        z = zVar instanceof n;
        if (zVar instanceof n) {
            z.c cVar = this.a.a();
            aVar.a(cVar);
            cVar.d(aVar, this.v, this.w, this.x);
        } else {
            aVar.a(this.a.e(aVar, this.v, this.w, this.x));
        }
    }
}
