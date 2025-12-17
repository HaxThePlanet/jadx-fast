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

/* loaded from: classes3.dex */
public final class u2<T>  extends i.b.m0.e.e.a<T, T> {

    final o<? super Throwable> b;
    final long c;

    static final class a extends AtomicInteger implements y<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final y<? super T> downstream;
        final o<? super Throwable> predicate;
        long remaining;
        final w<? extends T> source;
        final g upstream;
        a(y<? super T> y, long l2, o<? super Throwable> o3, g g4, w<? extends T> w5) {
            super();
            this.downstream = y;
            this.upstream = w5;
            this.source = obj6;
            this.predicate = g4;
            this.remaining = l2;
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
            y downstream;
            int cmp;
            long remaining = this.remaining;
            if (Long.compare(remaining, l) != 0) {
                this.remaining = remaining - i2;
            }
            if (Long.compare(remaining, i) == 0) {
                this.downstream.onError(throwable);
            } else {
                if (!this.predicate.test(throwable)) {
                    this.downstream.onError(throwable);
                }
                a();
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
    public u2(r<T> r, long l2, o<? super Throwable> o3) {
        super(r);
        this.b = obj4;
        this.c = l2;
    }

    public void subscribeActual(y<? super T> y) {
        g gVar = new g();
        y.onSubscribe(gVar);
        super(y, this.c, obj3, this.b, gVar, this.a);
        aVar2.a();
    }
}
