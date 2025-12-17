package i.b.m0.e.e;

import i.b.m0.d.b;
import i.b.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class k2 extends r<Long> {

    private final long a;
    private final long b;

    static final class a extends b<Long> {

        private static final long serialVersionUID = 396518478098735504L;
        final y<? super Long> downstream;
        final long end;
        boolean fused;
        long index;
        a(y<? super Long> y, long l2, long l3) {
            super();
            this.downstream = y;
            this.index = l2;
            this.end = obj4;
        }

        @Override // i.b.m0.d.b
        public Long a() {
            long index = this.index;
            if (Long.compare(index, end) != 0) {
                this.index = i3 += index;
                return Long.valueOf(index);
            }
            lazySet(1);
            return null;
        }

        @Override // i.b.m0.d.b
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            set(1);
        }

        @Override // i.b.m0.d.b
        public boolean isDisposed() {
            int i;
            i = get() != 0 ? 1 : 0;
            return i;
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            int i;
            i = Long.compare(index, end) == 0 ? 1 : 0;
            return i;
        }

        @Override // i.b.m0.d.b
        public Object poll() {
            return a();
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            final int i2 = 1;
            if (i &= i2 != 0) {
                this.fused = i2;
                return i2;
            }
            return 0;
        }

        @Override // i.b.m0.d.b
        void run() {
            int i2;
            long index;
            int i;
            int cmp;
            if (this.fused) {
            }
            y downstream = this.downstream;
            index = this.index;
            while (Long.compare(index, end) != 0) {
                if (get() == 0) {
                }
                downstream.onNext(Long.valueOf(index));
                index += i;
            }
            if (get() == 0) {
                lazySet(1);
                downstream.onComplete();
            }
        }
    }
    public k2(long l, long l2) {
        super();
        this.a = l;
        this.b = obj3;
    }

    protected void subscribeActual(y<? super Long> y) {
        final long l2 = this.a;
        super(y, l2, obj3, l2 + l, obj5);
        y.onSubscribe(aVar2);
        aVar2.run();
    }
}
