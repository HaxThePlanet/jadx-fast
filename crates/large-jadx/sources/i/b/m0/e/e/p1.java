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
        a(y<? super Long> y, long l2, long l3) {
            super();
            this.downstream = y;
            this.count = l2;
            this.end = obj4;
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
            boolean disposed;
            int i;
            Long valueOf;
            long count = this.count;
            this.downstream.onNext(Long.valueOf(count));
            if (!isDisposed() && Long.compare(count, end) == 0) {
                count = this.count;
                this.downstream.onNext(Long.valueOf(count));
                if (Long.compare(count, end) == 0) {
                    c.dispose(this);
                    this.downstream.onComplete();
                }
                this.count = count += i;
            }
        }
    }
    public p1(long l, long l2, long l3, long l4, TimeUnit timeUnit5, z z6) {
        super();
        this.v = timeUnit5;
        this.w = obj7;
        this.x = obj9;
        this.a = obj10;
        this.b = l;
        this.c = l3;
    }

    public void subscribeActual(y<? super Long> y) {
        Object zVar;
        i.b.m0.e.e.p1.a aVar;
        long l;
        long l2;
        TimeUnit time;
        boolean obj9;
        super(y, this.b, obj3, this.c, obj5);
        y.onSubscribe(aVar3);
        zVar = this.a;
        if (zVar instanceof n) {
            zVar = zVar.a();
            aVar3.a(zVar);
            zVar.d(aVar3, this.v, obj3, this.w);
        } else {
            aVar3.a(zVar.e(aVar3, this.v, obj3, this.w));
        }
    }
}
