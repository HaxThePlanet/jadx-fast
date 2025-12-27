package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.d;
import i.b.m0.a.g;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRetryBiPredicate.java */
/* loaded from: classes3.dex */
public final class t2<T> extends a<T, T> {

    final d<? super Integer, ? super Throwable> b;

    static final class a<T> extends AtomicInteger implements y<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final y<? super T> downstream;
        final d<? super Integer, ? super Throwable> predicate;
        int retries;
        final w<? extends T> source;
        final g upstream;
        a(y<? super T> yVar, d<? super Integer, ? super Throwable> dVar, g gVar, w<? extends T> wVar) {
            super();
            this.downstream = yVar;
            this.upstream = gVar;
            this.source = wVar;
            this.predicate = dVar;
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
            try {
                this.retries++;
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                arr[i] = th;
                this.downstream.onError(new CompositeException(arr));
                return;
            }
            if (!this.predicate.a(Integer.valueOf(i3), th)) {
                this.downstream.onError(th);
                return;
            }
            a();
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
    public t2(r<T> rVar, d<? super Integer, ? super Throwable> dVar) {
        super(rVar);
        this.b = dVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final g gVar = new g();
        yVar.onSubscribe(gVar);
        new t2.a(yVar, this.b, gVar, this.a).a();
    }
}
