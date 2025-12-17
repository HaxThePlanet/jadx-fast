package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.g;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class p2<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;

    static final class a extends AtomicInteger implements y<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final y<? super T> downstream;
        long remaining;
        final g sd;
        final w<? extends T> source;
        a(y<? super T> y, long l2, g g3, w<? extends T> w4) {
            super();
            this.downstream = y;
            this.sd = w4;
            this.source = obj5;
            this.remaining = l2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement;
            w source;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                while (this.sd.isDisposed()) {
                    this.source.subscribe(this);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            int downstream;
            int cmp;
            long remaining = this.remaining;
            if (Long.compare(remaining, l) != 0) {
                this.remaining = remaining - i;
            }
            if (Long.compare(remaining, i2) != 0) {
                a();
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            this.sd.a(b);
        }
    }
    public p2(r<T> r, long l2) {
        super(r);
        this.b = l2;
    }

    public void subscribeActual(y<? super T> y) {
        long l;
        long l2;
        g gVar = new g();
        y.onSubscribe(gVar);
        l = this.b;
        if (Long.compare(l, l2) != 0) {
            l2 = l;
        }
        super(y, l2, obj3, gVar, this.a);
        aVar2.a();
    }
}
