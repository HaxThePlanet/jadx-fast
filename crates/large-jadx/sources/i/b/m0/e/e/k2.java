package i.b.m0.e.e;

import i.b.m0.d.b;
import i.b.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRangeLong.java */
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
        a(y<? super Long> yVar, long j, long j2) {
            super();
            this.downstream = yVar;
            this.index = j;
            this.end = j2;
        }

        @Override // i.b.m0.d.b
        public Long a() {
            if (this.index != this.end) {
                this.index = 1L + index2;
                return Long.valueOf(this.index);
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
            boolean z = true;
            int r0 = get() != 0 ? 1 : 0;
            return (get() != 0 ? 1 : 0);
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            boolean z = true;
            int r0 = this.index == this.end ? 1 : 0;
            return (this.index == this.end ? 1 : 0);
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            final boolean z = true;
            if (i & z != 0) {
                this.fused = z;
                return z;
            }
            return 0;
        }

        @Override // i.b.m0.d.b
        void run() {
            long index2;
            if (this.fused) {
                return;
            }
            while (this.index != this.end) {
            }
            if (get() == 0) {
                int i = 1;
                lazySet(i);
                this.downstream.onComplete();
            }
        }
    }
    public k2(long j, long j2) {
        super();
        this.a = j;
        this.b = j2;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super Long> yVar) {
        k2.a aVar = new k2.a(yVar, l2, l3, l2 + this.b, obj);
        yVar.onSubscribe(aVar);
        aVar.run();
    }
}
