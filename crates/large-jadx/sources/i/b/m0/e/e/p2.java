package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.g;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRepeat.java */
/* loaded from: classes3.dex */
public final class p2<T> extends a<T, T> {

    final long b;

    static final class a<T> extends AtomicInteger implements y<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final y<? super T> downstream;
        long remaining;
        final g sd;
        final w<? extends T> source;
        a(y<? super T> yVar, long j, g gVar, w<? extends T> wVar) {
            super();
            this.downstream = yVar;
            this.sd = gVar;
            this.source = wVar;
            this.remaining = j;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement = 1;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                while (this.sd.isDisposed()) {
                    this.source.subscribe(this);
                    if (addAndGet(-andIncrement) == 0) {
                        return;
                    }
                }
                return;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (this.remaining != 9223372036854775807L) {
                this.remaining--;
            }
            if (this.remaining != 0) {
                a();
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            this.sd.a(bVar);
        }
    }
    public p2(r<T> rVar, long j) {
        super(rVar);
        this.b = j;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        long l = 9223372036854775807L;
        final g gVar2 = new g();
        yVar.onSubscribe(gVar2);
        l = Long.MAX_VALUE;
        if (this.b != Long.MAX_VALUE) {
            l = l - 1L;
        }
        p2.a aVar = new p2.a(yVar, l, gVar, gVar2, this.a);
        aVar.a();
    }
}
