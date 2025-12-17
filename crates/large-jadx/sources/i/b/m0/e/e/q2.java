package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.e;
import i.b.m0.a.g;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class q2<T>  extends i.b.m0.e.e.a<T, T> {

    final e b;

    static final class a extends AtomicInteger implements y<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final y<? super T> downstream;
        final w<? extends T> source;
        final e stop;
        final g upstream;
        a(y<? super T> y, e e2, g g3, w<? extends T> w4) {
            super();
            this.downstream = y;
            this.upstream = g3;
            this.source = w4;
            this.stop = e2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement;
            w source;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                this.source.subscribe(this);
                while (addAndGet(-andIncrement) == 0) {
                    this.source.subscribe(this);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            y downstream;
            try {
                if (this.stop.a()) {
                } else {
                }
                this.downstream.onComplete();
                a();
                a.b(th);
                this.downstream.onError(th);
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
            this.upstream.a(b);
        }
    }
    public q2(r<T> r, e e2) {
        super(r);
        this.b = e2;
    }

    public void subscribeActual(y<? super T> y) {
        g gVar = new g();
        y.onSubscribe(gVar);
        q2.a aVar = new q2.a(y, this.b, gVar, this.a);
        aVar.a();
    }
}
