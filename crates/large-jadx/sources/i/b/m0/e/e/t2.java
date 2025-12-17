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

/* loaded from: classes3.dex */
public final class t2<T>  extends i.b.m0.e.e.a<T, T> {

    final d<? super Integer, ? super Throwable> b;

    static final class a extends AtomicInteger implements y<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final y<? super T> downstream;
        final d<? super Integer, ? super Throwable> predicate;
        int retries;
        final w<? extends T> source;
        final g upstream;
        a(y<? super T> y, d<? super Integer, ? super Throwable> d2, g g3, w<? extends T> w4) {
            super();
            this.downstream = y;
            this.upstream = g3;
            this.source = w4;
            this.predicate = d2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement;
            w source;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                while (this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            retries += i;
            this.retries = i2;
            if (!this.predicate.a(Integer.valueOf(i2), throwable)) {
                try {
                    this.downstream.onError(throwable);
                    a();
                    a.b(th);
                    int arr = 2;
                    arr = new Throwable[arr];
                    arr[0] = throwable;
                    arr[obj0] = th;
                    CompositeException compositeException = new CompositeException(arr);
                    this.downstream.onError(compositeException);
                }
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            this.upstream.a(b);
        }
    }
    public t2(r<T> r, d<? super Integer, ? super Throwable> d2) {
        super(r);
        this.b = d2;
    }

    public void subscribeActual(y<? super T> y) {
        g gVar = new g();
        y.onSubscribe(gVar);
        t2.a aVar = new t2.a(y, this.b, gVar, this.a);
        aVar.a();
    }
}
