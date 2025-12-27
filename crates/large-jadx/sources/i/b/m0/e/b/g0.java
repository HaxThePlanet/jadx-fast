package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.o;
import i.b.m0.i.f;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;
import m.c.c;

/* compiled from: FlowableRetryPredicate.java */
/* loaded from: classes3.dex */
public final class g0<T> extends a<T, T> {

    final o<? super Throwable> c;
    final long v;

    static final class a<T> extends AtomicInteger implements k<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        final o<? super Throwable> predicate;
        long produced;
        long remaining;
        final f sa;
        final m.c.a<? extends T> source;
        a(b<? super T> bVar, long j, o<? super Throwable> oVar, f fVar, m.c.a<? extends T> aVar) {
            super();
            this.downstream = bVar;
            this.sa = fVar;
            this.source = aVar;
            this.predicate = oVar;
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
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.remaining != 9223372036854775807L) {
                this.remaining--;
            }
            if (this.remaining != 0) {
                try {
                } catch (Throwable th) {
                    a.b(th);
                    int arr = 2;
                    arr = new Throwable[arr];
                    arr[0] = th;
                    th = 1;
                    arr[th] = th;
                    this.downstream.onError(new CompositeException(arr));
                    return;
                }
                if (!this.predicate.test(th)) {
                    this.downstream.onError(th);
                    return;
                }
                a();
            } else {
                this.downstream.onError(th);
            }
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
    public g0(h<T> hVar, long j, o<? super Throwable> oVar) {
        super(hVar);
        this.c = oVar;
        this.v = j;
    }

    @Override // i.b.m0.e.b.a
    public void c0(b<? super T> bVar) {
        final f fVar = new f(false);
        bVar.onSubscribe(fVar);
        g0.a aVar = new g0.a(bVar, this.v, oVar, this.c, fVar, this.b);
        aVar.a();
    }
}
