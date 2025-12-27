package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.f;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.a;
import m.c.b;
import m.c.c;

/* compiled from: FlowableRepeat.java */
/* loaded from: classes3.dex */
public final class c0<T> extends a<T, T> {

    final long c;

    static final class a<T> extends AtomicInteger implements k<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        long produced;
        long remaining;
        final f sa;
        final a<? extends T> source;
        a(b<? super T> bVar, long j, f fVar, a<? extends T> aVar) {
            super();
            this.downstream = bVar;
            this.sa = fVar;
            this.source = aVar;
            this.remaining = j;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement = 1;
            long l = 0;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                while (this.sa.d()) {
                    l = 0L;
                    this.source.a(this);
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
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c cVar) {
            this.sa.g(cVar);
        }
    }
    public c0(h<T> hVar, long j) {
        super(hVar);
        this.c = j;
    }

    @Override // i.b.m0.e.b.a
    public void c0(b<? super T> bVar) {
        long l = 9223372036854775807L;
        final f fVar2 = new f(false);
        bVar.onSubscribe(fVar2);
        l = Long.MAX_VALUE;
        if (this.c != Long.MAX_VALUE) {
            l = l - 1L;
        }
        c0.a aVar = new c0.a(bVar, l, fVar, fVar2, this.b);
        aVar.a();
    }
}
