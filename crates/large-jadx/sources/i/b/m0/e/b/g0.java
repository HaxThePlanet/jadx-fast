package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.o;
import i.b.m0.i.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class g0<T>  extends i.b.m0.e.b.a<T, T> {

    final o<? super Throwable> c;
    final long v;

    static final class a extends AtomicInteger implements k<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        final o<? super Throwable> predicate;
        long produced;
        long remaining;
        final f sa;
        final a<? extends T> source;
        a(b<? super T> b, long l2, o<? super Throwable> o3, f f4, a<? extends T> a5) {
            super();
            this.downstream = b;
            this.sa = a5;
            this.source = obj6;
            this.predicate = f4;
            this.remaining = l2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement;
            a source;
            int i;
            int cmp;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                while (this.sa.d()) {
                    long produced = this.produced;
                    i = 0;
                    if (Long.compare(produced, i) != 0) {
                    }
                    this.source.a(this);
                    this.produced = i;
                    this.sa.f(produced);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            b downstream;
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
            this.produced = produced += i2;
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c c) {
            this.sa.g(c);
        }
    }
    public g0(h<T> h, long l2, o<? super Throwable> o3) {
        super(h);
        this.c = obj4;
        this.v = l2;
    }

    public void c0(b<? super T> b) {
        f fVar = new f(0);
        b.onSubscribe(fVar);
        super(b, this.v, obj3, this.c, fVar, this.b);
        aVar2.a();
    }
}
