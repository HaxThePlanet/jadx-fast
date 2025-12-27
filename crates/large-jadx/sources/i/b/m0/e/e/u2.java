package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.g;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRetryPredicate.java */
/* loaded from: classes3.dex */
public final class u2<T> extends a<T, T> {

    final o<? super Throwable> b;
    final long c;

    static final class a<T> extends AtomicInteger implements y<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final y<? super T> downstream;
        final o<? super Throwable> predicate;
        long remaining;
        final w<? extends T> source;
        final g upstream;
        a(y<? super T> yVar, long j, o<? super Throwable> oVar, g gVar, w<? extends T> wVar) {
            super();
            this.downstream = yVar;
            this.upstream = gVar;
            this.source = wVar;
            this.predicate = oVar;
            this.remaining = j;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement = 1;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                while (this.upstream.isDisposed()) {
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
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            this.upstream.a(bVar);
        }
    }
    public u2(r<T> rVar, long j, o<? super Throwable> oVar) {
        super(rVar);
        this.b = oVar;
        this.c = j;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final g gVar = new g();
        yVar.onSubscribe(gVar);
        u2.a aVar = new u2.a(yVar, this.c, oVar, this.b, gVar, this.a);
        aVar.a();
    }
}
