package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

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
        a(y<? super Long> y) {
            super();
            this.downstream = y;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(b b) {
            c.setOnce(this, b);
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
            Object downstream;
            Object dISPOSED;
            int i;
            if (get() != c.DISPOSED) {
                long count = this.count;
                this.count = i2 += count;
                this.downstream.onNext(Long.valueOf(count));
            }
        }
    }
    public o1(long l, long l2, TimeUnit timeUnit3, z z4) {
        super();
        this.b = l;
        this.c = timeUnit3;
        this.v = obj5;
        this.a = obj6;
    }

    public void subscribeActual(y<? super Long> y) {
        Object zVar;
        i.b.m0.e.e.o1.a aVar;
        long l;
        long l2;
        TimeUnit time;
        boolean obj9;
        o1.a aVar2 = new o1.a(y);
        y.onSubscribe(aVar2);
        zVar = this.a;
        if (zVar instanceof n) {
            zVar = zVar.a();
            aVar2.a(zVar);
            zVar.d(aVar2, this.b, obj3, this.c);
        } else {
            aVar2.a(zVar.e(aVar2, this.b, obj3, this.c));
        }
    }
}
